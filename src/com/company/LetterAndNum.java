package com.company;

import sun.font.FontRunIterator;

public class LetterAndNum {

   static class Num{
           private static  Integer[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
           private static  String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
           static boolean b = false;

   }

    public static void main(String[] args) {

        Num num = new Num();

        new Thread(() -> {
            synchronized (num) {
                for (int i = 0; i <Num.number.length; i++) {
                    if (Num.b) {

                            System.out.println(Thread.currentThread().getName() + "----" + Num.number[i]);
                            num.notifyAll();
                            Num.b = false;


                    } else {
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
            synchronized (num) {
                for (int i = 0; i < Num.letters.length; i++) {
                    if (Num.b) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {


                            System.out.println(Thread.currentThread().getName()+"----"+Num.letters[i]);
                            Num.b = true;
                            num.notifyAll();
                        }

                        }

            }
        }).start();
    }
}

