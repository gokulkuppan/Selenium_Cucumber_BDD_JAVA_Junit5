package com.myProject.stepDefinitions;

import com.myProject.pages.HomePage;
import com.myProject.pages.RegisterPage;
import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;

public class Register_StepDefs implements En {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();

    public Register_StepDefs() {
        When("The user is on the home page", () -> {
            Driver.get().get(ConfigurationReader.get("url"));
            String expectedUrl = ConfigurationReader.get("url");
            String actualUrl = Driver.get().getCurrentUrl();
            Assertions.assertEquals(expectedUrl, actualUrl);
        });

        When("The user clicks {string} menu button", (String tabName) -> {
            homePage.navigateToTabs(tabName);
            registerPage.dismissAdOnSignup();
        });

        Then("Verify New User Signup! is visible", () -> {
            String expectedText = "New User Signup!";
            String actualText = registerPage.getNewUserSignupText();
            Assertions.assertEquals(expectedText, actualText, "New User Signup text mismatch");
        });

        When("The user enters name and email address", () -> {
            registerPage.enterNameAndEmail();
        });

        When("The user clicks Signup button", () -> {
            registerPage.clickSignupButton();
        });

        Then("Verify that ENTER ACCOUNT INFORMATION is visible", () -> {
            String expectedText = "ENTER ACCOUNT INFORMATION";
            String actualText = registerPage.getEnterAccountText();
            Assertions.assertEquals(expectedText, actualText, "Enter Account Information text mismatch");
        });

        When("The user fills in account information", () -> {
            registerPage.fillRegistrationForm();
        });

        Then("Verify that ACCOUNT CREATED! is visible", () -> {
            String expectedText = "ACCOUNT CREATED!";
            String actualText = registerPage.getAccountCreatedText();
            Assertions.assertEquals(expectedText, actualText, "Account Created text mismatch");
        });

        When("The user clicks Continue button", () -> {
            registerPage.clickContinueButton();
        });

        When("The user clicks Dismiss button", () -> {
            registerPage.dismissAd();
        });

        Then("Verify that Logged in as username is visible", () -> {
            String expectedText = "Logged in as " + ConfigurationReader.get("firstName");
            String actualText = registerPage.getLoggedInText();
            Assertions.assertEquals(expectedText, actualText, "Logged in as username text mismatch");
        });

        When("The user clicks Delete Account button", () -> {
            registerPage.clickDeleteAccountButton();
        });

        Then("Verify that {string} is visible", (String expectedText) -> {
            String actualText = registerPage.getAccountDeletedText();
            Assertions.assertEquals(expectedText, actualText, "Account deleted text mismatch");
        });

        When("The user clicks Continue2 button", () -> {
            registerPage.clickContinueButton();
        });

        Then("Verify error Email Address already exist! is visible", () -> {
            Assertions.assertTrue(registerPage.isAlreadyExistTextDisplayed(), "Email Address already exist error is not displayed");
        });
    }

}
