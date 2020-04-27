package com.company;

/**
 * 饿汉模式下的单例模式
 */
public class SingleTonDemo1 {
    private static SingleTonDemo1 singleTonDemo1 = new SingleTonDemo1();

    public SingleTonDemo1() {
    }

    public static SingleTonDemo1 getSingleTonDemo1() {
        return singleTonDemo1;
    }
}
