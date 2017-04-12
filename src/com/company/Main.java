package com.company;

public class Main {
    private static volatile DigitArray digitArrayObject = new DigitArray(99);

    public static void main(String[] args) {
        new GeneratorDigit(digitArrayObject);
        new Follow(digitArrayObject);
    }
}
