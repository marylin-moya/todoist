package todoist.org.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.AddProjectModalPage;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    public Logger log = Logger.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        log.info("Load Todoist page - (BeforeClass - Setup)");
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close browser - (AfterClass - tearDown)");
        DriverManager.getInstance().quitDriver();
    }

    @BeforeMethod(onlyForGroups = {"projects"}, dependsOnMethods = {"setUp"})
    public void loginSite() {
        log.info("Login to Todoist site - (BeforeMethod - loginSite)");
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @BeforeMethod(onlyForGroups = {"createProject"}, dependsOnMethods = {"loginSite"})
    public void createProject() {
        log.info("Create Project - (BeforeMethod - createProject)");
        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        addProjectModalPage.setProjectName("my project");
        homePage = addProjectModalPage.clickAddButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(onlyForGroups = {"deleteProject"})
    public void deleteProject() throws InterruptedException {
        log.info("Delete project - (AfterMethod - delete project)");
        homePage.leftPanelPage.clickProjectMenu("my project");
        homePage.leftPanelPage.selectDeleteOption();
        homePage.leftPanelPage.clickDeleteButton();
    }

    @DataProvider(name = "provider")
    public Object[][] provide() throws Exception {
        return new Object[][]{{"my project"}};
    }
}