package javaOOP.Polymorphism.Lab.shapes;

public abstract class Shape {
    private double area;
    private double perimeter;

    protected abstract double calculateArea();
    protected abstract double calculatePerimeter();

    public double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
