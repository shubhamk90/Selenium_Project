package sampleapp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask5
{

    private WebDriver driver;
    private Task5 formsPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        formsPage = new Task5(driver);
    }

    @Test(priority = 2)
    public void fillOutFormTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        formsPage.enterFirstName("Shubham");
        formsPage.enterLastName("Kumar");
        formsPage.enterEmail("sharmashubham52y@gmail.com");
        formsPage.selectGender();
        formsPage.enterUserNumber("7986946889");
        formsPage.selectDateOfBirth();
        formsPage.enterSubjects("Physics", "English", "Computer Science");
        formsPage.selectHobbies();
        formsPage.uploadPicture("C:\\Users\\Shubham\\Downloads\\imagee.jpg");
        formsPage.enterCurrentAddress("Sector 21, Gurugram, Haryana");
        formsPage.selectStateAndCity("Uttar Pradesh", "Agra");

        formsPage.submitForm();

        // Assert that form submission was successful
        Assert.assertTrue(formsPage.isFormSubmittedSuccessfully(), "Form submission failed!");
    }

    @Test(priority = 1)
    public void verifyPageTitleTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        // Assert that the page title is as expected
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match the expected value!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}



