package com.myProject.oopsExamples_withAutomationExample;

/**
 * EXAMPLE 6: INTERFACE
 *
 * Interface = Pure abstraction (contract with NO implementation)
 *
 * KEY CONCEPTS:
 * - Interface: 100% abstract, only method signatures
 * - implements keyword: Class implements interface
 * - Multiple interfaces: Class can implement multiple interfaces
 * - WebDriver is an interface: ChromeDriver, FirefoxDriver implement it
 * - Why: Switch browsers without changing test code
 */

// WebDriver Interface (Simplified version of Selenium's WebDriver)
interface WebDriver {
    void get(String url);
    void findElement(String locator);
    void click(String locator);
    String getTitle();
    void quit();
}

// ChromeDriver implements WebDriver interface
class ChromeDriver implements WebDriver {

    private String currentUrl = "";

    @Override
    public void get(String url) {
        this.currentUrl = url;
        System.out.println("      🌐 [ChromeDriver] Navigating to: " + url);
        System.out.println("      🌐 [ChromeDriver] Using Chrome browser engine");
    }

    @Override
    public void findElement(String locator) {
        System.out.println("      🔍 [ChromeDriver] Finding element: " + locator);
    }

    @Override
    public void click(String locator) {
        System.out.println("      👆 [ChromeDriver] Clicking element: " + locator);
    }

    @Override
    public String getTitle() {
        System.out.println("      📄 [ChromeDriver] Getting page title");
        return "Automation Exercise - Chrome";
    }

    @Override
    public void quit() {
        System.out.println("      ❌ [ChromeDriver] Closing Chrome browser");
    }
}

// FirefoxDriver implements WebDriver interface
class FirefoxDriver implements WebDriver {

    private String currentUrl = "";

    @Override
    public void get(String url) {
        this.currentUrl = url;
        System.out.println("      🌐 [FirefoxDriver] Navigating to: " + url);
        System.out.println("      🌐 [FirefoxDriver] Using Firefox browser engine");
    }

    @Override
    public void findElement(String locator) {
        System.out.println("      🔍 [FirefoxDriver] Finding element: " + locator);
    }

    @Override
    public void click(String locator) {
        System.out.println("      👆 [FirefoxDriver] Clicking element: " + locator);
    }

    @Override
    public String getTitle() {
        System.out.println("      📄 [FirefoxDriver] Getting page title");
        return "Automation Exercise - Firefox";
    }

    @Override
    public void quit() {
        System.out.println("      ❌ [FirefoxDriver] Closing Firefox browser");
    }
}

// EdgeDriver implements WebDriver interface
class EdgeDriver implements WebDriver {

    private String currentUrl = "";

    @Override
    public void get(String url) {
        this.currentUrl = url;
        System.out.println("      🌐 [EdgeDriver] Navigating to: " + url);
        System.out.println("      🌐 [EdgeDriver] Using Edge browser engine");
    }

    @Override
    public void findElement(String locator) {
        System.out.println("      🔍 [EdgeDriver] Finding element: " + locator);
    }

    @Override
    public void click(String locator) {
        System.out.println("      👆 [EdgeDriver] Clicking element: " + locator);
    }

    @Override
    public String getTitle() {
        System.out.println("      📄 [EdgeDriver] Getting page title");
        return "Automation Exercise - Edge";
    }

    @Override
    public void quit() {
        System.out.println("      ❌ [EdgeDriver] Closing Edge browser");
    }
}

// Test class that works with ANY WebDriver implementation
class LoginTest {

    // Uses interface type - works with Chrome, Firefox, Edge, etc.
    public void executeLoginTest(WebDriver driver) {
        System.out.println("\n      🧪 Executing Login Test:");
        driver.get("https://automationexercise.com/login");
        driver.findElement("#email");
        driver.click("#email");
        driver.findElement("#password");
        driver.click("#password");
        driver.click("//button[.='Login']");
        String title = driver.getTitle();
        System.out.println("      ✅ Page Title: " + title);
        driver.quit();
    }
}

// Additional Interface Examples

// SearchEngine interface
interface SearchEngine {
    void search(String query);
    int getResultsCount();
}

// Google search implementation
class GoogleSearch implements SearchEngine {
    @Override
    public void search(String query) {
        System.out.println("      🔎 [Google] Searching for: " + query);
    }

    @Override
    public int getResultsCount() {
        return 1000;
    }
}

// Bing search implementation
class BingSearch implements SearchEngine {
    @Override
    public void search(String query) {
        System.out.println("      🔎 [Bing] Searching for: " + query);
    }

    @Override
    public int getResultsCount() {
        return 800;
    }
}

// Class implementing MULTIPLE interfaces
interface Clickable {
    void click();
}

interface Typeable {
    void type(String text);
}

interface Visible {
    boolean isVisible();
}

// WebElement implements multiple interfaces
class WebElement implements Clickable, Typeable, Visible {

    private String locator;

    public WebElement(String locator) {
        this.locator = locator;
    }

    @Override
    public void click() {
        System.out.println("      ✓ Clicking element: " + locator);
    }

    @Override
    public void type(String text) {
        System.out.println("      ✓ Typing '" + text + "' into: " + locator);
    }

    @Override
    public boolean isVisible() {
        System.out.println("      ✓ Checking visibility of: " + locator);
        return true;
    }
}

public class Example6_Interface {

    public static void demonstrate() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("EXAMPLE 6: INTERFACE");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Interface = Contract (what to do, not how to do it)");
        System.out.println("   - 100% abstract (no implementation)");
        System.out.println("   - Classes 'implement' interfaces");
        System.out.println("   - Can implement multiple interfaces");
        System.out.println("   - WebDriver is an interface in Selenium!");

        System.out.println("\n🔹 WebDriver Interface - Real Selenium Example:");
        System.out.println("\n   Test code uses WebDriver interface:");

        LoginTest test = new LoginTest();

        System.out.println("\n   Running test with ChromeDriver:");
        WebDriver chromeDriver = new ChromeDriver();
        test.executeLoginTest(chromeDriver);

        System.out.println("\n   Running same test with FirefoxDriver:");
        WebDriver firefoxDriver = new FirefoxDriver();
        test.executeLoginTest(firefoxDriver);

        System.out.println("\n   Running same test with EdgeDriver:");
        WebDriver edgeDriver = new EdgeDriver();
        test.executeLoginTest(edgeDriver);

        System.out.println("\n   🎯 Notice: Test code didn't change!");
        System.out.println("      Only changed: new ChromeDriver() → new FirefoxDriver()");

        System.out.println("\n🔹 Another Interface Example - SearchEngine:");

        SearchEngine google = new GoogleSearch();
        google.search("Selenium WebDriver");
        System.out.println("      Results: " + google.getResultsCount());

        SearchEngine bing = new BingSearch();
        bing.search("Selenium WebDriver");
        System.out.println("      Results: " + bing.getResultsCount());

        System.out.println("\n🔹 Multiple Interfaces - WebElement:");
        WebElement element = new WebElement("#username");
        element.click();              // From Clickable interface
        element.type("testuser");     // From Typeable interface
        boolean visible = element.isVisible();  // From Visible interface
        System.out.println("      Visible: " + visible);

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   In Selenium:");
        System.out.println("   • WebDriver is an INTERFACE");
        System.out.println("   • ChromeDriver, FirefoxDriver, EdgeDriver IMPLEMENT WebDriver");
        System.out.println("   • Your code: WebDriver driver = new ChromeDriver();");
        System.out.println("   • To switch browser: WebDriver driver = new FirefoxDriver();");
        System.out.println("   • Test code remains same - just change driver initialization!");
        System.out.println("\n   Benefits:");
        System.out.println("   • Write once, run on any browser");
        System.out.println("   • Easy to switch implementations");
        System.out.println("   • Loose coupling - test code doesn't depend on specific browser");
        System.out.println("   • Can create mock implementations for testing");

        System.out.println("\n   Interface vs Abstract Class:");
        System.out.println("   • Interface: 100% abstract, no implementation, multiple inheritance");
        System.out.println("   • Abstract Class: Can have implementation, single inheritance");
        System.out.println("   • Use Interface when: Defining pure contract (like WebDriver)");
        System.out.println("   • Use Abstract Class when: Sharing code among related classes (like BasePage)");
    }
}

