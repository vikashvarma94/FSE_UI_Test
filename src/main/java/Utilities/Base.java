package Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;


public class Base extends Browser{

    public static WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger(Base.class);


    @Before
    public void setup() throws InterruptedException, IOException {
        log.info("Browser initiated");
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
