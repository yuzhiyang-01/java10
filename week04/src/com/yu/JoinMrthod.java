package com.yu;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * 使用join等待线程来等值返回回来
 *
 */
public class JoinMrthod {
    /**
     * 使用volatile来进行数据设值
     */
    private volatile int value= 0;
    public  void sum(int num) {
         value+=num;
    }

    public  int getValue() {
        return value;
    }

    public static void main(String[] args) {

        final JoinMrthod joinMrthod= new JoinMrthod();
        Thread thread = new Thread(()->{
           joinMrthod.sum(500);
        });
        thread.start();
        try {
            thread.join();
            System.out.println("使用volatile的值为"+joinMrthod.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用原子类的atomicInteger来进行操作
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread thread1 = new Thread(()->{
            atomicInteger.set(75);
        });
        thread1.start();
        try {
            thread1.join();
            System.out.println("使用atomicInteger的值为"+atomicInteger.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
