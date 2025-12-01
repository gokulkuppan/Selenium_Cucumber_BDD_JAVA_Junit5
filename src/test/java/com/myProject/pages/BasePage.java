package com.myProject.pages;

import com.myProject.utilities.BrowserUtils;
import com.myProject.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage extends BrowserUtils {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".navbar-nav>li")
    private List<WebElement> tabMenu;

    public List<String> getTabMenuNames(){
        List<String> list = new ArrayList<>();

        for (WebElement menu : tabMenu) {
            list.add(menu.getText());
        }
        return list;
    }

    public void navigateToTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//a[contains(text(),'"+tabName+"')]"));
        click(tab);
    }

}
