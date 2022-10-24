package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Producer_Consumer2 {
    public static void main(String[] args) throws InterruptedException {
        //в java мы можем синхронизироваться на любом объекте
        Test1 t = new Test1();
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
class Test1{
    private Queue <Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();
    public void produce() throws InterruptedException{
        int val = 0;
        while (true){
            synchronized (lock){
                while (queue.size()==LIMIT) {
                    lock.wait();
                }
                    queue.offer(val++);
                lock.notify();
            }
        }
    }
    public void consumer() throws InterruptedException{
        while (true){
            synchronized (lock){
                while (queue.size()==0){
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Queue size = " + queue.size());
                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
