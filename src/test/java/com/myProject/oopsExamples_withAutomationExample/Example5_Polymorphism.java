package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 5: POLYMORPHISM
 *
 * Polymorphism = "Many forms" - Same method name, different behavior
 *
 * KEY CONCEPTS:
 * - Method Overriding: Child class provides specific implementation
 * - Method Overloading: Same method name, different parameters
 * - Runtime Polymorphism: Actual method called determined at runtime
 * - Why: Different pages handle same action differently
 */

// Base Page with methods that can be overridden
class PolymorphicBasePage {

    protected String pageName = "BasePage";

    // Method to be overridden by child classes
    public void performSearch(String searchTerm) {
        System.out.println("      ✓ [BasePage] Generic search for: " + searchTerm);
    }

    // Another method to be overridden
    public String getWelcomeMessage() {
        return "[BasePage] Welcome!";
    }

    // Method with default implementation
    public void clickLogo() {
        System.out.println("      ✓ [BasePage] Clicking logo to go home");
    }
}

// HomePage overrides methods differently
class PolymorphicHomePage extends PolymorphicBasePage {

    public PolymorphicHomePage() {
        this.pageName = "HomePage";
    }

    // OVERRIDING - Different implementation for HomePage
    @Override
    public void performSearch(String searchTerm) {
        System.out.println("      ✓ [HomePage] Entering '" + searchTerm + "' in main search box");
        System.out.println("      ✓ [HomePage] Clicking search button");
        System.out.println("      ✓ [HomePage] Displaying product results");
    }

    @Override
    public String getWelcomeMessage() {
        return "[HomePage] Welcome to Automation Exercise!";
    }
}

// Products Page overrides methods differently
class PolymorphicProductsPage extends PolymorphicBasePage {

    public PolymorphicProductsPage() {
        this.pageName = "ProductsPage";
    }

    // OVERRIDING - Different implementation for ProductsPage
    @Override
    public void performSearch(String searchTerm) {
        System.out.println("      ✓ [ProductsPage] Filtering products by: " + searchTerm);
        System.out.println("      ✓ [ProductsPage] Applying search filter");
        System.out.println("      ✓ [ProductsPage] Updating product grid");
    }

    @Override
    public String getWelcomeMessage() {
        return "[ProductsPage] Browse our products!";
    }
}

// Contact Page overrides methods differently
class PolymorphicContactPage extends PolymorphicBasePage {

    public PolymorphicContactPage() {
        this.pageName = "ContactPage";
    }

    // OVERRIDING - Different implementation for ContactPage
    @Override
    public void performSearch(String searchTerm) {
        System.out.println("      ✓ [ContactPage] Searching FAQ for: " + searchTerm);
        System.out.println("      ✓ [ContactPage] Showing relevant help articles");
    }

    @Override
    public String getWelcomeMessage() {
        return "[ContactPage] How can we help you?";
    }
}

// Demonstrates Method Overloading (Compile-time Polymorphism)
class SearchHelper {

    // Same method name, different parameters = Overloading

    // Search with just term
    public void search(String searchTerm) {
        System.out.println("      ✓ Searching for: " + searchTerm);
    }

    // Search with term and category
    public void search(String searchTerm, String category) {
        System.out.println("      ✓ Searching for: " + searchTerm + " in category: " + category);
    }

    // Search with term, category, and price range
    public void search(String searchTerm, String category, int minPrice, int maxPrice) {
        System.out.println("      ✓ Searching for: " + searchTerm + " in " + category);
        System.out.println("        Price range: $" + minPrice + " - $" + maxPrice);
    }

    // Search with different parameter type
    public void search(String[] searchTerms) {
        System.out.print("      ✓ Searching for multiple terms: ");
        for (String term : searchTerms) {
            System.out.print(term + " ");
        }
        System.out.println();
    }
}

// Test automation framework using polymorphism
class TestRunner {

    // This method accepts any page that extends PolymorphicBasePage
    // Actual method called is determined at RUNTIME (Runtime Polymorphism)
    public void executeSearch(PolymorphicBasePage page, String searchTerm) {
        System.out.println("\n   🔍 Executing search on: " + page.pageName);
        System.out.println("      Welcome message: " + page.getWelcomeMessage());
        page.performSearch(searchTerm);  // Different behavior based on actual page type!
    }
}

public class Example5_Polymorphism {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 5: POLYMORPHISM");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Polymorphism = Same method, different behavior based on object type");
        System.out.println("   - Method Overriding: Child provides different implementation");
        System.out.println("   - Method Overloading: Same name, different parameters");

        System.out.println("\n🔹 METHOD OVERRIDING (Runtime Polymorphism):");

        // Create different page objects
        PolymorphicHomePage homePage = new PolymorphicHomePage();
        PolymorphicProductsPage productsPage = new PolymorphicProductsPage();
        PolymorphicContactPage contactPage = new PolymorphicContactPage();

        System.out.println("\n   Same method 'performSearch()' behaves differently:");

        System.out.println("\n   • HomePage.performSearch():");
        homePage.performSearch("blue top");

        System.out.println("\n   • ProductsPage.performSearch():");
        productsPage.performSearch("blue top");

        System.out.println("\n   • ContactPage.performSearch():");
        contactPage.performSearch("blue top");

        System.out.println("\n   Notice: Same method name, different behavior!");

        System.out.println("\n🔹 RUNTIME POLYMORPHISM - Method decided at runtime:");
        TestRunner runner = new TestRunner();

        // All three are PolymorphicBasePage type, but behave differently!
        runner.executeSearch(homePage, "jeans");      // Calls HomePage's method
        runner.executeSearch(productsPage, "jeans");  // Calls ProductsPage's method
        runner.executeSearch(contactPage, "jeans");   // Calls ContactPage's method

        System.out.println("\n🔹 METHOD OVERLOADING (Compile-time Polymorphism):");
        SearchHelper helper = new SearchHelper();

        System.out.println("\n   Same method name 'search()', different parameters:");
        helper.search("shirt");                           // Calls version 1
        helper.search("shirt", "Men");                    // Calls version 2
        helper.search("shirt", "Men", 10, 50);           // Calls version 3
        helper.search(new String[]{"shirt", "jeans", "top"}); // Calls version 4

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   In YOUR framework:");
        System.out.println("   • Different pages override methods like verifyPageLoaded()");
        System.out.println("   • HomePage verifies carousel, LoginPage verifies login form");
        System.out.println("   • Same method name, different verification logic!");
        System.out.println("\n   Benefits:");
        System.out.println("   • Write generic test code: page.performSearch(term)");
        System.out.println("   • Works with any page type");
        System.out.println("   • Each page handles search in its own way");
        System.out.println("   • More flexible and maintainable code");

        System.out.println("\n   Real Example:");
        System.out.println("   • BasePage has click() method");
        System.out.println("   • ProductPage might override click() to add logging");
        System.out.println("   • CheckoutPage might override click() to handle confirmations");
    }
}

