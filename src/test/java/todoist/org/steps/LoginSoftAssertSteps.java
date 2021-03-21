package todoist.org.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;

public class LoginSoftAssertSteps {
    LoginPage loginPage;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();


    @Given("^SA-I navigate to Todoist Login page$")
    public void navigateToTodoistLoginPage() {
        DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
        loginPage = new LoginPage();
    }

    @When("^SA-I login to Todoist as \"(.*?)\" with password \"(.*?)\"$")
    public void loginToTodoist(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        homePage = loginPage.clickLoginButton();
    }

    @Then("^SA-I should login to Todoist successfully$")
    public void IloginSuccessfully() {
        //assertTrue(homePage.headerBarPage.isSettingDisplayed());
        softAssert.assertTrue(homePage.headerBarPage.isSettingDisplayed());
    }

    @Then("^SA-I make this step fail the first time$")
    public void stepToFail1() {
        softAssert.assertTrue(false, "stepToFail1");
    }

    @Then("^SA-I make this step fail the second time$")
    public void stepToFail2() {
        softAssert.assertFalse(true, "stepToFail2");
    }

    @Then("^SA-I make this step pass the first time$")
    public void stepToPass1() {
        softAssert.assertTrue(true);
    }

    @Then("SA-Verify all assertions")
    public void verifyAllAssertions() {
        softAssert.assertAll("Check all verifications");
    }
}
