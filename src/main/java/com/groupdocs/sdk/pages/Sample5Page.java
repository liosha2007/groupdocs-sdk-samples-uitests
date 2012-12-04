package com.groupdocs.sdk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Sample5Page extends Page {

    @FindBy(how = How.NAME, using = "client_id")
    @CacheLookup
    protected WebElement clientIdField;

    @FindBy(how = How.NAME, using = "private_key")
    @CacheLookup
    protected WebElement privateKeyField;

    @FindBy(how = How.NAME, using = "srcPath")
    @CacheLookup
    protected WebElement srcPathField;

    @FindBy(how = How.NAME, using = "destPath")
    @CacheLookup
    protected WebElement destPathField;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    @CacheLookup
    protected WebElement submitButton;

    public Sample5Page(WebDriver webDriver) {
        super(webDriver);
    }
}
