package com.myProject.stepDefinitions;

import com.myProject.pages.PaymentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class Payment_StepDefs {
    PaymentPage paymentPage = new PaymentPage();

    @When("The user enters payment details: Name on Card, Card Number, CVC, Expiration date")
    public void the_user_enters_payment_details_name_on_card_card_number_cvc_expiration_date() {
        paymentPage.fillCardDetails();
    }

    @When("The user clicks Pay and Confirm Order button")
    public void the_user_clicks_pay_and_confirm_order_button() {
        paymentPage.clickPayAndConfirmOrderButton();
    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        Assertions.assertTrue(paymentPage.isSuccessMessageDisplayed(), "Order success message is not displayed");
    }

    @When("The user clicks Download Invoice button")
    public void the_user_clicks_download_invoice_button() {
        paymentPage.clickDownloadInvoiceButton();
    }

    @When("Verify invoice is downloaded successfully")
    public void verify_invoice_is_downloaded_successfully() {
        Assertions.assertTrue(paymentPage.isInvoiceDownloaded(), "Invoice file is not downloaded");
    }
}
