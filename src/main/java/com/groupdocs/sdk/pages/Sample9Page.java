package com.groupdocs.sdk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Sample9Page extends Page {

    @FindBy(how = How.NAME, using = "fileId")
    @CacheLookup
    protected WebElement fileIdField;

    @FindBy(how = How.NAME, using = "width")
    @CacheLookup
    protected WebElement widthField;

    @FindBy(how = How.NAME, using = "height")
    @CacheLookup
    protected WebElement heightField;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    @CacheLookup
    protected WebElement submitButton;

    public Sample9Page(WebDriver webDriver) {
        super(webDriver);
    }

}
