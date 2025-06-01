package StepDefinition;

import PageObjects.CommonPage;
import Utilities.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static StepDefinition.BaseHooks.driver;

public class CommonStepDefs {

    CommonPage commonPage = new CommonPage(driver);

    @Given("Launch application {string}")
    public void launchApplication(String projectURL) throws IOException {
        Browser browser = new Browser();
        driver.get(browser.loadProps().getProperty(projectURL));
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
}
