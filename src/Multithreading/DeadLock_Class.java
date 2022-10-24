package Multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.*;

public class DeadLock_Class {
    public static void main(String[] args) throws InterruptedException {
        Runner r = new Runner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r.firstThread();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r.secondThread();
            }
        });
        t1.start();
        t2.start();


        t1.join();
        t2.join();

        r.finished();

    }
}
class Runner{
    private Account ac1 = new Account();
    private Account ac2 = new Account();

    private Lock l1 = new ReentrantLock();
    private Lock l2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;
        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken)
                    return;
                if (firstLockTaken)
                    lock1.unlock();
                if (secondLockTaken)
                    lock2.unlock();
            }
        }
    }

    public void firstThread() {
        Random r = new Random();
        for (int i = 0;i<1000;i++) {
            //вместо этого можно использовать написанный метод
            l1.lock();/**тут мы бурем первый поток**/
            l2.lock();/**мы не моежем взять второй поток. он уже занят**/
            try{
                Account.transfer(ac1,ac2,r.nextInt(100));
            }finally {
                l1.unlock();
                l2.unlock();
            }
        }
    }
    public void secondThread() {
        Random r = new Random();
        for (int i = 0;i<1000;i++) {
            l1.lock();/**а тут берем второ поток**///если написать l2.lock()
            l2.lock();/**а тут занят первый поток**/// и l1.lock()
            try{
                Account.transfer(ac2,ac1,r.nextInt(100));
            }finally {
                l1.unlock();
                l2.unlock();
            }
        }
    }

        //плохоц пример. много вложенности. усложняет программу
       /** for (int i=0;i<10000;i++){
            synchronized (ac1) {
                synchronized (ac2) {
                    Account.transfer(ac1, ac2, r.nextInt(100));
                }
            }
        }
    }
    public void secondThread(){
        Random r = new Random();
        for (int i=0;i<10000;i++){
            synchronized (ac1) {
                synchronized (ac2) {
                    Account.transfer(ac2, ac1, r.nextInt(100));
                }
            }
        }
    }**/


    public void finished(){
        System.out.println(ac1.getBalance());
        System.out.println(ac2.getBalance());
        System.out.println("Total balance: " + (ac1.getBalance() + ac2.getBalance()));
    }
}

class Account{
    private int balance = 10000;

    public void deposit(int amount){
        balance+=amount;
    }
    public void withdraw (int amount){
        balance-=amount;
    }

    public int getBalance(){
        return balance;
    }

    public static void transfer (Account a1, Account a2, int amount){
        a1.withdraw(amount);
        a2.deposit(amount);
    }
}