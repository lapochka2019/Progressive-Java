package Multithreading;

import java.util.Scanner;

public class Wait_Notify {
    public static void main(String[] args) throws InterruptedException {
        //в java мы можем синхронизироваться на любом объекте
        Test t = new Test();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
class Test{
    public void produce() throws InterruptedException {
        synchronized (this){/**synchronized (object)**/
            System.out.println("Producer thread started...");
            /*могут вызываться только внутри синхронизованных блоков
            * на объекте синхронизации*/
            this.wait();/** object.wait()**/
            //==this.wait();
            //как работает wait():
            // 1 -> отдает intrinsic lock
            // 2-> ждем, пока будет вызван notify()
            /*wait(1000); - время ожидания, пока поток освободится*/
            System.out.println("Producer thread resumed...");
        }
    }
    public void consumer() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            System.out.println("Waiting for Return key...");
            scanner.nextLine();
            this.notify();//пробуджает только 1 ожидающий поток
            //notifyAll() пробуждает все ждущие потоки
            //Thread.sleep(2000);

        }

    }
}
