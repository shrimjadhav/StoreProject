package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
	
	WebDriver driver;
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, MyAccountPage.this);
	}

	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement username1;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password1;
	
	@FindBy(xpath="//input[@name=\"login\"]")
	WebElement clickLogin;
	
	@FindBy(xpath="//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[1]/a")
	WebElement dashboard;
	
	public boolean loginToAccount(String username , String password)
	{
		username1.sendKeys(username);
		password1.sendKeys(password);
		clickLogin.click();
		return dashboard.isDisplayed();
	}
	
	
}
