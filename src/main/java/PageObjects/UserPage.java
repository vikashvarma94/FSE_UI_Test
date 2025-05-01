package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage {

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    private By name = By.xpath("//input[@name=\"name\"]");
    private By username = By.xpath("//input[@name=\"username\"]");
    private By email = By.xpath("//input[@name=\"email\"]");
    private By submit = By.xpath("//button[@type=\"submit\"]");

    public WebElement name() {
        return driver.findElement(name);
    }

    public WebElement username() {
        return driver.findElement(username);
    }

    public WebElement email() {
        return driver.findElement(email);
    }

    public WebElement submit() {
        return driver.findElement(submit);
    }

    //User details page
    public WebElement elementByText(String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
    }

}
