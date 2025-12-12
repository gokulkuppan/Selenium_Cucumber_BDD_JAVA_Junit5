package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class wareHouseSearchResultPage extends BasePage {

    @FindBy(xpath = "//*[@data-test-id=\"product-tile\"]")
    private List<WebElement> products;

    public void clickProduct(String productName) throws InterruptedException {
        for (WebElement product : products) {
            String productText = product.getText();
            if (productText.contains(productName)) {
                WebElement linkOfProduct = product.findElement(By.xpath(".//a"));
                clickWithJS(linkOfProduct);
                Thread.sleep(10000); // Wait for suggestions to load
                return;
            }
        }
    }


}
