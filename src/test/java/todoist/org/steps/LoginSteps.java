package todoist.org.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class LoginSteps {
    private Logger log = Logger.getLogger(getClass());

    private LoginPage loginPage;
    private HomePage homePage;

    @Given("^I navigate to Todoist Login page$")
    public void navigateToTodoistLoginPage() {
        log.info("Navigate to Todoist Login page");
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
    }

    @When("^I login to Todoist as \"(.*?)\" with password \"(.*?)\"$")
    public void loginToTodoist(String email, String password) {
        log.info("Type emai, password and click on login button");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        homePage = loginPage.clickLoginButton();
    }

    @Then("^I should login to Todoist successfully$")
    public void verifyTodoistHomePageIsDisplayed() {
        log.info("Verify that Home page is displayed");
        assertTrue(homePage.headerBarPage.isSettingDisplayed());
    }

    @After(value = "Login")
    public void closeBrowser() {
        log.info("Close Browser");
        DriverManager.getInstance().quitDriver();
    }


    @Then("^I make this step fail the first time$")
    public void stepToFail1(){
        System.out.println("This step is going to fail #1");
        assertTrue(false);
    }
    @Then("^I make this step pass the first time$")
    public void stepToPass1(){
        System.out.println("This step is going to pass #1");
        assertTrue(true);
    }

    @Then("^I make this step fail the second time$")
    public void stepToFail2(){
        System.out.println("This is going to fail #2");
        assertFalse(true);
    }
}
