package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 3: ENCAPSULATION
 *
 * Encapsulation = Data Hiding + Controlled Access
 *
 * KEY CONCEPTS:
 * - Private fields: Hide internal data/elements
 * - Public methods: Provide controlled access
 * - Why in POM: WebElements are private, accessed through public methods
 * - Benefits: Security, validation, flexibility to change implementation
 */

// BAD PRACTICE - No Encapsulation
class BadLoginPage {
    // Public fields - anyone can access and modify directly!
    public String usernameLocator = "#username";
    public String passwordLocator = "#password";
    public String loginButtonLocator = "//button[@id='login']";

    // Problem: Test code can directly access and break things
}

// GOOD PRACTICE - With Encapsulation (like your actual Page classes)
class GoodLoginPage {
    // PRIVATE fields - hidden from outside world
    private String usernameLocator = "#username";
    private String passwordLocator = "#password";
    private String loginButtonLocator = "//button[@id='login']";
    private String currentUsername = "";

    // PUBLIC methods - controlled access with validation
    public void enterUsername(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("      ⚠️  Username cannot be empty!");
            return;
        }
        this.currentUsername = username;
        System.out.println("      ✓ Entering username: " + username + " in locator: " + usernameLocator);
    }

    public void enterPassword(String password) {
        if (password == null || password.length() < 6) {
            System.out.println("      ⚠️  Password must be at least 6 characters!");
            return;
        }
        System.out.println("      ✓ Entering password: " + "*".repeat(password.length()) + " in locator: " + passwordLocator);
    }

    public void clickLogin() {
        if (currentUsername.isEmpty()) {
            System.out.println("      ⚠️  Cannot login - username not entered!");
            return;
        }
        System.out.println("      ✓ Clicking login button at: " + loginButtonLocator);
    }

    // Getter with validation
    public String getCurrentUsername() {
        return currentUsername;
    }

    // Private helper method - not accessible from outside
    private boolean validateCredentials() {
        System.out.println("      ✓ Validating credentials internally...");
        return !currentUsername.isEmpty();
    }
}

// Real POM Example - Encapsulated Product Page
class ProductPageEncapsulated {
    // PRIVATE WebElements - hidden from test code
    private String productNameLocator = "//h2[@class='product-name']";
    private String priceLocator = "//span[@class='price']";
    private String addToCartButtonLocator = "#add-to-cart";
    private String quantityInputLocator = "#quantity";

    // Private state
    private int currentQuantity = 1;

    // PUBLIC interface for test code
    public String getProductName() {
        System.out.println("      ✓ Retrieving product name from: " + productNameLocator);
        return "Blue Top"; // Simulated
    }

    public String getPrice() {
        System.out.println("      ✓ Retrieving price from: " + priceLocator);
        return "$25.00"; // Simulated
    }

    public void setQuantity(int quantity) {
        if (quantity < 1 || quantity > 10) {
            System.out.println("      ⚠️  Quantity must be between 1 and 10");
            return;
        }
        this.currentQuantity = quantity;
        System.out.println("      ✓ Setting quantity to " + quantity + " in: " + quantityInputLocator);
    }

    public void addToCart() {
        System.out.println("      ✓ Adding " + currentQuantity + " item(s) to cart");
        System.out.println("      ✓ Clicking: " + addToCartButtonLocator);
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    // Private helper - implementation detail hidden
    private void waitForPriceToLoad() {
        System.out.println("      ✓ Internal: Waiting for price element to load...");
    }
}

public class Example3_Encapsulation {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 3: ENCAPSULATION");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Encapsulation = Hiding internal details + Providing controlled access");
        System.out.println("   Private fields (WebElements) + Public methods (actions)");

        System.out.println("\n❌ BAD Practice - No Encapsulation:");
        BadLoginPage badPage = new BadLoginPage();
        System.out.println("   Problem: Can directly access fields:");
        System.out.println("   - badPage.usernameLocator = \"" + badPage.usernameLocator + "\"");
        badPage.usernameLocator = "//wrong-xpath"; // Can break the page!
        System.out.println("   - Someone changed it to: \"" + badPage.usernameLocator + "\" - BROKEN!");

        System.out.println("\n✅ GOOD Practice - With Encapsulation:");
        GoodLoginPage goodPage = new GoodLoginPage();
        // goodPage.usernameLocator = "//wrong"; // Compilation Error! Cannot access private field
        System.out.println("\n   Using public methods with validation:");
        goodPage.enterUsername("testuser");
        goodPage.enterPassword("pass123");
        goodPage.clickLogin();
        System.out.println("   Current user: " + goodPage.getCurrentUsername());

        System.out.println("\n   Testing validation:");
        goodPage.enterUsername("");  // Validation prevents empty username
        goodPage.enterPassword("123"); // Validation prevents short password

        System.out.println("\n🔹 Real POM Example - Product Page:");
        ProductPageEncapsulated productPage = new ProductPageEncapsulated();
        String productName = productPage.getProductName();
        String price = productPage.getPrice();
        System.out.println("   Product: " + productName + ", Price: " + price);

        productPage.setQuantity(3);
        productPage.addToCart();

        System.out.println("\n   Testing validation:");
        productPage.setQuantity(15);  // Validation prevents invalid quantity

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   In YOUR HomePage.java:");
        System.out.println("   - WebElements are PRIVATE (subscriptionText, footer, etc.)");
        System.out.println("   - Methods are PUBLIC (scrollDownToFooter(), enterEmailAndSubscribe())");
        System.out.println("   - Test code cannot break locators, only use safe public methods");
        System.out.println("   - You can add validation, logging without affecting test code!");
    }
}

