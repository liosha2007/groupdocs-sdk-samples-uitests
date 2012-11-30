package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample8Test extends TestBase {
    protected static final String FIRST_CHECK_XPATH = "html/body/div[1]/div[2]/table/tbody/tr[2]/td[2]";
    protected static final String SECOND_CHECK_XPATH = "html/body/div[1]/div[2]/img";
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected Sample8Page sample8Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample8Page = PageFactory.initElements(webDriver, Sample8Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample8Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testClientIdFieldExisting() {
        assertNotNull(sample8Page.clientIdField);
    }

    @Test
    public void testPrivateKeyFieldExisting() {
        assertNotNull(sample8Page.privateKeyField);
    }

    @Test
    public void testFileIdFieldExisting() {
        assertNotNull(sample8Page.fileIdField);
    }

    @Test
    public void testPageNumberFieldExisting() {
        assertNotNull(sample8Page.pageNumberField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample8Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample8Page.clientIdField.clear();
        sample8Page.clientIdField.sendKeys(clientid);

        sample8Page.privateKeyField.clear();
        sample8Page.privateKeyField.sendKeys(privatekey);

        sample8Page.fileIdField.clear();
        sample8Page.fileIdField.sendKeys(fileid);

        sample8Page.pageNumberField.clear();
        sample8Page.pageNumberField.sendKeys("1");

        sample8Page.submitButton.submit();

        waitForMe(By.xpath(FIRST_CHECK_XPATH), 10);
        WebElement webTdElement = webDriver.findElement(By
                .xpath(FIRST_CHECK_XPATH));
        WebElement webImgElement = webDriver.findElement(By
                .xpath(SECOND_CHECK_XPATH));

        assertNotNull(webTdElement);
        assertNotNull(webImgElement);
    }
}
