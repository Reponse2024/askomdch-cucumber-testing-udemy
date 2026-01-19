package com.askomdch.steps;

import com.askomdch.domainobjects.BillingDetails;
import com.askomdch.factory.DriverFactory;
import com.askomdch.hooks.Hooks;
import com.askomdch.pages.CartPage;
import com.askomdch.pages.CheckoutPage;
import com.askomdch.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PlaceAnOrderSteps {

    WebDriver driver= Hooks.driver;
    private BillingDetails billingDetails;

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        driver= DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");

    }
    @And("my billing  details are")
        public void myBillingDetailsAre(BillingDetails billingDetails){
        this.billingDetails= billingDetails;

    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(driver).chekout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
        new CheckoutPage(driver).getNotice());
    }
}
