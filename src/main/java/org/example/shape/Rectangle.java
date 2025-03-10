package org.example.shape;

public class Rectangle extends ColoredShape {
    private int width, height;

    public Rectangle(int width, int height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }

    @Override
    public int getPerimeter() {
        return 2 * (width + height);
    }

    public void printDetails() {
        System.out.print("\nФигура - Прямоугольник. ");
        printInfo();
        printColors();
    }
}
