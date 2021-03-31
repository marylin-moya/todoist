package todoist.org.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.AddProjectModalPage;
import pages.ContentAreaPage;

import static org.testng.Assert.assertTrue;

public class ProjectsTests extends BaseTest {
    public Logger log = Logger.getLogger(getClass());

    @Test(groups = {"projects","deleteProject"}, dataProvider = "provider")
    public void testCreateProject(String projectName) throws InterruptedException {
        log.info("Test Create Project");

        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        addProjectModalPage.setProjectName(projectName);
        homePage = addProjectModalPage.clickAddButton();
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
    }

    //GIVEN
    @Test(groups = {"projects", "createProject"}, dataProvider = "provider")
    public void testDeleteProject(String projectName) throws InterruptedException {
        //WHEN
        homePage.leftPanelPage.clickProjectMenu(projectName);
        homePage.leftPanelPage.selectDeleteOption();
        homePage.leftPanelPage.clickDeleteButton();
        //THEN
        assertTrue(homePage.leftPanelPage.isProjectDeleted(projectName));
    }

    @Test(groups = {"projects", "createProject","deleteProject"}, dataProvider = "provider")
    public void testUpdateProject(String projectName) throws InterruptedException {
        homePage.leftPanelPage.clickProjectMenu(projectName);
        Thread.sleep(2000);
        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.selectEditOption();
        Thread.sleep(2000);
        addProjectModalPage.selectBoardRadioButton();
        Thread.sleep(2000);
        addProjectModalPage.clickAddButton();
        Thread.sleep(2000);
        ContentAreaPage contentAreaPage = homePage.leftPanelPage.clickProject(projectName);
        Thread.sleep(2000);
        assertTrue(contentAreaPage.isProjectNameDisplayed(projectName));
    }
}
