package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Browser {

    private static WebDriver driver;

    public void setDriver(String browser) {
        switch (browser) {
            case "Chrome":
                driver= new ChromeDriver();
                break;
            case "Edge":
                driver= new EdgeDriver();
                break;
            default:
                new IllegalArgumentException("No browser");
                break;
        }
    }

    /*Get browser details from env.properties file*/
    public WebDriver getDriver() throws IOException {
        setDriver(loadProps().getProperty("browser"));
        return driver;
    }

    /*Load properties from env file*/
    public Properties loadProps() throws IOException {
        FileInputStream input = new FileInputStream("src\\env.properties");
        Properties props = new Properties();
        props.load(input);
        return props;
    }
}

