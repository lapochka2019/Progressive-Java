package Multithreading;

import java.util.Random;

public class Thread_Interruption {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i=0;i<1_000_000_000;i++){
                    if(Thread.currentThread().isInterrupted()){//Поток был прерван? если да, то прерываем
                        System.out.println("Thread is interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting thread!");
        thread.start();

        Thread.sleep(1000);
        //важно прервать поток до джоина
        thread.interrupt();//команда прерывания потока

        thread.join();
        System.out.println("Thread has finished!");
    }
    /** Другой вариант прерывания потока при помощи класса Exception
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i =0;i<1_000_000_000;i++){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println("Thread was finished!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
     **/
}
