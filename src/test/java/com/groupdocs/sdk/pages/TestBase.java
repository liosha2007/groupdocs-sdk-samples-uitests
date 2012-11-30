package com.groupdocs.sdk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.groupdocs.sdk.util.Browser;
import com.groupdocs.sdk.util.PropertyLoader;
import com.groupdocs.sdk.webdriver.WebDriverFactory;

/*
 * Base class for all the test classes
 */

public class TestBase {
    protected WebDriver webDriver;
    protected String gridHubUrl;
    protected String websiteUrl;
    protected String clientid;
    protected String privatekey;
    protected String document;
    protected String signature;
    protected String fileid;

    protected Browser browser;

    @BeforeClass
    public void init() {
        websiteUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
        clientid = PropertyLoader.loadProperty("groupdocs.clientid");
        privatekey = PropertyLoader.loadProperty("groupdocs.privatekey");
        document = PropertyLoader.loadProperty("groupdocs.document");
        signature = PropertyLoader.loadProperty("groupdocs.signature");
        fileid = PropertyLoader.loadProperty("groupdocs.fileid");

        browser = new Browser();
        browser.setName(PropertyLoader.loadProperty("browser.name"));
        browser.setVersion(PropertyLoader.loadProperty("browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        webDriver = WebDriverFactory.getInstance(gridHubUrl, browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebElement waitForMe(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutSeconds);
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
    }
}
