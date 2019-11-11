package POM_p2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchPage extends Page {
    private  String URL ;
    private static By PRODUCT_LIST_LIST = By.xpath("//*[@title='List']");
    private static By PRODUCT_LIST_ADDTOCARD = By.xpath("//*[@class='product_list row list']/li[1]//*[@title='Add to cart']");
    private static By PRODUCT_ADDTOCARD_WINDOW = By.xpath("//*[@id=\"layer_cart\"]/div[1]");
    private static By PRODUCT_BTN_CHECKOUT = By.xpath("//*[@id='layer_cart']//a[@title='Proceed to checkout']");
    private WebDriver driver;

    public SearchPage(WebDriver driver, String url){
        super(driver, url);
        this.driver=driver;

    }

    public void setURL(String url){
        this.URL=url;
    }

    public String getUrl(String product){
        return "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query="+product.toLowerCase()+"&submit_search=";
    }

    public By getBtnList(){
        return PRODUCT_LIST_LIST;
    }

    public By getBtnAddToCard(){
        return PRODUCT_LIST_ADDTOCARD;
    }
    public By getBtnCheckOut(){
        return PRODUCT_BTN_CHECKOUT;
    }
    public By getProductAddtocardWindow(){
        return PRODUCT_ADDTOCARD_WINDOW;
    }

}
