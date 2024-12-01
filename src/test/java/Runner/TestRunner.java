package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/Resources/Features",
        glue = {"StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        tags = "@NormalTest",
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
