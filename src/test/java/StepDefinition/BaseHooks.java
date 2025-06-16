package StepDefinition;


import PageObjects.CommonPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;


public class BaseHooks {
    public static WebDriver driver;

    public static ExtentReports report;
    public static ExtentTest test;

    CommonPage commonPage = new CommonPage(driver);

    //Logs
    private static final Logger log = LogManager.getLogger(BaseHooks.class);

    @Before()
    public void setup(Scenario scenario) throws IOException {

        log.info("***** Browser initiated *****");
        //Get driver
        driver = commonPage.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @AfterStep()
    public void attachScreenShot(Scenario scenario){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] scr = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(scr, "image/png", scenario.getName());
    }

    @After()
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                log.info("***** Scenario failed ******");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] scr = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(scr, "image/png", scenario.getName());
            } else {
                log.info("***** Scenario Passed ******");
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        } finally {
            //quit driver
            if (driver != null) {
                driver.quit();
            }
        }
    }
}


