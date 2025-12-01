package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(tagName = "footer")
    private WebElement footer;

    @FindBy(xpath = "//h2[.='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement susbscribeEmailBox;

    @FindBy(id = "success-subscribe")
    private WebElement successSubscribeText;

    @FindBy(xpath = "//a[.='View Product']")
    private List<WebElement> viewProductButtons;

    @FindBy(xpath = "//h2[.='Category']")
    private WebElement categoryText;

    @FindBy(xpath = "//a[@href='#Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//div[@id='Women']//a[.='Dress ']")
    private WebElement dressCategory;

    @FindBy(id = "dismiss-button")
    private WebElement dismissButton;

    @FindBy(xpath = "//h2[.='recommended items']")
    private WebElement recommendedItemsText;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@class='btn btn-default add-to-cart']")
    private List<WebElement> recommendedItemsList;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpArrow;

    @FindBy(xpath = "//h2[.='Full-Fledged practice website for Automation Engineers']")
    private WebElement fullFlaggedText;

    // Getter methods for text elements
    public String getSubscriptionText() {
        return subscriptionText.getText();
    }

    public String getSuccessSubscribeText() {
        return successSubscribeText.getText();
    }

    public String getCategoryText() {
        return categoryText.getText();
    }

    public String getRecommendedItemsText() {
        return recommendedItemsText.getText();
    }

    public String getFullFlaggedText() {
        return fullFlaggedText.getText();
    }

    public boolean isSubscriptionTextDisplayed() {
        return subscriptionText.isDisplayed();
    }

    public boolean isSuccessSubscribeTextDisplayed() {
        return successSubscribeText.isDisplayed();
    }

    public boolean isCategoryTextDisplayed() {
        return categoryText.isDisplayed();
    }

    public boolean isRecommendedItemsTextDisplayed() {
        return recommendedItemsText.isDisplayed();
    }

    public boolean isFullFlaggedTextDisplayed() {
        return fullFlaggedText.isDisplayed();
    }

    // Action methods
    public void scrollDownToFooter() {
        scrollToElement(footer);
    }

    public void enterEmailAndSubscribe(String email) {
        sendKeys(susbscribeEmailBox, email + Keys.ENTER);
    }

    public void clickViewProductButton(int index) {
        click(viewProductButtons.get(index));
    }

    public void dismissAd() {
        try {
            Driver.get().switchTo().frame("aswift_9");
            Driver.get().switchTo().frame("ad_iframe");
            click(dismissButton);
        } catch (Exception e) {
            // Ad not present
        }
    }

    public void scrollToCategoryText() {
        scrollToElement(categoryText);
    }

    public void clickWomenCategory() {
        click(womenCategory);
    }

    public void clickDressCategory() {
        click(dressCategory);
        Driver.get().switchTo().frame("aswift_9");
        Driver.get().switchTo().frame("ad_iframe");
        click(dismissButton);
    }

    public void clickRecommendedItemAddToCart(int index) {
        click(recommendedItemsList.get(index));
    }

    public void clickScrollUpArrow() {
        click(scrollUpArrow);
    }

    public void scrollUpToTop() {
        scrollToElement(fullFlaggedText); // Scroll to top element instead
    }

}
