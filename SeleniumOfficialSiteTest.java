package sampleapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumOfficialSiteTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver and WebDriverWait
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased the wait time
    }

    @Test(priority = 1)
    public void searchForTerm() {
        // Navigate to the Selenium official website
        driver.get("https://www.selenium.dev/");

        // Locate the search element and perform a search
        By searchInput = By.name("search"); // Ensure this is the correct locator
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchBox.sendKeys("WebDriver");

        // Verify that the search results are displayed
        By searchResults = By.cssSelector(".search-results"); // Adjust selector based on actual search results container
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));

        Assert.assertTrue(driver.findElements(searchResults).size() > 0, "Search results were not found!");
    }

    @Test(priority = 2)
    public void checkDocumentationLink() {
        // Navigate to the Selenium official website
        driver.get("https://www.selenium.dev/");

        // Locate and click on the "Documentation" link
        By documentationLink = By.linkText("Documentation"); // Update the locator based on the actual link text
        WebElement documentation = wait.until(ExpectedConditions.elementToBeClickable(documentationLink));
        documentation.click();

        // Verify that the documentation page is loaded
        Assert.assertTrue(driver.getTitle().contains("Documentation"), "Documentation page did not load successfully!");
    }

    @AfterClass
    public void tearDown() {
        // Clean up and close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
