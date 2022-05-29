package com.yu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrie 循环栅栏
 */
public class CyclicBarrierMethod {
    private volatile Integer value = null;
    CyclicBarrier barrier;

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void sum(int num) throws BrokenBarrierException, InterruptedException {
        value = num;
        barrier.await();
    }


    public int getValue() throws InterruptedException {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        final CyclicBarrierMethod method = new CyclicBarrierMethod();
        CyclicBarrier barrier = new CyclicBarrier(1, ()-> {
            int result = 0; //这是得到的返回值
            try {
                result = method.getValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 确保  拿到result 并输出
            System.out.println("执行结果为："+result);

        });
        method.setBarrier(barrier);

        Thread thread = new Thread(() -> {
            try {
                method.sum(500);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        // 然后退出main线程
    }
}
