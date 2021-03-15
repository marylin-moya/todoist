package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProjectModalPage extends BasePage {
    @FindBy(name = "name")
    @CacheLookup
    WebElement projectNameInput;

    @FindBy(css = "button[type='submit']")
    @CacheLookup
    WebElement addButton;

    @FindBy(css = "#project_list_board_style_option button")
    @CacheLookup
    WebElement boardRadioButton;

    public AddProjectModalPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectModalPage setProjectName(String projectName) {
        log.info("Type Project Name: " + projectName);
        wait.until(ExpectedConditions.visibilityOf(projectNameInput));
        projectNameInput.sendKeys(projectName);
        return this;
    }

    public HomePage clickAddButton() {
        log.info("Click Add Project button");
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
        return new HomePage();
    }

    public void selectBoardRadioButton() {
        log.info("Select Board radio button");
        wait.until(ExpectedConditions.visibilityOf(boardRadioButton));
        if (!boardRadioButton.isSelected()) {
            boardRadioButton.click();
        }
    }
}
