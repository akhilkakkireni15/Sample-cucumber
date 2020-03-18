package pageObjects;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class Stepdefs {
	
	@Given("^I have an account file with contents:$")
	public void i_have_an_account_file_with_contents(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}

	@When("^I parse the file$")
	public void i_parse_the_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the first account number is \"([^\"]*)\"$")
	public void the_first_account_number_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
}
