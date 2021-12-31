package com.qlo.stepdefinition;

import com.qlo.pages.OrderCancelPage;

import cucumber.api.java.en.Then;

public class OrderCancelStepDefinition {
	
	OrderCancelPage orderCancelPage;
	
	@Then("^Place the order$")
	public void place_the_order() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.placeOrder();
	}

	@Then("^Click on the ORDER HISTROY AND DETAILS from My Account page\\.$")
	public void click_on_the_ORDER_HISTROY_AND_DETAILS_from_My_Account_page() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.viewOrderHistory();
	}

	@Then("^Click on Details$")
	public void click_on_Details() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.clickDetails();
	}

	@Then("^Go to FOLLOW YOUR ORDER'S STATUS STEP-BY-STEP section and click on CANCEL BOOKINGS$")
	public void go_to_FOLLOW_YOUR_ORDER_S_STATUS_STEP_BY_STEP_section_and_click_on_CANCEL_BOOKINGS() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.requestForCancellation();
	}

	@Then("^Select rooms which bookings you want to cancel\\. Click on Room-(\\d+)$")
	public void select_rooms_which_bookings_you_want_to_cancel_Click_on_Room(int arg1) throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.selectRoomToBeCancel();
	}

	@Then("^click submit$")
	public void click_submit() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.submitTheRequest();
	}

	@Then("^Type some message on the pop up window and Submit$")
	public void type_some_message_on_the_pop_up_window_and_Submit() throws Throwable {
		orderCancelPage=new OrderCancelPage();
		orderCancelPage.provideReason();
	}

}
