package com.myProject.oopsBasics;

/**
 * EXAMPLE 3: POLYMORPHISM
 *
 * Polymorphism means "many forms" - the ability of an object to take many forms.
 *
 * TWO TYPES:
 * 1. Method Overloading (Compile-time Polymorphism): Same method name, different parameters
 * 2. Method Overriding (Runtime Polymorphism): Child class provides specific implementation
 */

// Parent Class
class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Method to be overridden by child classes
    public void draw() {
        System.out.println("Drawing a shape...");
    }

    // Method to be overridden
    public double calculateArea() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
    }
}

// Child Class 1 - Circle
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Method Overriding - Runtime Polymorphism
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Child Class 2 - Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // Method Overriding - Runtime Polymorphism
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle with width " + width + " and height " + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Child Class 3 - Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    // Method Overriding - Runtime Polymorphism
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " triangle with base " + base + " and height " + height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Class demonstrating Method Overloading (Compile-time Polymorphism)
class Calculator {

    // Method Overloading - Same name, different parameters
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }

    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    public String add(String a, String b) {
        System.out.println("Concatenating strings: " + a + " + " + b);
        return a + b;
    }
}

public class Example3_Polymorphism {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("EXAMPLE 3: POLYMORPHISM");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Polymorphism allows objects to take many forms.");
        System.out.println("   1. Method Overloading: Same method name, different parameters");
        System.out.println("   2. Method Overriding: Child class provides specific implementation");

        // PART 1: Method Overriding (Runtime Polymorphism)
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PART 1: METHOD OVERRIDING (Runtime Polymorphism)");
        System.out.println("=".repeat(70));

        // Parent reference, child objects
        Shape shape1 = new Circle("Red", 5.0);
        Shape shape2 = new Rectangle("Blue", 4.0, 6.0);
        Shape shape3 = new Triangle("Green", 3.0, 8.0);

        // Array of shapes
        Shape[] shapes = {shape1, shape2, shape3};

        System.out.println("\n🎨 Drawing all shapes:");
        for (Shape shape : shapes) {
            shape.draw();  // Calls appropriate child class method
            System.out.println("   Area: " + String.format("%.2f", shape.calculateArea()));
            System.out.println();
        }

        // PART 2: Method Overloading (Compile-time Polymorphism)
        System.out.println("=".repeat(70));
        System.out.println("PART 2: METHOD OVERLOADING (Compile-time Polymorphism)");
        System.out.println("=".repeat(70));

        Calculator calc = new Calculator();

        System.out.println("\n🧮 Using overloaded add() methods:");
        int result1 = calc.add(5, 10);
        System.out.println("Result: " + result1);

        System.out.println();
        double result2 = calc.add(5.5, 10.5);
        System.out.println("Result: " + result2);

        System.out.println();
        int result3 = calc.add(5, 10, 15);
        System.out.println("Result: " + result3);

        System.out.println();
        String result4 = calc.add("Hello, ", "World!");
        System.out.println("Result: " + result4);

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   Method Overriding: Same method name in parent and child classes.");
        System.out.println("   Method Overloading: Same method name with different parameters.");
        System.out.println("   Both allow code flexibility and reusability!");
    }
}

