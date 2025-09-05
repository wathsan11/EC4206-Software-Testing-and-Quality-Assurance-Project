package com.Employee.Data.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoSwaglabs {
    private WebDriver webDriver;

    @FindBy(name = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(name="add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartBadge;

    public DemoSwaglabs (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void goTo(){
        webDriver.get("https://www.saucedemo.com/");
    }

    public void enterName(){
        userName.sendKeys("standard_user");
    }

    public void enterPassword(){
        password.sendKeys("secret_sauce");
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean isOnProductPage(){
        return webDriver.getCurrentUrl().contains("inventory");
    }

    public void addBackpackToCart(){
        backpackAddToCart.click();
    }

    public void clickCart(){
        cartBadge.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("cart.html"));

    }

    public String getCartCount(){
       return cartBadge.getText();
    }



}
