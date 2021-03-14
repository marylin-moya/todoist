import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProjectModalPage;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class ProjectsTests extends BaseTest {
    @Test
    public void testCreateProject() throws InterruptedException {
        System.out.println("Test Method");
        String projectName = "my project";

        Thread.sleep(3000);
        AddProjectModalPage addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
        Thread.sleep(3000);
        addProjectModalPage.setProjectName(projectName);
        Thread.sleep(3000);
        homePage = addProjectModalPage.clickAddButton();
        Thread.sleep(3000);
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(projectName));
    }

    @BeforeMethod
    public void loginSite() {
        System.out.println("BeforeMethod - loginSite");
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        homePage = loginPage.clickLoginButton();
    }

    @AfterMethod
    public void deleteProject() {
        System.out.println("AfterMethod - loginSite");

    }

}
