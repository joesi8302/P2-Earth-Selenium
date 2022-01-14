package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/forgotpassword.feature",
        glue = "stepdefinitions",
        dryRun = false
)
public class CucumberTestRunner {

}
