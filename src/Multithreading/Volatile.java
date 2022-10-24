package Multithreading;

import java.util.Scanner;

public class Volatile {
    //Ключевое слово volatile
    //один поток записывает в переменную, а другой читает
    public static void main(String[] args) {
        //поток запускается
        MyThread myThread = new MyThread();
        myThread.start();
        //поток мэйн ожидает действий, а Наш Поток работает
        Scanner s = new Scanner(System.in);
        s.nextLine();
        myThread.shutdown();
    }
}
class MyThread extends Thread{
    private volatile boolean running = true;
    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void shutdown(){//останавливает выполнение потока
        this.running = false;
    }
}
