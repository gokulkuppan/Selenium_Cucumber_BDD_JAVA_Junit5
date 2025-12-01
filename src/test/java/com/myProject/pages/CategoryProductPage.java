package com.myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryProductPage extends BasePage {

    @FindBy(xpath = "//h2[.='Women - Dress Products']")
    private WebElement womenDressProductsText;

    @FindBy(xpath = "//a[@href='#Men']")
    private WebElement menCategory;

    @FindBy(xpath = "//a[.='Tshirts ']")
    private WebElement tshirtsCategory;

    @FindBy(xpath = "//h2[.='Men - Tshirts Products']")
    private WebElement menTshirtsProductsText;

    // Getter methods for text elements
    public String getWomenDressProductsText() {
        return womenDressProductsText.getText();
    }

    public String getMenTshirtsProductsText() {
        return menTshirtsProductsText.getText();
    }

    public boolean isWomenDressProductsTextDisplayed() {
        return womenDressProductsText.isDisplayed();
    }

    public boolean isMenTshirtsProductsTextDisplayed() {
        return menTshirtsProductsText.isDisplayed();
    }

    // Action methods
    public void clickMenCategory() {
        click(menCategory);
    }

    public void clickTshirtsCategory() {
        click(tshirtsCategory);
    }

}
