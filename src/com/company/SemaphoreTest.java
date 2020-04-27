package com.company;

import java.util.concurrent.Semaphore;

/**
 * Semaphore.循环，满了之后排队，走一个进一个
 */
public class SemaphoreTest {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <7 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到停车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"\t停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
