package com.yu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskMethod {
    static class Get implements Callable<Integer> {
        FutureTask<Integer> sum;

        public Get(FutureTask<Integer> sum) {
            this.sum = sum;
        }

        @Override
        public Integer call() throws Exception {
            return sum.get();
        }
    }

    static class Sum implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 500;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        FutureTask<Integer> sum = new FutureTask<>(new Sum());
        FutureTask<Integer> get = new FutureTask<>(new Get(sum));

        Thread sumT = new Thread(sum);
        sumT.start();
        Thread getT = new Thread(get);
        getT.start();

        int result = get.get(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("执行结果为："+result);

    }

}
