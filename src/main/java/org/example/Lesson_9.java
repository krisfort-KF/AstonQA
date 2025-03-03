package org.example;

import java.util.Arrays;

public class Lesson_9 {
    public static void main(String[] args) {
        printTreeWorld();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkRangeFrom10To20(20, 1));
        determineNumberType();
        System.out.println(isNegative(-4));
        printStringMultipleTimes("Привет", 2);
        System.out.println(isLeapYear(2025));
        invertBinaryArray();
        fillArray();
        printStringMultipleTimes();
        fillDiagonal();
        createArrayWithValue(8, 6);



    }

    public static void printTreeWorld() {                            //1 задача
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {                                //2 задача
        int a = 5;
        int b = -3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {                                  //3 задача
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {                               //4 задача
        int a = 2;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkRangeFrom10To20(int a, int b) {          //5 задача
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void determineNumberType() {                          //6 задача
        int number = -4;
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean isNegative(int number) {                          //7 задача
        return number < 0;
    }

    public static void printStringMultipleTimes(String str, int times) {        //8 задача
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {                      //9 задача
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static void invertBinaryArray() {                         //10 задание
        int[] array = new int[]{0, 1, 0, 1, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray() {                                     //11 задание
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void printStringMultipleTimes() {                      //12 задание
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value < 6) {
                array[i] = value * 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillDiagonal() {                                 //13 задание
        int [][] array = new int[9][9];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }
        Arrays.stream(array).forEach(
                arr -> System.out.println(Arrays.toString(arr)));
    }

    public static void createArrayWithValue(int len, int initialValue) {          //14 задание
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
    }
}
