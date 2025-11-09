import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class FormTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void fillFormAndCheckPopup() {

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("Nata");
        driver.findElement(By.id("lastName")).sendKeys("Jgerenaia");
        driver.findElement(By.id("userEmail")).sendKeys("natajgerenaia16@gmail.com");
        driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("5991233211");

        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        dob.sendKeys("16 Dec 2005");
        dob.sendKeys(Keys.ENTER);

        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("Computer Science");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".subjects-auto-complete__menu-list .subjects-auto-complete__option")));
        subjectInput.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();

        driver.findElement(By.id("currentAddress")).sendKeys("1234 Street, Tbilisi, Georgia");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.id("react-select-4-input"));

        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);


        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);


        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("example-modal-sizes-title-lg")));
       Assert.assertTrue(modal.isDisplayed(), "Popup not displayed!");

        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText(),
                "Nata Jgerenaia");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText(),
                "natajgerenaia16@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(),
                "Female");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText(),
                "5991233211");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(),
                "16 December,2005");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td")).getText(),
                "Computer Science");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td")).getText(),
                "Reading, Music");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),
                "1234 Street, Tbilisi, Georgia");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td")).getText(),
                "NCR Delhi");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
