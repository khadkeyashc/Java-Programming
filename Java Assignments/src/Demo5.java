abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

public class Demo5 {
    public static void main(String[] args) {
        Shape circle = new Circle(7);
        System.out.println("Area of Circle: " + circle.area());

        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Area of Rectangle: " + rectangle.area());
    }
}
