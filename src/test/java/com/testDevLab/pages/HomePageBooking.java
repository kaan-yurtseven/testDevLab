package com.testDevLab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePageBooking extends BasePageBooking {

    @FindBy(id = "ss")
    public WebElement searchBox;

    @FindBys(
            {@FindBy(xpath = "//*[@class='search_hl_name']")}
    )
    public List <WebElement> allSearchResult;

    @FindBy(xpath = "//td[@data-date='2022-02-20']")
    public WebElement CheckIn;

    @FindBy(xpath = "//td[@data-date='2022-02-23']")
    public WebElement CheckOut;

    @FindBy(xpath = "(//*[@type='submit'])[1]")
    public WebElement searchButton;

}
