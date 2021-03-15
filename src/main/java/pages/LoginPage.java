package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    @CacheLookup
    WebElement emailInput;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(css = "button.submit_btn")
    @CacheLookup
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        log.info("Type email: " + email);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        log.info("Type password: *******");
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public HomePage clickLoginButton() {
        log.info("Click Login button");
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new HomePage();
    }
}
