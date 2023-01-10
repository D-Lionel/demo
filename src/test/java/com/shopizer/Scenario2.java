package com.shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.CartPageObject;
import pageobjects.HomePageObject;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;

public class Scenario2 {

    public HomePageObject HomePage;
    public CartPageObject CartPage;
    public WebDriver driver;
    
    @Before
    public void initializing(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/shopizer/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("http://192.168.102.40:8080/shop");
    }

    @Test
    public void Test2() throws InterruptedException{
        //iQuickAddToCart
        HomePage = PageFactory.initElements(driver,HomePageObject.class);
        HomePage.clickNightTables(driver);
        CartPage = PageFactory.initElements(driver,CartPageObject.class);
        
    }

    
}
