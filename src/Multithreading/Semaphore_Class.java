package Multithreading;

import java.util.concurrent.*;

public class Semaphore_Class {
    public static void main(String[] args) throws InterruptedException {
        /*Semaphore semaphore = new Semaphore(3);//количество используемых потоков

        try{
            semaphore.acquire();//взяли одно разрешение (3-1), работаем с ресурсом
            //будет ждать, если разрешений 0
            semaphore.acquire();
            semaphore.acquire();
            System.out.println("all threads was acquired");
            semaphore.acquire();
            System.out.println("Error");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release();//закончили работу с ресурсом, вернули разрешение
        System.out.println(semaphore.availablePermits());//возвращает количество свободных потоков
        /*try{
            semaphore.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(semaphore.availablePermits());*/
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        Connection connection = Connection.getConnection();
        for (int i=0;i<200;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork_Semaphore();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.DAYS);


    }
}//паттерн сингл тон
// у нас может быть только один объект класса
class Connection{
    private static Connection connection = new Connection();
    private int connections_count=0;
    private Semaphore semaphore = new Semaphore(10);
    //не позволяет более чем 10 потокам работать единовременно
    private Connection(){

    }
    public static Connection getConnection(){
        return connection;
    }
    public void doWork_Semaphore() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }


    }
    public void doWork(){
        synchronized (this){
            connections_count++;
            System.out.println(connections_count);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this){
            connections_count--;
            System.out.println(connections_count);
        }

    }
}
