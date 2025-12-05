package com.myProject.oopsBasics;

/**
 * EXAMPLE 1: INHERITANCE
 *
 * Inheritance allows a class to inherit properties and methods from another class.
 * - Parent Class (Base/Super class): Contains common functionality
 * - Child Class (Derived/Sub class): Inherits from parent and can add specific functionality
 * - "extends" keyword: Used to inherit from a class
 */

// Parent Class - Animal
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Common method available to all child classes
    public void eat() {
        System.out.println(name + " is eating...");
    }

    public void sleep() {
        System.out.println(name + " is sleeping...");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Child Class 1 - Dog inherits from Animal
class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age); // Call parent constructor
    }

    // Child-specific method
    public void bark() {
        System.out.println(name + " says: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
}

// Child Class 2 - Cat inherits from Animal
class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age); // Call parent constructor
    }

    // Child-specific methods
    public void meow() {
        System.out.println(name + " says: Meow! Meow!");
    }

    public void scratch() {
        System.out.println(name + " is scratching the furniture!");
    }
}

// Child Class 3 - Bird inherits from Animal
class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    public void chirp() {
        System.out.println(name + " says: Chirp! Chirp!");
    }

    public void fly() {
        System.out.println(name + " is flying high!");
    }
}

// Main demonstration class
public class Example1_InheritanceBasics {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("EXAMPLE 1: INHERITANCE BASICS");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Inheritance allows child classes to reuse code from parent class.");
        System.out.println("   All animals can eat() and sleep() (inherited methods).");
        System.out.println("   Each animal also has its own specific behaviors.");

        System.out.println("\n🐕 Dog Example:");
        Dog myDog = new Dog("Buddy", 3);
        myDog.displayInfo();     // Inherited from Animal
        myDog.eat();             // Inherited from Animal
        myDog.bark();            // Dog's own method
        myDog.fetch();           // Dog's own method

        System.out.println("\n🐱 Cat Example:");
        Cat myCat = new Cat("Whiskers", 2);
        myCat.displayInfo();     // Inherited from Animal
        myCat.eat();             // Inherited from Animal
        myCat.meow();            // Cat's own method
        myCat.scratch();         // Cat's own method

        System.out.println("\n🐦 Bird Example:");
        Bird myBird = new Bird("Tweety", 1);
        myBird.displayInfo();    // Inherited from Animal
        myBird.sleep();          // Inherited from Animal
        myBird.chirp();          // Bird's own method
        myBird.fly();            // Bird's own method

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   All animals share common methods (eat, sleep, displayInfo).");
        System.out.println("   Each animal type has its own unique behaviors (bark, meow, chirp).");
        System.out.println("   This eliminates code duplication and promotes reusability!");
    }
}

