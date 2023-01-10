package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {
    
    public WebDriver driver;
    
    @FindBy(xpath = "(//a[@class='addToCart'])[1]")
    public WebElement quickAddToCart;

    @FindBy(xpath = "//div[@class='shop-cart']")
    public WebElement cart;

    @FindBy(xpath = "//a[@onclick='viewShoppingCartPage();']")
    public WebElement cartPayment;

    public void initializing(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/shopizer/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("http://192.168.102.40:8080/shop");
    }

    public void cartPayment() throws InterruptedException{
        Actions action = new Actions(driver);
        action.moveToElement(cart).perform();
        Thread.sleep(2000);
        cartPayment.click();
    }

}
