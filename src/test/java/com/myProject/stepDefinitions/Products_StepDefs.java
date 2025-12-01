package com.myProject.stepDefinitions;

import com.myProject.pages.ProductsPage;
import com.myProject.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class Products_StepDefs {
    ProductsPage productsPage = new ProductsPage();

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        String expectedUrl = "https://www.automationexercise.com/products";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Products page URL mismatch");
    }

    @Then("Verify the products list is visible")
    public void verify_the_products_list_is_visible() {
        Assertions.assertTrue(productsPage.getProductsListSize() > 1, "Products list is empty");
    }

    @When("The user clicks on View Product of first product")
    public void the_user_clicks_on_view_product_of_first_product() {
        productsPage.clickFirstViewProductButton();
    }

    @Then("Verify the user is landed to product detail page")
    public void verify_the_user_is_landed_to_product_detail_page() {
        String expectedUrl = "https://www.automationexercise.com/product_details/1";
        String actualUrl = Driver.get().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Product detail page URL mismatch");
    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        Assertions.assertTrue(productsPage.isProductNameDisplayed(), "Product name is not displayed");
        Assertions.assertTrue(productsPage.isProductCategoryDisplayed(), "Product category is not displayed");
        Assertions.assertTrue(productsPage.isProductPriceDisplayed(), "Product price is not displayed");
        Assertions.assertTrue(productsPage.isProductAvailabilityDisplayed(), "Product availability is not displayed");
        Assertions.assertTrue(productsPage.isProductConditionDisplayed(), "Product condition is not displayed");
        Assertions.assertTrue(productsPage.isProductBrandDisplayed(), "Product brand is not displayed");
    }

    @When("The user hovers over first product and clicks Add to cart")
    public void the_user_hovers_over_first_product_and_clicks_add_to_cart() {
        productsPage.hoverOverProductAndAddToCart(0);
    }

    @When("The user clicks Continue Shopping button")
    public void the_user_clicks_continue_shopping_button() {
        productsPage.clickContinueShoppingButton();
    }

    @When("The user hovers over second product and clicks Add to cart")
    public void the_user_hovers_over_second_product_and_clicks_add_to_cart() {
        productsPage.hoverOverProductAndAddToCart(1);
    }

    @When("The user clicks View Cart button")
    public void the_user_clicks_view_cart_button() {
        productsPage.clickViewCartButton();
    }

    @Then("Verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        Assertions.assertTrue(productsPage.isBrandsTextDisplayed(), "Brands text is not displayed");
    }

    @When("The user clicks on left side bar {string} brand name")
    public void the_user_clicks_on_left_side_bar_brand_name(String brand) {
        productsPage.scrollToBrandsText();
        productsPage.clickBrandName(brand);
    }

    @Then("Verify that user is navigated to brand page and brand products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
        Assertions.assertTrue(productsPage.getProductsListSize() > 0, "No brand products are displayed");
    }
}
