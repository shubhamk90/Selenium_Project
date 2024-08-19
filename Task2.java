package sampleapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Task2
{
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Initialize JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Load the form page
            driver.get("https://demoqa.com/automation-practice-form");

            System.out.println("Title: " + driver.getTitle());
            driver.findElement(By.id("firstName")).sendKeys("Shubham");
            driver.findElement(By.id("lastName")).sendKeys("Kumar");
            driver.findElement(By.id("userEmail")).sendKeys("sharmashubham52y@gmail.com");

            WebElement genderRadio = driver.findElement(By.cssSelector("label[for=gender-radio-1]"));

            driver.findElement(By.id("userNumber")).sendKeys("7986946889");

            js.executeScript("arguments[0].scrollIntoView(true);", genderRadio);
            genderRadio.click();

            // Date of Birth input
            WebElement dateElement = driver.findElement(By.id("dateOfBirthInput"));
            dateElement.click();
            js.executeScript("arguments[0].scrollIntoView(true);", dateElement);
            dateElement.click();

            // Select Month
            WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
            monthDropdown.click();
            driver.findElement(By.cssSelector(".react-datepicker__month-select option[value='9']")).click();

            // Select year
            WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
            yearDropdown.click();
            driver.findElement(By.cssSelector(".react-datepicker__year-select option[value='2003']")).click();

            // Select day
            driver.findElement(By.cssSelector(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)")).click();

            // Subjects
            WebElement subjectInput = driver.findElement(By.cssSelector(".subjects-auto-complete__input input"));
            js.executeScript("arguments[0].click();", subjectInput);

            subjectInput.sendKeys("Physics");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // Ensure to trigger the selection

            subjectInput.sendKeys("English");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // Ensure to trigger the selection

            subjectInput.sendKeys("Computer Science");
            Thread.sleep(1000);
            subjectInput.sendKeys(Keys.TAB); // Ensure to trigger the selection

            // Hobbies using JavaScript to click
            WebElement musicCheckbox = driver.findElement(By.xpath("//label[text()='Music']"));
            js.executeScript("arguments[0].click();", musicCheckbox);

            // Upload picture
            driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Shubham\\Downloads\\imagee.jpg");

            // Current address
            driver.findElement(By.id("currentAddress")).sendKeys("Sector 21, Gurugram, Haryana");

            // State and City
            WebElement state = driver.findElement(By.id("react-select-3-input"));
            state.sendKeys("Uttar Pradesh");
            state.sendKeys(Keys.ENTER);

            WebElement city = driver.findElement(By.id("react-select-4-input"));
            city.sendKeys("Agra");
            city.sendKeys(Keys.ENTER);

            // Submit the form using JavaScript
            WebElement submitButton = driver.findElement(By.id("submit"));
            js.executeScript("arguments[0].click();", submitButton);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Always quit the driver at the end
//            driver.quit();
        }
    }
}







