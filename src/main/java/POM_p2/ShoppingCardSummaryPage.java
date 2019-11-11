package POM_p2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCardSummaryPage extends Page {
    private static String URL = "http://automationpractice.com/index.php?controller=order";
    private static By PRODUCT_TOTAL = By.xpath("//*[@class='cart_total'][1]//*[@class='price']");
    private static By TOTAL_PRODUCTS = By.xpath("//*[@id='total_product'][1]");
    private static By TOTAL_SHIPPING = By.xpath("//*[@id='total_shipping'][1]");
    private static By TOTAL_ALL = By.xpath("//*[@id='total_price_without_tax'][1]");
    private static By TAX = By.xpath("//*[@id='total_tax'][1]");
    private static By TOTAL_COMMON = By.xpath("//*[@id='total_price'][1]");
    private static By ADD_BTN = By.xpath("//*[@id='cart_quantity_up_2_7_0_0'][1]");
    private static By DELETE_BTN = By.xpath("//*[@id='2_7_0_0'][1]");
    private static By EMPTY_CARD_MSG = By.xpath("//*[@class='alert alert-warning'][1]");
    private WebDriver driver;
    private String productTotal, totalProducts,
            totalShipping, total_all, tax, total_common;

    public ShoppingCardSummaryPage(WebDriver driver, String url){
        super(driver,url);
        this.driver = driver;
    }

    public void productTotal(WebDriver driver){
        productTotal = driver.findElement(PRODUCT_TOTAL).getText();
        totalProducts = driver.findElement(TOTAL_PRODUCTS).getText();
        totalShipping = driver.findElement(TOTAL_SHIPPING).getText();
        total_all = driver.findElement(TOTAL_ALL).getText();
        tax = driver.findElement(TAX).getText();
        total_common = driver.findElement(TOTAL_COMMON).getText();
    }

    public By getProductTotal(){
        return PRODUCT_TOTAL;
    }
    public By getTotalProducts(){
        return TOTAL_PRODUCTS;
    }
    public By getTotalShipping(){
        return TOTAL_SHIPPING;
    }
    public By getTotalAll(){
        return TOTAL_ALL;
    }
    public By getTAX(){
        return TAX;
    }
    public By getTotalCommon(){
        return TOTAL_COMMON;
    }
    public By getAddBtn(){
        return ADD_BTN;
    }
    public By getDeleteBtn(){
        return DELETE_BTN;
    }
    public By getEmptyCardMsg(){
        return EMPTY_CARD_MSG;
    }

    public String getProductTotalText(){
        return productTotal;
    }
    public String getTotalProductsText(){
        return totalProducts;
    }
    public String getTotalShippingText(){
        return totalShipping;
    }
    public String getTotalAllText(){
        return total_all;
    }
    public String getTAXText(){
        return tax;
    }
    public String getTotalCommonText(){
        return total_common;
    }

}
