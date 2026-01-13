package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.AllureUtils;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureUtils.takeScreenshot(DriverFactory.getDriver(), result.getName());
        }
        DriverFactory.quitDriver();
    }
}
