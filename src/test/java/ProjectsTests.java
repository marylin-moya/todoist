import org.testng.annotations.Test;
import pages.AddProjectModalPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ProjectsTests extends BaseTest {
    @Test
    public void testCreateProject() throws InterruptedException {
        String projectName = "my project";
        loginPage.setEmail("marylinmoya@hotmail.com");
        loginPage.setPassword("Password123");
        HomePage homePage = loginPage.clickLoginButton();
        Thread.sleep(3000);
        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        Thread.sleep(3000);
        addProjectModalPage.setProjectName(projectName);
        Thread.sleep(3000);
        homePage = addProjectModalPage.clickAddButton();
        Thread.sleep(3000);
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
    }
}
