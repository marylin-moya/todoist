package todoist.org.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import selenium.DriverManager;

@CucumberOptions(
        plugin = {"pretty", "html:build/cucumber/cucumber-report.html",
        "json:build/cucumber/cucumber-report.json", "rerun:build/cucumber/rerun.txt" },
        glue = {"todoist.org"},
        features = {"classpath:features/login","classpath:features/projects"}, tags = "@Login")
public class RunnerTest extends AbstractTestNGCucumberTests {
    private static Logger log = Logger.getLogger("RunnerTest");

    @AfterTest
    public void afterExecution(){
        log.info("-------------------After Execution---------------");
        DriverManager.getInstance().quitDriver();
    }
}
