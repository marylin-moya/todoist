package todoist.org.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    public Logger log = Logger.getLogger(getClass());

    @Test(groups = {"login"})
    public void testLogin() {
        log.info("Test Successful Login");
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        HomePage homePage = loginPage.clickLoginButton();
        assertTrue(homePage.headerBarPage.isSettingDisplayed(), "Setting is not displayed");
    }
}
