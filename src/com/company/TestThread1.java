package com.company;

public class TestThread1 {
    private volatile static Integer num = 0;

    public static Integer getNum(){
        num++;
        return num;
    }

    public static void main(String[] args) {
        for (int i = 1; i <10 ; i++) {
            new Thread(() ->{
                for (int j = 1; j <10 ; j++) {

                    System.out.println(Thread.currentThread().getName()+"----------"+TestThread1.getNum());
                }
            }).start();
        }
    }
}
