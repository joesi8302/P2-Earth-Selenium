package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/register.feature",
        glue = "stepdefinitions",
        dryRun = true
)
public class CucumberTestRunner {

}