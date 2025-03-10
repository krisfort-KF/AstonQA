package org.example.shape;

public interface Shape {
    int getArea();

    int getPerimeter();

    default void printInfo() {
        System.out.println("Периметр: " + getPerimeter() + ". Площадь: " + getArea() + ". ");

    }
}
