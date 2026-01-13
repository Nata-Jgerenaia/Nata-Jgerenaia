package tests;

import io.qameta.allure.*;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import utils.DriverFactory;

@Epic("Homework 3")
@Feature("Alerts")
public class AlertTests extends BaseTest {

    @Test
    @Story("Send text to alert and verify")
    @Severity(SeverityLevel.NORMAL)
    @Description("Open alert with textbox, send name and accept, then verify result text")

    public void alertWithTextboxTest() {

        AlertPage alert = new AlertPage(DriverFactory.getDriver());

        alert.open();
        alert.openTextboxAlert();
        alert.clickAlertButton();
        alert.sendTextAndAccept("Nata Jgerenaia");

        Assert.assertTrue(alert.getResultText().contains("Nata Jgerenaia"),
                "Result text does not contain expected name!");
    }
}
