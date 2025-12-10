package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class noelSearchResultPage extends BasePage {

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement searchResultTitle;

    @FindBy(xpath = "//*[@data-test-id=\"product-tile\"]")
    private List<WebElement> searchResultProducts;

    public String getSearchResultTitleFromSearchPage() {
        return searchResultTitle.getText();
    }

    public void clickOnFirstProduct(){
        click(searchResultProducts.get(0));
    }

}
