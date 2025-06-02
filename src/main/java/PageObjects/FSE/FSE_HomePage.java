package PageObjects.FSE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FSE_HomePage {
    WebDriver driver;
    public FSE_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"navbar-brand\"]")
    public WebElement header;

    public WebElement getWebElement(WebElement element) {
        return element;
    }

    private By tableColumn = By.xpath("//thead/tr/th");
    private By links = By.tagName("a");
    private By addUser = By.xpath("//a[text()='Add User']");
    private By edit = By.xpath("//thead/tr/th");
    private By delete = By.xpath("//thead/tr/th");


    public List<WebElement> allLinks() {
        return driver.findElements(links);
    }

    public List<WebElement> tableColumns() {
        return driver.findElements(tableColumn);
    }

    public WebElement addUser() {
        return driver.findElement(addUser);
    }

    public WebElement view(String name) {
        return driver.findElement(By.xpath("//td[text()='" + name + "']/following::a[text()='View']"));
    }

    public WebElement edit(String name) {
        return driver.findElement(By.xpath("//td[text()='" + name + "']/following::a[text()='Edit']"));
    }

    public WebElement delete(String name) {
        return driver.findElement(By.xpath("//td[text()='" + name + "']/following::button[text()='Delete']"));
    }

    public WebElement selectUserByName(String name) {
        return driver.findElement(By.xpath("//td[text()='" + name + "']"));
    }


}
