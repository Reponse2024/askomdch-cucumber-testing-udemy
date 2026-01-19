package com.askomdch.steps;

import com.askomdch.factory.DriverFactory;
import com.askomdch.pages.CartPage;
import com.askomdch.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddToCartSteps {
    private WebDriver driver;

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        driver= DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) {
        new StorePage(driver).addToCart(productName);
    }

    @Then("I should see {int} {string}in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        CartPage cartPage= new CartPage(driver);
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
