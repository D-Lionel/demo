package com.shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.CartPageObject;
import pageobjects.HomePageObject;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Scenario1 {

    public HomePageObject HomePage;
    public CartPageObject CartPage;
    public WebDriver driver;
    
    @Test
    public void Test1() throws InterruptedException{
        //iAccessShopizer
        HomePage = PageFactory.initElements(driver,HomePageObject.class);
        HomePage.initializing();
        //iQuickAddToCart
        HomePage.quickAddToCart.click();
        //CartPayment
        HomePage.cartPayment();
        //Check Cart Items
        CartPage = PageFactory.initElements(driver,CartPageObject.class);
        assertTrue("Cart table is present", CartPage.cartTable.isDisplayed());
        assertTrue("Item name is good", CartPage.articleTable.getText().contains("Compact night table"));
        //Double Items
        CartPage.doubleItems();

    }

    



    public void iDoubleItems(){
        
    }

    public void iRecalculate(){
        
    }

    public void iPay(){
        
    }

    
}
