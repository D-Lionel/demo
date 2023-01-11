package com.shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import pageobjects.CartPageObject;
import pageobjects.HomePageObject;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;

public class Scenario1 {

    public HomePageObject HomePage;
    public CartPageObject CartPage;
    public WebDriver driver;
    
    @Before
    public void initializing(){
        
        int myWebDriver = 1;

        switch(myWebDriver){
   
            case 1: 
                System.setProperty("webdriver.chrome.driver", "src/main/java/com/shopizer/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        
            case 2:
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
                System.setProperty("webdriver.gecko.driver", "src/main/java/com/shopizer/drivers/geckodriver.exe");
                driver = new FirefoxDriver(options);
                break;

            default:
                System.setProperty("webdriver.chrome.driver", "src/main/java/com/shopizer/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("http://192.168.102.40:8099/shop");
    }

    @Test
    public void Test1() throws InterruptedException{
        //iQuickAddToCart
        HomePage = PageFactory.initElements(driver,HomePageObject.class);
        HomePage.quickAddToCart.click();
        //CartPayment
        HomePage.cartPayment1(driver);
        //Check Cart Items
        CartPage = PageFactory.initElements(driver,CartPageObject.class);
        assertTrue("Cart table is present", CartPage.cartTable.isDisplayed());
        assertTrue("Item name is good", CartPage.articleTable.getText().contains("Compact night table"));
        //Double Items
        CartPage.doubleItems();
        //Recalculate
        CartPage.clickRecalculate();
        //assertTrue("Total changed", CartPage.tableTotal.getText().contains("259.98"));
        //Payment
        Thread.sleep(1000);
        CartPage.finalPayment.click();
    }

    
}
