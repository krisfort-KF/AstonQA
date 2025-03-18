package org.example;


import org.example.model.ArithmeticOperations;
import org.example.model.ResultCompareNumbers;
import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.example.service.NumberComparator.compareNumbers;
import static org.example.service.Factorial.calculateFactorial;
import static org.example.service.TriangleArea.calculateTriangleArea;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Lesson14Test {

    @ParameterizedTest
    @CsvSource({
            "120, 5",
            "1, 0",
            "1, 1",
            "2, 2",
    })
    void ShouldCalculateFactorial(int expected, int x) {
        assertEquals(expected, calculateFactorial(x));
    }

    @Test
    void ShouldThrowExceptionWhenFactorialIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculateFactorial(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 4, 5",
            "726, 55, 33, 44",
            "554, 62, 48, 25",
            "645, 37, 49, 35",
    })
    void ShouldCalculateTriangleArea(int expected, int x, int y, int c) {
        assertEquals(expected, calculateTriangleArea(x, y, c), 1);
    }

    @ParameterizedTest
    @CsvSource({
            "6, PLUS",
            "2, MINUS",
            "8, MULTIPLY",
            "2, DIVIDE"
    })
    void arithmeticOperations(int expected, ArithmeticOperations operation) {
        assertEquals(expected, Calculator.calculate(4, 2, operation));
    }

    @Test
    void divisionZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.calculate(1, 0, ArithmeticOperations.DIVIDE));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 4, 3, 5",
            "10, 8, 1, 10",
            "555, 444, 333, 555",
            "447, 11, 7, 447",
    })
    void ShouldCompareNumbers(int a, int b, int c, int eq) {
        assertEquals(ResultCompareNumbers.MORE, compareNumbers(a, b));
        assertEquals(ResultCompareNumbers.LESS, compareNumbers(c, b));
        assertEquals(ResultCompareNumbers.EQUALS, compareNumbers(a, eq));
    }
}