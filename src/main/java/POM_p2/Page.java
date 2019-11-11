package POM_p2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    private WebDriver driver;
    private String url;


    public Page(WebDriver driver, String url){
        this.driver=driver;
        this.url=url;
        openPage();
    }
    public void openPage(){
        this.driver.get(url);
    }

    public Page  enterValue(By elem, String value){
        this.driver.findElement(elem).clear();
        this.driver.findElement(elem).sendKeys(value);
        return this;
    }

    public Page clickButton(By btn){
        this.driver.findElement(btn).click();
        return this;
    }

}
