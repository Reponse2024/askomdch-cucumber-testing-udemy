package com.askomdch.hooks;

import com.askomdch.factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void beforeScenario() {
        driver= DriverFactory.initializeDriver();
    }

    @After
    public void afterScenario(){
            driver.quit();
    }
}