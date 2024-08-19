package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Task3
{
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriver driver =new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");

        try {
            // Navigate to the Wikipedia homepage
            driver.get("https://www.wikipedia.org/");

            // Find all language links by their specific CSS selector
            List<WebElement> languageLinks = driver.findElements(By.cssSelector(".central-featured-lang a"));

            // Iterate through each language link
            for (int i = 0; i < languageLinks.size(); i++) {
                try {
                    // Re-fetch the language links to avoid stale element references
                    languageLinks = driver.findElements(By.cssSelector(".central-featured-lang a"));

                    WebElement link = languageLinks.get(i);

                    // Get the href attribute of the link
                    String url = link.getAttribute("href");

                    if (url != null && !url.isEmpty()) {
                        // Print the URL
                        System.out.println("Language Link: " + url);

                        // Click the link
                        link.click();

                        // Optionally: wait for some time or check if the page has loaded
                        Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)

                        // Navigate back to the homepage
                        driver.navigate().back();

                        // Re-fetch the language links after navigation
                        languageLinks = driver.findElements(By.cssSelector(".central-featured-lang a"));

                        // Ensure the iteration index is valid
                        i = Math.min(i, languageLinks.size() - 1);
                    }
                } catch (Exception e) {
                    System.out.println("Could not click link or navigate back: " + e.getMessage());
                }
            }
            WebElement searchInput = driver.findElement(By.id("searchInput"));
            if (searchInput != null) {
                // Type a search query into the search bar
                searchInput.sendKeys("Selenium WebDriver");

                // Submit the search form
                searchInput.sendKeys(Keys.RETURN);

                // Optionally, wait for the search results page to load
                Thread.sleep(5000); // Wait for 2 seconds (adjust as needed)

                // Navigate back to the homepage
                driver.navigate().back();

                // Re-fetch the search input element after navigating back
                searchInput = driver.findElement(By.id("searchInput"));

            }}
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            // driver.quit();
        }

    }
}






