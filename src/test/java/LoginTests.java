import org.testng.annotations.Test;
import pages.HomePage;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @Test
    public void testLogin() {
        loginPage.setEmail(GradleProperties.getInstance().getEmail());
        loginPage.setPassword(GradleProperties.getInstance().getPassword());
        HomePage homePage = loginPage.clickLoginButton();
        assertTrue(homePage.headerBarPage.isSettingDisplayed(), "Setting is not displayed");
    }
}
