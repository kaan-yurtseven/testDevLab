package com.testDevLab.step_definitions;

import com.testDevLab.pages.HomePageBooking;
import com.testDevLab.utilities.ConfigurationReader;
import com.testDevLab.utilities.Driver;
import com.testDevLab.utilities.ProjectUtils;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RigaTests {
    HomePageBooking home = new HomePageBooking();

    @Given("I am in {string} page")
    public void i_am_in_page(String string) {
        Driver.get().get(ConfigurationReader.get("url"));
        ProjectUtils.waitFor(2);
        assertEquals("you are not on home page",string,Driver.get().getTitle());

 }

    @When("I set up destination as {string}")
    public void i_set_up_destination_as(String string) {
         home.searchBox.sendKeys(string);
         List<WebElement> results = home.allSearchResult;
         home.allSearchResult.get(0).click();


 }

    @When("I set dates {string} and {string}")
    public void i_set_dates(String string, String string2) {
       ProjectUtils.waitFor(2);
        home.CheckIn.click();
        home.CheckOut.click();
    }

    @When("I click on {string} button")
    public void i_click_on_button(String string) {
        home.searchButton.click();
        ProjectUtils.waitFor(2);
        assertTrue("your results are not releated with Riga",Driver.get().getTitle().contains("Riga"));

    }

}
