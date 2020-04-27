package com.company;

import java.util.Arrays;

/**
 * 多线程打印求和
 * 线程打印int[] num = {1,3,5,7,9,11,13,15};
 * 线程求上条线程的和int[] sum = {1,6,15,28,45,66,91,120}
 */
public class ThreadPrintSum {
    private static boolean b = true;

    public static void main(String[] args) {
        //实例对象用作锁
        ThreadPrintSum tp = new ThreadPrintSum();
        int[] num = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] sum = new int[num.length];


        new Thread(() -> {

            synchronized (tp) {

                if (ThreadPrintSum.b) {
                    //打印数组
                        System.out.print(Arrays.toString(num));
                    System.out.println();
                    ThreadPrintSum.b = false;
                    //唤醒锁着的线程
                    tp.notifyAll();
                } else {
                    try {
                        //线程等待
                        tp.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
        new Thread(() -> {

            synchronized (tp) {

                if (ThreadPrintSum.b) {
                    try {
                        tp.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    for (int i = 0; i < num.length; i++) {
                        //接收每一个元素
                        int nums = num[i];
                        //每一个元素求和的初始值
                        int sums = 0;
                        for (int j = 1; j <=nums ; j++) {
                            //求和
                            sums = sums+j;
                            //放入求和数组
                            sum[i] = sums;
                        }
                    }
                    System.out.println(Arrays.toString(sum));
                }
            }

        }).start();

    }
}
