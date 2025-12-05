package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 1: INHERITANCE BASICS
 *
 * Inheritance allows a class to inherit properties and methods from another class.
 *
 * KEY CONCEPTS:
 * - Parent Class (Base/Super class): Contains common functionality
 * - Child Class (Derived/Sub class): Inherits from parent, adds specific functionality
 * - "extends" keyword: Used to inherit from a class
 * - Benefits: Code reusability, reduced duplication
 */

// Parent Class - Contains common browser actions
class BrowserActions {
    protected String browserName;

    public BrowserActions() {
        this.browserName = "Chrome";
    }

    // Common method available to all child classes
    public void openBrowser() {
        System.out.println("   ✓ Opening " + browserName + " browser...");
    }

    public void closeBrowser() {
        System.out.println("   ✓ Closing " + browserName + " browser...");
    }

    public void navigateToURL(String url) {
        System.out.println("   ✓ Navigating to: " + url);
    }

    // Protected method - accessible to child classes
    protected void waitForPageLoad() {
        System.out.println("   ✓ Waiting for page to load...");
    }
}

// Child Class 1 - Inherits all methods from BrowserActions
class LoginPageActions extends BrowserActions {

    // Child-specific method
    public void login(String username, String password) {
        System.out.println("   ✓ Logging in with username: " + username);
        waitForPageLoad(); // Can access parent's protected method
    }

    public void verifyLoginSuccess() {
        System.out.println("   ✓ Verifying login was successful");
    }
}

// Child Class 2 - Also inherits from BrowserActions
class HomePageActions extends BrowserActions {

    // Child-specific methods
    public void clickProduct(String productName) {
        System.out.println("   ✓ Clicking on product: " + productName);
    }

    public void addToCart() {
        System.out.println("   ✓ Adding product to cart");
        waitForPageLoad(); // Can access parent's protected method
    }
}

// Main demonstration class
public class Example1_InheritanceBasics {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 1: INHERITANCE BASICS");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Inheritance allows child classes to reuse code from parent class.");
        System.out.println("   Parent class (BrowserActions) contains common browser operations.");
        System.out.println("   Child classes (LoginPageActions, HomePageActions) inherit these methods.");

        System.out.println("\n🔹 Demonstrating LoginPageActions (Child Class 1):");
        LoginPageActions loginPage = new LoginPageActions();
        loginPage.openBrowser();          // Inherited from BrowserActions
        loginPage.navigateToURL("https://automationexercise.com/login");  // Inherited
        loginPage.login("user@test.com", "password123");  // Own method
        loginPage.verifyLoginSuccess();   // Own method
        loginPage.closeBrowser();         // Inherited

        System.out.println("\n🔹 Demonstrating HomePageActions (Child Class 2):");
        HomePageActions homePage = new HomePageActions();
        homePage.openBrowser();           // Inherited from BrowserActions
        homePage.navigateToURL("https://automationexercise.com"); // Inherited
        homePage.clickProduct("Blue Top"); // Own method
        homePage.addToCart();             // Own method
        homePage.closeBrowser();          // Inherited

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   Both LoginPageActions and HomePageActions inherited common methods");
        System.out.println("   (openBrowser, closeBrowser, navigateToURL) from BrowserActions.");
        System.out.println("   This eliminates code duplication and makes maintenance easier!");
    }
}

