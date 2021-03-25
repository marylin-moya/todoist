package todoist.org.steps;

import entities.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.AddProjectModalPage;
import pages.ContentAreaPage;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ProjectSteps {
    private Logger log = Logger.getLogger(getClass());

    AddProjectModalPage addProjectModalPage;
    HomePage homePage;
    Project project;

    public ProjectSteps(HomePage homePage, Project project){
        this.homePage = homePage;
        this.project = project;
    }

    @When("I select create Project option")
    public void iSelectCreateProjectOption() {
        log.info("Click create project option");
        addProjectModalPage = homePage.leftPanelPage.clickQuickAddProject();
    }

    @And("I type {string} in Project Name field")
    public void iTypeInProjectNameField(String projectName) {
        log.info("Type project name");
        project.setName(projectName);
        addProjectModalPage.setProjectName(projectName);
    }

    @Then("the Project should be created")
    public void theProjectShouldBeCreated() {
        assertTrue(homePage.contentAreaPage.isProjectNameDisplayed(project.getName()));
    }

    @And("I click on Add button")
    public void iClickOnAddButton() {
        homePage = addProjectModalPage.clickAddButton();
    }


    @When("I select delete option of project")
    public void iSelectDeleteOptionOfProject() {
        homePage.leftPanelPage.clickProjectMenu(project.getName());
        homePage.leftPanelPage.selectDeleteOption();
    }

    @And("I click on Delete button")
    public void iClickOnDeleteButton() throws InterruptedException {
        homePage.leftPanelPage.clickDeleteButton();
    }
    @Then("the Project should be deleted")
    public void theProjectShouldBeDeleted() {
        assertTrue(homePage.leftPanelPage.isProjectDeleted("my project"));
    }

    @When("I select edit option of project")
    public void iSelectEditOptionOfProject() throws InterruptedException {
        homePage.leftPanelPage.clickProjectMenu(project.getName());
        Thread.sleep(1000);
        addProjectModalPage = homePage.leftPanelPage.selectEditOption();
        Thread.sleep(1000);
    }

    @And("I change project type to Board")
    public void iChangeProjectTypeToBoard() {
        addProjectModalPage.selectBoardRadioButton();
        addProjectModalPage.clickAddButton();
    }

    @Then("the project type is Board")
    public void theProjectTypeIsBoard() {
        ContentAreaPage contentAreaPage = homePage.leftPanelPage.clickProject(project.getName());
        assertTrue(contentAreaPage.isProjectNameDisplayed(project.getName()));
    }
}
