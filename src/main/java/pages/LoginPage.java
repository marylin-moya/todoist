package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By emailBy = By.id("email");
    private By passwordBy = By.id("password");
    private By loginBy = By.cssSelector("button.submit_btn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        driver.findElement(emailBy).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginBy).click();
        return new HomePage(driver);
    }
}
