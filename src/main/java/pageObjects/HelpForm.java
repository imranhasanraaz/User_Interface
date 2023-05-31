package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class HelpForm extends BaseForm {
    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//span[contains(text(), 'Send')]"), "Send To Bottom Button");
    private final ITextBox hiddenHelpTitle = getElementFactory().getTextBox(By.xpath("//h2[contains(@class, 'help-form__title')]"), "Hidden Help Form");

    public HelpForm() {
        super(By.className("help-form"), "Help Form");
    }

    public void clickSendToBottomButton() {
        sendToBottomButton.click();
    }

    public boolean isHelpFormHidden() {
        return hiddenHelpTitle.state().waitForNotDisplayed();
    }
}