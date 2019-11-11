package POM_p2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.jws.WebMethod;

public class BaseTest extends CreateDriver {
    private WebDriver driver;
    private MainPage mainpage;
    private SearchPage searchPage;
    private String searchPageURL, cardURL;
    private ShoppingCardSummaryPage cardPage;
    private String productToSearch = "blouse";
    private String searchurl= "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query="+productToSearch.toLowerCase()+"&submit_search=";



    @BeforeClass
    public void newDriver() {
        this.driver = runDriver();
        mainpage = new MainPage(driver);
    }

    @Test(priority = 1)
    public void productSearch() {
        mainpage.enterValue(mainpage.getSearchField(), "Blouse")
                .clickButton(mainpage.getSearchBTN());
        searchPageURL = driver.getCurrentUrl();
        Assert.assertNotEquals(mainpage.getURL(), searchPageURL, "Find Blouse");
    }


    @Test(priority = 2)
    public void addToCardProduct() {
        addToCard();
        System.out.println(searchurl+"      "+  driver.getCurrentUrl());
            Assert.assertNotEquals(searchurl, driver.getCurrentUrl());
       deleteProduct();
    }



    @Test(priority = 3)
    public void checkCardProductTotal() {
        checkCard();
        Assert.assertTrue(cardPage.getProductTotalText().equals("$54.00"), "ProductTotal ok " + cardPage.getProductTotalText());
        deleteProduct();
    }
    @Test(priority = 3)
    public void checkCardTotalProduct() {
        checkCard();
        Assert.assertEquals(cardPage.getTotalProductsText(),"$54.00", "total product ok");
        deleteProduct();
    }
    @Test(priority = 3)
    public void checkCardTotalShipping() {
        checkCard();
        Assert.assertEquals(cardPage.getTotalShippingText(),"$2.00","TotalShipping ok" );
        deleteProduct();
    }
    @Test(priority = 3)
    public void checkCardTotalAll() {
        checkCard();
        Assert.assertEquals(cardPage.getTotalAllText(),"$56.00", "TotalAll ok");
        deleteProduct();
    }
    @Test(priority = 3)
    public void checkCardTAX() {
        checkCard();
        Assert.assertEquals(cardPage.getTAXText(),"$0.00", "tax ok");
        deleteProduct();
    }
    @Test(priority = 3)
    public void checkCardTotalCommon() {
        checkCard();
        Assert.assertEquals(cardPage.getTotalCommonText(),"$56.00", "total common ok");
        deleteProduct();
    }


    @Test(priority = 4)
    public void deleteProductCheck() {
        checkCard();
        deleteProduct();
        Assert.assertTrue(driver.findElement(cardPage.getEmptyCardMsg()).isDisplayed());
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }



    public void addToCard() {
        searchPage = new SearchPage(driver, searchurl);
        //searchPage = new SearchPage(driver, searchPageURL);
        searchPage.clickButton(searchPage.getBtnList())
                .clickButton(searchPage.getBtnAddToCard());
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(searchPage.getProductAddtocardWindow())));
        searchPage.clickButton(searchPage.getBtnCheckOut());
        cardURL = driver.getCurrentUrl();
        Boolean dynamicElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@name='quantity_2_7_0_0']"), "1"));

    }


    public void checkCard() {
        addToCard();
        cardPage = new ShoppingCardSummaryPage(driver, cardURL);
        cardPage.clickButton(cardPage.getAddBtn());
        Boolean dynamicElement1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@name='quantity_2_7_0_0']"), "2"));
        cardPage.productTotal(driver);
    }


    public void deleteProduct() {
        if ( cardPage==null){cardPage = new ShoppingCardSummaryPage(driver, cardURL);}
        WebElement errmsg1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(cardPage.getDeleteBtn()));
        cardPage.clickButton(cardPage.getDeleteBtn());
        WebElement errmsg = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(cardPage.getEmptyCardMsg()));

    }
}
