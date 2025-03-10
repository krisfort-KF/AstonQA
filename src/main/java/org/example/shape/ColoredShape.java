package org.example.shape;

public abstract class ColoredShape implements Shape {
    protected String fillColor;
    protected String borderColor;

    public ColoredShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void printColors() {
        System.out.println("Цвет заливки - " + fillColor + ". Цвет контура - " + borderColor + ".");
    }
}
