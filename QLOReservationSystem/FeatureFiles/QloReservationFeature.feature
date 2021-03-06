Feature: Buliding cucumber framework for QLO Reservation System Website 
@Register
Scenario: Verify user is able to register account in the qloapps application 
	Given user is on Home page 
	Then user able to click on Sign in button 
	When enter the email Address 
	And click create an account 
	And select the title 
	Then enter the firstname and lastname 
	And enter the email Aaddress and password 
	Then click on register 
	And user able to logout 
	
	
	
Scenario: Verify if the user is able to remove selected Room from the cart 
	Given user is on Home page 
	Then click Sign In and enter email Address and password 
	And Go to home page 
	Then Enter/Select Hotel Location 
	And Select Hotel 
	And Select Check In Date from Calendar 
	And Select Check Out Date as from Calendar 
	Then Go to Executive Rooms and click on Book Now 
	And Remove the product from the cart 
	And Take screenshot 
	
	
@OrderCancel
Scenario: Verify the order and cancel the order. 

	Given user is on Home page 
	Then click Sign In and enter email Address and password 
	And Go to home page 
	Then Enter/Select Hotel Location 
	And Select Hotel 
	And Select Check In Date from Calendar 
	And Select Check Out Date as from Calendar 
	Then Go to Executive Rooms and click on Book Now 
	And Place the order 
	Then  Click on the ORDER HISTROY AND DETAILS from My Account page. 
	Then  Click on Details 
	And Go to FOLLOW YOUR ORDER'S STATUS STEP-BY-STEP section and click on CANCEL BOOKINGS 
	And Select rooms which bookings you want to cancel. Click on Room-1 
	And click submit 
	Then Type some message on the pop up window and Submit 
	
	
	#Examples:
	#|UserName                  |pwd     |Hotel Location|
	#|dharanishree2412@gmail.com|Tara?!24|United States |
@Cookies
Scenario: valid login based cookie
Given user is on Home page 
	Then Login into application and store the authentication cookie generated 
	