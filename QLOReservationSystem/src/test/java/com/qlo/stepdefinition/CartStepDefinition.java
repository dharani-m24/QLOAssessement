package com.qlo.stepdefinition;

import com.qlo.pages.CartPage;
import com.qlo.utilities.BaseClass;
import com.qlo.utilities.TakeScreenShot;

import cucumber.api.java.en.Then;

public class CartStepDefinition extends BaseClass{
	
	CartPage cartPage;
	
	@Then("^click Sign In and enter email Address \"([^\"]*)\" and password \"([^\"]*)\"\\.$")
	public void click_Sign_In_and_enter_email_Address_and_password(String userId, String password) throws Throwable {
		
		cartPage=new CartPage();
		cartPage.login(userId, password);
	    
	}
	
	@Then("^Go to home page$")
	public void go_to_home_page() throws Throwable {
		cartPage=new CartPage();
		cartPage.clickHomeButton();
	}

	@Then("^Enter/Select Hotel Location as \"([^\"]*)\"$")
	public void enter_Select_Hotel_Location_as(String hotelLocation) throws Throwable {
		cartPage=new CartPage();
		cartPage.enterHotelLocation(hotelLocation);
	}

	@Then("^Select Hotel$")
	public void select_Hotel() throws Throwable {
		cartPage=new CartPage();
		cartPage.selectHotel();
	}

	@Then("^Select Check In Date from Calendar$")
	public void select_Check_In_Date_as_From_Calendar() throws Throwable {
		cartPage=new CartPage();
		cartPage.selectCheckInDate();
	    
	}

	@Then("^Select Check Out Date as from Calendar$")
	public void select_Check_Out_Date_as_From_Calendar() throws Throwable {
		cartPage=new CartPage();
		cartPage.selectCheckOutDate();
	}

	@Then("^Go to Executive Rooms and click on Book Now$")
	public void go_to_Executive_Rooms_and_click_on_Book_Now() throws Throwable {
		cartPage=new CartPage();
		cartPage.bookRoom();
	}
	
	@Then("^Remove the product from the cart$")
	public void remove_the_product_from_the_cart() throws Throwable {
		cartPage=new CartPage();
		cartPage.removeCart();
		
	}
	
	@Then("^Take screenshot$")
	public void take_screenshot() throws Throwable {
		String screenshotName="viewCart";
		TakeScreenShot.getscreenshotpath(screenshotName);
	}

}
