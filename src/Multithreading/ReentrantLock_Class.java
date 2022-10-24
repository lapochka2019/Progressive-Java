package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_Class {
    public static void main(String[] args) throws InterruptedException {
        Task t = new Task();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.firstThread();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.secondThread();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t.showCounter();

    }
}
class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    public void increment(){
        for (int i=0;i<10000;i++)
            counter++;
    }
    public void firstThread(){
        lock.lock();
        increment();
        lock.unlock();
    }
    public void secondThread(){
        lock.lock();
        increment();
        lock.unlock();
    }
    public void showCounter(){
        System.out.println(counter);}
}
