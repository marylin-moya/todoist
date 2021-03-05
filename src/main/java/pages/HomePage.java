package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HeaderBarPage headerBarPage;
    public LeftPanelPage leftPanelPage;
    public ContentAreaPage contentAreaPage;

    public HomePage(WebDriver driver) {
        super(driver);
        headerBarPage = new HeaderBarPage(driver);
        leftPanelPage = new LeftPanelPage(driver);
        contentAreaPage = new ContentAreaPage(driver);
    }
}
