package com.company;

public class ThreadLettersAndNum {
    static class Num {
        private static Integer number = 0;
        private static Integer letters = 0;
        static boolean b = false;
    }

    public static void main(String[] args) {
        Num num = new Num();
        new Thread(() -> {
            synchronized (num){
                while (Num.number<27){
                    if (Num.b){
                        System.out.println(Num.number);
                        Num.number++;
                        num.notifyAll();
                        Num.b = false;
                    }else {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (num){
                while (Num.number<27){
                    if (Num.b){
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println((char)(96+Num.letters));
                        if (Num.letters ==26){
                            Num.letters = 0;
                        }
                        Num.letters++;
                        Num.b = true;
                        num.notifyAll();
                    }
                }
            }
        }).start();
    }
}
