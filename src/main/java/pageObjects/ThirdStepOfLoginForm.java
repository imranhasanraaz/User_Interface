package pageObjects;

import framework.BaseForm;
import org.openqa.selenium.By;

public class ThirdStepOfLoginForm extends BaseForm {

    public ThirdStepOfLoginForm() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(), '3 / 4')]"), "Third Login Page");
    }
}