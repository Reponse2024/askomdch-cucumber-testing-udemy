package com.askomdch.steps;

import com.askomdch.domainobjects.Product;
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

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }

    @Then("I should see {int} {product}in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        CartPage cartPage= new CartPage(driver);
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}
