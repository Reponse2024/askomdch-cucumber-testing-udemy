package com.askomdch.steps;

import com.askomdch.hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;

    @Given("I am on the AskOmDch homepage")
    public void iAmOnTheAskOmDchHomepage() {
        driver.get("https://askomdch.com/");
    }

    @When("I click on the Account tab")
    public void iClickOnTheAccountTab() {
        By accountTab= By.id("menu-item-1237");
        driver.findElement(accountTab).click();
    }

    @And("I enter {string} and {string} in the login form")
    public void iEnterAndInTheLoginForm(String username, String password) {
        By usernameFld= By.id("username");
        By passwordFld= By.id("password");
        driver.findElement(usernameFld).sendKeys(username);
        driver.findElement(passwordFld).sendKeys(password);
    }

    @And("I click the Log in button")
    public void iClickTheLogInButton() {
        By logginBtn= By.name("login");
        driver.findElement(logginBtn).click();
    }

    @Then("I should see the account dashboard")
    public void iShouldSeeTheAccountDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.urlContains("account"));
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("account") : "Not on account dashboard! URL: " + currentUrl;
    }

    @And("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        By partialSuccessMsg= By.cssSelector("p > strong");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(partialSuccessMsg));
        boolean isDisplayed = driver.findElement(partialSuccessMsg).isDisplayed();
        assert isDisplayed : "Success message not displayed!";

    }

    @And("I should see a logout link")
    public void iShouldSeeALogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
        boolean isDisplayed = driver.findElement(By.linkText("Logout")).isDisplayed();
        assert isDisplayed : "Logout link not displayed!";

    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".woocommerce-error")));
        boolean isDisplayed = driver.findElement(By.cssSelector(".woocommerce-error")).isDisplayed();
        assert isDisplayed : "Error message not displayed!";
    }
}
