package com.yu;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMethod {
    public static void main(String[] args) throws InterruptedException {
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        int result = CompletableFuture.supplyAsync(()-> sum()).join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

    }

    private static int sum() {
        return 500;
    }
}
