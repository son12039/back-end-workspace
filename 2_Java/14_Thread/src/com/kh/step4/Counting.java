package com.kh.step4;

public class Counting extends Thread {

    InputThreadTest process;

    Counting(InputThreadTest process) {
        this.process = process;
    }

    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (process.check) break;
            System.out.println(i);
        }
    }
}

