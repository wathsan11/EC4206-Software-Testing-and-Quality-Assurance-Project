package com.Employee.Data.Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwagLabsLoginTest {

    WebDriver browser;

    private boolean isCI() {
        var gh = System.getenv("GITHUB_ACTIONS");
        return gh != null && gh.equals("true");
    }

    @Before
    public void beforeEach(){
        var option = new ChromeOptions();
        option.addArguments("--safe-mode");

        if (isCI()) {
            option.addArguments("--headless");
        }
        option.addArguments("--incognito");
        option.setCapability("webSocketUrl",true);
        browser =new ChromeDriver(option);

    }

    @Test
    public void loginTest() throws InterruptedException{
        var demoLogin = new DemoSwaglabs(browser);
        demoLogin.goTo();
        demoLogin.enterName();
        Thread.sleep(500);
        demoLogin.enterPassword();
        Thread.sleep(2000);
        demoLogin.clickLogin();
        Thread.sleep(2000);

        assertTrue("Login failed!",demoLogin.isOnProductPage());
        Thread.sleep(3000);

    }

    @After
    public void tearDownAfterEach(){
        browser.close();
    }
}
