package StepDefinition;

import PageObjects.HomePage;
import PageObjects.UserPage;
import Utilities.Base;
import Utilities.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CommonStepDefs extends Base {

    private static WebDriver driver;

    @Given("Launch application {string}")
    public void launchApplication(String projectURL) throws IOException {
        driver.get(loadProps().getProperty(projectURL));
    }

    @When("User lands on home page {string}")
    public void userLandsOnHomePage(String title) {
        Assert.assertTrue(driver.getTitle().contains(title));
        System.out.println(driver.getCurrentUrl());
    }


    @When("Input Value {string} to the field {string}")
    public void inputValueToTheField(String value, WebElement field) {
        if(field.equals(null)){
            log.info("provide WebElement");
        }//else{getElement()}
        field.sendKeys(value);
    }

    @When("clicks on Button_Link {string}")
    public void clicksOnButton_Link(WebElement btn) {
        btn.click();
    }
}
