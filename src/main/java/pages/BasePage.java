package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.DriverManager;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Logger log = Logger.getLogger(getClass());

    public BasePage() {
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
    }

    protected void hoverProjects(WebElement element) {
        log.info("Hover on a Web element");
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
