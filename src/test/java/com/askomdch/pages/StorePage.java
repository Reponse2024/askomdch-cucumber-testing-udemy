package com.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage extends BasePage{
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
    @FindBy(css= "a[title='View cart']") private WebElement viewCartLink;
    public StorePage(WebDriver driver) {
        super(driver);
    }
    public void addToCart(String productName){
        By addToCartBtn = By.cssSelector("a.add_to_cart_button[data-product_id=\"1215\"]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
