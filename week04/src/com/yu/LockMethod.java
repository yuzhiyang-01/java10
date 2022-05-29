package com.yu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock锁机制
 */
public class LockMethod {
    private volatile Integer value = null;
    private Lock lock = new ReentrantLock();
    private Condition calComplete = lock.newCondition();

    public void sum(int num) {
        lock.lock();
        try {
            value = num;
            calComplete.signal();
        } finally {
            lock.unlock();
        }
    }


    public int getValue() throws InterruptedException {
        lock.lock();
        try {
            while (value == null) {
                calComplete.await();
            }
        } finally {
            lock.unlock();
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        final LockMethod method = new LockMethod();
        Thread thread = new Thread(() -> {
            method.sum(500);
        });
        thread.start();

        int result = method.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("执行结果为："+result);

    }

}
