package javaOOP.Polymorphism.Lab.shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    protected double calculateArea() {
        return width * height;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * (width + height);
    }
}
