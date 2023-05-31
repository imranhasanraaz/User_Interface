package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FirstStepOfLoginForm;
import pageObjects.HomePage;

public class TestTimer extends BaseTest {

    @Test
    public void timeTest() {
        logger.info("Timer Test starting");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.waitForDisplayed(), "Main Page has not been displayed!");
        homePage.clickedOnNextPage();

        FirstStepOfLoginForm firstStepofLoginForm = new FirstStepOfLoginForm();
        firstStepofLoginForm.waitForDisplayed();
        ISettingsFile testData = new JsonSettingsFile("testdata.json");
        Assert.assertEquals(firstStepofLoginForm.getTimerValue(), testData.getValue("/timer").toString(), "Timer does not start at 00:00:00");
        logger.info("Timer successfully Tested");
    }
}