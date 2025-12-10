package com.myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class noelCartPage extends BasePage {

    @FindBy(xpath = "//h1[@class=\"title number-of-items\"]")
    private WebElement cartItemsCount;

    @FindBy(xpath = "//*[@data-test-id=\"product-card\"]//input[@type=\"text\"]")
    private List<WebElement> quantityTextBoxes;

    public String getCartItemCountText() {
        waitForVisibility(cartItemsCount, 10);
        return cartItemsCount.getText();
    }

    public void setQuantity(int quantity, int itemIndex) {
        WebElement quantityBox = quantityTextBoxes.get(itemIndex);
        quantityBox.clear();
        sendKeys(quantityBox, String.valueOf(quantity));
    }

}
