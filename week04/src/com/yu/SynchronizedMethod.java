package com.yu;

/**
 * 利用等待和唤醒方式来获取值
 */
public class SynchronizedMethod {

    private volatile Integer value = null;

    synchronized public void sum(int num) {
        value = num;
        //唤醒所有等待线程
       notifyAll();
    }


    synchronized public int getValue() throws InterruptedException {
        while (value == null) {
            // 等待线程
            wait();
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        final SynchronizedMethod method = new SynchronizedMethod();
        Thread thread = new Thread(() -> {
            method.sum(45);
        });
        thread.start();

        int result = method.getValue(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("执行结果为："+result);


    }

}
