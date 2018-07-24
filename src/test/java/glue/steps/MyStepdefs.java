package glue.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;

public class MyStepdefs extends LoginPage {


    @Given("^browser \"([^\"]*)\" with remote address: \"([^\"]*)\"$")
    public void browserWithRemoteAddress(String browserName, String address) throws Throwable {
        openRemoteWebDriver(browserName, address);
    }

    @Given("^browser \"([^\"]*)\"$")
    public void browser(String browserName) throws Throwable {
        openLocalWebDriver(browserName);
    }

    @And("^website loaded this address: \"([^\"]*)\"$")
    public void websiteLoadedThisAddress(String url) throws Throwable {
        driver.navigate().to(url);
    }

    @When("^I execute a search for \"([^\"]*)\"$")
    public void iExecuteASearchFor(String address) throws Throwable {
        WaitTool waitTool = new WaitTool();
        waitTool.waitForElementPresent(driver, By.cssSelector("#lst-ib"), 10).sendKeys(address);
        waitTool.waitForElementPresent(driver, By.cssSelector("#lst-ib"), 10).submit();
    }
//test project
    @Then("^I should expect there are some results$")
    public void iShouldExpectThereAreSomeResults() throws Throwable {
        WaitTool waitTool = new WaitTool();
        List<WebElement> elements = null;
        if (driver instanceof RemoteWebDriver) {
            if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equalsIgnoreCase("firefox")) {
                waitTool.waitForElementPresent(driver, By.id("search"), 10);
            }
        } else {
            if (((EventFiringWebDriver) driver).getWrappedDriver() instanceof FirefoxDriver) {
                waitTool.waitForElementPresent(driver, By.id("search"), 10);
            }
        }
        elements = waitTool.waitForListElementsPresent(driver, By.tagName("a"), 10);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase("Progress | КОМПЮТЪРНО ОБРАЗОВАТЕЛЕН ЦЕНТЪР")) {
                System.out.println(element.getText());
            }
        }

//        if (((EventFiringWebDriver) driver).getWrappedDriver() instanceof FirefoxDriver) {
//            driver.findElement(By.id("search"));
//        }
//        List<WebElement> texts = driver.findElements(By.tagName("a"));
//        for(WebElement element : texts){
//            if (element.getText().equalsIgnoreCase("Progress | КОМПЮТЪРНО ОБРАЗОВАТЕЛЕН ЦЕНТЪР")) {
//                System.out.println(element.getText());
//            }
//        }

        Thread.sleep(10000);
    }

    @After
    public void tearDown() {
        driver.close();
    }



    @Then("^I should expect current page url in the address bar$")
    public void iShouldExpectCurrentPageUrlInTheAdressBar(String url) throws Throwable {

        Assert.assertEquals(url,driver.getCurrentUrl());

    }

    @When("^i click on nachalo btn$")
    public void ClickOnNachaloBtn() throws Throwable {
        WebElement firstButton = driver.findElement(By.cssSelector("#menu-item-2912 > a"));
        firstButton.click();

        WebElement secondButton = driver.findElement(By.cssSelector("#menu-item-2554 > a"));
        firstButton.click();

        WebElement thirdButton = driver.findElement(By.cssSelector("#menu-item-15128 > a"));
        firstButton.click();




    }
}
