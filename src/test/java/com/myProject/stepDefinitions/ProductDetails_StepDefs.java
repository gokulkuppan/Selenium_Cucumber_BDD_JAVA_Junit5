package com.myProject.stepDefinitions;

import com.myProject.pages.ProductDetailsPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductDetails_StepDefs {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        String expectedUrl = "https://www.automationexercise.com/product_details/1";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Product detail URL mismatch");
    }

    @When("The user increases quantity to {string}")
    public void the_user_increases_quantity_to(String string) {
        productDetailsPage.setQuantity(string);
    }

    @When("The user clicks Add to cart button")
    public void the_user_clicks_add_to_cart_button() {
        productDetailsPage.clickAddToCartButton();
    }

    @Then("Verify Write Your Review is visible")
    public void verify_write_your_review_is_visible() {
        productDetailsPage.scrollToWriteYourReview();
        Assertions.assertTrue(productDetailsPage.isWriteYourReviewTextDisplayed(), "Write Your Review text is not displayed");
    }

    @Then("The user fills in ProductReview and click Submit Button")
    public void the_user_fills_in_product_review_and_click_submit_button() {
        productDetailsPage.fillProductReview();
    }

    @Then("Verify success message Thank you for your review.")
    public void verify_success_message_thank_you_for_your_review() {
        Assertions.assertTrue(productDetailsPage.isThankYouTextDisplayed(), "Thank you for your review message is not displayed");
    }

}
