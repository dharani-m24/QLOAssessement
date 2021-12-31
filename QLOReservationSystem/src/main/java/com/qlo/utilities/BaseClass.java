package com.qlo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public BaseClass() {

		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(
					"E:\\Programs\\CucumberTraining\\QLOReservationSystem\\src\\main\\java\\com\\qlo\\utilities\\config.properties");

			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void launchBrowser() {
//		if(properties.getProperty("browser").equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", properties.getProperty("drivePath"));
//			driver=new ChromeDriver();
//		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	public static void closeBowser() {
		driver.close();
	}
	

}
