package my.company;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.step;

/**
 * @author baev (Dmitry Baev)
 */
public class SimpleTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void takeScreenshotOfBrowserStack() {
        driver.get("https://browserstack.com");
        step("step 1");
        step("step 2");
        Allure.addAttachment("bsTest", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test
    public void takeScreenshotOfAmazon() {
        driver.get("https://amazon.co.uk");
        step("step 1");
        step("step 2");
        Allure.addAttachment("amazonTest", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

