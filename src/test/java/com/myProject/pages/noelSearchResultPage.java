package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class noelSearchResultPage extends BasePage {

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement searchResultTitle;

    public String getSearchResultTitleFromSearchPage() {
        return searchResultTitle.getText();
    }
}
