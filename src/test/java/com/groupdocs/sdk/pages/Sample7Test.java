package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample7Test extends TestBase {
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected static final String IMAGE_CHECK_XPATH = "//body/div[1]/div[2]/table/tbody/tr[2]/td/img";
    protected Sample7Page sample7Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample7Page = PageFactory.initElements(webDriver, Sample7Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample7Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample7Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample7Page.privateKeyField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample7Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample7Page.clientIdField.clear();
        sample7Page.clientIdField.sendKeys(clientid);

        sample7Page.privateKeyField.clear();
        sample7Page.privateKeyField.sendKeys(privatekey);

        sample7Page.submitButton.submit();

        waitForMe(By.xpath(IMAGE_CHECK_XPATH), 10);
        List<WebElement> webElements = webDriver.findElements(By
                .xpath(IMAGE_CHECK_XPATH));

        assertTrue(webElements.size() > 0);
    }
}
