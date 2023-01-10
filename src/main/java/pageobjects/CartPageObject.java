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

    public void doubleItems(){
        quantityTable.clear();
        quantityTable.sendKeys("2");
    }

}
