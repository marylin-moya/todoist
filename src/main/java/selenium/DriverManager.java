package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;
import utils.GradleProperties;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class DriverManager {
    private static DriverManager instance = null;
    public Logger log = Logger.getLogger(getClass());
    private WebDriver driver;
    private WebDriverWait wait;

    protected DriverManager() {
        initialize();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initialize() {
        log.info("Initialize Driver");
        if (GradleProperties.getInstance().getBrowser().equals(CHROME)) {
            log.info("Configure Chrome Driver");
            System.setProperty(CHROME_WEBDRIVER, ConfigProperties.getInstance().getChromeDriver());
            driver = new ChromeDriver();
        }

        if (GradleProperties.getInstance().getBrowser().equals(FIREFOX)) {
            log.info("Configure Firefox Driver");
            //Code for firefox
        }
        driver.manage().timeouts().implicitlyWait(ConfigProperties.getInstance().getImplicitTime(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, ConfigProperties.getInstance().getExplicitTime());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setUrl(String url) {
        driver.get(url);
    }

    public void quitDriver() {
        driver.quit();
        instance = null;
    }
}
