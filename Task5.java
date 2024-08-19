package sampleapp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Task5 {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("userEmail");
    private By genderRadio = By.cssSelector("label[for='gender-radio-1']");
    private By userNumberInput = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By monthDropdown = By.className("react-datepicker__month-select");
    private By yearDropdown = By.className("react-datepicker__year-select");
    private By dayOfMonth = By.cssSelector(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)");
    private By subjectInput = By.cssSelector(".subjects-auto-complete__input input");
    private By musicCheckbox = By.xpath("//label[text()='Music']");
    private By uploadPictureInput = By.id("uploadPicture");
    private By currentAddressInput = By.id("currentAddress");
    private By stateInput = By.id("react-select-3-input");
    private By cityInput = By.id("react-select-4-input");
    private By submitButton = By.id("submit");
    private By submissionSuccessMessage = By.id("example-modal-sizes-title-lg"); // Example locator for success message

    public Task5(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void selectGender() {
        WebElement genderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(genderRadio));
        js.executeScript("arguments[0].scrollIntoView(true);", genderElement);
        genderElement.click();
    }

    public void enterUserNumber(String userNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNumberInput)).sendKeys(userNumber);
    }

    public void selectDateOfBirth() {
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateOfBirthInput));
        js.executeScript("arguments[0].scrollIntoView(true);", dateElement);
        dateElement.click();

        wait.until(ExpectedConditions.elementToBeClickable(monthDropdown)).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select option[value='9']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(yearDropdown)).click();
        driver.findElement(By.cssSelector(".react-datepicker__year-select option[value='2003']")).click();

        driver.findElement(dayOfMonth).click();
    }

    public void enterSubjects(String... subjects) throws InterruptedException {
        WebElement subjectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
        for (String subject : subjects) {
            subjectElement.sendKeys(subject);
            Thread.sleep(1000);
            subjectElement.sendKeys(Keys.TAB);
        }
    }

    public void selectHobbies() {
        WebElement musicCheckboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(musicCheckbox));
        js.executeScript("arguments[0].click();", musicCheckboxElement);
    }

    public void uploadPicture(String filePath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPictureInput)).sendKeys(filePath);
    }

    public void enterCurrentAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddressInput)).sendKeys(address);
    }

    public void selectStateAndCity(String state, String city) {
        WebElement stateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stateInput));
        stateElement.sendKeys(state);
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
        cityElement.sendKeys(city);
        cityElement.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        js.executeScript("arguments[0].click();", submitBtn);
    }

    public boolean isFormSubmittedSuccessfully() {
        // Checks if the success message is displayed after form submission
        return wait.until(ExpectedConditions.visibilityOfElementLocated(submissionSuccessMessage)).isDisplayed();
    }
}
