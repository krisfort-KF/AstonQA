package org.example.service;

import org.example.model.ArithmeticOperations;

public class Calculator {
    public static int calculate(int a, int b, ArithmeticOperations operation) throws ArithmeticException {
        int res = 0;
        switch (operation) {
            case PLUS: {
                res = a + b;
                System.out.printf("Сложение: %d + %d = %d%n", a, b, res);
                return res;
            }
            case MINUS: {
                res = a - b;
                System.out.printf("Вычитание: %d - %d = %d%n", a, b, res);
                return res;
            }
            case MULTIPLY: {
                res = a * b;
                System.out.printf("Умножение: %d * %d = %d%n", a, b, res);
                return res;
            }
            case DIVIDE: {

                if (b == 0) {
                    String error = "Деление на ноль невозможно";
                    System.out.println(error);
                    throw new ArithmeticException(error);
                }
                res = a / b;
                System.out.printf("Деление: %d / %d = %d%n", a, b, res);
                return a / b;
            }
        }
        return res;
    }
}







