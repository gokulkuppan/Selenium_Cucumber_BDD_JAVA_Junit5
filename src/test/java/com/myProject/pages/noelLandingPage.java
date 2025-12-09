package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class noelLandingPage extends BasePage {

    @FindBy(id = "search-input")
    private WebElement searchBox_byId;

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement searchBox_byXpath;

    @FindBy(css = "#search-input")
    private WebElement searchBox_byCss;

    @FindBy(xpath = "//div[@class='suggestions-right-col']//button[@name='search-button']")
    private WebElement searchButton_byXpath;

    public void enterTextInSearchBox(String Keyword) {
        sendKeys(searchBox_byId, Keyword);
    }

    public void navigateToNoelLandingPage() {
        WebDriver driver = Driver.get();
        String noelUrl = ConfigurationReader.get("noelUrl");
        driver.get(noelUrl);

        //Driver.get().get(ConfigurationReader.get("url"));
    }

    public void clickShowAllResultsButton() {
        click(searchButton_byXpath);
    }

}
