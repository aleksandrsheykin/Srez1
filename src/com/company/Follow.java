package com.company;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 12.04.2017.
 */
public class Follow extends Thread  {

    Thread s;
    private DigitArray digitArrayObject;

    public Follow(DigitArray digitArrayObject) {
        this.digitArrayObject = digitArrayObject;
        s = new Thread(this);
        s.start();
    }

    @Override
    public void run() {
        while (true) {
            digitArrayObject.lock();

            if (digitArrayObject.tiker % 5 == 0) {
                for (int i = 0; i < digitArrayObject.digitArray.size(); i++) {
                    if (digitArrayObject.digitArray.get(i) < 5) {
                        System.out.println("digit " + i + " is " + digitArrayObject.digitArray.get(i));
                    } else {
                        digitArrayObject.flStop.set(true);
                        digitArrayObject.unlock();
                        System.out.println("finish");
                        return;
                    }
                }
            }
            Thread.yield();

            digitArrayObject.unlock();
        }
    }
}
