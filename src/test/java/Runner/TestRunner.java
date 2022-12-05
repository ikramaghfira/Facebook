package Runner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        tags ="@regression",
        features = {"classpath:features"},
        glue = {"classpath:StepDef"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}
