package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoadProps {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH_mm_ss");
    public static LocalDateTime now = LocalDateTime.now();


    /*Load properties from env file*/
    public Properties loadProps() throws IOException {
        FileInputStream input = new FileInputStream("src\\main\\resources\\env.properties");
        Properties props = new Properties();
        props.load(input);
        return props;
    }

    public String getScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "//Screnshots/" + dtf.format(now) + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }
}
