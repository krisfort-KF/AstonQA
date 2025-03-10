package org.example.shape;

public class Triangle extends ColoredShape {
    private int a, b, c;

    public Triangle(int a, int b, int c, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int getArea() {
        int s = (a + b + c) / 2;
        return (int) Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public int getPerimeter() {
        return a + b + c;
    }

    public void printDetails() {
        System.out.print("\nФигура - Треугольник. ");
        printInfo();
        printColors();
    }
}
