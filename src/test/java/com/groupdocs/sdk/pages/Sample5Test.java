package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample5Test extends TestBase {
    protected static final String FIRST_CHECK_XPATH = "html/body/div/p[1]";
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected Sample5Page sample5Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample5Page = PageFactory.initElements(webDriver, Sample5Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample5Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample5Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample5Page.privateKeyField);
    }

    @Test
    public void testFileIdFieldExisting() {
        assertNotNull(sample5Page.srcPathField);
    }

    @Test
    public void testPageNumberFieldExisting() {
        assertNotNull(sample5Page.destPathField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample5Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample5Page.clientIdField.clear();
        sample5Page.clientIdField.sendKeys(clientid);

        sample5Page.privateKeyField.clear();
        sample5Page.privateKeyField.sendKeys(privatekey);

        sample5Page.srcPathField.clear();
        sample5Page.srcPathField.sendKeys("bb.doc");

        sample5Page.destPathField.clear();
        sample5Page.destPathField.sendKeys("test/bb.doc");

        sample5Page.submitButton.submit();

        waitForMe(By.xpath(FIRST_CHECK_XPATH), 10);
        WebElement webTdElement = webDriver.findElement(By
                .xpath(FIRST_CHECK_XPATH));
        
        assertNotNull(webTdElement);
       
    }
}
