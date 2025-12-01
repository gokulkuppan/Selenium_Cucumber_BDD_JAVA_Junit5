package com.myProject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CheckOutPage extends BasePage {

    @FindBy(xpath = "(//li[.='myAddress'])[1]")
    private WebElement deliveryAddressText;

    @FindBy(xpath = "(//li[.='myAddress'])[2]")
    private WebElement billingAddressText;

    @FindBy(tagName = "textarea")
    private WebElement commentTextBox;

    @FindBy(xpath = "//tbody//td[@class='cart_product']")
    private List<WebElement> reviewCardProducts;

    // Getter methods for text elements
    public String getDeliveryAddressText() {
        return deliveryAddressText.getText();
    }

    public String getBillingAddressText() {
        return billingAddressText.getText();
    }

    public int getReviewCardProductsSize() {
        return reviewCardProducts.size();
    }

    public boolean isDeliveryAddressTextDisplayed() {
        return deliveryAddressText.isDisplayed();
    }

    public boolean isBillingAddressTextDisplayed() {
        return billingAddressText.isDisplayed();
    }

    // Action methods
    public void enterCommentAndPlaceOrder(String comment) {
        sendKeys(commentTextBox, comment + Keys.TAB + Keys.ENTER);
    }

}
