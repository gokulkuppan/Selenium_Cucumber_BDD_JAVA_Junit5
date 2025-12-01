package com.myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewCartPage extends BasePage {
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> addedCardProducts;

    @FindBy(xpath = "//tbody/tr/td[@class='cart_price']")
    private List<WebElement> cardPrices;

    @FindBy(xpath = "//tbody/tr/td[@class='cart_quantity']")
    private List<WebElement> cartQuantities;

    @FindBy(xpath = "//tbody/tr/td[@class='cart_total']")
    private List<WebElement> cartTotalPrices;

    @FindBy(xpath = "//a[.='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//u[.='Register / Login']")
    private WebElement registerLoginButton;

    @FindBy(xpath = "//td[@class='cart_delete']/a")
    private List<WebElement> deleteButtons;

    @FindBy(xpath = "//b[.='Cart is empty!']")
    private WebElement cartEmptyText;

    // Getter methods for text and list elements
    public int getAddedCardProductsSize() {
        return addedCardProducts.size();
    }

    public String getCardPriceText(int index) {
        return cardPrices.get(index).getText();
    }

    public String getCartQuantityText(int index) {
        return cartQuantities.get(index).getText();
    }

    public String getCartTotalPriceText(int index) {
        return cartTotalPrices.get(index).getText();
    }

    public String getCartEmptyText() {
        return cartEmptyText.getText();
    }

    public boolean isCartEmptyTextDisplayed() {
        return cartEmptyText.isDisplayed();
    }

    // Action methods
    public void clickProceedToCheckoutButton() {
        click(proceedToCheckoutButton);
    }

    public void clickRegisterLoginButton() {
        click(registerLoginButton);
    }

    public void clickDeleteProductButton(int index) {
        click(deleteButtons.get(index));
    }

}
