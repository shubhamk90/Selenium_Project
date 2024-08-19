package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
public class Task1
{
    public static void main(String[] args) {
        // Set up WebDriver and specify the path for the geckodriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            // Navigate to example website
            driver.get("https://example.com/");

            // Example of finding a link by linkText and clicking on it
            WebElement exampleLinkText = driver.findElement(By.linkText("More information..."));
            exampleLinkText.click();

            WebElement exampleLinkText2 = driver.findElement(By.linkText("Domains"));
            exampleLinkText2.click();
            Thread.sleep(2000);

            WebElement anotherLink = driver.findElement(By.linkText("Reserved Domains"));     // Internal Link
            anotherLink.click();
            Thread.sleep(2000);



            WebElement exampleLinkText3 = driver.findElement(By.linkText("Protocols"));
            exampleLinkText3.click();
            Thread.sleep(2000);


            WebElement exampleLinkText4 = driver.findElement(By.linkText("Numbers"));
            exampleLinkText4.click();
            Thread.sleep(2000);

            WebElement anotherLink3 = driver.findElement(By.linkText("IPv6 (ARIN)"));         // Internal Link
            anotherLink3.click();
            Thread.sleep(2000);


            WebElement exampleLinkText5 = driver.findElement(By.linkText("About"));
            exampleLinkText5.click();
            Thread.sleep(2000);

            WebElement anotherLink4 = driver.findElement(By.linkText("Audits"));             // Internal Link
            anotherLink4.click();
            Thread.sleep(2000);
            driver.navigate().back();

            // Navigate back to the home page by reloading the home page URL
            driver.get("https://example.com/");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally {
            // Close the browser after the operations
            // driver.quit();
        }
    }
}



