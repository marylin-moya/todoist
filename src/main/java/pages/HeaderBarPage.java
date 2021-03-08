package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBarPage extends BasePage {
    @FindBy(css = "button[aria-label='Settings']")
    @CacheLookup
    WebElement settings;

    public HeaderBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSettingDisplayed() {
        return settings.isDisplayed();
    }
}
