package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HelpForm;
import pageObjects.HomePage;

public class TestHideHelp extends BaseTest {

    @Test
    public void hideHelp() {

        logger.info("Hide Help Test starting");
        HomePage homepage = new HomePage();
        Assert.assertTrue(homepage.isDisplayed(), "Welcome page is not open.");
        homepage.clickedOnNextPage();
        HelpForm help = new HelpForm();
        Assert.assertTrue(help.isDisplayed(), "Help is not Displayed");
        help.clickSendToBottomButton();
        Assert.assertTrue(help.isHelpFormHidden(), "Help Form is not hidden!");
        logger.info("Hide Help Successfully Tested");

    }
}