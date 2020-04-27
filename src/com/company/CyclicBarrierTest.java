package com.company;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * CyclicBarrier自增，达到要求之后执行其他操作
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() + "\t召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final Integer num = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t集齐了第" + num + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //    cyclicBarrier.getNumberWaiting();
            }).start();
        }
//
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }


    }
}
