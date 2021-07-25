package com.singularity.grid.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class SimulationSteps {

    @Managed
    WebDriver driver;

    @When("he tries to create a simulation in d3a.io using following parameters")
    public void heTriesToCreateASimulationInDAIoUsingFollowingParameters(Map<String, String> params) {

        String projectName = Serenity.sessionVariableCalled("projectName");

        driver.findElement(By.xpath("//span[text()='" + projectName + "']")).click();
        driver.findElement(By.xpath("//span[text()='" + projectName + "']/../../../../*/button/span[text()='new simulation']")).click();
        driver.findElement(By.id("textarea-field-description")).sendKeys(params.get("Description"));
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        Serenity.setSessionVariable("simulationDescription").to(params.get("Description"));
    }

    @Then("the simulation should be successfully created")
    public void theSimulationShouldBeSuccessfullyCreated() {
        String simulationDescription = Serenity.sessionVariableCalled("simulationDescription");

        driver.get("https://www.d3a.io/projects");
        String projectName = Serenity.sessionVariableCalled("projectName");
        driver.findElement(By.xpath("//span[text()='" + projectName + "']")).click();
        WebElement webElement = driver.findElement(By.xpath("//span[text()='" + projectName + "']/../../../..//span[text()='"+simulationDescription+"']"));
        Assert.assertEquals(simulationDescription,webElement.getText());
    }
}
