package com.company;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 12.04.2017.
 */
public class DigitArray {
    public CopyOnWriteArrayList<Integer> digitArray;
    public ReentrantLock locker = new ReentrantLock();
    public Integer tiker = 0;
    public AtomicBoolean flStop = new AtomicBoolean(false);

    public DigitArray(int length) {
        digitArray = new CopyOnWriteArrayList();
        for (int i = 0; i < length; i++) {
            digitArray.add(0);
        }
    }
}