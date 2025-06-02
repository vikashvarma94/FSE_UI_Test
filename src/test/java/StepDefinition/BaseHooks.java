package StepDefinition;


import PageObjects.CommonPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaseHooks {
    public static WebDriver driver;
    public static Logger log;

    public static ExtentReports report;
    public static ExtentTest test;
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY_MM_dd_HH_mm");
    public static LocalDateTime now = LocalDateTime.now();

    CommonPage commonPage = new CommonPage(driver);

    @Before()
    public void setup() throws IOException {
        //Logs
        log = (Logger) LogManager.getLogger(BaseHooks.class);
        log.info("***** Browser initiated *****");
        //Get driver
        driver = commonPage.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        //Extent report
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + dtf.format(now) + ".html");
        System.out.println(System.getProperty("user.dir") + "//Reports/"+dtf.format(now)+".html");
        report = new ExtentReports();
        report.attachReporter(reporter);
    }


    @After()
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            log.info("***** Scenario failed ******");
            String temp = commonPage.getScreenshot(driver);
            test.fail(String.valueOf(scenario.getStatus()), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        } else {
            log.info("***** Scenario Passed ******");
            String temp = commonPage.getScreenshot(driver);
            test.pass("pass", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        report.flush();

        //quit driver
        if (driver != null) {
            driver.quit();
        }
    }

}


