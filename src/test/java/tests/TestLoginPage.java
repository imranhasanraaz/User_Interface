package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FirstStepOfLoginForm;
import pageObjects.HomePage;
import pageObjects.SecondStepOfLoginForm;
import pageObjects.ThirdStepOfLoginForm;
import utils.LoginDataGenerator;

public class TestLoginPage extends BaseTest {

    @Test
    public void loginPage() {

        logger.info("Login Page Test starting");
        HomePage homepage = new HomePage();
        Assert.assertTrue(homepage.isDisplayed(), "Welcome page is not open.");
        homepage.clickedOnNextPage();
        FirstStepOfLoginForm firstStepOfLoginForm = new FirstStepOfLoginForm();
        logger.info("First Login Page Test starting");
        Assert.assertTrue(firstStepOfLoginForm.isDisplayed(), "First Step of login page is not open");

        logger.info("Input Login Info");
        ISettingsFile testData = new JsonSettingsFile("testdata.json");

        String email = LoginDataGenerator.getEmail(Integer.parseInt(testData.getValue("/emailLength").toString()));
        String password = LoginDataGenerator.getPassword(email, Integer.parseInt(testData.getValue("/lengthOfPassword").toString()));
        String domain = LoginDataGenerator.getDomain();

        firstStepOfLoginForm.setPassword(password);
        firstStepOfLoginForm.setEmail(email);
        firstStepOfLoginForm.setDomain(domain);
        firstStepOfLoginForm.SetMailSuffixfromDropDown();
        firstStepOfLoginForm.clickedOnTerms();
        firstStepOfLoginForm.clickedOnNext();

        logger.info("Second Login Page Test starting");
        SecondStepOfLoginForm secondStepofLoginForm = new SecondStepOfLoginForm();
        Assert.assertTrue(secondStepofLoginForm.isDisplayed(), "Second Step of login page is not open");
        secondStepofLoginForm.uploadImage(testData.getValue("/image").toString());
        secondStepofLoginForm.chooseInterests(Integer.parseInt(testData.getValue("/numberOfInterests").toString()));
        secondStepofLoginForm.clickNextButton();

        logger.info("Third Login Page Test starting");
        ThirdStepOfLoginForm thirdStepofLoginForm = new ThirdStepOfLoginForm();
        Assert.assertTrue(thirdStepofLoginForm.isDisplayed(), "Third Step of login page is not open");
        logger.info("Login Page Successfully Tested");
    }
}