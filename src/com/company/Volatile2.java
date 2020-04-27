package com.company;

/**
 * 测试volatile的不保证原子性
 *
 * 1.枷锁可以保证原子性synchronized
 * 2.属性上添加volatile关键字也可以实现
 */
public class Volatile2 {
    private volatile Integer num = 0;

    //   public synchronized void getNum(){
    public void getNum() {
        num++;
    }

    public static void main(String[] args) {
        Volatile2 volatile2 = new Volatile2();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    volatile2.getNum();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {

        }
        System.out.println(Thread.currentThread().getName() + "\t" + volatile2.num);

    }
}
