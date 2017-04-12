package com.company;

/**
 * Created by admin on 12.04.2017.
 */
public class GeneratorDigit extends Thread  {

    Thread s;
    private DigitArray digitArrayObject;

    public GeneratorDigit(DigitArray digitArrayObject) {
        this.digitArrayObject = digitArrayObject;
        s = new Thread(this, "GeneratorDigit");
        s.start();
    }

    @Override
    public void run() {
        try {
            digitArrayObject.locker.lock();

            if (digitArrayObject.flStop.get()) {
                digitArrayObject.locker.unlock();
                return;
            }

            Thread.sleep(500);
            digitArrayObject.tiker += 1;
            int r = (int) (Math.random() * (99 - 0)) + 0;
            digitArrayObject.digitArray.set(r, digitArrayObject.digitArray.get(r)+1) ;
            digitArrayObject.locker.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
