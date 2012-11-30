package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample10Test extends TestBase {
    protected static final String FIRST_CHECK_XPATH = "/html/body/div/div[2]/h3/font/h1";
    protected static final String REQUEST_EMAIL = "test@sample.com";
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected Sample10Page sample10Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample10Page = PageFactory.initElements(webDriver, Sample10Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample10Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample10Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample10Page.privateKeyField);
    }

    @Test
    public void testFileIdFieldExisting() {
        assertNotNull(sample10Page.fileIdField);
    }

    @Test
    public void testEmailFieldExisting() {
        assertNotNull(sample10Page.emailField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample10Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample10Page.clientIdField.clear();
        sample10Page.clientIdField.sendKeys(clientid);

        sample10Page.privateKeyField.clear();
        sample10Page.privateKeyField.sendKeys(privatekey);

        sample10Page.fileIdField.clear();
        sample10Page.fileIdField.sendKeys(fileid);

        sample10Page.emailField.clear();
        sample10Page.emailField.sendKeys(REQUEST_EMAIL);

        sample10Page.submitButton.submit();

        waitForMe(By.xpath(FIRST_CHECK_XPATH), 10);
        WebElement webTdElement = webDriver.findElement(By
                .xpath(FIRST_CHECK_XPATH));

        assertNotNull(webTdElement);
        assertEquals(webTdElement.getText(), REQUEST_EMAIL);
    }
}
