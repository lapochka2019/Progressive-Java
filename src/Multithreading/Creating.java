package Multithreading;

public class Creating {
    public static void main(String[] args) throws InterruptedException {
        /*MyTread myTread = new MyTread();
        myTread.start();
        MyTread myTread2 = new MyTread();
        myTread2.start();
        */
        /*System.out.println("I am going to sleep");
        Thread.sleep(3000);
        System.out.println("I am awake");*/

        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println("Hello from main thread");
    }
    static class Runner implements Runnable{//этот способ лучше

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                try {
                    Thread.sleep(1000);       // waiting a 1 minute
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello from MyThread" + i);
            }
        }
    }
    static class MyTread extends Thread {//один из методов создания потока
        public void run(){
            for (int i=0; i<100; i++){
                try {
                    Thread.sleep(1000);       // waiting a 1 minute
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello from MyThread" + i);
            }
        }
    }
}

