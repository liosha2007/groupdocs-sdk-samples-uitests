package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample9Test extends TestBase {
    protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
    protected static final String CHECK_ID = "viewer_mainwrapper";
    protected Sample9Page sample9Page;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {
        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        sample9Page = PageFactory.initElements(webDriver, Sample9Page.class);
        waitForMe(By.tagName("body"), 20);
    }

    @Test
    public void testTitleIsCorrect() {
        assertEquals(sample9Page.getTitle(), CHECK_TITLE);
    }

    @Test
    public void testFileIdFieldExisting() {
        assertNotNull(sample9Page.fileIdField);
    }

    @Test
    public void testWidthFieldExisting() {
        assertNotNull(sample9Page.widthField);
    }

    @Test
    public void testHeightFieldExisting() {
        assertNotNull(sample9Page.heightField);
    }

    @Test
    public void testSubmitButtonExisting() {
        assertNotNull(sample9Page.submitButton);
    }

    @Test
    public void testFormAction() {
        sample9Page.fileIdField.clear();
        sample9Page.fileIdField.sendKeys(fileid);

        sample9Page.widthField.clear();
        sample9Page.widthField.sendKeys("200");

        sample9Page.heightField.clear();
        sample9Page.heightField.sendKeys("200");

        sample9Page.submitButton.submit();

        webDriver.switchTo().frame(0);
        waitForMe(By.id(CHECK_ID), 10);
        WebElement webTdElement = webDriver.findElement(By.id(CHECK_ID));
        assertNotNull(webTdElement);
    }
}
