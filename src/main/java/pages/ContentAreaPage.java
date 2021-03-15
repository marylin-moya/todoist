package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContentAreaPage extends BasePage {
    private String projectName = "//div[@id='editor']//span[text()='%s']";

    public boolean isProjectNameDisplayed(String name) {
        log.info("Get if the project name is displayed");
        By project = By.xpath(String.format(projectName, name));
        wait.until(ExpectedConditions.visibilityOfElementLocated(project));

        return driver.findElement(project).isDisplayed();
    }
}
