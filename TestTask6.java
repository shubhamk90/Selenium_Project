package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestTask6
{
    @Test
    public void navigateToDownloads()
    {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        try
        {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");
            WebElement downloadsLink = driver.findElement(By.linkText("Downloads"));
            downloadsLink.click();
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

    @Test
    public void navigateToProjects()
    {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        try
        {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");
            WebElement projectsLink = driver.findElement(By.linkText("Projects"));
            projectsLink.click();
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

    @Test
    public void navigateToDocumentation()
    {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        try
        {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");
            WebElement documentationLink = driver.findElement(By.linkText("Documentation"));
            documentationLink.click();
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }

    @Test
    public void searchSeleniumIDE()
    {
        // Set up the WebDriver and open the browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        try
        {
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/");
            WebElement documentationLink = driver.findElement(By.linkText("Documentation"));
            documentationLink.click();

            WebElement searchButton = driver.findElement(By.className("DocSearch-Button-Placeholder"));
            searchButton.click();
            WebElement searchInput = driver.findElement(By.className("DocSearch-Input"));
            searchInput.sendKeys("Selenium IDE");
            searchInput.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(searchInput).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }
    }
}



