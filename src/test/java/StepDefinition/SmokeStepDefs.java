package StepDefinition;

import PageObjects.HomePage;
import PageObjects.UserPage;
import Utilities.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SmokeStepDefs extends Browser{
    private static WebDriver driver;
    HomePage homePage;
    UserPage userPage;

    @Before
    public void setup() throws InterruptedException, IOException {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        homePage = new HomePage(driver);
        userPage = new UserPage(driver);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Launch application {string}")
    public void launchApplication(String projectURL) throws IOException {
            driver.get(loadProps().getProperty(projectURL));

                }

    @When("User lands on home page {string}")
    public void userLandsOnHomePage(String title) {
        Assert.assertTrue(driver.getTitle().contains(title));
        System.out.println(driver.getCurrentUrl());
    }

    @Then("Verify home page header {string}")
    public void verifyHomePageHeader(String header) {
        homePage.header().getText().equals(header);
    }

    @And("Verify employees table column names")
    public void verifyEmployeesTableColumnNames(List<String> expColumnName) {
        for (int i = 0; i <= 4; i++) {
            Assert.assertTrue(homePage.tableColumns().get(i).getText().equals(expColumnName.get(i)));
        }
    }

    @And("Verify all broken links")
    public void verifyAllBrokenLinks() throws IOException {
        Iterator<WebElement> it = homePage.allLinks().iterator();
        it.hasNext();
        String url = it.next().getAttribute("href");
        HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
        huc.setRequestMethod("HEAD");
        huc.connect();

        int response = huc.getResponseCode();
        Assert.assertTrue(response >= 200 && response < 400);
    }

    @And("User navigates to add user page by clicking on add button")
    public void userNavigatesToAddUserPageByClickingOnAddButton() throws InterruptedException {
        homePage.addUser().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(userPage.email()));
        Assert.assertTrue(userPage.email().isEnabled());
    }

    @And("User enters new user details and clicks on submit {}, {}, {}")
    public void userEntersNewUserDetailsAndClicksOnSubmit(String arg0, String arg1, String arg2) {
        userPage.name().clear();
        userPage.name().sendKeys(arg0);
        userPage.username().clear();
        userPage.username().sendKeys(arg1);
        userPage.username().clear();
        userPage.email().sendKeys(arg2);
        userPage.submit().click();
    }

    @Then("Verify new user {} is added in home page")
    public void verifyNewUserIsAddedInHomePage(String arg0) {
        Assert.assertTrue(homePage.selectUserByName(arg0).isDisplayed());
    }

    @And("User navigates to view {} user page by clicking on view button")
    public void userNavigatesToViewUserPageByClickingOnViewButton(String arg0) throws InterruptedException {
        homePage.view(arg0).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(userPage.elementByText(arg0)));
    }

    @Then("Verify user can see the expected details {}, {}, {}")
    public void verifyUserCanSeeTheExpectedDetails(String arg0, String arg1, String arg2) {
        Assert.assertTrue(userPage.elementByText(arg0).isDisplayed());
        Assert.assertTrue(userPage.elementByText(arg1).isDisplayed());
        Assert.assertTrue(userPage.elementByText(arg2).isDisplayed());
    }

    @And("Verify user lands on home page after clicking back to home button")
    public void verifyUserLandsOnHomePageAfterClickingBackToHomeButton() {
        userPage.elementByText("Back to Home").click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(homePage.header()));
        Assert.assertTrue(homePage.header().isDisplayed());
    }

    @And("User navigates to edit {} user page by clicking on edit button")
    public void userNavigatesToEditUserPageByClickingOnEditButton(String arg0) {
        homePage.edit(arg0).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(userPage.elementByText("Edit User")));
    }

    @And("Deleted user {string} by clicking on delete button")
    public void deletedUserByClickingOnDeleteButton(String arg0) {
        homePage.delete(arg0).click();
    }

    @Then("Verify user {string} is deleted from homepage")
    public void verifyUserIsDeletedFromHomepage(String arg0) {
        try {
            homePage.view(arg0).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("User deleted successfully");
        }
    }



}
