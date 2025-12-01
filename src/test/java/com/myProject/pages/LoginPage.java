package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h2[.='Login to your account']")
    private WebElement loginYourAccountText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailBox;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in')]")
    private WebElement usernameText;

    @FindBy(id = "dismiss-button")
    private WebElement dismissButton;

    @FindBy(xpath = "//p[contains(text(),'incorrect')]")
    private WebElement incorrectText;

    @FindBy(xpath = "//a[.=' Logout']")
    private WebElement logoutButton;

    // Getter methods for text elements
    public String getLoginYourAccountText() {
        return loginYourAccountText.getText();
    }

    public String getUsernameText() {
        return usernameText.getText();
    }

    public String getIncorrectText() {
        return incorrectText.getText();
    }

    public boolean isLoginYourAccountTextDisplayed() {
        return loginYourAccountText.isDisplayed();
    }

    public boolean isUsernameTextDisplayed() {
        return usernameText.isDisplayed();
    }

    public boolean isIncorrectTextDisplayed() {
        return incorrectText.isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    // Action methods
    public void enterLoginInfo() {
        sendKeys(loginEmailBox, ConfigurationReader.get("email"));
        sendKeys(loginPasswordBox, ConfigurationReader.get("password"));
    }

    public void enterWrongLoginInfo() {
        sendKeys(loginEmailBox, "wrongEmail@mail.com");
        sendKeys(loginPasswordBox, "wrongPassword");
    }

    public void clickLoginButton() {
        click(loginButton);
    }


}
