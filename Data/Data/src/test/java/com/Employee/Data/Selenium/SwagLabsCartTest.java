package com.Employee.Data.Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

public class SwagLabsCartTest {
    WebDriver browser;

    @Before
    public void beforeEach(){
        var options = new ChromeOptions();
        options.addArguments("--safe-mode");
        options.addArguments("--incognito");
        //options.setCapability("webStockUrl",true);
        browser = new ChromeDriver(options);
    }


    @Test
    public void testCart() throws InterruptedException{
        var demoSwagland = new DemoSwaglabs(browser);
        demoSwagland.goTo();
        demoSwagland.enterName();
        demoSwagland.enterPassword();
        Thread.sleep(2000);
        demoSwagland.clickLogin();
        Thread.sleep(2000);
        boolean a = demoSwagland.isOnProductPage();

        demoSwagland.addBackpackToCart();
        Thread.sleep(2000);

        demoSwagland.clickCart();
        Thread.sleep(5000);
        String count = demoSwagland.getCartCount();
        assertEquals("1",count);

    }

    @After
    public void aftereach(){
        browser.close();
    }


}
