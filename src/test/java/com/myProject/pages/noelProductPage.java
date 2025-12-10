package com.myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class noelProductPage extends BasePage {

    @FindBy(xpath = "//*[@data-test-id=\"add-to-cart-button\"]/button")
    private WebElement addToCartButton;
    //a[normalize-space()='Go to cart']
    //a[text()='Go to cart']

    @FindBy(xpath = "//a[text()='Go to cart']")
    private WebElement goToCartButton;

    public void clickOnAddtoCartButton() {
        click(addToCartButton);
    }

    public void clickOnGoToCartButton() {
        click(goToCartButton);
    }
}
