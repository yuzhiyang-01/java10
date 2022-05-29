package com.yu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 主线程等待子线程执行完成再执行
 */
public class CountDownLatchMethod {

    private volatile Integer value = null;
    private CountDownLatch latch;

    public void sum(int num) {
        value = num;
        //递减锁存器的计数，如果计数到达零，则释放所有等待的线程
        latch.countDown();
    }


    public int getValue() throws InterruptedException {
        latch.await();
        return value;
    }

    /**
     * latch没有重置功能，用这个函数来传入新的
     * @param latch
     */
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public static void main(String[] args) throws InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        CountDownLatch latch = new CountDownLatch(1);
        final CountDownLatchMethod method = new CountDownLatchMethod();
        method.setLatch(latch);
        Thread thread = new Thread(() -> {
            method.sum(500);
        });
        thread.start();

        int result = method.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("执行结果为："+result);
    }
}
