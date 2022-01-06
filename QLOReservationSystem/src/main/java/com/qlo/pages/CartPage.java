package com.qlo.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qlo.baseClass.BaseClass;
import com.qlo.utilities.TakeScreenShot;

public class CartPage extends BaseClass{
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signIn;
	
	@FindBy(xpath=" //span[text()=' Home']")
	WebElement homeButton;
	
	@FindBy(id="hotel_location")
	WebElement hotelLocationName;
	
	@FindBy(id="id_hotel_button")
	WebElement selectHotelDropDown;
	
	@FindBy(xpath="//li[text()='The Hotel Prime']")
	WebElement chooseHotelPrime;
	
	@FindBy(id="check_in_time")
	WebElement checkInDate;
	
	@FindBy(xpath="//*[@id=\"category_data_cont\"]/div[3]/div/div[1]/a/img")
	WebElement exclusiveRoom;
	
	@FindBy(xpath="//span[text()=' Book Now ']")
	WebElement bookNowButton;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
	WebElement closePopUp;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[4]/div/a")
	WebElement viewCart;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[4]/div/div/div/div/dl/dt/span/a")
	WebElement removeCart;
	
	@FindBy(xpath="//span[text()=' Proceed to checkout']")
	WebElement checkOut;
	
	@FindBy(xpath="//p[@class='alert alert-warning']")
	WebElement warningMessage;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String emailId, String pwd) throws InterruptedException {
		signInBtn.click();
		emailAddress.clear();
		Thread.sleep(2000);
		emailAddress.sendKeys(emailId, Keys.ENTER);
		password.clear();
		Thread.sleep(2000);
		password.sendKeys(pwd, Keys.ENTER);
		signIn.click();

	}
	
	public void clickHomeButton() {
		//homeButton.click();
		
		WebDriverWait wait = new WebDriverWait (driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Home']")));
		homeButton.click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeButton);
	}
	
	public void enterHotelLocation(String locationName) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", hotelLocationName);
		hotelLocationName.sendKeys(locationName,Keys.ENTER);		
	
		
		Actions action=new Actions(driver);
		action.moveToElement(hotelLocationName).click();
		action.build().perform();
		
		Thread.sleep(2000);
	}
	
	public void selectHotel() throws InterruptedException {
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectHotelDropDown);
		Actions action=new Actions(driver);
		action.moveToElement(chooseHotelPrime).click();
		action.build().perform();
		Thread.sleep(2000);
	
		
	}
	
	
	
	public void selectCheckInDate()  {
	((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]",
	        driver.findElement(By.id("check_in_time")), "09-01-2022");

	
	
	
	}
	
	public void selectCheckOutDate() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]",
		        driver.findElement(By.id("check_out_time")), "11-01-2022");
		
		WebElement search=driver.findElement(By.id("search_room_submit"));
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", search);
	}
	
	public void bookRoom() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", exclusiveRoom);
		//exclusiveRoom.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookNowButton);
		//bookNowButton.click();
		
	}
	
	public void removeCart() throws IOException, InterruptedException {
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", closePopUp);
		checkOut.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeCart);
		Thread.sleep(2000);
		
	}
	
	public void validCartMessage() {
		
		String message=warningMessage.getText();
		System.out.println(message);
		
		Assert.assertEquals(message, "Till now you did not added any room in your cart.");
		
	}
}


/*
 * public void SelectCheckInDate(String selectdate) {
 * 
 * //checkInDate.click(); ((JavascriptExecutor)
 * driver).executeScript("arguments[0].click();", checkInDate);
 * 
 * List<WebElement>
 * dates=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table//td"
 * ));
 * 
 * int total_nodes=dates.size();
 * 
 * for(int i=0; i<total_nodes; i++) { String date=dates.get(i).getText();
 * System.out.println("hi"+date); if(date.equalsIgnoreCase(selectdate));{
 * //dates.get(i).click(); ((JavascriptExecutor)
 * driver).executeScript("arguments[0].click();", dates.get(i));
 * 
 * }
 * 
 * } }
 */

/*
 * public void SelectCheckInDate() {
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
 * checkInDate); while(true) { String
 * text=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div")).
 * getText(); String month="January 2022"; if(text.equals(month)) { break; }else
 * { WebElement
 * next=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div"));
 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);
 * 
 * } } driver.findElement(By.xpath(
 * "//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[7]/a")).click(); }
 */
