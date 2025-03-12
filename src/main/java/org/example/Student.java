package org.example;

import java.util.List;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public void nextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    @Override
    public String toString() {
        return name + " (Группа: " + group + ", Курс: " + course + ", Средний балл: " + getAverageGrade() + ")";
    }

    public static void removeLowScoringStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            student.nextCourse();
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(System.out::println);
    }
}


