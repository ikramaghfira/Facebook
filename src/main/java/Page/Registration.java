package Page;

import Utils.WebelementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration extends WebelementUtils {
    public Registration(WebDriver driver) {
        super(driver);
    }

    /*
    BUTTON ELEMENT
     */
    @FindBy(id = "day")
    private WebElement buttonDay;
    @FindBy(id = "month")
    private WebElement buttonMonth;
    @FindBy(id = "year")
    private WebElement buttonYear;
    @FindBy(xpath="(//input[@name='sex'])[1]")
    private WebElement buttonFemale;
    @FindBy(id="(//input[@name='sex'])[2]")
    private WebElement buttonMale;
    @FindBy(id="(//input[@name='sex'])[3]")
    private WebElement buttonCustom;
    @FindBy(name = "websubmit")
    private WebElement signUpButton;


    /*
    INPUT ELEMENT
     */
    @FindBy(name = "firstname")
    private WebElement inputFirstName;
    @FindBy(name = "lastname")
    private WebElement inputLastName;
    @FindBy(name = "reg_email__")
    private WebElement inputEmailOrPhone;
    @FindBy(name = "reg_passwd__")
    private WebElement inputPassword;
    @FindBy(name = "reg_email_confirmation__")
    private WebElement reenterEmail;

    /*
    NON INTERACTIVE ELEMENT
     */
    @FindBy(id = "reg_error_inner")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@class='x1e56ztr x1xmf6yo']/span")
    private WebElement otpHeader;

    public Registration verifyOnTheFBRegistrationPage(){
        Assert.assertTrue(signUpButton.isEnabled());
        return this;
    }

    public Registration inputName(String firstName, String lastName){
        writeText(inputFirstName, firstName);
        writeText(inputLastName, lastName);
        return this;
    }

    public Registration inputPhoneOrEmail(String text){
        writeText(inputEmailOrPhone, text);
        waitVisibilityElement(reenterEmail);
        writeText(reenterEmail, text);
        return this;
    }

    public Registration inputPassword(String text){
        writeText(inputPassword, text);
        return this;
    }

    public Registration setBirthday(String day, String month1, String year1){
        Select date = new Select(buttonDay);
        Select month = new Select(buttonMonth);
        Select year = new Select(buttonYear);

        date.selectByValue(day);
        month.selectByValue(month1);
        year.selectByValue(year1);

        return this;
    }

    public Registration setGender(String gender){
        if(gender == "female"){
            clickElement(buttonFemale);
        } else if (gender == "male"){
            clickElement(buttonMale);
        } else {
            clickElement(buttonCustom);
        }
        return this;
    }

    public Registration signUp(){
        clickElement(signUpButton);
        return this;
    }

    public Registration verifyRegisterSucceed(){
        waitVisibilityElement(otpHeader);
        String expectedTitle = readText(otpHeader);
        Assert.assertEquals(expectedTitle, "We need more information");
        return this;
    }

}
