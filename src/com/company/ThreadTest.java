package com.company;

public class ThreadTest {

    private volatile static Integer num = 0;

    public static Integer getNum(){
        return num ++;
    }

    public static void main(String[] args) {
        for (int i = 1; i <=100 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "=====" + ThreadTest.getNum());
            }).start();
        }
    }
}
