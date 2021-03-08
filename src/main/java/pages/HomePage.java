package pages;

public class HomePage extends BasePage {
    public HeaderBarPage headerBarPage;
    public LeftPanelPage leftPanelPage;
    public ContentAreaPage contentAreaPage;

    public HomePage() {
        headerBarPage = new HeaderBarPage();
        leftPanelPage = new LeftPanelPage();
        contentAreaPage = new ContentAreaPage();
    }
}
