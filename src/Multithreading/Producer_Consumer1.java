package Multithreading;
import java.util.Random;
import java.util.concurrent.*;


public class Producer_Consumer1 {
    private static BlockingQueue <Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
    /** один или много потоков, которые СОЗДАЮТ запросы или что-либо еще**/
    private static void producer(){
        Random random = new Random();
        while (true){
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    /** БЕРЕТ сущность, созданную producer и как-то ее обрабатывает**/
    private static void consumer(){
        Random ran = new Random();
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ran.nextInt(10)==5) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Size: " + queue.size());
            }
        }
    }
}
