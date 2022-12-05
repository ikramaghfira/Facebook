package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.DriverUtils.driver;
public class WebelementUtils {
    public WebDriverWait wait;

    public WebelementUtils(WebDriver driver){
        driver = DriverUtils.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    protected WebelementUtils waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }
    protected WebelementUtils waitVisibilityElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    protected WebelementUtils clickElement(WebElement element){
        waitToBeClickable(element);
        element.click();
        return this;
    }
    protected WebelementUtils writeText(WebElement element, String text){
        waitVisibilityElement(element);
        element.sendKeys(text);
        return this;
    }
    protected String readText(WebElement element) {
        waitVisibilityElement(element);
        return element.getText();
    }

}
