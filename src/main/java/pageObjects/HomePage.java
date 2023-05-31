package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import framework.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    private final IButton nextPage = getElementFactory().getButton(By.className("start__link"), "Start Button");

    public HomePage() {
        super(By.xpath("//div[@class='logo__icon']"), "homepage");
    }

    public void clickedOnNextPage() {
        nextPage.clickAndWait();
    }
}