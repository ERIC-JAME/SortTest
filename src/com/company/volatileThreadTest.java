package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class volatileThreadTest {

    private volatile Integer num = 0;

    public void getNum(){
        num++;
    }

    public static void main(String[] args) {

        volatileThreadTest volatileThreadTest = new volatileThreadTest();

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i <10 ; i++) {
            new Thread(() ->{
                for (int j = 0; j <100 ; j++) {
                     volatileThreadTest.getNum();
                    atomicInteger.decrementAndGet();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
           Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"----"+volatileThreadTest.num);
        System.out.println(Thread.currentThread().getName()+"----"+atomicInteger);
    }
}
