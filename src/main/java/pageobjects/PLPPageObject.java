package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLPPageObject {
    
    public WebDriver driver;
    
    @FindBy(xpath = "//div[@id='productsContainer']//h3[@itemprop='name']")
    public List<WebElement> itemTitleList;

    @FindBy(xpath = "//div[@id='productsContainer']//div[@class='thumbnail product-img']")
    public List<WebElement> itemThumbnailList;

    @FindBy(xpath = "//div[@id='productsContainer']//del")
    public List<WebElement> itemOldPriceList;

    @FindBy(xpath = "//div[@id='productsContainer']//span[@itemprop='price']")
    public List<WebElement> itemNewPriceList;

    @FindBy(xpath = "//div[@id='productsContainer']//a[@class='addToCart']")
    public List<WebElement> addToCartList;

    public int printList(List<WebElement> list){
        int itemsCount = 0;
        for(WebElement e : list) {
            System.out.println(e.getText());
            itemsCount++;
          }
          return itemsCount;
    }
    
    public boolean checkTitle(String title, List<WebElement> list){
        for(WebElement e : list) {
            if(!e.getText().contains(title)){
                return false;
            }
          }
        return true;
    }
    


}
