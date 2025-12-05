package com.myProject.oopsBasics;

/**
 * MAIN CLASS TO RUN ALL OOP EXAMPLES
 *
 * This class runs all OOP concept examples in sequence.
 * You can also run each example individually by running its main method.
 */
public class RunAllExamples {

    public static void main(String[] args) {
        System.out.println("\n\n");
        System.out.println("╔" + "═".repeat(68) + "╗");
        System.out.println("║" + " ".repeat(15) + "OBJECT-ORIENTED PROGRAMMING EXAMPLES" + " ".repeat(16) + "║");
        System.out.println("║" + " ".repeat(22) + "Learn OOP the Easy Way!" + " ".repeat(23) + "║");
        System.out.println("╚" + "═".repeat(68) + "╝");

        try {
            // Example 1: Inheritance
            Example1_InheritanceBasics.main(new String[]{});
            Thread.sleep(2000);

            // Example 2: Encapsulation
            Example2_Encapsulation.main(new String[]{});
            Thread.sleep(2000);

            // Example 3: Polymorphism
            Example3_Polymorphism.main(new String[]{});
            Thread.sleep(2000);

            // Example 4: Abstraction
            Example4_Abstraction.main(new String[]{});
            Thread.sleep(2000);

            // Example 5: All Concepts Together
            Example5_AllConcepts.main(new String[]{});

            System.out.println("\n\n");
            System.out.println("╔" + "═".repeat(68) + "╗");
            System.out.println("║" + " ".repeat(20) + "🎉 ALL EXAMPLES COMPLETED! 🎉" + " ".repeat(19) + "║");
            System.out.println("╚" + "═".repeat(68) + "╝");
            System.out.println("\n📝 To run individual examples, execute their main() methods directly.");
            System.out.println("   Example: Right-click on Example1_InheritanceBasics and 'Run'\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

