package com.groupdocs.sdk.webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.groupdocs.sdk.util.Browser;

/*
 * Factory to instantiate a WebDriver object. It returns an instance of the driver (local invocation) or an instance of RemoteWebDriver
 */
public class WebDriverFactory {

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String HTML_UNIT = "htmlunit";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String XP = "xp";
    public static final String VISTA = "vista";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    /*
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     * 
     * @param gridHubUrl : grid hub URI
     * 
     * @param browser : Browser object containing info around the browser to hit
     * 
     * @return RemoteWebDriver
     */
    public static WebDriver getInstance(String gridHubUrl, Browser browser) {

        WebDriver webDriver = null;

        DesiredCapabilities capability = new DesiredCapabilities();
        String browserName = browser.getName();
        capability.setJavascriptEnabled(true);

        // In case there is no Hub
        if (gridHubUrl == null || gridHubUrl.length() == 0) {
            return getInstance(browserName);
        }

        if (CHROME.equals(browserName)) {
            capability = DesiredCapabilities.chrome();
        }
        else if (FIREFOX.equals(browserName)) {
            capability = DesiredCapabilities.firefox();
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        }
        else if (INTERNET_EXPLORER.equals(browserName)) {

            capability = DesiredCapabilities.internetExplorer();
            capability
                    .setCapability(
                            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                            true);
        }
        else if (OPERA.equals(browserName)) {
            capability = DesiredCapabilities.opera();
        }
        else {

            capability = DesiredCapabilities.htmlUnit();
            webDriver = new HtmlUnitDriver(true);

            return webDriver;
        }

        capability = setVersionAndPlatform(capability, browser.getVersion(),
                browser.getPlatform());

        // Create Remote WebDriver
        try {
            webDriver = new RemoteWebDriver(new URL(gridHubUrl), capability);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return webDriver;
    }

    /*
     * Factory method to return a WebDriver instance given the browser to hit
     * 
     * @param browser : String representing the local browser to hit
     * 
     * @return WebDriver instance
     */
    public static WebDriver getInstance(String browser) {

        WebDriver webDriver = null;

        if (CHROME.equals(browser)) {
            setChromeDriver();
            webDriver = new ChromeDriver();
        }
        else if (FIREFOX.equals(browser)) {
            webDriver = new FirefoxDriver();
        }
        else if (INTERNET_EXPLORER.equals(browser)) {
            webDriver = new InternetExplorerDriver();

        }
        else {

            // HTMLunit Check
            webDriver = new HtmlUnitDriver(true);
        }

        return webDriver;
    }

    /*
     * Helper method to set version and platform for a specific browser
     * 
     * @param capability : DesiredCapabilities object coming from the selected
     * browser
     * 
     * @param version : browser version
     * 
     * @param platform : browser platform
     * 
     * @return DesiredCapabilities
     */
    private static DesiredCapabilities setVersionAndPlatform(
            DesiredCapabilities capability, String version, String platform) {
        if (MAC.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC);
        }
        else if (XP.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.XP);
        }
        else if (VISTA.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.VISTA);
        }
        else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        }
        else {
            capability.setPlatform(Platform.ANY);
        }

        if (version != null) {
            capability.setVersion(version);
        }
        return capability;
    }

    /*
     * Helper method to set ChromeDriver location into the right ststem property
     */
    private static void setChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        String chromeBinary = "src/main/resources/drivers/chrome/chromedriver"
                + (os.equals("win") ? ".exe" : "");
        System.setProperty("webdriver.chrome.driver", chromeBinary);
    }

}