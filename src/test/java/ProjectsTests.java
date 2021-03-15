import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectModalPage;
import pages.ContentAreaPage;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class ProjectsTests extends BaseTest {
    public Logger log = Logger.getLogger(getClass());

    @Test(groups = {"projects","deleteProject"})
    public void testCreateProject() throws InterruptedException {
        log.info("Test Create Project");
        String projectName = "my project";

        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        addProjectModalPage.setProjectName(projectName);
        homePage = addProjectModalPage.clickAddButton();
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
    }

    @Test(groups = {"projects", "createProject"})
    public void testDeleteProject() throws InterruptedException {
        homePage.leftPanelPage.clickProjectMenu("my project");
        homePage.leftPanelPage.selectDeleteOption();
        homePage.leftPanelPage.clickDeleteButton();
        assertTrue(homePage.leftPanelPage.isProjectDeleted("my project"));
    }

    @Test(groups = {"projects", "createProject","deleteProject"})
    public void testUpdateProject() throws InterruptedException {
        homePage.leftPanelPage.clickProjectMenu("my project");
        Thread.sleep(2000);
        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.selectEditOption();
        Thread.sleep(2000);
        addProjectModalPage.selectBoardRadioButton();
        Thread.sleep(2000);
        addProjectModalPage.clickAddButton();
        Thread.sleep(2000);
        ContentAreaPage contentAreaPage = homePage.leftPanelPage.clickProject("my project");
        Thread.sleep(2000);
        assertTrue(contentAreaPage.isProjectNameDisplayed("my project"));
    }
}
