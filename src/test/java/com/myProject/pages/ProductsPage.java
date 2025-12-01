package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//a[.='View Product'][1]")
    private WebElement firstViewProductButton;

    @FindBy(xpath = "//h2[.='Blue Top']")
    private WebElement productName;

    @FindBy(xpath = "//p[.='Category: Women > Tops']")
    private WebElement productCategory;

    @FindBy(xpath = "//span[.='Rs. 500']")
    private WebElement productPrice;

    @FindBy(xpath = "//p[contains(text(),' In Stock')]")
    private WebElement productAvailability;

    @FindBy(xpath = "//p[contains(text(),' New')]")
    private WebElement productCondition;

    @FindBy(xpath = "//p[contains(text(),' Polo')]")
    private WebElement productBrand;

    @FindBy(id = "search_product")
    private WebElement searchProductBox;

    @FindBy(xpath = "//div[@class='overlay-content']//a[contains(@class,'add-to-cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[.='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//u[.='View Cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//h2[.='Brands']")
    private WebElement brandsText;

    // Getter methods for text elements
    public String getProductName() {
        return productName.getText();
    }

    public String getProductCategory() {
        return productCategory.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductAvailability() {
        return productAvailability.getText();
    }

    public String getProductCondition() {
        return productCondition.getText();
    }

    public String getProductBrand() {
        return productBrand.getText();
    }

    public String getBrandsText() {
        return brandsText.getText();
    }

    public int getProductsListSize() {
        return productsList.size();
    }

    public boolean isProductNameDisplayed() {
        return productName.isDisplayed();
    }

    public boolean isProductCategoryDisplayed() {
        return productCategory.isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return productPrice.isDisplayed();
    }

    public boolean isProductAvailabilityDisplayed() {
        return productAvailability.isDisplayed();
    }

    public boolean isProductConditionDisplayed() {
        return productCondition.isDisplayed();
    }

    public boolean isProductBrandDisplayed() {
        return productBrand.isDisplayed();
    }

    public boolean isBrandsTextDisplayed() {
        return brandsText.isDisplayed();
    }

    // Action methods
    public void clickFirstViewProductButton() {
        click(firstViewProductButton);
    }

    public void hoverOverProductAndAddToCart(int productIndex) {
        scrollToElement(productsList.get(productIndex));
        hover(productsList.get(productIndex));
        waitForClickablility(addToCartButtons.get(productIndex), 2);
        click(addToCartButtons.get(productIndex));
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public void clickViewCartButton() {
        waitForClickablility(viewCartButton, 5);
        click(viewCartButton);
    }

    public void scrollToBrandsText() {
        scrollToElement(brandsText);
    }

    public void clickBrandName(String brand) {
        WebElement brandElement = Driver.get().findElement(By.xpath("//div[@class='brands-name']//a[contains(.,'" + brand + "')]"));
        click(brandElement);
    }
}
