import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;

public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.out.println("BeforeClass - Setup");
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("AfterClass - tearDown");
        DriverManager.getInstance().quitDriver();
    }
}