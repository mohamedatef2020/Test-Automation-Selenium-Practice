package googleTests;

import googlePages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
    private WebDriver driver;
    private googlePages.HomePage HomePage;

    @BeforeClass
    private void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    private void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    private void afterMethod(){
        driver.quit();
    }
    /**
     ________________ Task #1 - Difficulty: Basic ________________
     Open Google Chrome
     Navigate to [https://www.google.com/ncr]
     Assert that the page title is [Google]
     Close Google Chrome
     **/
    @Test
    private void assertPageTitleIsCorrect(){
        var currentPageTitle = new HomePage(driver)
                .visit()
                .getTitle();

        Assert.assertEquals(currentPageTitle, "Google");
    }

    /**
    ________________ Task #2 - Difficulty: Basic ________________
    Open Google Chrome
    Navigate to [https://www.google.com/ncr]
    Assert that the Google logo is displayed
    Close Google Chrome
    **/
    @Test
    private void assertLogoIsDisplayed(){
        var isLogoDisplayed = new HomePage(driver)
                .visit()
                .isLogoDisplayed();

        Assert.assertTrue(isLogoDisplayed);
    }

    /**
     ________________ Task #3 - Difficulty: Basic ________________
     Open Google Chrome
     Navigate to [https://www.google.com/ncr]
     Search for [Selenium WebDriver]
     Assert that the text of the first result is [Selenium - Web Browser Automation]
     Close Google Chrome
     **/
    @Test
    private void assertFirstSearchResultContent(){
    var firstResultText = new HomePage(driver)
            .visit()
            .searchForQuery("Selenium - Web Browser Automation")
            .getFirstResultText();

    Assert.assertEquals(firstResultText, "Selenium - Web Browser Automation");
    }

}
