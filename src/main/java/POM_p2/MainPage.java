package POM_p2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends Page {
    private static String URL = "http://automationpractice.com/";
    private static By SEARCH_FIELD = By.id("search_query_top");
    private static By SEARCH_BTN = By.xpath("//*[@name='submit_search']");
    private WebDriver driver;



    public MainPage(WebDriver driver){
        super(driver,URL);
        this.driver=driver;
    }

    public String getURL(){
        return URL;
    }

    public By getSearchField(){
        return SEARCH_FIELD;
    }

    public By getSearchBTN(){
        return SEARCH_BTN;
    }


//    public void openPage(){
//        this.driver.navigate.to(url);
//    }
//
//    public Class enterValue(By elem, String value){
//        this.driver.findElement(elem).clear();
//        this.driver.findElement(elem).sendKeys(value);
//        return this;
//    }
//
//    public Class clickButton(By btn){
//        this.driver.findElement(btn).click();
//        return this;
//    }

}
