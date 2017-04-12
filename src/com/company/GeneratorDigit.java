package com.company;

/**
 * Created by admin on 12.04.2017.
 */
public class GeneratorDigit extends Thread  {

    private Thread s;
    private DigitArray digitArrayObject;

    public GeneratorDigit(DigitArray digitArrayObject) {
        this.digitArrayObject = digitArrayObject;
        s = new Thread(this);
        s.start();
    }

    @Override
    public void run() {
        try {
            while(true) {
                digitArrayObject.lock();

                if (digitArrayObject.flStop.get()) {
                    digitArrayObject.unlock();
                    return;
                }

                digitArrayObject.tiker += 1;
                int r = (int) (Math.random() * (99));
                digitArrayObject.digitArray.set(r, digitArrayObject.digitArray.get(r) + 1);
                digitArrayObject.unlock();
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            digitArrayObject.unlock();
            e.printStackTrace();
        }

    }
}
