package com.myProject.oopsBasics;

/**
 * EXAMPLE 4: ABSTRACTION
 *
 * Abstraction hides implementation details and shows only essential features.
 *
 * TWO WAYS TO ACHIEVE ABSTRACTION:
 * 1. Abstract Classes: Can have both abstract and concrete methods
 * 2. Interfaces: Contract that defines what a class must do (not how)
 */

// PART 1: ABSTRACT CLASS
abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Abstract methods - must be implemented by child classes
    public abstract void start();
    public abstract void stop();
    public abstract void accelerate();

    // Concrete method - shared by all vehicles
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println(brand + " Car: Turning key, engine starting... Vroom!");
    }

    @Override
    public void stop() {
        System.out.println(brand + " Car: Applying brakes, engine stopping...");
    }

    @Override
    public void accelerate() {
        System.out.println(brand + " Car: Pressing gas pedal, accelerating smoothly...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car, Doors: " + numberOfDoors);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void start() {
        System.out.println(brand + " Motorcycle: Kick starting, engine roaring... Brrrm!");
    }

    @Override
    public void stop() {
        System.out.println(brand + " Motorcycle: Squeezing brakes, coming to a halt...");
    }

    @Override
    public void accelerate() {
        System.out.println(brand + " Motorcycle: Twisting throttle, speeding up fast...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle, Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// PART 2: INTERFACE
interface Playable {
    // All methods in interface are public and abstract by default
    void play();
    void pause();
    void stop();
}

interface Recordable {
    void record();
    void stopRecording();
}

// Class implementing one interface
class MusicPlayer implements Playable {
    private String currentSong;

    public MusicPlayer(String currentSong) {
        this.currentSong = currentSong;
    }

    @Override
    public void play() {
        System.out.println("♪ Playing music: " + currentSong);
    }

    @Override
    public void pause() {
        System.out.println("⏸ Music paused");
    }

    @Override
    public void stop() {
        System.out.println("⏹ Music stopped");
    }
}

// Class implementing multiple interfaces
class VideoCamera implements Playable, Recordable {
    private String videoFile;

    public VideoCamera(String videoFile) {
        this.videoFile = videoFile;
    }

    @Override
    public void play() {
        System.out.println("▶ Playing video: " + videoFile);
    }

    @Override
    public void pause() {
        System.out.println("⏸ Video paused");
    }

    @Override
    public void stop() {
        System.out.println("⏹ Video stopped");
    }

    @Override
    public void record() {
        System.out.println("🔴 Recording video...");
    }

    @Override
    public void stopRecording() {
        System.out.println("⏹ Recording stopped");
    }
}

public class Example4_Abstraction {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("EXAMPLE 4: ABSTRACTION");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Abstraction hides complex implementation and shows only essentials.");
        System.out.println("   1. Abstract Class: Partial abstraction (can have abstract + concrete)");
        System.out.println("   2. Interface: Complete abstraction (only method signatures)");

        // PART 1: Abstract Class Demo
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PART 1: ABSTRACT CLASS");
        System.out.println("=".repeat(70));

        System.out.println("\n🚗 Car Operations:");
        Vehicle myCar = new Car("Toyota", 2023, 4);
        myCar.displayInfo();
        myCar.start();
        myCar.accelerate();
        myCar.stop();

        System.out.println("\n🏍️ Motorcycle Operations:");
        Vehicle myMotorcycle = new Motorcycle("Harley-Davidson", 2022, false);
        myMotorcycle.displayInfo();
        myMotorcycle.start();
        myMotorcycle.accelerate();
        myMotorcycle.stop();

        // This would cause compilation error:
        // Vehicle vehicle = new Vehicle("Generic", 2023); // Cannot instantiate abstract class

        // PART 2: Interface Demo
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PART 2: INTERFACES");
        System.out.println("=".repeat(70));

        System.out.println("\n🎵 Music Player:");
        Playable player = new MusicPlayer("Imagine - John Lennon");
        player.play();
        player.pause();
        player.stop();

        System.out.println("\n📹 Video Camera:");
        VideoCamera camera = new VideoCamera("Holiday_2023.mp4");
        // Can use as Playable
        camera.play();
        camera.pause();
        camera.stop();

        System.out.println();
        // Can also use Recordable features
        camera.record();
        camera.stopRecording();

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   Abstract Class: Use when classes share common code + behavior.");
        System.out.println("   Interface: Use when classes should follow a contract.");
        System.out.println("   Both hide complexity and provide clean, simple usage!");
    }
}

