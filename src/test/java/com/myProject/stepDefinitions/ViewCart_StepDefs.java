package com.myProject.stepDefinitions;

import com.myProject.pages.ViewCartPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ViewCart_StepDefs {
    ViewCartPage viewCartPage = new ViewCartPage();

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        Assertions.assertEquals(2, viewCartPage.getAddedCardProductsSize(), "Number of products in cart mismatch");
    }

    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        Assertions.assertEquals("Rs. 500", viewCartPage.getCardPriceText(0), "First product price mismatch");
        Assertions.assertEquals("1", viewCartPage.getCartQuantityText(0), "First product quantity mismatch");
        Assertions.assertEquals("Rs. 500", viewCartPage.getCartTotalPriceText(0), "First product total price mismatch");
        Assertions.assertEquals("Rs. 400", viewCartPage.getCardPriceText(1), "Second product price mismatch");
        Assertions.assertEquals("1", viewCartPage.getCartQuantityText(1), "Second product quantity mismatch");
        Assertions.assertEquals("Rs. 400", viewCartPage.getCartTotalPriceText(1), "Second product total price mismatch");
    }

    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        Assertions.assertEquals("4", viewCartPage.getCartQuantityText(0), "Product quantity mismatch");
    }

    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        String expectedUrl = "https://www.automationexercise.com/view_cart";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Cart page URL mismatch");
    }

    @When("The user clicks Proceed To Checkout button")
    public void the_user_clicks_proceed_to_checkout_button() {
        viewCartPage.clickProceedToCheckoutButton();
    }

    @When("The user clicks Register-Login button")
    public void the_user_clicks_register_login_button() {
        viewCartPage.clickRegisterLoginButton();
    }

    @When("The user clicks X button corresponding to particular product")
    public void the_user_clicks_x_button_corresponding_to_particular_product() {
        viewCartPage.clickDeleteProductButton(0);
    }

    @Then("Verify that product is removed from the cart")
    public void verify_that_product_is_removed_from_the_cart() {
        Assertions.assertTrue(viewCartPage.isCartEmptyTextDisplayed(), "Cart empty text is not displayed");
    }

    @Then("Verify that products are visible in cart")
    public void verify_that_products_are_visible_in_cart() {
        Assertions.assertEquals(1, viewCartPage.getAddedCardProductsSize(), "Number of products in cart mismatch");
    }

    @Then("Verify that those products are visible in cart after login as well")
    public void verify_that_those_products_are_visible_in_cart_after_login_as_well() {
        Assertions.assertEquals(1, viewCartPage.getAddedCardProductsSize(), "Number of products in cart after login mismatch");
    }

    @Then("Verify that recommended product is displayed in cart page")
    public void verify_that_recommended_product_is_displayed_in_cart_page() {
        Assertions.assertEquals(1, viewCartPage.getAddedCardProductsSize(), "Recommended product not in cart");
    }
}
