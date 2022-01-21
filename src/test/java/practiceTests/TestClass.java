package practiceTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/ncr");
    }

    @AfterMethod
    public void afterMethod(){
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
    public void assertPageTitleIsCorrect(){
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    /**
    ________________ Task #2 - Difficulty: Basic ________________
    Open Google Chrome
    Navigate to [https://www.google.com/ncr]
    Assert that the Google logo is displayed
    Close Google Chrome
    **/
    @Test
    public void assertLogoIsDisplayed(){
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed());
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
    public void assertFirstSearchResultContent(){
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver" + Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//a/h3)[1]")).getText(), "Selenium - Web Browser Automation");
    }

}
