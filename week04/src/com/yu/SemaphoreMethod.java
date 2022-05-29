package com.yu;

import java.util.concurrent.Semaphore;

/**
 * Semaphore--信号量方式
 */
public class SemaphoreMethod {
    private volatile Integer value = null;
    final Semaphore semaphore = new Semaphore(1);

    public void sum(int num) throws InterruptedException {
        // 获取一个令牌
        semaphore.acquire();
        System.out.println(2);
        value = num;
        //释放一个令牌
        semaphore.release();
    }


    public int getValue() throws InterruptedException {
        int result;
        semaphore.acquire();
        while (this.value == null){
            semaphore.release();
        }
        result = this.value;

        return result;
    }

    public static void main(String[] args) throws InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        final SemaphoreMethod method = new SemaphoreMethod();
        Thread thread = new Thread(() -> {
            try {
                method.sum(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        // 需要睡眠一段时间，如子线程先走
//        Thread.sleep(100);
        int result = method.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("执行结果为："+result);


    }
}
