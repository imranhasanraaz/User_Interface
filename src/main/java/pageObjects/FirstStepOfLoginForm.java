package pageObjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

import static utils.RandomGenerator.getRandomInteger;

public class FirstStepOfLoginForm extends BaseForm {


    private final ITextBox password = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "Password Fields");
    private final ITextBox email = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Your email')]"), "Email Field");
    private final ITextBox domain = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "Domain Field");
    private final IButton dropDown = getElementFactory().getButton(By.xpath("//div[contains(@class, 'dropdown--gray')]"), "Drop Down");
    private final ICheckBox termsAndConditions = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'checkbox__box')]"), "Check Box");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary')]"), "Next Button");
    private final ITextBox timerTextBox = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'timer--white')]"), "Timer Box");
    private final List<IComboBox> mailSuffixes = getElementFactory().findElements(By.className("dropdown__list-item"), IComboBox.class, ElementsCount.MORE_THAN_ZERO, ElementState.EXISTS_IN_ANY_STATE);


    public FirstStepOfLoginForm() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(), '1 / 4')]"), "First Login Page");
    }


    public void setPassword(String Password) {
        password.clearAndType(Password);
    }

    public void  setEmail(String Email) {

        email.clearAndType(Email);

    }

    public void setDomain(String Domain) {
        domain.clearAndType(Domain);
    }


    public void SetMailSuffixfromDropDown() {
        dropDown.click();
        int randomDomain = getRandomInteger(mailSuffixes.size());
        mailSuffixes.get(randomDomain).click();
    }

    public void clickedOnTerms() {
        termsAndConditions.click();
    }

    public void clickedOnNext() {
        nextButton.click();
    }

    public String getTimerValue() {
        return timerTextBox.getText();
    }
}