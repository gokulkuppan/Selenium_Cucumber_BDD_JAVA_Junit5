package com.myProject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class PaymentPage extends BasePage {

    @FindBy(name = "name_on_card")
    private WebElement nameOnCard;

    @FindBy(xpath = "//div[@id='success_message'][1]")
    private WebElement successMessage;

    @FindBy(id = "submit")
    private WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//a[.='Download Invoice']")
    private WebElement downloadInvoiceButton;

    // Getter methods for text elements
    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    // Action methods
    public void fillCardDetails() {
        click(nameOnCard);
        sendKeys(nameOnCard, "Fname Lname");
        sendKeys(nameOnCard, Keys.TAB.toString());

        WebElement activeElement = getActiveElement();
        sendKeys(activeElement, "123456765432345");
        sendKeys(activeElement, Keys.TAB.toString());

        activeElement = getActiveElement();
        sendKeys(activeElement, "11");
        sendKeys(activeElement, Keys.TAB.toString());

        activeElement = getActiveElement();
        sendKeys(activeElement, "11");
        sendKeys(activeElement, Keys.TAB.toString());

        activeElement = getActiveElement();
        sendKeys(activeElement, "2025");
    }

    public void clickPayAndConfirmOrderButton() {
        click(payAndConfirmOrderButton);
    }

    public void clickDownloadInvoiceButton() {
        click(downloadInvoiceButton);
    }

    public boolean isInvoiceDownloaded() {
        String homePath = System.getProperty("user.home");
        File f = new File(homePath + "/Downloads/invoice.txt");
        return f.exists();
    }

}
