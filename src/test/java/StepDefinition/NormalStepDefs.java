package StepDefinition;

import PageObjects.HomePage;
import PageObjects.UserPage;
import Utilities.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class NormalStepDefs extends Browser {

    private static WebDriver driver;
    HomePage homePage;
    UserPage userPage;

    @Given("Launch application")
    public void launchApplication() {
    }

    @Then("Verify home page {string}")
    public void verifyHomePage(String header) {
        driver.getPageSource().equals(header);
    }
}
