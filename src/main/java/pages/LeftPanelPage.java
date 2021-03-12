package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftPanelPage extends BasePage {

    @FindBy(css = "button[data-track='navigation|projects_panel']")
    @CacheLookup
    WebElement projects;

    @FindBy(css = "button[data-track='navigation|projects_quick_add']")
    @CacheLookup
    WebElement addProject;

    public LeftPanelPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectModalPage clickQuickAddProject() {
        hoverProjects();
        addProject.click();
        return new AddProjectModalPage();
    }

    void hoverProjects() {
        Actions actions = new Actions(driver);
        actions.moveToElement(projects).perform();
    }
}
