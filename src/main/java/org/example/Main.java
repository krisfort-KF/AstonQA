package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.example.Student.*;

public class Main {
    public static void main(String[] args) {
        students();
        phoneDirectory();

    }

    private static void students() {
        Set<Student> students = new HashSet<>(Arrays.asList(
                new Student("Иван", "A-55", 1, Arrays.asList(4, 5, 3, 4)),
                new Student("Петр", "B-12", 2, Arrays.asList(2, 3, 2, 3)),
                new Student("Сергей", "С-12", 1, Arrays.asList(5, 5, 5, 5)),
                new Student("Екатерина", "C-12", 3, Arrays.asList(3, 4, 3, 3))));

        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);

        removeLowScoringStudents(students);
        promoteStudents(students);

        System.out.println("\nСписок студентов после отчисления и перевода:");
        students.forEach(System.out::println);

        System.out.println("\nСтуденты на 2 курсе:");
        printStudents(students, 2);
    }

    private static void phoneDirectory() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.addPhone("Сивков", "+7-900-123-45-67");
        phoneDirectory.addPhone("Шупейко", "+7-911-234-56-78");
        phoneDirectory.addPhone("Колесников", "+7-922-345-67-89");
        phoneDirectory.addPhone("Мурко", "+7-933-456-78-90");

        System.out.println("Телефоны Сивкова: " + phoneDirectory.getPhones("Сивков"));
        System.out.println("Телефоны Шупейко: " + phoneDirectory.getPhones("Шупейко"));
        System.out.println("Телефоны Колесникова: " + phoneDirectory.getPhones("Колесников"));
        System.out.println("Телефоны Мурко: " + phoneDirectory.getPhones("Мурко")); // Пустой список

        System.out.println("\nПолный справочник:");
        phoneDirectory.printDirectory();
    }
}


