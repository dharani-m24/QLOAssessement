package com.qlo.stepdefinition;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.openqa.selenium.Cookie;

import com.qlo.baseClass.BaseClass;
import com.qlo.excelData.ReadExcelFile;
import com.qlo.pages.CartPage;

import cucumber.api.java.en.Then;

public class CookieStepDefinition extends BaseClass{
	
	CartPage cartPage;
	ReadExcelFile excelData;
	
	@Then("^Login into application and store the authentication cookie generated$")
	public void login_into_application_and_store_the_authentication_cookie_generated() throws Throwable {
	   
		cartPage=new CartPage();
		excelData=new ReadExcelFile();
		 ArrayList<String> testData=excelData.getData("User 1");
		cartPage.login(testData.get(1), testData.get(4));
		
		// create file named Cookies to store Login Information		
        File file = new File("E:\\Programs\\CucumberTraining\\QLOReservationSystem\\Cookies.data");							
        try		
        {	  
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
          	
            	
            // loop for getting the cookie information 		
            for(Cookie ck : driver.manage().getCookies())							
            {			
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
                Bwrite.newLine();             
            }			
            Bwrite.close();			
            fileWrite.close();	
            
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
	}

}
