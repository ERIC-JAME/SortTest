package com.company;

/**
 * 懒汉模式的单例模式
 */
public class SingTomTest {
    private static ThreadTest threadTest = null;

    public SingTomTest() {

    }
    public static SingTomTest getInstance(){
        if (threadTest ==null){
            synchronized (SingTomTest.class){
                if (threadTest ==null){
                     threadTest = new ThreadTest();
                }
            }
        }
        return SingTomTest.getInstance();
    }
}
