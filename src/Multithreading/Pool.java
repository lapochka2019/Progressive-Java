package Multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0;i< 5;i++){
            executorService.submit(new Work(i));//выдаем задания
        }
        executorService.shutdown();//Просим выполнить те задания, которые уже дали. Прекращаем выдачу новых заданий
        System.out.println("All tasks submitted!");
        executorService.awaitTermination(1, TimeUnit.DAYS);//Поток main останавливается и ожидает, пока не будет выполнена вся работа. Только потом идет дальше
    }

}
class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Id (" + id + ") was completed");
    }
}
