package POM_p2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CreateDriver {
    private WebDriver driver;

 //   @BeforeTest
    public WebDriver runDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ирен\\IdeaProjects\\l_SelDriver\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;

    }

}
