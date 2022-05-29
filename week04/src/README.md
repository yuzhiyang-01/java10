作业2：思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
个方法的返回值后，退出主线程? 
第一种：利用volatile的读取刷主内存的特性，在取值时利用循环方式判断是否有值来进行取值
第二种：利用volatile的读取刷主内存的特性或者atomicInteger原子类，进行等待线程来进行取值
第三种：利用synchronized锁的 管程等待-通知机制，来获取值
第四种：Semaphore信号量方式来获取
第五种：利用锁机制和释放锁的方式来获取值
第六种：使用CyclicBarrier的可循环利用的方式获取值
第七种：使用CountDownLatch倒计时计算器方式获取值
第八种：使用Future的异步调用获取值
第九种：使用FutureTask
第十种：使用CompletableFuture 

作业6：图为