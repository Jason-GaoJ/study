package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jasongaoj
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年01月04日 17:20:00
 */
public class PrintLetterNumber {

    public static void main(String[] args) {
        Object lock=new Object();
        Thread t1,t2;
        t1=new Thread(new Runnable() {
            @Override
            public void run() {
                char a='A';
                for (int i = 1; i <= 26; i++) {
                    synchronized (lock){
                        System.out.print(a);
                        a++;
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }, "t1");

        t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    synchronized (lock){
                        System.out.print(i);
                        try {
                            lock.notify();
                            if (i<26){
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }, "t2");

        /*ReentrantLock reentrantLock=new ReentrantLock();
        Condition condition1=reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();

        t1=new Thread(new Runnable() {
            @Override
            public void run() {
                char a='A';
                for (int i = 1; i <= 26; i++) {
                    try {
                        reentrantLock.lock();
                        System.out.print(a);
                        a++;
                        condition2.signal();
                        condition1.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();

                    }
                }
            }
        }, "t1");

        t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 26; i++) {
                    try {
                        reentrantLock.lock();
                        System.out.print(i);
                        condition1.signal();
                        condition2.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        }, "t2");*/
        t2.setPriority(2);
        t1.start();
        t2.start();

    }
}
