package com.testDevLab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeBasePage extends BasePage {



    @FindBy(xpath = "//*[@class='sections']/div")
    public List<WebElement> sections;

    @FindBy(xpath = "//*[@class='sections']//a[contains(@hrf,'')]")
    public List<WebElement> subSections;


}
