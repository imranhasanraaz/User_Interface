package framework;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class BaseForm extends Form {

    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    public boolean isDisplayed() {
        return state().isDisplayed();
    }

    public boolean waitForDisplayed() {
        return state().waitForDisplayed();
    }
}