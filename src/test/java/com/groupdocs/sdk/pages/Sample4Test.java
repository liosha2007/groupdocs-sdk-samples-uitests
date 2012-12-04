package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample4Test extends TestBase {
    protected static final String FIRST_CHECK_XPATH = "html/body/div/div/font/font";
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected Sample4Page sample4Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample4Page = PageFactory.initElements(webDriver, Sample4Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample4Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample4Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample4Page.privateKeyField);
    }

    @Test
    public void testFileIdFieldExisting() {
        assertNotNull(sample4Page.fileIdField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample4Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample4Page.clientIdField.clear();
        sample4Page.clientIdField.sendKeys(clientid);

        sample4Page.privateKeyField.clear();
        sample4Page.privateKeyField.sendKeys(privatekey);

        sample4Page.fileIdField.clear();
        sample4Page.fileIdField.sendKeys(fileid);

        sample4Page.submitButton.submit();

        waitForMe(By.xpath(FIRST_CHECK_XPATH), 10);
        WebElement webTdElement = webDriver.findElement(By.xpath(FIRST_CHECK_XPATH));

        assertNotNull(webTdElement);

    }
}
