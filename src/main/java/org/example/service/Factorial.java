package org.example.service;

public class Factorial {

    public static long calculateFactorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Число должно быть положительное");
        }
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
}
