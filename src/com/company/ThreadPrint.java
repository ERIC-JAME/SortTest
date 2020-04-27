package com.company;

public class ThreadPrint {
    static class Num {
        public int number = 1;
    }

    public static void main(String[] args) {
        Num num = new Num();

        new Thread(()->{
            while (num.number<100){
                synchronized (num) {
                    if (num.number % 2 == 1) {
                        System.out.print(num.number);
                        num.number++;
                        num.notifyAll();
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


        new Thread(()->{
            while (num.number<100){
                synchronized (num) {
                    if (num.number % 2 == 1) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.print(num.number);
                        num.number++;
                        num.notifyAll();

                    }
                }


            }
        }).start();


    }
}
