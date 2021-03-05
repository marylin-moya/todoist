import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @Test
    public void testLogin() {
        loginPage.setEmail("marylinmoya@hotmail.com");
        loginPage.setPassword("Password123");
        HomePage homePage = loginPage.clickLoginButton();
        assertTrue(homePage.headerBarPage.isSettingDisplayed(), "Setting is not displayed");
    }
}
