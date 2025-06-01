package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public Object getPageObject(String className) {
        Object obj = null;
        switch (className) {
            case "HomePage":
                obj = new HomePage(driver);
                break;
            case "UserPage":
                obj = new UserPage(driver);
                break;
            case "NaukriLogin":
                obj = new NaukriLogin(driver);
                break;
            default:
                new IllegalArgumentException("No page");
                break;
        }
        return obj;
    }

    public WebElement getWebElement(String page, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Object pageObject = getPageObject(page);
        Field field = pageObject.getClass().getField(fieldName);
        WebElement webElement = (WebElement) field.get(pageObject);

        return webElement;
    }

    public void inputValue(String page, String fieldName, String value) throws NoSuchFieldException, IllegalAccessException {
        try {
            getWebElement(page, fieldName).sendKeys(value);
        } catch (Exception e) {
            System.out.println("Exception message" + e);
        }
    }

    public void clickButton(String page, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        try {
            getWebElement(page, fieldName).click();
        } catch (Exception e) {
            System.out.println("Exception message" + e);
        }
    }
}
