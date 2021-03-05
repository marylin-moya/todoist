package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectModalPage extends BasePage {
    private By projectNameInput = By.name("name");
    private By addButton = By.cssSelector("button[type='submit']");

    public AddProjectModalPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectModalPage setProjectName(String projectName) {
        driver.findElement(projectNameInput).sendKeys(projectName);
        return this;
    }

    public HomePage clickAddButton() {
        driver.findElement(addButton).click();
        return new HomePage(driver);
    }
}
