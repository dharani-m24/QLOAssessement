package com.qlo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qlo.baseClass.BaseClass;

import junit.framework.Assert;

public class RegisterPage extends BaseClass{
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailAddress;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccountButton;
	
	@FindBy(id="id_gender2")
	WebElement title;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement validEmailAddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit'][1]")
	WebElement register;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement successMessage;
	
	@FindBy(id="user_info_acc")
	WebElement userName;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOutBtn;
	
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSigIn() {
		signInBtn.click();
	}
	
	public void enterEmailAddress(String emailId) {
		System.out.println(emailId);
		emailAddress.sendKeys(emailId);
	}
	
	public void clickCreateAccountButton() {
		createAccountButton.click();
	}
	
	public void selectTitle() {
		title.click();
	}
	
	public void enterMandatoryDetails(String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
	}
	
	public void enterEmailAndPassword(String emailId, String pwd) {
		validEmailAddress.clear();
		validEmailAddress.sendKeys(emailId);
		password.sendKeys(pwd);
	}
	
	public void submit() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", register);
		String message=successMessage.getText();
		System.out.println(message);
		Assert.assertEquals(message, "Your account has been created.");
		//register.click();
	}
	
	public void logOut() {
		userName.click();
		logOutBtn.click();
		
	}
	
}
