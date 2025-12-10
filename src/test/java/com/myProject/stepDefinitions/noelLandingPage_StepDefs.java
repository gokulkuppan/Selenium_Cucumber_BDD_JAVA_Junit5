package com.myProject.stepDefinitions;

import com.myProject.pages.noelCartPage;
import com.myProject.pages.noelLandingPage;
import com.myProject.pages.noelProductPage;
import com.myProject.pages.noelSearchResultPage;
import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class noelLandingPage_StepDefs implements En {
    noelLandingPage noelLandingPage = new noelLandingPage();
    noelSearchResultPage noelSearchResultPage = new noelSearchResultPage();
    noelProductPage noelProductPage = new noelProductPage();
    noelCartPage noelCartPage = new noelCartPage();

    public noelLandingPage_StepDefs() {
        Given("^The user is on the noel Landing page$", () -> {
            noelLandingPage.navigateToNoelLandingPage();
        });
        When("^The user enters (.*) in search input box$", (String keyword) -> {
            noelLandingPage.enterTextInSearchBox(keyword);
        });
        And("^The user clicks show all results button$", () -> {
            noelLandingPage.clickShowAllResultsButton();
        });
        Then("^Verify the (.*) product is displayed on search page$", (String keyword) -> {
            String ActualTitle = noelSearchResultPage.getSearchResultTitleFromSearchPage();
            Assertions.assertEquals("Search results for \"" + keyword + "\""
                    , ActualTitle
                    , "Search result title does not match the searched product name");
        });
        And("^Open the first displayed product$", () -> {
            noelSearchResultPage.clickOnFirstProduct();
        });
        And("^Click on Add to cart button$", () -> {
            noelProductPage.clickOnAddtoCartButton();
        });
        And("^Click on Go to cart button$", () -> {
            noelProductPage.clickOnGoToCartButton();
        });
        Then("^Verify the cart quantity is (\\d+)$", (Integer expectedProductCount) -> {
            String actualCartItemText = noelCartPage.getCartItemCountText();
            String expectedActualItemText = "Cart (" + expectedProductCount + ")";
            Assertions.assertEquals(expectedActualItemText, actualCartItemText, "Cart item count text does not match expected value");
        });
        And("^set the quantity to (\\d+) for the (\\d+)st product in the cart$", (Integer quantity, Integer productIndex) -> {
            noelCartPage.setQuantity(quantity, productIndex-1);
        });
    }
}
