package base;

import com.codeborne.selenide.Selenide;
import common.CommonSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected CommonSteps commonSteps;

    protected BaseTest() {
        commonSteps = new CommonSteps();
    }

    @BeforeMethod
    public void openAuthPage() {
        Selenide.open("https://www.saucedemo.com/");
    }

    @BeforeSuite
    public void beforeSuite() {
        BaseConfig.setup();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (Selenide.webdriver().driver().hasWebDriverStarted()) {
            Selenide.webdriver().driver().getWebDriver().quit();
        }
    }
}
