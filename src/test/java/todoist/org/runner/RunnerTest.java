package todoist.org.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import selenium.DriverManager;

//@CucumberOptions(
//        plugin = {"pretty", "json:build/cucumber/cucumber-report.json"},
//        glue = {"todoist.org"},
//        features = {"classpath:features/login"})
public class RunnerTest extends AbstractTestNGCucumberTests {
    private static Logger log = Logger.getLogger("RunnerTest");

    @AfterTest
    public void afterExecution(){
        log.info("-------------------After Execution---------------");

    }
}
