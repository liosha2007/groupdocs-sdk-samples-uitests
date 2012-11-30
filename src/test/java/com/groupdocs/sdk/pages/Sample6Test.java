package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample6Test extends TestBase {
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected static final String CHECK_ID = "viewer_mainwrapper";
    protected Sample6Page sample6Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample6Page = PageFactory.initElements(webDriver, Sample6Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample6Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample6Page.clientIdField);
    }

    @Test
    public void testPricateKeyFieldExisting() {
        assertNotNull(sample6Page.privateKeyField);
    }

    @Test
    public void testDocumentFieldExisting() {
        assertNotNull(sample6Page.documentField);
    }

    @Test
    public void testSignatureFieldExisting() {
        assertNotNull(sample6Page.signatureField);
    }

    @Test
    public void testSendForm() throws InterruptedException {
        sample6Page.clientIdField.clear();
        sample6Page.clientIdField.sendKeys(clientid);

        sample6Page.privateKeyField.clear();
        sample6Page.privateKeyField.sendKeys(privatekey);

        sample6Page.documentField.sendKeys(document);

        sample6Page.signatureField.sendKeys(signature);

        sample6Page.btnLoad.click();

        webDriver.switchTo().frame(0);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Neet
                                                                            // replece
                                                                            // to
                                                                            // waitForMe
        // waitForMe(By.id(CHECK_ID), 40);
        assertTrue(sample6Page.isFrameLoaded());
    }
}
