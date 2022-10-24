package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Synchronization {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        //Synchronization s = new Synchronization();
        //s.doWork();
        new Worker().main();

    }
   //public synchronized/*ключевое слово для синхронизации потоков*/  void implement(){
   //     //synchronized разрешает только одному потоку в одну единицу времени
   //     //исполнять метод
   //     //один поток делает, остальные ждут
   //     counter++;
   // }
    public void implement(){
        //блок synchronized
        synchronized (this){
            counter++;
        }
    }
    public void doWork() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++)
                    implement();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++)
                    //counter++;//не атомарная функция, а состоящая из 3 действий
                    implement();
            }
        });

        t1.start();
        t2.start();
        //ожидаем, что потоки выполняют свою работу
        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
    class Worker{
    private List <Integer> list1 = new ArrayList<>();
    private List <Integer> list2 = new ArrayList<>();
    Object lock1 = new Object();
    Object lock2 = new Object();
    Random random = new Random();

    public void addToList1(){
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list1.add(random.nextInt(100));
        }
    }
    public void addToList2(){
        synchronized(lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list2.add(random.nextInt(100));
        }
    }
    public void Work(){
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

        public void main(){
            long before = System.currentTimeMillis();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Work();
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Work();
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long after = System.currentTimeMillis();
            System.out.println("Program took " + (after-before) + " ms to run");
            System.out.println("List1: " + list1.size());
            System.out.println("List2: " + list2.size());
        };


    }
