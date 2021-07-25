package com.singularity.grid.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {

    @Managed
    WebDriver driver;

    @Given("User is on login page of d3a.io")
    public void user_is_on_login_page_d3a_io() {
        driver.get("https://www.d3a.io/login");
    }

    @When("he tries to login to d3a.io using preexisting user")
    public void heTriesToLoginToDAIo(Map<String, String> params) {
        driver.findElement(By.id("email")).sendKeys(params.get("Email"));
        driver.findElement(By.id("password")).sendKeys(params.get("Password"));
        driver.findElement(By.cssSelector("span[class='button__label']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //using implicit wait as assertion will be done in a separate step

    }

    @Then("he is successfully logged in to d3a.io")
    public void heIsSuccessfullyLoggedInToDAIo() {

        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.d3a.io/",URL);

        boolean isTitlePresent= driver.findElement(By.cssSelector("h1[class='headline header__page-title headline-london']")).isDisplayed();
        Assert.assertEquals(isTitlePresent, true);
    }
}
