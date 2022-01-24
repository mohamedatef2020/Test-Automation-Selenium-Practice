package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    /************** Test Data ***************/
    String url = "https://www.google.com/ncr";


    /************** Locators ***************/
    private By googleLogo = By.xpath("//img[@alt='Google']");
    private By searchBox = By.name("q");


    /************** Actions ***************/
    public HomePage visit(){
        driver.navigate().to(url);

        return this;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean isLogoDisplayed(){
        return driver.findElement(googleLogo).isDisplayed();
    }

    public ResultsPage searchForQuery(String searchWord) {
        driver.findElement(searchBox).sendKeys(searchWord + Keys.ENTER);
        return new ResultsPage(driver);
    }
}
