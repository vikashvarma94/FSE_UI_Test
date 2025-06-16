package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;

public class Browser extends LoadProps {

    private static WebDriver driver;

    public void setDriver(String browser) {
        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                new IllegalArgumentException("No browser");
                break;
        }
    }

    /*Get browser details from env.properties file*/
    public WebDriver getDriver() throws IOException {
        if (driver == null) {
            setDriver(loadProps().getProperty("browser"));
        }
        return driver;
    }


}

