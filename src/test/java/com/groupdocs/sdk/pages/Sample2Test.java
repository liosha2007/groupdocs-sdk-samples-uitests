package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample2Test extends TestBase {
    protected static final String CHECK_XPATH = "/html/body/div/div[2]/table/tbody/tr[2]/td[2]";
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected Sample2Page sample2Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample2Page = PageFactory.initElements(webDriver, Sample2Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample2Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample2Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample2Page.privateKeyField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample2Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample2Page.clientIdField.clear();
        sample2Page.clientIdField.sendKeys(clientid);

        sample2Page.privateKeyField.clear();
        sample2Page.privateKeyField.sendKeys(privatekey);

        sample2Page.submitButton.submit();

        waitForMe(By.xpath(CHECK_XPATH), 10);
        WebElement webTdElement = webDriver.findElement(By.xpath(CHECK_XPATH));

        assertNotNull(webTdElement);
        assertNotNull(webTdElement.getText());
        assertTrue(!"".equals(webTdElement.getText()));
    }
}
