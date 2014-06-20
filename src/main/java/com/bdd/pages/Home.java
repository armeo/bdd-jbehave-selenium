package com.bdd.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Page object defining the home page
 */
public class Home extends FluentWebDriverPage {

    /*
      Define page elements
    */
    private By linkReviews          = linkText("Reviews");
    private By inputSearchWhat      = id("search_whatInput");
    private By inputSearchWhere     = id("location");
    private By buttonSubmitSearch   = cssSelector("button.search-submit");
    private By linkVideos           = cssSelector("a[title='Videos']");

    /**
     * Default constructor
     * @param webDriverProvider
     */
    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go(String url) {
        get(url);
        // wait for page to load
        getDriverProvider().get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void go(String url, String section) {
        go(url);
        link(xpath("@title = '" + section + "'")).click();
    }

    public void searchForWhatWhere(String what, String where) {
        within(secs(5)).input(inputSearchWhat).clearField().sendKeys(what);
        input(inputSearchWhere).clearField().sendKeys(where);
        button(buttonSubmitSearch).click();
    }

    public void searchGoogle(String what) {
        input(By.id("gbqfq")).clearField().sendKeys(what);
        button(By.id("gbqfb")).click();
    }

    public void goToReviewsSection() {
        within(secs(5)).link(linkReviews).click();
    }

    public void goToVideosSection() {
        within(secs(5)).link(linkVideos).click();
    }
}
