import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTests {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void alertWithTextboxTest() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.cssSelector("a[href='#Textbox']")).click();

        driver.findElement(By.cssSelector("button.btn.btn-info")).click();

        Alert alert = driver.switchTo().alert();
        String name = "Nata Jgerenaia";
        alert.sendKeys(name);
        alert.accept();

        String result = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue(result.contains(name), "Result text does not contain expected name!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

