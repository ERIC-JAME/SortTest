package com.company;

/**
 * 异步懒汉模式
 */
public class SingleTonDemo2 {
    private static SingleTonDemo2 singleTonDemo2 =null;
    private static String LOOK = "look";
    public SingleTonDemo2() {
    }
    public static SingleTonDemo2 getInstance(){
        if (singleTonDemo2 == null){
            synchronized (LOOK){
                if (singleTonDemo2 == null){
                    singleTonDemo2 = new SingleTonDemo2();

                }
            }

        }
        return singleTonDemo2;
    }
}
