package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "quantity")
    private WebElement quantityBox;

    @FindBy(css = ".btn.btn-default.cart")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//a[.='Write Your Review']")
    private WebElement writeYourReviewText;

    @FindBy(id = "name")
    private WebElement nameBox;

    @FindBy(xpath = "//span[.='Thank you for your review.']")
    private WebElement thankYouText;

    // Getter methods for text elements
    public String getWriteYourReviewText() {
        return writeYourReviewText.getText();
    }

    public String getThankYouText() {
        return thankYouText.getText();
    }

    public boolean isWriteYourReviewTextDisplayed() {
        return writeYourReviewText.isDisplayed();
    }

    public boolean isThankYouTextDisplayed() {
        return thankYouText.isDisplayed();
    }

    // Action methods
    public void setQuantity(String quantity) {
        clearAndSendKeys(quantityBox, quantity);
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    public void scrollToWriteYourReview() {
        scrollToElement(writeYourReviewText);
    }

    public void fillProductReview() {
        click(nameBox);
        sendKeys(nameBox, ConfigurationReader.get("firstName"));
        sendKeys(nameBox, Keys.TAB.toString());

        // Send email to the next field
        WebElement activeElement = getActiveElement();
        sendKeys(activeElement, ConfigurationReader.get("email"));
        sendKeys(activeElement, Keys.TAB.toString());

        // Send review text to the next field
        activeElement = getActiveElement();
        sendKeys(activeElement, "myReview");
        sendKeys(activeElement, Keys.TAB.toString());

        // Submit the form
        activeElement = getActiveElement();
        sendKeys(activeElement, Keys.ENTER.toString());
    }

}
