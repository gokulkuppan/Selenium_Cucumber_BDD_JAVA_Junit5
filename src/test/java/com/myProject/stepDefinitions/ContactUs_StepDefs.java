package com.myProject.stepDefinitions;

import com.myProject.pages.ContactUsPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ContactUs_StepDefs {
    ContactUsPage contactUsPage = new ContactUsPage();

    @Then("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        Assertions.assertTrue(contactUsPage.isGetInTouchTextDisplayed(), "Get In Touch text is not displayed");
    }

    @When("The user enters name, email, subject and message")
    public void the_user_enters_name_email_subject_and_message() {
        contactUsPage.fillContactUsForm();
    }

    @When("The user uploads file")
    public void the_user_uploads_file() {
        contactUsPage.uploadFile();
    }

    @When("The User clicks Submit button")
    public void the_user_clicks_submit_button() {
        contactUsPage.clickSubmitButton();
    }

    @When("The user clicks OK button")
    public void the_user_clicks_ok_button() {
        contactUsPage.acceptAlert();
    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        Assertions.assertTrue(contactUsPage.isSuccessTextDisplayed(), "Success message is not displayed");
    }

    @When("The user clicks Home button")
    public void the_user_clicks_home_button() {
        contactUsPage.clickHomeButton();
    }

    @Then("Verify that landed to home page successfully")
    public void verify_that_landed_to_home_page_successfully() {
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Home page URL mismatch");
    }
}
