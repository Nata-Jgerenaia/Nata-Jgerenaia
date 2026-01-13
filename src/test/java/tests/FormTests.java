package tests;

import io.qameta.allure.*;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.DriverFactory;

@Epic("Homework 3")
@Feature("Practice Form")
public class FormTests extends BaseTest {

    @Test
    @Story("Submit form and verify data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fill the automation practice form and check that all entered data appears correctly in the modal popup")
    public void fillFormAndCheckPopup() {

        FormPage form = new FormPage(DriverFactory.getDriver());

        form.open();
        form.enterFirstName("Nata");
        form.enterLastName("Jgerenaia");
        form.enterEmail("natajgerenaia16@gmail.com");
        form.selectFemaleGender();
        form.enterPhone("5991233211");
        form.setDateOfBirth("16 Dec 2005");
        form.setSubject("Computer Science");
        form.selectHobbies();
        form.enterAddress("1234 Street, Tbilisi, Georgia");
        form.selectState("NCR");
        form.selectCity("Delhi");
        form.submitForm();

        Assert.assertTrue(form.isModalDisplayed(), "Popup not displayed!");

        Assert.assertEquals(form.getTableValue("Student Name"), "Nata Jgerenaia");
        Assert.assertEquals(form.getTableValue("Student Email"), "natajgerenaia16@gmail.com");
        Assert.assertEquals(form.getTableValue("Gender"), "Female");
        Assert.assertEquals(form.getTableValue("Mobile"), "5991233211");
        Assert.assertEquals(form.getTableValue("Date of Birth"), "16 December,2005");
        Assert.assertEquals(form.getTableValue("Subjects"), "Computer Science");
        Assert.assertEquals(form.getTableValue("Hobbies"), "Reading, Music");
        Assert.assertEquals(form.getTableValue("Address"), "1234 Street, Tbilisi, Georgia");
        Assert.assertEquals(form.getTableValue("State and City"), "NCR Delhi");
    }
}
