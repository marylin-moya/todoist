package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderBarPage extends BasePage {
    @FindBy(css = "button[aria-label='Settings']")
    @CacheLookup
    WebElement settings;

    public HeaderBarPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isSettingDisplayed() {
        log.info("Get if the Setting is displayed");
        wait.until(ExpectedConditions.visibilityOf(settings));
        return settings.isDisplayed();
    }
}
