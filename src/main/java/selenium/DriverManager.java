package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance = null;

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
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getInstance().getChromeDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ConfigProperties.getInstance().getImplicitTime(), TimeUnit.SECONDS);
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
