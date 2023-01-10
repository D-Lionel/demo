package com.shopizer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.HomePageObject;

import org.junit.Test;

public class Scenario2 {
    public HomePageObject HomePage;
    
    
    @Test
    public void iAccessShopizer(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/shopizer/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.102.40:8080/shop");
    }

    public void iHoverBedroom(){
        
    }

    public void iClickNightTables(){
        
    }

    public void iCheckElements(){
        
    }

    public void iClickOnTables(){
        
    }

    public void iSelectFilter(){
        
    }

    public void iSelectFirstArticle(){
        
    }

    public void iCheckElements2(){
        
    }

    
    

    
}
