package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By femaleGender = By.cssSelector("label[for='gender-radio-2']");
    private By phone = By.id("userNumber");
    private By dobInput = By.id("dateOfBirthInput");
    private By subjectsInput = By.id("subjectsInput");
    private By hobbiesReading = By.cssSelector("label[for='hobbies-checkbox-2']");
    private By hobbiesMusic = By.cssSelector("label[for='hobbies-checkbox-3']");
    private By address = By.id("currentAddress");
    private By stateInput = By.id("react-select-3-input");
    private By cityInput = By.id("react-select-4-input");
    private By submit = By.id("submit");
    private By modalTitle = By.id("example-modal-sizes-title-lg");

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void selectFemaleGender() {
        WebElement female = driver.findElement(femaleGender);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", female);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", female);
    }

    public void enterPhone(String value) {
        driver.findElement(phone).sendKeys(value);
    }

    public void setDateOfBirth(String value) {
        WebElement dob = driver.findElement(dobInput);
        dob.sendKeys(Keys.CONTROL + "a");
        dob.sendKeys(value);
        dob.sendKeys(Keys.ENTER);
    }

    public void setSubject(String value) {
        WebElement subject = driver.findElement(subjectsInput);
        subject.sendKeys(value);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".subjects-auto-complete__menu-list .subjects-auto-complete__option")));

        subject.sendKeys(Keys.ENTER);
    }

    public void selectHobbies() {
        WebElement reading = driver.findElement(hobbiesReading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reading);

        WebElement music = driver.findElement(hobbiesMusic);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", music);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", music);
    }

    public void enterAddress(String value) {
        driver.findElement(address).sendKeys(value);
    }

    public void selectState(String value) {
        WebElement state = driver.findElement(stateInput);
        state.sendKeys(value);
        state.sendKeys(Keys.ENTER);
    }

    public void selectCity(String value) {
        WebElement city = driver.findElement(cityInput);
        city.sendKeys(value);
        city.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        WebElement submitBtn = driver.findElement(submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
    }

    public boolean isModalDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle)).isDisplayed();
    }

    public String getTableValue(String fieldName) {
        return driver.findElement(
                By.xpath("//td[text()='" + fieldName + "']/following-sibling::td")
        ).getText();
    }
}
