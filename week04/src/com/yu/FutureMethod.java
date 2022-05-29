package com.yu;

import java.util.concurrent.*;

/**
 * Future
 */
public class FutureMethod  implements Callable<Long>  {

        private long sum(int num) {
            return num;
        }



        @Override
        public Long call() throws Exception {
            return sum(500);
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {

            long start=System.currentTimeMillis();
            // 在这里创建一个线程或线程池，
            // 异步执行 下面方法
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Long> future = executor.submit(new FutureMethod());

            long result = future.get(); //这是得到的返回值

            // 确保  拿到result 并输出
            System.out.println("执行结果为："+result);

            // 然后退出main线程
            executor.shutdown();
        }

    }
