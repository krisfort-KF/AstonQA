package org.example.shape;

public class Circle extends ColoredShape {
    private int radius;

    public Circle(int radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * radius * radius);
    }

    @Override
    public int getPerimeter() {
        return (int) (2 * Math.PI * radius);
    }

    public void printDetails() {
        System.out.print("\nФигура - Круг. ");
        printInfo();
        printColors();
    }
}
