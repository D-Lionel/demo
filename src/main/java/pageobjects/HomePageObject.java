package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    
    public WebDriver driver;
    
    @FindBy(xpath = "(//a[@class='addToCart'])[1]")
    public WebElement quickAddToCart;

    @FindBy(xpath = "//div[@class='shop-cart']")
    public WebElement cart;

    @FindBy(xpath = "//a[@onclick='viewShoppingCartPage();']")
    public WebElement cartPayment;

    @FindBy(xpath = "(//a[contains(text(),'Bedroom')])[1]")
    public WebElement bedroomCat;

    @FindBy(xpath = "(//a[contains(text(),'Night Tables')])[1]")
    public WebElement nightTablesCat;


    public HomePageObject clickQuickAddToCart(WebDriver driver){
        quickAddToCart.click();
        return PageFactory.initElements(driver, HomePageObject.class);
    }

    public void cartPayment1(WebDriver driver) throws InterruptedException{
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(1000);
        cartPayment.click();
    }

    public void clickNightTables(WebDriver driver) throws InterruptedException{
        Actions action = new Actions(driver);
        action.moveToElement(bedroomCat).perform();
        Thread.sleep(1000);
        nightTablesCat.click();
    }

}
