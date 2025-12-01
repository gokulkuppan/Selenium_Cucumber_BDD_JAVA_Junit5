package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[.='Get In Touch']")
    private WebElement getInTouchText;

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement nameBox;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//div[contains(text(),'Success!')][1]")
    private WebElement successText;

    @FindBy(xpath = "//span[.=' Home']")
    private WebElement homeButton;

    @FindBy(id = "dismiss-button")
    private WebElement dismissButton;

    // Getter methods for text elements
    public String getGetInTouchText() {
        return getInTouchText.getText();
    }

    public String getSuccessText() {
        return successText.getText();
    }

    public boolean isGetInTouchTextDisplayed() {
        return getInTouchText.isDisplayed();
    }

    public boolean isSuccessTextDisplayed() {
        return successText.isDisplayed();
    }

    // Action methods
    public void fillContactUsForm() {
        click(nameBox);
        sendKeys(nameBox, "myName");
        sendKeys(nameBox, Keys.TAB.toString());

        WebElement activeElement = getActiveElement();
        sendKeys(activeElement, "myEmail@email.com");
        sendKeys(activeElement, Keys.TAB.toString());

        activeElement = getActiveElement();
        sendKeys(activeElement, "mySubject");
        sendKeys(activeElement, Keys.TAB.toString());

        activeElement = getActiveElement();
        sendKeys(activeElement, "myMessage");
        sendKeys(activeElement, Keys.TAB.toString());
    }

    public void uploadFile() {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/test.txt";
        String fullPath = projectPath + "/" + filePath;
        sendKeys(chooseFileButton, fullPath);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void acceptAlert() {
        Driver.get().switchTo().alert().accept();
    }

    public void clickHomeButton() {
        click(homeButton);
        try {
            Driver.get().switchTo().frame("aswift_2");
            Driver.get().switchTo().frame("ad_iframe");
            click(dismissButton);
        } catch (Exception e) {
            // Ad not present
        }
    }

}
