package org.example;

import org.example.model.ArithmeticOperations;

import static org.example.service.NumberComparator.compareNumbers;
import static org.example.service.Factorial.calculateFactorial;
import static org.example.service.Calculator.calculate;
import static org.example.service.TriangleArea.calculateTriangleArea;

public class Main {
    public static void main(String[] args) {

        //факториал
        int num = 5;
        System.out.println("Факториал: " + calculateFactorial(num));

        //площадь треугольника
        double a = 3, b = 4, c = 5;
        System.out.println("Площадь треугольника: " + calculateTriangleArea(a, b, c));

        //арифметические операции
        int x = 22, y = 11;
        calculate(x, y, ArithmeticOperations.PLUS);
        calculate(x, y, ArithmeticOperations.MINUS);
        calculate(x, y, ArithmeticOperations.MULTIPLY);
        calculate(x, y, ArithmeticOperations.DIVIDE);

        //сравнение двух чисел
        int p = 9, q = 9;
        compareNumbers(p, q);
    }
}