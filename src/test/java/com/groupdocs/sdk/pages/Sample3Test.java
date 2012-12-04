package com.groupdocs.sdk.pages;

import bsh.ConsoleInterface;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample3Test extends TestBase {
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected static final String CHECK_ID = "viewer_mainwrapper";
    protected Sample3Page sample3Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample3Page = PageFactory.initElements(webDriver, Sample3Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample3Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample3Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample3Page.privateKeyField);
    }
    
    @Test
    public void testfileFieldExisting() {
        assertNotNull(sample3Page.fileField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample3Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample3Page.clientIdField.clear();
        sample3Page.clientIdField.sendKeys(clientid);

        sample3Page.privateKeyField.clear();
        sample3Page.privateKeyField.sendKeys(privatekey);
        
        sample3Page.fileField.sendKeys(document);

        sample3Page.submitButton.submit();

      webDriver.switchTo().frame(0);
      webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
       
      assertTrue(sample3Page.isFrameLoaded());
    }
}
