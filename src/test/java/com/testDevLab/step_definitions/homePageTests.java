package com.testDevLab.step_definitions;

import com.testDevLab.utilities.Driver;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class homePageTests {
    @Then("verify page title")
    public void verify_page_title() {
        assertEquals("google", Driver.get().getTitle());
    }
}
