package com.myProject.stepDefinitions;

import com.myProject.pages.CategoryProductPage;
import com.myProject.pages.HomePage;
import com.myProject.pages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HomePage_StepDefs {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    CategoryProductPage categoryProductPage = new CategoryProductPage();

    @When("The user scrolls down to footer")
    public void the_user_scrolls_down_to_footer() {
        homePage.scrollDownToFooter();
    }

    @Then("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        Assertions.assertTrue(homePage.isSubscriptionTextDisplayed(), "Subscription text is not displayed");
    }

    @When("The user enters email address in input and click arrow button")
    public void the_user_enters_email_address_in_input_and_click_arrow_button() {
        homePage.enterEmailAndSubscribe("myEmail@email.com");
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        Assertions.assertTrue(homePage.isSuccessSubscribeTextDisplayed(), "Success subscribe message is not displayed");
    }

    @When("The user clicks View Product for any product on home page")
    public void the_user_clicks_view_product_for_any_product_on_home_page() {
        homePage.clickViewProductButton(0);
        registerPage.dismissAdOnSignup();
    }

    @Then("Verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        homePage.scrollToCategoryText();
        Assertions.assertTrue(homePage.isCategoryTextDisplayed(), "Category text is not displayed");
    }

    @When("The user clicks on Women category")
    public void the_user_clicks_on_women_category() {
        homePage.clickWomenCategory();
    }

    @When("The user clicks on Dress link under Women category")
    public void the_user_clicks_on_dress_link_under_women_category() {
        homePage.clickDressCategory();
    }

    @Then("Verify RECOMMENDED ITEMS are visible")
    public void verify_recommended_items_are_visible() {
        Assertions.assertTrue(homePage.isRecommendedItemsTextDisplayed(), "Recommended items text is not displayed");
    }

    @When("The user clicks on Add To Cart on Recommended product")
    public void the_user_clicks_on_add_to_cart_on_recommended_product() {
        homePage.clickRecommendedItemAddToCart(4);
    }

    @When("The user clicks on arrow at bottom right side to move upward")
    public void the_user_clicks_on_arrow_at_bottom_right_side_to_move_upward() {
        homePage.clickScrollUpArrow();
    }

    @Then("Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void verify_that_page_is_scrolled_up_and_full_fledged_practice_website_for_automation_engineers_text_is_visible_on_screen() {
        Assertions.assertTrue(homePage.isFullFlaggedTextDisplayed(), "Full-Fledged text is not displayed");
    }

    @When("The user scrolls up page to top")
    public void the_user_scrolls_up_page_to_top() {
        homePage.scrollUpToTop();
    }

}
