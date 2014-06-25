package com.bdd.steps;

import com.bdd.pages.Home;
import com.bdd.pages.PageFactory;
import com.bdd.pages.SearchResults;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Steps {

    private Home home;
    private SearchResults searchResults;

    public Steps(PageFactory pageFactory) {
        home = pageFactory.newHome();
        searchResults = pageFactory.newSearchResults();
    }

    @Given("I am on $url")
    public void gotoGoogle(@Named("url") String url) {
        home.go(String.format("http://www.%s.com/", url));
    }

    @When("I search for a $inputValue")
    public void searchGoogle(@Named("inputValue") String inputValue) {
        home.searchGoogle(inputValue);
    }

    @Then("I should found results")
    public void googleFound() {
        assertThat(searchResults.googleFound().isEmpty(), is(false));
    }

    @Then("I should not found results")
    public void googleNotFound() {
        assertThat(searchResults.googleFound().isEmpty(), is(true));
    }

}
