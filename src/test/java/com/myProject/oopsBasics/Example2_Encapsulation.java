package com.myProject.oopsBasics;

/**
 * EXAMPLE 2: ENCAPSULATION
 *
 * Encapsulation is the bundling of data (variables) and methods that operate on the data
 * into a single unit (class), and restricting access to some components.
 *
 * KEY CONCEPTS:
 * - Private variables: Data hiding
 * - Public getter/setter methods: Controlled access
 * - Data validation: Ensure data integrity
 * - Benefits: Security, flexibility, maintainability
 */

class BankAccount {
    // Private variables - cannot be accessed directly from outside
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = 0.0;
    }

    // Public getter for accountNumber (read-only, no setter)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Public getter for accountHolder (read-only, no setter)
    public String getAccountHolder() {
        return accountHolder;
    }

    // Public getter for balance (read-only, no setter)
    public double getBalance() {
        return balance;
    }

    // Controlled method to deposit money with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ Deposited: $" + amount);
            System.out.println("  New Balance: $" + balance);
        } else {
            System.out.println("✗ Invalid deposit amount!");
        }
    }

    // Controlled method to withdraw money with validation
    public boolean withdraw(double amount, String enteredPin) {
        // Validate PIN
        if (!pin.equals(enteredPin)) {
            System.out.println("✗ Invalid PIN!");
            return false;
        }

        // Validate amount
        if (amount <= 0) {
            System.out.println("✗ Invalid withdrawal amount!");
            return false;
        }

        // Check sufficient balance
        if (amount > balance) {
            System.out.println("✗ Insufficient funds!");
            return false;
        }

        balance -= amount;
        System.out.println("✓ Withdrawn: $" + amount);
        System.out.println("  Remaining Balance: $" + balance);
        return true;
    }

    // Method to display account info (without sensitive data)
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("PIN: ****"); // Hidden for security
    }

    // Method to change PIN (requires old PIN for security)
    public boolean changePin(String oldPin, String newPin) {
        if (pin.equals(oldPin)) {
            if (newPin.length() >= 4) {
                pin = newPin;
                System.out.println("✓ PIN changed successfully!");
                return true;
            } else {
                System.out.println("✗ New PIN must be at least 4 digits!");
                return false;
            }
        } else {
            System.out.println("✗ Invalid old PIN!");
            return false;
        }
    }
}

public class Example2_Encapsulation {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("EXAMPLE 2: ENCAPSULATION");
        System.out.println("=".repeat(70));

        System.out.println("\n📚 CONCEPT:");
        System.out.println("   Encapsulation hides internal data and provides controlled access.");
        System.out.println("   Private variables protect sensitive data (balance, PIN).");
        System.out.println("   Public methods provide controlled access with validation.");

        System.out.println("\n🏦 Creating Bank Account:");
        BankAccount account = new BankAccount("ACC12345", "John Doe", "1234");
        account.displayAccountInfo();

        System.out.println("\n💰 Depositing Money:");
        account.deposit(1000);
        account.deposit(500);

        System.out.println("\n💸 Attempting Withdrawal (Wrong PIN):");
        account.withdraw(200, "9999");

        System.out.println("\n💸 Attempting Withdrawal (Correct PIN):");
        account.withdraw(200, "1234");

        System.out.println("\n💸 Attempting Withdrawal (Insufficient Funds):");
        account.withdraw(5000, "1234");

        System.out.println("\n🔐 Changing PIN:");
        account.changePin("1234", "5678");

        System.out.println("\n💸 Withdrawal with New PIN:");
        account.withdraw(100, "5678");

        System.out.println("\n📊 Final Account Status:");
        account.displayAccountInfo();

        // This would cause compilation error (private variable):
        // account.balance = 1000000; // Cannot access private variable
        // account.pin = "0000";      // Cannot access private variable

        System.out.println("\n✅ KEY TAKEAWAY:");
        System.out.println("   Encapsulation protects sensitive data from direct access.");
        System.out.println("   All operations go through controlled methods with validation.");
        System.out.println("   This ensures data integrity and security!");
    }
}

