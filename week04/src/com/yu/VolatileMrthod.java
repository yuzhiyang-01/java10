package com.yu;

/**
 * 使用循环的方式判断返回值是否有值来进行判断
 * 使用volatile去主内存中刷数据
 */
public class VolatileMrthod {

    private volatile  Integer value =null;

    public void sum (Integer num){
        value=num;
    }
    public Integer getValue(){
       while (value==null){

       }
       return value;
    }

    public static void main(String[] args) {

        // 创建线程异步执行sum方法
        final VolatileMrthod volatileMrthod=new VolatileMrthod();
        // 打印未执行异步线程时，value的值
//        System.out.println(volatileMrthod.getValue());
        Thread thread = new Thread(()->{
            volatileMrthod.sum(125);
        });
        // 启动线程
        thread.start();
        Integer value = volatileMrthod.getValue();
        System.out.println("执行结果为："+value);
        // 结束主线程
    }
}
