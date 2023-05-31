package pageObjects;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import framework.BaseForm;
import org.openqa.selenium.By;
import utils.RobotUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomGenerator.getRandomInteger;


public class SecondStepOfLoginForm extends BaseForm {

    private final IButton upload = getElementFactory().getButton(By.className("avatar-and-interests__upload-button"), "Upload Image Button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'button--stroked')]"), "Next Button");
    private final ICheckBox unSelectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "Unselect All");
    private final List<ICheckBox> checkBoxes = getElementFactory().findElements(By.xpath("//span[@class='checkbox__box' and not(ancestor::div/span[text()='Unselect all'] or ancestor::div/span[text()='Select all'])]"), ICheckBox.class, ElementsCount.MORE_THAN_ZERO, ElementState.EXISTS_IN_ANY_STATE);

    public SecondStepOfLoginForm() {
        super(By.xpath("//div[@class='page-indicator' and contains(text(), '2 / 4')]"), "Second Login Page");
    }

    public void uploadImage(String path) {
        upload.clickAndWait();
        RobotUtils robot = new RobotUtils();
        robot.uploadFile(path);
    }

    public void chooseInterests(int numberOfInterests) {
        unSelectAll.getJsActions().scrollIntoView();
        unSelectAll.click();

        List<Integer> randomIndices = new ArrayList<>();

        for (int counter = 0; counter < numberOfInterests && !checkBoxes.isEmpty(); counter++) {
            int index = getRandomInteger(checkBoxes.size());
            if (!randomIndices.contains(index)) {
                randomIndices.add(index);
            }
        }

        for (int index : randomIndices) {
            checkBoxes.get(index).click();
        }
    }



    public void clickNextButton() {
        nextButton.click();
    }
}