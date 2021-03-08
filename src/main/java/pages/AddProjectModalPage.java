package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProjectModalPage extends BasePage {
    @FindBy(name = "name")
    @CacheLookup
    WebElement projectNameInput;

    @FindBy(css = "button[type='submit']")
    @CacheLookup
    WebElement addButton;

    public AddProjectModalPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectModalPage setProjectName(String projectName) {
        projectNameInput.sendKeys(projectName);
        return this;
    }

    public HomePage clickAddButton() {
        addButton.click();
        return new HomePage();
    }
}
