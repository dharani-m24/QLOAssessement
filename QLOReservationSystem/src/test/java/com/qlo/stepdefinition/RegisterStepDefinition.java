package com.qlo.stepdefinition;

import java.util.ArrayList;

import com.qlo.baseClass.BaseClass;
import com.qlo.excelData.ReadExcelFile;
import com.qlo.pages.RegisterPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefinition extends BaseClass {
	
	RegisterPage registerPage;
	ReadExcelFile excelData;
	
	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		BaseClass.launchBrowser();
	   
	}

	@Then("^user able to click on Sign in button$")
	public void user_able_to_click_on_Sign_in_button() throws Throwable {
	    registerPage=new RegisterPage();
	    registerPage.clickSigIn();
	}

	@When("^enter the email Address$")
	public void enter_the_email_Address() throws Throwable{
		 registerPage=new RegisterPage();
		 excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("User 2");
		 registerPage.enterEmailAddress(testData.get(1));
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

	@Then("^enter the firstname and lastname$")
	public void enter_the_firstname_and_lastname() throws Throwable {
		registerPage=new RegisterPage();
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("User 2");
		registerPage.enterMandatoryDetails(testData.get(2), testData.get(3));
	    
	}

	@Then("^enter the email Aaddress and password$")
	public void enter_the_email_Aaddress_and_password() throws Throwable {
		registerPage=new RegisterPage();
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("User 2");
		registerPage.enterEmailAndPassword(testData.get(1), testData.get(4));
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
