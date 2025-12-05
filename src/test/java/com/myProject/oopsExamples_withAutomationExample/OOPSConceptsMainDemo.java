package com.myProject.oopsExamples_withAutomationExample;

/**
 * MAIN DEMO CLASS - OOP CONCEPTS IN TEST AUTOMATION
 *
 * This class demonstrates all OOP concepts used in Selenium test automation frameworks.
 * Run this main method to see all examples in action.
 *
 * @author Test Automation Framework
 * @version 1.0
 */
public class OOPSConceptsMainDemo {

    public static void main(String[] args) {

        printHeader();
        printIntroduction();

        // Execute all examples
        try {
            Example1_InheritanceBasics.demonstrate();
            waitForUser();

            Example2_POMInheritance.demonstrate();
            waitForUser();

            Example3_Encapsulation.demonstrate();
            waitForUser();

            Example4_Abstraction.demonstrate();
            waitForUser();

            Example5_Polymorphism.demonstrate();
            waitForUser();

            Example6_Interface.demonstrate();
            waitForUser();

            printSummary();
            printYourFrameworkMapping();

        } catch (Exception e) {
            System.err.println("\n❌ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printHeader() {
        System.out.println("\n");
        System.out.println("╔" + "═".repeat(78) + "╗");
        System.out.println("║" + centerText("OOP CONCEPTS IN TEST AUTOMATION", 78) + "║");
        System.out.println("║" + centerText("Selenium + Page Object Model (POM)", 78) + "║");
        System.out.println("╚" + "═".repeat(78) + "╝");
    }

    private static void printIntroduction() {
        System.out.println("\n📖 INTRODUCTION:");
        System.out.println("   This demo covers all OOP concepts used in Selenium test automation:");
        System.out.println("   1. Inheritance     - BasePage pattern (code reusability)");
        System.out.println("   2. Encapsulation   - Private elements + Public methods (data hiding)");
        System.out.println("   3. Abstraction     - Abstract BasePage (enforcing structure)");
        System.out.println("   4. Polymorphism    - Method overriding (flexible behavior)");
        System.out.println("   5. Interface       - WebDriver interface (loose coupling)");
        System.out.println("\n   Each example shows:");
        System.out.println("   • What the concept is");
        System.out.println("   • Why it's used in test automation");
        System.out.println("   • How it works in your framework");
        System.out.println("\n" + "─".repeat(80));
    }

    private static void printSummary() {
        System.out.println("\n" + "═".repeat(80));
        System.out.println("📊 SUMMARY OF ALL OOP CONCEPTS");
        System.out.println("═".repeat(80));

        System.out.println("\n1️⃣  INHERITANCE:");
        System.out.println("   ├─ Parent class (BasePage) → Child classes (HomePage, LoginPage)");
        System.out.println("   ├─ Benefit: Reuse common code across all pages");
        System.out.println("   └─ Example: All pages inherit click(), sendKeys(), scrollToElement()");

        System.out.println("\n2️⃣  ENCAPSULATION:");
        System.out.println("   ├─ Private WebElements + Public action methods");
        System.out.println("   ├─ Benefit: Hide implementation, prevent direct access to elements");
        System.out.println("   └─ Example: private WebElement loginButton + public clickLoginButton()");

        System.out.println("\n3️⃣  ABSTRACTION:");
        System.out.println("   ├─ Abstract BasePage with abstract methods");
        System.out.println("   ├─ Benefit: Force all pages to implement required methods");
        System.out.println("   └─ Example: abstract getPageTitle() - each page must implement");

        System.out.println("\n4️⃣  POLYMORPHISM:");
        System.out.println("   ├─ Same method, different implementation in child classes");
        System.out.println("   ├─ Benefit: Flexible behavior based on page type");
        System.out.println("   └─ Example: verifyPageLoaded() - different for HomePage vs LoginPage");

        System.out.println("\n5️⃣  INTERFACE:");
        System.out.println("   ├─ WebDriver interface implemented by ChromeDriver, FirefoxDriver");
        System.out.println("   ├─ Benefit: Switch browsers without changing test code");
        System.out.println("   └─ Example: WebDriver driver = new ChromeDriver() or FirefoxDriver()");
    }

    private static void printYourFrameworkMapping() {
        System.out.println("\n" + "═".repeat(80));
        System.out.println("🗺️  MAPPING TO YOUR ACTUAL FRAMEWORK");
        System.out.println("═".repeat(80));

        System.out.println("\n📁 YOUR CODE STRUCTURE:");
        System.out.println("   src/test/java/com/myProject/pages/");
        System.out.println("   ├─ BasePage.java          ← Abstract parent class");
        System.out.println("   ├─ HomePage.java          ← extends BasePage (INHERITANCE)");
        System.out.println("   ├─ LoginPage.java         ← extends BasePage (INHERITANCE)");
        System.out.println("   └─ ProductPage.java       ← extends BasePage (INHERITANCE)");

        System.out.println("\n🔍 YOUR BasePage.java:");
        System.out.println("   public abstract class BasePage extends BrowserUtils {");
        System.out.println("       // Constructor - initializes page elements");
        System.out.println("       public BasePage() {");
        System.out.println("           PageFactory.initElements(Driver.get(), this);");
        System.out.println("       }");
        System.out.println("       ");
        System.out.println("       // Common methods inherited by all pages");
        System.out.println("       protected void click(WebElement element) { ... }");
        System.out.println("       protected void sendKeys(WebElement element, String text) { ... }");
        System.out.println("       protected void scrollToElement(WebElement element) { ... }");
        System.out.println("   }");

        System.out.println("\n🔍 YOUR HomePage.java:");
        System.out.println("   public class HomePage extends BasePage {  // INHERITANCE");
        System.out.println("       ");
        System.out.println("       // ENCAPSULATION - private elements");
        System.out.println("       @FindBy(xpath = \"//h2[.='Subscription']\")");
        System.out.println("       private WebElement subscriptionText;");
        System.out.println("       ");
        System.out.println("       @FindBy(id = \"susbscribe_email\")");
        System.out.println("       private WebElement susbscribeEmailBox;");
        System.out.println("       ");
        System.out.println("       // ENCAPSULATION - public methods");
        System.out.println("       public void scrollDownToFooter() {");
        System.out.println("           scrollToElement(footer);  // Inherited from BasePage!");
        System.out.println("       }");
        System.out.println("       ");
        System.out.println("       public void enterEmailAndSubscribe(String email) {");
        System.out.println("           sendKeys(susbscribeEmailBox, email);  // Inherited!");
        System.out.println("       }");
        System.out.println("   }");

        System.out.println("\n🔍 Driver.java (Using WebDriver INTERFACE):");
        System.out.println("   public class Driver {");
        System.out.println("       private static WebDriver driver;  // INTERFACE type");
        System.out.println("       ");
        System.out.println("       public static WebDriver get() {");
        System.out.println("           if (driver == null) {");
        System.out.println("               // POLYMORPHISM - different driver based on config");
        System.out.println("               if (browser.equals(\"chrome\")) {");
        System.out.println("                   driver = new ChromeDriver();  // Implementation 1");
        System.out.println("               } else if (browser.equals(\"firefox\")) {");
        System.out.println("                   driver = new FirefoxDriver(); // Implementation 2");
        System.out.println("               }");
        System.out.println("           }");
        System.out.println("           return driver;");
        System.out.println("       }");
        System.out.println("   }");

        System.out.println("\n✨ HOW OOP MAKES YOUR FRAMEWORK BETTER:");
        System.out.println("   • Less code duplication (write click() once, use everywhere)");
        System.out.println("   • Easier maintenance (change BasePage, affects all pages)");
        System.out.println("   • More flexible (add new pages easily by extending BasePage)");
        System.out.println("   • Better organization (clear structure and relationships)");
        System.out.println("   • Reusable components (common actions in BasePage)");
        System.out.println("   • Easy browser switching (WebDriver interface)");
    }

    private static void waitForUser() {
        System.out.println("\n" + "─".repeat(80));
        System.out.println("Press Enter to continue to next example...");
        System.out.println("─".repeat(80));
        try {
            // In IDE, just pause briefly instead of waiting for input
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text + " ".repeat(Math.max(0, padding));
    }

    // Additional utility methods for demonstration
    private static void printFooter() {
        System.out.println("\n" + "═".repeat(80));
        System.out.println("✅ ALL EXAMPLES COMPLETED SUCCESSFULLY!");
        System.out.println("═".repeat(80));
        System.out.println("\n📚 Next Steps:");
        System.out.println("   1. Review each example file to understand the concepts");
        System.out.println("   2. Compare with your actual BasePage.java and HomePage.java");
        System.out.println("   3. Try modifying examples to experiment");
        System.out.println("   4. Apply these concepts in your test automation framework");
        System.out.println("\n💡 Remember:");
        System.out.println("   OOP is not just theory - it's what makes your framework");
        System.out.println("   maintainable, scalable, and professional!");
        System.out.println("\n");
    }
}

