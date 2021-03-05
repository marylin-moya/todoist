package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderBarPage extends BasePage {
    private By settings = By.cssSelector("button[aria-label='Settings']");

    public HeaderBarPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSettingDisplayed() {
        return driver.findElement(settings).isDisplayed();
    }
}
