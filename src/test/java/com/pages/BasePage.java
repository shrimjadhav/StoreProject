package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
// explain project structure / framework==>in our project we r using page object model where we separating all pages 
// into page classes and all tests in test classes.in tests we r writing only validation statements.
//in pages we  r wrtitng elements i.e object repository  and actions we r performig,also page factory is used to initialize all elements
// in base page class we put all common methods in all page classes.similarly for base test.
// for logging purpose we r using log4j in order to create logs in the files and in console.
// for report purpose rather than using testng we r using extent reports in order to write report in html format.
//also util package i.e.helper classes  is there to write utilities classes like file reading,writing,window handles,database connection ,screenshot taking then reading excel data for this we r creating
// utility classes in util package/folder.
//test data we r writing in resources folder.properties files r used to get key and values from file 	
	
//there must be connection between every page.firsr decisde whta to do.then follow that pages	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitleofPage()   //this method as well as switch to alert,frmae,current url,page source 
	{                                // are req for all pages so we kept at base page
		return driver.getTitle();      
	}
	
	
	
	
}
