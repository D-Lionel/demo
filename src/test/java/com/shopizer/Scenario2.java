package com.shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.CartPageObject;
import pageobjects.HomePageObject;
import pageobjects.PLPPageObject;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class Scenario2 {

    public HomePageObject HomePage;
    public CartPageObject CartPage;
    public PLPPageObject PLPPage;
    public WebDriver driver;
    String category;
    
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
        PLPPage = PageFactory.initElements(driver,PLPPageObject.class);
        //Faire une liste des miniature, titre, prix, promo, et comparer la longueur des ses listes
        int verifier = 0;
        int itemTitleCount = 0;
        int itemThumbnailCount = 0;
        int itemOldPriceCount = 0;
        int itemNewPriceCount = 0;
        int itemAddToCartCount = 0;
        itemTitleCount = PLPPage.printList(PLPPage.itemTitleList);
        System.out.println(itemTitleCount);
        itemThumbnailCount = PLPPage.printList(PLPPage.itemThumbnailList);
        System.out.println(itemThumbnailCount);
        itemOldPriceCount = PLPPage.printList(PLPPage.itemOldPriceList);
        System.out.println(itemOldPriceCount);
        itemNewPriceCount = PLPPage.printList(PLPPage.itemNewPriceList);
        System.out.println(itemNewPriceCount);
        itemAddToCartCount = PLPPage.printList(PLPPage.addToCartList);
        System.out.println(itemAddToCartCount);
        verifier = itemThumbnailCount;
        assertTrue("All item elements are equally present", itemTitleCount == verifier && itemThumbnailCount == verifier && itemAddToCartCount == verifier && itemOldPriceCount == verifier && itemNewPriceCount == verifier );
        //Click tables
        HomePage.tablesCat.click();
        //Click filters
        HomePage.asianWoodFilter.click();
        try(InputStream input = new FileInputStream("src/test/resources/config.properties")){
            Properties prop = new Properties();
            prop.load(input);            
            category = prop.getProperty("filter.category.asian");
            System.out.println("cat : "+category);
            assertTrue("The items of the category "+category+" are displayed", PLPPage.checkTitle(category, PLPPage.itemTitleList));
    
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Click product
        PLPPage.itemTitleList.get(0).click();
    }

    
}
