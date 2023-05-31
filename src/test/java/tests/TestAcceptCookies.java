package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AcceptCookies;
import pageObjects.HomePage;

public class TestAcceptCookies extends BaseTest {

    @Test
    public void acceptCookies() {

        logger.info("Accept Cookies Test starting");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isDisplayed(), "Welcome page is not open.");
        homePage.clickedOnNextPage();

        AcceptCookies acceptCookies = new AcceptCookies();
        Assert.assertTrue(acceptCookies.waitForDisplayed(), "Accept Cookies is not Displayed");
        acceptCookies.clickAcceptCookies();
        Assert.assertFalse(acceptCookies.isDisplayed(), "Cookies form has not been accepted");
        logger.info("Accept Cookies Successfully Tested");

    }
}