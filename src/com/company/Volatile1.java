package com.company;

/**
 * volatile 是jvm中的轻量级锁
 * 特性：1.可以保证可见性
 * 2.不能保证原子性
 * 3.禁止重排序
 *
 * 测试volati可见性
 */
public class Volatile1 {
    //不加volatile会一直进入死循环
    private volatile Integer num = 0;

    public void getNum(){
        num = 60;
    }

    public static void main(String[] args) {
        Volatile1 volatile1 = new Volatile1();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t线程come in");

            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            volatile1.getNum();
            System.out.println(Thread.currentThread().getName()+"\tvalue="+volatile1.num);
        }).start();

        while (volatile1.num == 0){
            //main线程一直处于等待状态
        }
        System.out.println(Thread.currentThread().getName()+"\tover");
    }
}
