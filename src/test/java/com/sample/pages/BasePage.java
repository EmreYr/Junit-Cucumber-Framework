package com.sample.pages;

import com.sample.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * parent class for concrete Page object classes
 * provides constructor with initElements method for re-usability
 * abstract - to prevent instantiation.
 */
public abstract  class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(tagName = "h1")
    public WebElement pageHeader;

    @FindBy(css = "")
    public WebElement accountHolderName;

    @FindBy(linkText = "")
    public WebElement logOutLink;

    public void logOut(){
        accountHolderName.click();
        logOutLink.click();
    }


}
