package StepDef;

import Utils.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
    @Before
    public void initiateBrowser() {
        DriverUtils.getDriver();
    }
//    @After
//    public void closeBrowser(){
//        DriverUtils.tearDown();
//    }
}
