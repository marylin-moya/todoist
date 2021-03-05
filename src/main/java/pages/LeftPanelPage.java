package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftPanelPage extends BasePage {
    private By addProject = By.cssSelector("a.sel_add_project");

    public LeftPanelPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectModalPage clickAddProject() {
        driver.findElement(addProject).click();
        return new AddProjectModalPage(driver);
    }
}
