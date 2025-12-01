package com.myProject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//h2[.='Searched Products']")
    private WebElement searchedProductsText;

    @FindBy(xpath = "//div[@class='features_items']/div[@class=\"col-sm-4\"]")
    private List<WebElement> searchedProducts;

    @FindBy(id = "search_product")
    private WebElement searchProductBox;

    // Getter methods for text elements
    public String getSearchedProductsText() {
        return searchedProductsText.getText();
    }

    public int getSearchedProductsSize() {
        return searchedProducts.size();
    }

    public boolean isSearchedProductsTextDisplayed() {
        return searchedProductsText.isDisplayed();
    }

    // Action methods
    public void searchProduct(String productName) {
        sendKeys(searchProductBox, productName + Keys.TAB + Keys.ENTER);
    }

}
