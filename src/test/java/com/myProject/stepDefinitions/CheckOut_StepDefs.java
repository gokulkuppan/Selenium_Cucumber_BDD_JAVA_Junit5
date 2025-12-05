package com.myProject.stepDefinitions;

import com.myProject.pages.CheckOutPage;
import com.myProject.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckOut_StepDefs {
    CheckOutPage checkOutPage = new CheckOutPage();

    @Then("Verify Address Details and Review User's Order")
    public void verify_address_details_and_review_user_s_order() {
        Assertions.assertEquals(ConfigurationReader.get("address"), checkOutPage.getDeliveryAddressText(), "Delivery address mismatch");
        Assertions.assertEquals(2, checkOutPage.getReviewCardProductsSize(), "Number of review products mismatch");
    }

    @When("The user enters description in comment text area and click Place Order")
    public void the_user_enters_description_in_comment_text_area_and_click_place_order() {
        checkOutPage.enterCommentAndPlaceOrder("myComment");
    }

    @Then("Verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        Assertions.assertEquals(ConfigurationReader.get("address"), checkOutPage.getDeliveryAddressText(), "Delivery address mismatch");
    }

    @Then("Verify that the billing address is same address filled at the time registration of account")
    public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
        Assertions.assertEquals(ConfigurationReader.get("address"), checkOutPage.getBillingAddressText(), "Billing address mismatch");
    }




}
