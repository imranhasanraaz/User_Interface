package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {

    private final ISettingsFile configReader = new JsonSettingsFile("config.json");
    private final String URL = configReader.getValue("/URL").toString();
    public Logger logger = AqualityServices.getLogger();

    @BeforeMethod
    public void SetUp() {
        getBrowser().maximize();
        getBrowser().goTo(URL);
        getBrowser().waitForPageToLoad();
    }

    @AfterTest
    public void Teardown() {
        getBrowser().getDriver().quit();
    }
}