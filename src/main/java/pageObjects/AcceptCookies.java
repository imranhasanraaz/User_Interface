package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import framework.BaseForm;
import org.openqa.selenium.By;

public class AcceptCookies extends BaseForm {
    private final IButton acceptCookies = getElementFactory().getButton(By.xpath("//button[@name='button' and contains(text(), 'Not really, no')]"), "Accept Cookies Button");

    public AcceptCookies() {
        super(By.className("cookies"), "Cookies Form");
    }

    public void clickAcceptCookies() {
        acceptCookies.click();
    }
}