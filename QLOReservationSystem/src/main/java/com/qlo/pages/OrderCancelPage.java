package com.qlo.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlo.utilities.BaseClass;
import com.qlo.utilities.TakeScreenShot;

public class OrderCancelPage extends BaseClass{
	
	@FindBy(xpath="//span[text()=' Proceed to checkout']")
	WebElement checkOut;
	
	@FindBy(xpath="//span[text()=' Proceed ']")
	WebElement proceedButton;
	
	@FindBy(xpath="(//span[text()=' Proceed '])[2]")
	WebElement guestProceedButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//a[text()=' Pay by check ']")
	WebElement payment;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement confirmOrder;
	
	@FindBy(xpath="//span[@class='account_user_name hide_xs']")
	WebElement clickAccountHolderName;
	
	@FindBy(xpath="//a[text()='Accounts']")
	WebElement selectAccount;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement OrderHistory;
	
	@FindBy(xpath=" //span[text()=' Details']")
	WebElement details;
	
	@FindBy(xpath=" //span[text()='Cancel Bookings']")
	WebElement cancelBookings;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement clickRoomCheckBox;
	
	@FindBy(xpath="(//span[text()='Submit'])[1]")
	WebElement finalSubmit;
	
	@FindBy(xpath="//textarea[@name='reasonForRefund']")
	WebElement testArea;
	
	@FindBy(xpath="(//span[text()='Submit'])[2]")
	WebElement submitReason;
	
	public OrderCancelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void placeOrder() {
		checkOut.click();
		proceedButton.click();
		guestProceedButton.click();
		checkBox.click();
		payment.click();
		confirmOrder.click();
	}

	public void viewOrderHistory() {
		clickAccountHolderName.click();
		selectAccount.click();
		OrderHistory.click();
		
	}
	
	public void clickDetails() {
		details.click();
	}
	
	public void requestForCancellation() throws IOException {
		//cancelBookings.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cancelBookings);
		String screenshotName="CancelBooking";
		TakeScreenShot.getscreenshotpath(screenshotName);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelBookings);
		
	}
	
	public void selectRoomToBeCancel() {
		//clickRoomCheckBox.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickRoomCheckBox);
	}
	
	public void submitTheRequest() {
		//finalSubmit.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", finalSubmit);
	}
	
	public void provideReason() {
		testArea.sendKeys("cancel");
		submitReason.click();
	}
}
