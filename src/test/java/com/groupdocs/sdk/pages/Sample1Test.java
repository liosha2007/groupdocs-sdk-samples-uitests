package com.groupdocs.sdk.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample1Test extends TestBase {
	protected static final String CHECK_XPATH = "/html/body/div/div/table/tbody/tr[4]/td[2]";
	protected static final String CHECK_TITLE = "GroupDocs Python SDK Samples";
	protected Sample1Page sample1Page;

	@Parameters({ "path" })
	@BeforeClass
	public void testInit(String path) {
		// Load the page in the browser
		webDriver.get(websiteUrl + path);
		sample1Page = PageFactory.initElements(webDriver, Sample1Page.class);
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void testTitleIsCorrect() {
		assertEquals(sample1Page.getTitle(), CHECK_TITLE);
	}

	@Test
	public void testClientIdFieldExisting() {
		assertNotNull(sample1Page.clientIdField);
	}

	@Test
	public void testPrivateKeyFieldExisting() {
		assertNotNull(sample1Page.privateKeyField);
	}

	@Test
	public void testSubmitButtonExisting() {
		assertNotNull(sample1Page.submitButton);
	}

	@Test
	public void testFormAction() {
		sample1Page.clientIdField.clear();
		sample1Page.clientIdField.sendKeys(clientid);

		sample1Page.privateKeyField.clear();
		sample1Page.privateKeyField.sendKeys(privatekey);

		sample1Page.submitButton.submit();

		waitForMe(By.xpath(CHECK_XPATH), 3);
		WebElement webTdElement = webDriver.findElement(By
				.xpath(CHECK_XPATH));

		assertNotNull(webTdElement);
	}
}
