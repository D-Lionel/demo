package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageObject {
    
    @FindBy(xpath = "//table[@id='mainCartTable']")
    public WebElement cartTable;

    @FindBy(xpath = "(//table[@id='mainCartTable']//strong)[1]")
    public WebElement articleTable;

    @FindBy(xpath = "//input[@class='input-small quantity text-center']")
    public WebElement quantityTable;

    @FindBy(xpath = "//a[contains(@onclick,'updateCart')]")
    public WebElement updateCart;

    @FindBy(xpath = "//td[@data-th='Total']//strong")
    public WebElement tableTotal;

    @FindBy(xpath = "//a[@href='/shop/order/checkout.html']")
    public WebElement finalPayment;

    public void doubleItems(){
        quantityTable.clear();
        quantityTable.sendKeys("2");
    }

    public void clickRecalculate(){
        updateCart.click();
    }

}
