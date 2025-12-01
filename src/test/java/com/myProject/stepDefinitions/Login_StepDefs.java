package com.myProject.stepDefinitions;

import com.myProject.pages.LoginPage;
import com.myProject.pages.RegisterPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Then("Verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        String expectedText = "Login to your account";
        String actualText = loginPage.getLoginYourAccountText();
        Assertions.assertEquals(expectedText, actualText, "Login to your account text mismatch");
    }

    @When("The user enters correct email address and password")
    public void the_user_enters_correct_email_address_and_password() {
        loginPage.enterLoginInfo();
    }

    @When("The user clicks login button")
    public void the_user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("Verify that ACCOUNT DELETED! is visible")
    public void verify_that_account_deleted_is_visible() {
        String expectedText = "ACCOUNT DELETED!";
        String actualText = registerPage.getAccountDeletedText();
        Assertions.assertEquals(expectedText, actualText, "Account deleted text mismatch");
    }

    @When("The user enters incorrect email address and password")
    public void the_user_enters_incorrect_email_address_and_password() {
        loginPage.enterWrongLoginInfo();
    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible() {
        Assertions.assertTrue(loginPage.isIncorrectTextDisplayed(), "Incorrect login error message is not displayed");
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        String expectedUrl = "https://www.automationexercise.com/login";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Login page URL mismatch");
    }
}
