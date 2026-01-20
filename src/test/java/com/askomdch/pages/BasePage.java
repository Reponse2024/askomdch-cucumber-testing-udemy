package com.askomdch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void load(String url){
        driver.get(url);
    }
    protected WebDriver driver;
    protected WebDriver wait;
}
