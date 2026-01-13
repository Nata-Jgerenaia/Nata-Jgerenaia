package pages;

import org.openqa.selenium.*;

public class AlertPage {

    private WebDriver driver;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    private By textboxTab = By.cssSelector("a[href='#Textbox']");
    private By button = By.cssSelector("button.btn.btn-info");
    private By result = By.id("demo1");

    public void open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    public void openTextboxAlert() {
        driver.findElement(textboxTab).click();
    }

    public void clickAlertButton() {
        driver.findElement(button).click();
    }

    public void sendTextAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }


    public String getResultText() {
        return driver.findElement(result).getText();
    }
}
