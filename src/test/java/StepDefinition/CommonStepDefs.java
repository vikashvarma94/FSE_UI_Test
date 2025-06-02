package StepDefinition;

import PageObjects.CommonPage;
import Utilities.Browser;
import Utilities.LoadProps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import static StepDefinition.BaseHooks.driver;
import static StepDefinition.BaseHooks.report;

public class CommonStepDefs {
ExtentTest test;
    CommonPage commonPage = new CommonPage(driver);

    @Given("Launch application {string}")
    public void launchApplication(String projectURL) throws IOException {
        test = report.createTest("Login Test");
        test.log(Status.INFO, "Navigating to the login page");
        driver.get(commonPage.loadProps().getProperty(projectURL));
    }

    @When("User lands on home page {string}")
    public void userLandsOnHomePage(String title) {
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @When("Input Value {string} to the field {string} on {string}")
    public void inputValueToTheFieldOnPage(String value, String fieldName, String page) throws NoSuchFieldException, IllegalAccessException {
        commonPage.inputValue(page, fieldName, value);
    }

    @When("clicks on Button_Link {string} on {string}")
    public void clicksOnButtonOnPage(String page, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        commonPage.clickButton(page, fieldName);
    }

    @When("Verify expected text {string} from {string} on {string}")
    public void verifyExpectedTextFromOn(String exptext, String fieldName, String page) throws NoSuchFieldException, IllegalAccessException {
        String actualText = commonPage.getActualText(page, fieldName);
        Assert.assertEquals(actualText, exptext);
    }
}
