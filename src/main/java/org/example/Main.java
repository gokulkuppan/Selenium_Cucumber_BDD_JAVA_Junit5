package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Navigate to Google
            System.out.println("Navigating to Google.com...");
            driver.get("https://www.google.com");

            // Print the page title
            System.out.println("Page Title: " + driver.getTitle());

            // Wait for 3 seconds to see the page
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            System.out.println("Closing browser...");
            driver.quit();
        }
    }
}