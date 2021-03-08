package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftPanelPage extends BasePage {
    @FindBy(css = "a.sel_add_project")
    @CacheLookup
    WebElement addProject;

    public LeftPanelPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectModalPage clickAddProject() {
        addProject.click();
        return new AddProjectModalPage();
    }
}
