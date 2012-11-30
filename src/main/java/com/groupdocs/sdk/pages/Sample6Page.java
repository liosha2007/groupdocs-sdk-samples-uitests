package com.groupdocs.sdk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Sample6Page extends Page {
    @FindBy(how = How.TAG_NAME, using = H1_TAG)
    @CacheLookup
    protected WebElement h1Element;

    @FindBy(how = How.ID, using = "client_id")
    @CacheLookup
    protected WebElement clientIdField;

    @FindBy(how = How.ID, using = "private_key")
    @CacheLookup
    protected WebElement privateKeyField;

    @FindBy(how = How.ID, using = "fi_document")
    @CacheLookup
    protected WebElement documentField;

    @FindBy(how = How.ID, using = "fi_signature")
    @CacheLookup
    protected WebElement signatureField;

    @FindBy(how = How.ID, using = "btnLoad")
    @CacheLookup
    protected WebElement btnLoad;

    public Sample6Page(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isFrameLoaded() {
        return webDriver.findElement(By.id("viewer_mainwrapper")) != null;
    }
}
