package com.interview.Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.interview.TestScript.Movies;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppIndependentMethods extends Movies {
	
	
	/* Method Name		: setObject()*/
	public boolean setObject(WebDriver oDriver, WebElement objEle, String strValue)
	{
		try {
			if(objEle != null) {
				objEle.sendKeys(strValue);
				System.out.println("==> Entered "+strValue+" into Element with Locator "+Locator(objEle));
				return true;
			}else {
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in SetObject method : "+e);
			return false;
		}
		
	}
	
	/*Method Name		: clickEnter()*/
	public boolean clickEnter(WebDriver oDriver, WebElement objEle) {
		try {
			if(objEle!=null) {
				objEle.sendKeys(Keys.ENTER);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("Exception in clickEnter method : "+e);
			return false;
		}
	}
	
	
	/*Method Name		: verifyElementExist()*/
	public boolean verifyElementExist(WebDriver oDriver, WebElement objEle)
	{
		try {
			if(objEle.isDisplayed() ) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in verifyElementExist method : "+e);
			return false;
		}
	}
		
	/*Method Name		: launchBrowser()*/
	public WebDriver launchBrowser(String browserType)
	{
		WebDriver oDriver = null;
		try {
			switch(browserType.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					oDriver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", ".\\Library\\drivers\\geckodriver.exe");
					oDriver = new FirefoxDriver();
					break;
				default:
			}
			
			if(oDriver!=null) {
				oDriver.manage().window().maximize();
				oDriver.manage().deleteAllCookies();
				
				oDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				oDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

				return oDriver;
			}else {
				return null;
			}
		}catch(Exception e)
		{
			System.out.println("Exception in launchBrowser method : "+e);
			return null;
		}
	}
		
	/*Method Name		: closeBrowser()*/
	public boolean closeBrowser(WebDriver oDriver)
	{
		try {
			oDriver.quit();
			oDriver = null;
			return true;
		}catch(Exception e)
		{
			System.out.println("Exception in closeBrowser method : "+e);
			return false;
		}
	}

	/*
	 * Method Name		: FormatDate()
	 * Purpose			: Converts below mentioned format to YYYY-MM-DD
	*/
	public LocalDate FormatDate(String date, String format) {
		DateTimeFormatter dtf = null;
		try {
			switch(format) {
			case "MMMM d, yyyy":
				dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
				break;
			case "d MMMM yyyy":
				dtf = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
				break;
			default:
				System.out.println("Invalid Date Format");
				break;
			}
			
			LocalDate date1 = LocalDate.parse(date, dtf);	
			return date1;
			
		}catch(Exception e) {
			System.out.println("Exception in FormatDate method : "+e);
			return null;
		}
	}
}
