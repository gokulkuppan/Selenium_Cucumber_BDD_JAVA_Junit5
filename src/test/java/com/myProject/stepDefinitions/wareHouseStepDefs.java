package com.myProject.stepDefinitions;

import com.myProject.pages.wareHouseLandingPage;
import com.myProject.pages.wareHouseSearchResultPage;
import io.cucumber.java8.En;
import org.openqa.selenium.Keys;

public class wareHouseStepDefs implements En {
    public wareHouseStepDefs() {
        wareHouseLandingPage wareHouseLandingPage = new wareHouseLandingPage();
        wareHouseSearchResultPage searchPage = new wareHouseSearchResultPage();
        Given("^the user is on the wareHouse Landing page$", () -> {
            wareHouseLandingPage.navigateToWareHouseLandingPage();
        });
        When("^the user enters \"([^\"]*)\" in search input box$", (String productName) -> {
            wareHouseLandingPage.searchProduct(productName + Keys.ENTER);
        });
        Then("^User clicks on \"([^\"]*)\" in the sarch result page$", (String productName) -> {
            searchPage.clickProduct(productName);
        });
    }
}
