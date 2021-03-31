package todoist.org.steps;

import entities.Project;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AddProjectModalPage;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;


public class Hooks {
    private Logger log = Logger.getLogger(getClass());

    Project project;
    HomePage homePage;
    LoginPage loginPage;
    AddProjectModalPage addProjectModalPage;

    public Hooks(HomePage homePage, Project project) {
        this.project = project;
        this.homePage = homePage;
    }

    public void loginTodoist() {
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @Before(value = "@createProject")
    public void createProject() {
        loginTodoist();
        project.setName("my project");
        addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        addProjectModalPage.setProjectName(project.getName());
        homePage = addProjectModalPage.clickAddButton();
    }


    @After(value = "@deleteProject", order = 51)
    public void deleteProject() throws InterruptedException {
        log.info("----Delete Project------");
        homePage.leftPanelPage.clickProjectMenu(project.getName());
        homePage.leftPanelPage.selectDeleteOption();
        homePage.leftPanelPage.clickDeleteButton();
    }

    @After(order = 50)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "SCREENSHOT-NAME"); //stick it in the report
        }
        DriverManager.getInstance().quitDriver();
    }
}
