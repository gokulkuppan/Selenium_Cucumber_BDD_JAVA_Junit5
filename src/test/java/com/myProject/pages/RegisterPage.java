package com.myProject.pages;

import com.myProject.utilities.ConfigurationReader;
import com.myProject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//h2[.='New User Signup!']")
    private WebElement newUserSignupText;

    @FindBy(name = "name")
    private WebElement nameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailBox;

    @FindBy(xpath = "//button[.='Signup']")
    private WebElement signupButton;

    @FindBy(xpath = "//b[.='Enter Account Information']")
    private WebElement enterAccountText;

    @FindBy(id = "uniform-id_gender1")
    private WebElement genderButton;

    @FindBy(id = "id_gender1")
    private WebElement genderRadioButton;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "days")
    private WebElement selectDay;

    @FindBy(id = "months")
    private WebElement selectMonth;

    @FindBy(id = "years")
    private WebElement selectYear;

    @FindBy(id = "newsletter")
    private WebElement newsletterBox;

    @FindBy(id = "first_name")
    private WebElement firstNameBox;

    @FindBy(id = "last_name")
    private WebElement lastNameBox;

    @FindBy(id = "address1")
    private WebElement address1Box;

    @FindBy(id = "country")
    private WebElement selectCountry;

    @FindBy(id = "state")
    private WebElement stateBox;

    @FindBy(id = "city")
    private WebElement cityBox;

    @FindBy(id = "zipcode")
    private WebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberBox;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    private WebElement accountText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(id = "dismiss-button")
    private WebElement dismissButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in')]")
    private WebElement loggedInText;

    @FindBy(xpath = "//a[.=' Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(css = ".title.text-center")
    private WebElement accountDeletedText;

    @FindBy(xpath = "//p[.='Email Address already exist!']")
    private WebElement alreadyExistText;

    // Getter methods for text elements
    public String getNewUserSignupText() {
        return newUserSignupText.getText();
    }

    public String getEnterAccountText() {
        return enterAccountText.getText();
    }

    public String getAccountCreatedText() {
        return accountText.getText();
    }

    public String getLoggedInText() {
        return loggedInText.getText();
    }

    public String getAccountDeletedText() {
        return accountDeletedText.getText();
    }

    public String getAlreadyExistText() {
        return alreadyExistText.getText();
    }

    public boolean isNewUserSignupTextDisplayed() {
        return newUserSignupText.isDisplayed();
    }

    public boolean isEnterAccountTextDisplayed() {
        return enterAccountText.isDisplayed();
    }

    public boolean isAccountCreatedTextDisplayed() {
        return accountText.isDisplayed();
    }

    public boolean isLoggedInTextDisplayed() {
        return loggedInText.isDisplayed();
    }

    public boolean isAccountDeletedTextDisplayed() {
        return accountDeletedText.isDisplayed();
    }

    public boolean isAlreadyExistTextDisplayed() {
        return alreadyExistText.isDisplayed();
    }

    // Action methods
    public void enterNameAndEmail() {
        sendKeys(nameBox, ConfigurationReader.get("firstName"));
        sendKeys(emailBox, ConfigurationReader.get("email"));
    }

    public void clickSignupButton() {
        click(signupButton);
    }

    public void fillRegistrationForm() {
        // Select Title (Mr.) - Mandatory
        click(genderRadioButton);

        // Enter Password - Mandatory
        sendKeys(passwordBox, ConfigurationReader.get("password"));

        // Select Date of Birth
        selectByVisibleText(selectDay, "1");
        selectByVisibleText(selectMonth, "January");
        selectByVisibleText(selectYear, "1981");

        // Address Information - Mandatory fields only
        sendKeys(firstNameBox, ConfigurationReader.get("firstName"));
        sendKeys(lastNameBox, ConfigurationReader.get("lastName"));
        sendKeys(address1Box, ConfigurationReader.get("address"));

        // Select Country - Mandatory
        selectByVisibleText(selectCountry, "Canada");

        // State, City, Zipcode, Mobile Number - Mandatory
        sendKeys(stateBox, ConfigurationReader.get("state"));
        sendKeys(cityBox, ConfigurationReader.get("city"));
        sendKeys(zipcodeBox, ConfigurationReader.get("zipcode"));
        sendKeys(mobileNumberBox, ConfigurationReader.get("mobilNumber"));

        // Submit the form
        click(createAccountButton);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void dismissAd() {
        try {
            Driver.get().switchTo().frame("aswift_3");
            click(dismissButton);
        } catch (Exception e) {
            // Ad not present
        }
    }

    public void dismissAdOnSignup() {
        try {
            Driver.get().switchTo().frame("aswift_9");
            Driver.get().switchTo().frame("ad_iframe");
            click(dismissButton);
        } catch (Exception e) {
            // Ad not present
        }
    }

    public void clickDeleteAccountButton() {
        click(deleteAccountButton);
    }
}
