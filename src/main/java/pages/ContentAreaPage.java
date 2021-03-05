package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentAreaPage extends BasePage {
    private String projectName = "//div[@id='editor']//span[text()='%s']";

    public ContentAreaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProjectNameDisplayed(String name) {
        By project = By.xpath(String.format(projectName, name));
        return driver.findElement(project).isDisplayed();
    }
}
