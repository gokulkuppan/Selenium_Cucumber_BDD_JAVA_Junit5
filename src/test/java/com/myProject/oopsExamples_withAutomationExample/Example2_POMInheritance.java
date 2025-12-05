package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 2: PAGE OBJECT MODEL (POM) INHERITANCE PATTERN
 *
 * This demonstrates the REAL inheritance pattern used in Selenium frameworks.
 * Similar to how your HomePage extends BasePage.
 *
 * KEY CONCEPTS:
 * - BasePage: Contains common web actions (click, sendKeys, scroll, etc.)
 * - Page Classes: Inherit from BasePage to reuse common actions
 * - PageFactory pattern: Initialize elements automatically
 * - Why: Every page needs click, sendKeys, etc. - inherit instead of duplicate!
 */

// Simulated WebElement for demonstration (normally from Selenium)
class WebElementSimulation {
    private String locator;

    public WebElementSimulation(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}

// BASE PAGE - Contains all common web actions
// This is similar to your actual BasePage.java
class BasePageExample {

    // Constructor - simulates PageFactory.initElements()
    public BasePageExample() {
        System.out.println("      [BasePage Constructor] Initializing page elements...");
    }

    // Common action methods that all pages can use
    protected void click(WebElementSimulation element) {
        System.out.println("      ✓ Clicking element: " + element.getLocator());
    }

    protected void sendKeys(WebElementSimulation element, String text) {
        System.out.println("      ✓ Entering text '" + text + "' into: " + element.getLocator());
    }

    protected void scrollToElement(WebElementSimulation element) {
        System.out.println("      ✓ Scrolling to element: " + element.getLocator());
    }

    protected String getText(WebElementSimulation element) {
        System.out.println("      ✓ Getting text from: " + element.getLocator());
        return "Sample Text";
    }

    protected boolean isDisplayed(WebElementSimulation element) {
        System.out.println("      ✓ Checking if element is displayed: " + element.getLocator());
        return true;
    }

    protected void waitForElement(WebElementSimulation element, int seconds) {
        System.out.println("      ✓ Waiting " + seconds + " seconds for: " + element.getLocator());
    }
}

// HOME PAGE - Inherits from BasePage (just like your HomePage.java)
class HomePageExample extends BasePageExample {

    // Page-specific elements (simulating @FindBy annotations)
    private WebElementSimulation subscriptionText = new WebElementSimulation("//h2[.='Subscription']");
    private WebElementSimulation subscribeEmailBox = new WebElementSimulation("#subscribe_email");
    private WebElementSimulation scrollUpArrow = new WebElementSimulation("#scrollUp");

    public HomePageExample() {
        super(); // Calls parent constructor
        System.out.println("      [HomePage Constructor] HomePage specific initialization");
    }

    // Page-specific methods using INHERITED common actions
    public void scrollDownToSubscription() {
        scrollToElement(subscriptionText);  // Inherited from BasePage!
    }

    public void enterEmailAndSubscribe(String email) {
        sendKeys(subscribeEmailBox, email); // Inherited from BasePage!
        System.out.println("      ✓ Pressing Enter to subscribe");
    }

    public void clickScrollUpArrow() {
        click(scrollUpArrow);               // Inherited from BasePage!
    }

    public boolean isSubscriptionVisible() {
        return isDisplayed(subscriptionText); // Inherited from BasePage!
    }
}

// LOGIN PAGE - Also inherits from BasePage
class LoginPageExample extends BasePageExample {

    // Page-specific elements
    private WebElementSimulation emailField = new WebElementSimulation("#email");
    private WebElementSimulation passwordField = new WebElementSimulation("#password");
    private WebElementSimulation loginButton = new WebElementSimulation("//button[.='Login']");

    public LoginPageExample() {
        super();
        System.out.println("      [LoginPage Constructor] LoginPage specific initialization");
    }

    // Page-specific methods using INHERITED common actions
    public void enterEmail(String email) {
        sendKeys(emailField, email);        // Inherited from BasePage!
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);  // Inherited from BasePage!
    }

    public void clickLoginButton() {
        waitForElement(loginButton, 5);     // Inherited from BasePage!
        click(loginButton);                 // Inherited from BasePage!
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}

// Main demonstration class
public class Example2_POMInheritance {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 2: PAGE OBJECT MODEL (POM) INHERITANCE");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   In POM, BasePage contains common Selenium actions (click, sendKeys, etc.)");
        System.out.println("   All page classes (HomePage, LoginPage, etc.) extend BasePage.");
        System.out.println("   This is EXACTLY like your HomePage extends BasePage!");

        System.out.println("\n🔹 Creating HomePage (extends BasePage):");
        HomePageExample homePage = new HomePageExample();
        System.out.println("\n   HomePage Actions:");
        homePage.scrollDownToSubscription();  // Uses inherited scrollToElement()
        homePage.enterEmailAndSubscribe("test@example.com"); // Uses inherited sendKeys()
        homePage.clickScrollUpArrow();        // Uses inherited click()
        homePage.isSubscriptionVisible();     // Uses inherited isDisplayed()

        System.out.println("\n🔹 Creating LoginPage (also extends BasePage):");
        LoginPageExample loginPage = new LoginPageExample();
        System.out.println("\n   LoginPage Actions:");
        loginPage.login("user@test.com", "password123"); // Uses inherited methods

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   BasePage = Reusable Selenium actions (click, sendKeys, scroll, etc.)");
        System.out.println("   HomePage/LoginPage = Specific page logic using inherited actions");
        System.out.println("   Benefit: Write click() once in BasePage, use everywhere!");
        System.out.println("\n   YOUR ACTUAL CODE:");
        System.out.println("   - BasePage has: click(), sendKeys(), scrollToElement()");
        System.out.println("   - HomePage extends BasePage and uses these methods");
        System.out.println("   - This avoids duplicating Selenium code in every page class!");
    }
}

