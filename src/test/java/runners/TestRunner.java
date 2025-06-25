package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/runners/TestRunner.java",
        glue = "WebStepDefs",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {}

