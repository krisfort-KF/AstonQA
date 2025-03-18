package org.example;

import org.example.model.ArithmeticOperations;
import org.example.model.ResultCompareNumbers;
import org.example.service.Calculator;
import org.example.service.Factorial;
import org.example.service.NumberComparator;
import org.example.service.TriangleArea;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Lesson14Test {


    @DataProvider
    public Object[][] factorialData() {
        return new Object[][]{
                {120, 5},
                {1, 0},
                {1, 1},
                {2, 2}
        };
    }

    @Test(dataProvider = "factorialData")
    void ShouldCalculateFactorial(int expected, int x) {
        assertEquals(expected, Factorial.calculateFactorial(x));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть положительное")
    void ShouldThrowExceptionWhenFactorialIsNegative() {
        Factorial.calculateFactorial(-1);
    }

    @DataProvider
    public Object[][] triangleData() {
        return new Object[][]{
                {6, 3, 4, 5},
                {726, 55, 33, 44},
                {554, 62, 48, 25},
                {645, 37, 49, 35}
        };

    }

    @Test(dataProvider = "triangleData")
    void ShouldCalculateTriangleArea(int expected, int x, int y, int c) {
        assertEquals(expected, TriangleArea.calculateTriangleArea(x, y, c), 1);
    }

    @DataProvider
    public Object[][] calculationData() {
        return new Object[][]{
                {6, ArithmeticOperations.PLUS},
                {2, ArithmeticOperations.MINUS},
                {8, ArithmeticOperations.MULTIPLY},
                {2, ArithmeticOperations.DIVIDE}
        };
    }

    @Test(dataProvider = "calculationData")
    void arithmeticOperations(int expected, ArithmeticOperations operation) {
        assertEquals(expected, Calculator.calculate(4, 2, operation));
    }

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "Деление на ноль невозможно")
    void divisionZero() {
        Calculator.calculate(1, 0, ArithmeticOperations.DIVIDE);
    }

    @DataProvider
    public Object[][] numberData() {
        return new Object[][]{
                {5, 4, 3, 5},
                {10, 8, 1, 10},
                {555, 444, 333, 555},
                {447, 11, 7, 447}
        };
    }

    @Test(dataProvider = "numberData")
    void ShouldCompareNumbers(int a, int b, int c, int eq) {
        assertEquals(ResultCompareNumbers.MORE, NumberComparator.compareNumbers(a, b));
        assertEquals(ResultCompareNumbers.LESS, NumberComparator.compareNumbers(c, b));
        assertEquals(ResultCompareNumbers.EQUALS, NumberComparator.compareNumbers(a, eq));
    }
}
