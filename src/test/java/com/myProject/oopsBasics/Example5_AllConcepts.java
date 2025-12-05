package com.myProject.oopsBasics;

/**
 * EXAMPLE 5: ALL OOP CONCEPTS TOGETHER
 *
 * This example demonstrates all four OOP pillars working together:
 * - Inheritance
 * - Encapsulation
 * - Polymorphism
 * - Abstraction
 *
 * Real-world scenario: Library Management System
 */

// Abstract class (Abstraction)
abstract class LibraryItem {
    // Private fields (Encapsulation)
    private String id;
    private String title;
    private boolean isAvailable;

    // Constructor
    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    // Public getters (Encapsulation)
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Controlled setters (Encapsulation)
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Abstract method (Abstraction) - to be implemented by child classes
    public abstract void displayDetails();

    // Abstract method (Abstraction)
    public abstract String getItemType();

    // Concrete method shared by all items
    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("✓ " + title + " has been checked out.");
        } else {
            System.out.println("✗ " + title + " is not available.");
        }
    }

    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("✓ " + title + " has been returned.");
        } else {
            System.out.println("✗ " + title + " was not checked out.");
        }
    }
}

// Child class 1 (Inheritance)
class Book extends LibraryItem {
    private String author;
    private int pages;

    public Book(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("📖 Book Details:");
        System.out.println("   ID: " + getId());
        System.out.println("   Title: " + getTitle());
        System.out.println("   Author: " + author);
        System.out.println("   Pages: " + pages);
        System.out.println("   Available: " + (isAvailable() ? "Yes" : "No"));
    }

    @Override
    public String getItemType() {
        return "Book";
    }
}

// Child class 2 (Inheritance)
class DVD extends LibraryItem {
    private String director;
    private int duration; // in minutes

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("💿 DVD Details:");
        System.out.println("   ID: " + getId());
        System.out.println("   Title: " + getTitle());
        System.out.println("   Director: " + director);
        System.out.println("   Duration: " + duration + " minutes");
        System.out.println("   Available: " + (isAvailable() ? "Yes" : "No"));
    }

    @Override
    public String getItemType() {
        return "DVD";
    }
}

// Child class 3 (Inheritance)
class Magazine extends LibraryItem {
    private String publisher;
    private int issueNumber;

    public Magazine(String id, String title, String publisher, int issueNumber) {
        super(id, title);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("📰 Magazine Details:");
        System.out.println("   ID: " + getId());
        System.out.println("   Title: " + getTitle());
        System.out.println("   Publisher: " + publisher);
        System.out.println("   Issue: #" + issueNumber);
        System.out.println("   Available: " + (isAvailable() ? "Yes" : "No"));
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }
}

// Library class to manage items (Encapsulation)
class Library {
    private String name;
    private LibraryItem[] items;
    private int itemCount;

    public Library(String name, int capacity) {
        this.name = name;
        this.items = new LibraryItem[capacity];
        this.itemCount = 0;
    }

    // Method Overloading (Polymorphism)
    public void addItem(LibraryItem item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
            System.out.println("✓ Added " + item.getItemType() + ": " + item.getTitle());
        } else {
            System.out.println("✗ Library is full!");
        }
    }

    public void displayAllItems() {
        System.out.println("\n📚 " + name + " - All Items:");
        System.out.println("=".repeat(50));
        for (int i = 0; i < itemCount; i++) {
            items[i].displayDetails(); // Polymorphism - calls appropriate child method
            System.out.println();
        }
    }

    public void displayAvailableItems() {
        System.out.println("\n✅ Available Items:");
        System.out.println("=".repeat(50));
        for (int i = 0; i < itemCount; i++) {
            if (items[i].isAvailable()) {
                System.out.println("- " + items[i].getTitle() + " (" + items[i].getItemType() + ")");
            }
        }
    }
}

public class Example5_AllConcepts {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("EXAMPLE 5: ALL OOP CONCEPTS TOGETHER");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   This example combines all OOP concepts in a Library System:");
        System.out.println("   • Inheritance: Book, DVD, Magazine extend LibraryItem");
        System.out.println("   • Encapsulation: Private fields with controlled access");
        System.out.println("   • Polymorphism: Method overriding for displayDetails()");
        System.out.println("   • Abstraction: Abstract LibraryItem class");

        // Create library
        System.out.println("\n🏛️ Creating City Library:");
        Library library = new Library("City Library", 10);

        // Add items (Polymorphism - treating all as LibraryItem)
        System.out.println("\n➕ Adding Items:");
        LibraryItem book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", 180);
        LibraryItem book2 = new Book("B002", "1984", "George Orwell", 328);
        LibraryItem dvd1 = new DVD("D001", "Inception", "Christopher Nolan", 148);
        LibraryItem magazine1 = new Magazine("M001", "National Geographic", "Nat Geo Partners", 123);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);
        library.addItem(magazine1);

        // Display all items (Polymorphism in action)
        library.displayAllItems();

        // Check out items
        System.out.println("\n📤 Checking Out Items:");
        book1.checkOut();
        dvd1.checkOut();

        // Display available items
        library.displayAvailableItems();

        // Return items
        System.out.println("\n📥 Returning Items:");
        book1.returnItem();

        // Final status
        library.displayAvailableItems();

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   All OOP concepts work together to create maintainable code:");
        System.out.println("   • Inheritance reduces code duplication");
        System.out.println("   • Encapsulation protects data integrity");
        System.out.println("   • Polymorphism provides flexibility");
        System.out.println("   • Abstraction hides complexity");
    }
}

