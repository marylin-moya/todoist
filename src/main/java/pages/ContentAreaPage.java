package pages;

import org.openqa.selenium.By;

public class ContentAreaPage extends BasePage {
    private String projectName = "//div[@id='editor']//span[text()='%s']";

    public boolean isProjectNameDisplayed(String name) {
        By project = By.xpath(String.format(projectName, name));
        return driver.findElement(project).isDisplayed();
    }
}
