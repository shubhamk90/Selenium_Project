package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class Task4
{
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Find the search box and enter a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // Wait for suggestions to appear
            Thread.sleep(2000);

            // Simulate pressing the down arrow key to navigate through the suggestions
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000); // Small delay for each navigation step

            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);

            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(1000);

            // Select the suggestion by pressing Enter
            actions.sendKeys(Keys.ENTER).perform();

            // Wait for the search results to load
            Thread.sleep(2000);

//             Optionally, you can click on the first result
            List<WebElement> searchResults = driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
            if (!searchResults.isEmpty()) {
                searchResults.get(2).click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            // Always quit the driver at the end
//            driver.quit();
        }
    }
}











