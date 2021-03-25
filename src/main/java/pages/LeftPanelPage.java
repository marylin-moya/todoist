package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftPanelPage extends BasePage {

    @FindBy(css = "button[data-track='navigation|projects_panel']")
    @CacheLookup
    WebElement projects;

    @FindBy(css = "button[data-track='navigation|projects_quick_add']")
    @CacheLookup
    WebElement addProject;

    @FindBy(css = "#menu_delete_text")
    @CacheLookup
    WebElement deleteOption;

    //@FindBy(css = ".confirm_dialog__actions .ist_button_red")
    @FindBy(xpath = "//footer/button[contains(text(),'Delete')]")
    @CacheLookup
    WebElement deleteButton;

    @FindBy(css = "td[data-track='projects|menu_edit'] .menu_label")
    @CacheLookup
    WebElement editOption;

   By deleteModal = By.cssSelector( "reach-portal");

    String project = "//ul[@id='projects_list']//span[text()='%s']";
    String projectMenu = "//ul[@id='projects_list']//span[text()='%s']/../following-sibling::td/div[contains(@class,'gear_menu')]";

    public LeftPanelPage() {
        PageFactory.initElements(driver, this);
    }

    public AddProjectModalPage clickQuickAddProject() {
        log.info("Click on Add Project icon");
        hoverProjects(projects);
        wait.until(ExpectedConditions.visibilityOf(addProject));
        addProject.click();
        return new AddProjectModalPage();
    }

    public ContentAreaPage clickProject(String projectName) {
        log.info("Click on Project");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By projectBy = By.xpath(String.format(project, projectName));
        WebElement projectElement = driver.findElement(projectBy);
        wait.until(ExpectedConditions.visibilityOf(projectElement));
        projectElement.click();
        return new ContentAreaPage();
    }

    public void clickProjectMenu(String projectName) {
        log.info("Open Project Menu");
        WebElement projectOptions = driver.findElement(By.xpath(String.format(project, projectName)));
        hoverProjects(projectOptions);
        By projectMenuBy = By.xpath(String.format(projectMenu, projectName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectMenuBy));
        wait.until(ExpectedConditions.elementToBeClickable(projectMenuBy));
        driver.findElement(projectMenuBy).click();
        By menuHidden = By.xpath("//div[@class='ist_menu' and not(contains(@style,'display: none'))]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuHidden));
    }

    public void selectDeleteOption() {
        log.info("Select Delete option");
        wait.until(ExpectedConditions.visibilityOf(deleteOption));
        deleteOption.click();
    }

    public void clickDeleteButton() throws InterruptedException {
        log.info("Click Delete button");
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        Thread.sleep(3000);
        deleteButton.click();
        Thread.sleep(2000);
    }

    public boolean isProjectDeleted(String projectName) {
        log.info("Click Delete button");
        By projectBy = By.xpath(String.format(project, projectName));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(projectBy));

        return driver.findElements(projectBy).size() == 0;
    }

    public AddProjectModalPage selectEditOption() {
        log.info("Select Edit option");
        wait.until(ExpectedConditions.visibilityOf(editOption));
        editOption.click();
        return new AddProjectModalPage();
    }
}
