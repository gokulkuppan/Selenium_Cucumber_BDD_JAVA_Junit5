package com.myProject.stepDefinitions;

import com.myProject.pages.CategoryProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class CategoryProduct_StepDefs {
    CategoryProductPage categoryProductPage = new CategoryProductPage();

    @Then("Verify that category page is displayed and confirm text women Dress PRODUCTS")
    public void verify_that_category_page_is_displayed_and_confirm_text_women_dress_products() {
        Assertions.assertTrue(categoryProductPage.isWomenDressProductsTextDisplayed(), "Women Dress Products text is not displayed");
        Assertions.assertEquals("WOMEN - DRESS PRODUCTS", categoryProductPage.getWomenDressProductsText(), "Women Dress Products text mismatch");
    }

    @When("The user clicks on Men category")
    public void the_user_clicks_on_men_category() {
        categoryProductPage.clickMenCategory();
    }

    @When("The user clicks on Tshirts link under Men category")
    public void the_user_clicks_on_tshirts_link_under_men_category() {
        categoryProductPage.clickTshirtsCategory();
    }

    @Then("Verify that category page is displayed and confirm text men Tshirts PRODUCTS")
    public void verify_that_category_page_is_displayed_and_confirm_text_men_tshirts_products() {
        Assertions.assertEquals("MEN - TSHIRTS PRODUCTS", categoryProductPage.getMenTshirtsProductsText(), "Men Tshirts Products text mismatch");
    }
}
