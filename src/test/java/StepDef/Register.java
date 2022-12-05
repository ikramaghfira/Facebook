package StepDef;

import Page.Registration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.DriverUtils.driver;

public class Register {

    private Registration regis = new Registration(driver);
    @Given("user is on Facebook Registration page")
    public void userIsOnFacebookRegistrationPage() {
        regis
                .verifyOnTheFBRegistrationPage();
    }

    @When("user fill all fields with valid credential")
    public void userFillAllFieldsWithValidCredential() {
        regis
                .inputName("Ikramah", "Maghfirah")
                .inputPhoneOrEmail("ikramah.maghfirah28@gmail.com")
                .inputPassword("aaaaa123")
                .setBirthday("10", "12", "1997")
                .setGender("female")
                .signUp();
    }

    @Then("user should be navigated to input OTP code")
    public void userShouldBeNavigatedToInputOTPCode() {
        regis.verifyRegisterSucceed();
    }
}
