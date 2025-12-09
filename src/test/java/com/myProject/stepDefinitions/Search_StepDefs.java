package com.myProject.stepDefinitions;

import com.myProject.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java8.En;

public class Search_StepDefs {
    SearchPage searchPage = new SearchPage();

    @When("The user enters product name in search input and click search button")
    public void the_user_enters_product_name_in_search_input_and_click_search_button() {
        searchPage.searchProduct("Kids");
    }

    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        Assertions.assertTrue(searchPage.isSearchedProductsTextDisplayed(), "Searched Products text is not displayed");
    }

    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        Assertions.assertEquals(1, searchPage.getSearchedProductsSize(), "Number of searched products mismatch");
    }

}
