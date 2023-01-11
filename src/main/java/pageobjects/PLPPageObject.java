package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLPPageObject {
    
    public WebDriver driver;
    
    @FindBy(xpath = "//h3[@itemprop='name']")
    public List<WebElement> itemTitleList;

    @FindBy(xpath = "//div[@class='thumbnail product-img']")
    public List<WebElement> itemThumbnailList;
    
    public int printList(List<WebElement> list){
        int itemsCount = 0;
        for(WebElement e : list) {
            System.out.println(e.getText());
            itemsCount++;
          }
          return itemsCount;
    }
    
    


}
