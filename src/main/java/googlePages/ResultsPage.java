package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
    WebDriver driver;
    public ResultsPage(WebDriver driver){
        this.driver = driver;
    }

    /************** Locators ***************/
    private By firstSearchResult = By.xpath("(//a/h3)[1]");


    /************** Actions ***************/
    public String getFirstResultText(){
        return driver.findElement(firstSearchResult).getText();
    }
}
