package PageObjects.Naukri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;

public class NaukriLogin {
    private WebDriver driver;
    public NaukriLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "login_layer")
    public WebElement loginBtn;

    @FindBy(id="usernameField")
    public WebElement userName;

    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement login;

}
