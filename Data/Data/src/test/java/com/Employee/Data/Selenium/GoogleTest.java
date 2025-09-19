package com.Employee.Data.Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {
    WebDriver browser;

    private boolean isCI() {
        var gh = System.getenv("GITHUB_ACTIONS");
        return gh != null && gh.equals("true");
    }

    @Before
   public void beforeEach(){
        var options = new ChromeOptions();
        options.addArguments("--safe-mode");

        if (isCI()) {
            options.addArguments("--headless");
        }
        options.setCapability("webSocketUrl",true);
        browser = new ChromeDriver(options);
    }

    @Test
    public void googleTest() throws InterruptedException{
        browser.get("https://www.google.com");
        Thread.sleep(2000);
        var googleSearchBox = browser.findElement(By.name("q"));
        googleSearchBox.sendKeys("iphone");
        Thread.sleep(5000);

    }

    @After
   public void afterEach(){
        browser.close();
    }
}
