package com.company;

/**
 * @author:zxg
 * @2020/4/21
 */
public class OT_A_TT_BTest {
    private static boolean flag = true;
    private int count = 1;
    //打印数字
    public synchronized void printNum(){
        if (flag ==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1);
        System.out.print(2*count);
        flag = false;
        notifyAll();

    }
    //打印字母
    public synchronized void printChar(){
        if (flag ==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char)('A'+count-1));

        flag = true;
        count++;
        notifyAll();
    }

    public static void main(String[] args) {
        OT_A_TT_BTest Test = new OT_A_TT_BTest();
        //打印数字
        new Thread(() -> {
                for (int i = 0; i < 26; i++) {
                    Test.printNum();
            }
        }).start();
        //打印字母
        new Thread(() -> {

                for (int i = 0; i < 26; i++) {

                    Test.printChar();
            }
        }).start();
    }
}
