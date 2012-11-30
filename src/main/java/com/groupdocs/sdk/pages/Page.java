package com.groupdocs.sdk.pages;

import org.openqa.selenium.WebDriver;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    public static final String H1_TAG = "h1";

    protected WebDriver webDriver;

    /*
     * Constructor injecting the WebDriver interface
     * 
     * @param webDriver
     */
    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
