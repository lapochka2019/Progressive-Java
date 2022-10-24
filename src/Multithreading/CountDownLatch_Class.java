package Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatch_Class {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0;i<3;i++){
            executorService.submit(new Processor(countDownLatch, i));
        }
        executorService.shutdown();
        //countDownLatch.await();
        //System.out.println("Latch has been opened, mai thread is proceeding");
        /**/for (int i=0;i<3;i++){
        /**/    Thread.sleep(3000);
        /**/    countDownLatch.countDown();
        /**/}
    }
}
class Processor implements Runnable{
    private CountDownLatch countDownLatch;
    private int id;

    public Processor(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //countDownLatch.countDown();
        /**/try {
        /**/    countDownLatch.await();
        /**/} catch (InterruptedException e) {
        /**/    throw new RuntimeException(e);
        /**/}
        /**/System.out.println("Tread with id " + id + " proceeded");
    }
}
