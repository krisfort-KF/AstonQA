package org.example.service;

import org.example.model.ResultCompareNumbers;

public class NumberComparator {

    public static ResultCompareNumbers compareNumbers(int a, int b) {

        if (a > b) {
            System.out.println(a + " больше, чем " + b);
            return ResultCompareNumbers.MORE;
        }
        if (a < b) {
            System.out.println(a + " меньше, чем " + b);
            return ResultCompareNumbers.LESS;
        }
        System.out.println(a + " равно " + b);
        return ResultCompareNumbers.EQUALS;
    }
}
