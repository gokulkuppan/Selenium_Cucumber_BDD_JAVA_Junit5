package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 4: ABSTRACTION
 *
 * Abstraction = Hiding implementation details, showing only essential features
 *
 * KEY CONCEPTS:
 * - Abstract class: Cannot be instantiated, can have abstract & concrete methods
 * - Abstract method: Declaration without implementation (child must implement)
 * - Why: Force all pages to implement certain methods (e.g., getPageTitle)
 * - Your BasePage is abstract - cannot create BasePage object directly
 */

// Abstract Base Page - Defines contract for all pages
abstract class AbstractBasePage {

    protected String pageName;

    public AbstractBasePage(String pageName) {
        this.pageName = pageName;
        System.out.println("      [" + pageName + "] Initializing page...");
    }

    // Concrete method - has implementation, inherited by all
    public void click(String locator) {
        System.out.println("      ✓ Clicking element: " + locator);
    }

    public void sendKeys(String locator, String text) {
        System.out.println("      ✓ Entering '" + text + "' into: " + locator);
    }

    // ABSTRACT methods - no implementation, child MUST implement
    public abstract String getPageTitle();
    public abstract void verifyPageLoaded();
    public abstract String getPageURL();
}

// Concrete Home Page - Must implement all abstract methods
class AbstractHomePage extends AbstractBasePage {

    public AbstractHomePage() {
        super("HomePage");
    }

    // MUST implement - forced by abstract parent
    @Override
    public String getPageTitle() {
        System.out.println("      ✓ Getting HomePage title");
        return "Automation Exercise - Home";
    }

    @Override
    public void verifyPageLoaded() {
        System.out.println("      ✓ Verifying HomePage loaded by checking carousel");
    }

    @Override
    public String getPageURL() {
        return "https://automationexercise.com/";
    }

    // HomePage specific method
    public void clickProduct() {
        click("//a[.='View Product']"); // Using inherited method
        System.out.println("      ✓ HomePage: Product clicked");
    }
}

// Concrete Login Page - Must implement all abstract methods
class AbstractLoginPage extends AbstractBasePage {

    public AbstractLoginPage() {
        super("LoginPage");
    }

    // MUST implement - forced by abstract parent
    @Override
    public String getPageTitle() {
        System.out.println("      ✓ Getting LoginPage title");
        return "Automation Exercise - Login";
    }

    @Override
    public void verifyPageLoaded() {
        System.out.println("      ✓ Verifying LoginPage loaded by checking login form");
    }

    @Override
    public String getPageURL() {
        return "https://automationexercise.com/login";
    }

    // LoginPage specific method
    public void login(String email, String password) {
        sendKeys("#email", email);      // Using inherited method
        sendKeys("#password", password); // Using inherited method
        click("//button[.='Login']");    // Using inherited method
        System.out.println("      ✓ LoginPage: Login submitted");
    }
}

// Concrete Product Page - Must implement all abstract methods
class AbstractProductPage extends AbstractBasePage {

    public AbstractProductPage() {
        super("ProductPage");
    }

    @Override
    public String getPageTitle() {
        System.out.println("      ✓ Getting ProductPage title");
        return "Automation Exercise - Product Details";
    }

    @Override
    public void verifyPageLoaded() {
        System.out.println("      ✓ Verifying ProductPage loaded by checking product details");
    }

    @Override
    public String getPageURL() {
        return "https://automationexercise.com/product_details/1";
    }

    public void addToCart() {
        click("//button[.='Add to cart']");
        System.out.println("      ✓ ProductPage: Added to cart");
    }
}

// Demonstration of using abstract classes
class PageManager {

    public void validatePage(AbstractBasePage page) {
        // Can accept any page that extends AbstractBasePage
        System.out.println("\n   📋 Validating Page:");
        System.out.println("      Page: " + page.pageName);
        System.out.println("      Title: " + page.getPageTitle());
        System.out.println("      URL: " + page.getPageURL());
        page.verifyPageLoaded();
    }
}

public class Example4_Abstraction {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 4: ABSTRACTION");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Abstract class = Blueprint with some implementation + mandatory methods");
        System.out.println("   - Cannot create object of abstract class directly");
        System.out.println("   - Child classes MUST implement all abstract methods");
        System.out.println("   - Forces consistency across all page classes");

        System.out.println("\n🔹 Trying to create abstract class object:");
        System.out.println("   ❌ AbstractBasePage page = new AbstractBasePage(); // Compilation Error!");
        System.out.println("   Reason: Cannot instantiate abstract class");

        System.out.println("\n✅ Creating concrete page objects:");

        // Create HomePage
        System.out.println("\n   Creating HomePage:");
        AbstractHomePage homePage = new AbstractHomePage();
        System.out.println("      Title: " + homePage.getPageTitle());
        homePage.verifyPageLoaded();
        homePage.clickProduct();

        // Create LoginPage
        System.out.println("\n   Creating LoginPage:");
        AbstractLoginPage loginPage = new AbstractLoginPage();
        System.out.println("      Title: " + loginPage.getPageTitle());
        loginPage.verifyPageLoaded();
        loginPage.login("test@test.com", "password");

        // Create ProductPage
        System.out.println("\n   Creating ProductPage:");
        AbstractProductPage productPage = new AbstractProductPage();
        System.out.println("      Title: " + productPage.getPageTitle());
        productPage.verifyPageLoaded();
        productPage.addToCart();

        // Using PageManager with abstraction
        System.out.println("\n🔹 Using Abstraction - PageManager validates any page:");
        PageManager manager = new PageManager();
        manager.validatePage(homePage);    // Polymorphism!
        manager.validatePage(loginPage);   // Works with any AbstractBasePage
        manager.validatePage(productPage);

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   YOUR BasePage is abstract:");
        System.out.println("   - You cannot do: new BasePage() ❌");
        System.out.println("   - All pages extend BasePage: HomePage extends BasePage ✓");
        System.out.println("   - Abstract methods ensure all pages implement required methods");
        System.out.println("   - Provides consistent structure across all page objects");
        System.out.println("\n   Benefits:");
        System.out.println("   • Forces all pages to implement getPageTitle(), verifyPageLoaded()");
        System.out.println("   • Provides common methods (click, sendKeys) to all pages");
        System.out.println("   • Maintains consistency in framework architecture");
    }
}

