package com.qlo.stepdefinition;

import com.qlo.pages.RegisterPage;
import com.qlo.utilities.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefinition extends BaseClass {
	
	RegisterPage registerPage;
	
	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		BaseClass.launchBrowser();
	   
	}

	@Then("^user able to click on Sign in button$")
	public void user_able_to_click_on_Sign_in_button() throws Throwable {
	    registerPage=new RegisterPage();
	    registerPage.clickSigIn();
	}

	@When("^enter the \"([^\"]*)\"$")
	public void enter_the(String emailAddress) throws Throwable {
		 registerPage=new RegisterPage();
		 registerPage.enterEmailAddress(emailAddress);
	}

	@When("^click create an account$")
	public void click_create_an_account() throws Throwable {
		 registerPage=new RegisterPage();
		 registerPage.clickCreateAccountButton();
	}

	@When("^select the title$")
	public void select_the_title() throws Throwable {
		registerPage=new RegisterPage();
		registerPage.selectTitle();
	}

	@Then("^enter the firstname \"([^\"]*)\" and lastname \"([^\"]*)\"$")
	public void enter_the_firstname_and_lastname(String arg1, String arg2) throws Throwable {
		registerPage=new RegisterPage();
		registerPage.enterMandatoryDetails(arg1, arg2);
	    
	}

	@Then("^enter the email Aaddress\"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_the_email_Aaddress_and_password(String arg1, String arg2) throws Throwable {
		registerPage=new RegisterPage();
		registerPage.enterEmailAndPassword(arg1, arg2);
	}

	@Then("^click on register$")
	public void click_on_register() throws Throwable {
		registerPage=new RegisterPage();
		registerPage.submit();
	   
	}
	
	@Then("^user able to logout$")
	public void user_able_to_logout() throws Throwable {
		registerPage=new RegisterPage();
		registerPage.logOut();
	}



}
