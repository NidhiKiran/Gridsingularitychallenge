package com.singularity.grid.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ProjectSteps {

    @Managed
    WebDriver driver;
    public static Logger LOGGER = LoggerFactory.getLogger(ProjectSteps.class);

    @Given("User is on project page of d3a.io")
    public void userIsOnProjectPageOfDAIo() {
        driver.get("https://www.d3a.io/projects");
    }

    @When("he tries to create a project in d3a.io using following parameters")
    public void heTriesToCreateAProjectInDAIo(Map<String, String> params) {
        String projectName = params.get("Name")+"_"+System.currentTimeMillis(); //to generate unique name everytime
        driver.findElement(By.cssSelector("button[class='button button--accent button-icon']")).click();
        driver.findElement(By.id("input-field-name")).sendKeys(projectName);
        driver.findElement(By.id("textarea-field-nameTextArea")).sendKeys(params.get("Description"));
        driver.findElement(By.xpath("//span[text()='Add']")).click();
        Serenity.setSessionVariable("projectName").to(projectName);
    }

    @Then("the project should be successfully created")
    public void theProjectShouldBeSuccessfullyCreated() {
        String projectName = Serenity.sessionVariableCalled("projectName");

            WebElement webElement = driver.findElement(By.xpath("//span[text()='" + projectName + "']"));
            Assert.assertEquals(projectName,webElement.getText());
    }
}
