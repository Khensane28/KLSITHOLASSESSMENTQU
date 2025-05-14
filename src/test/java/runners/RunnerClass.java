package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/runners/TestRunner.java",
        glue = "E2EStepDefs",
        monochrome = true
)
public class RunnerClass extends AbstractTestNGCucumberTests {}

