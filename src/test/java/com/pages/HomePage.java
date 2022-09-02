package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	//here we have constructor we cretetd from hometest.in constructor we have driver from hometets,also we have homepage driver
	//using this we asssign this class driver to hometest driver.so we get driver access.
	//now we need to give driver access to basepage.so we pass driver in super.it will call the basepage constructor and
	//give it driver access.here also after passing the driver in super.it will ask to create constructor in
	//basepage.so we created it.
	//go to===>basepage
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, HomePage.this);
	}


	@FindBy(xpath="//h2[contains(text(),'new arrivals')]")
	WebElement newArrivalsEle;
	
	@FindBy(xpath="//img[@class=\"attachment-shop_catalog size-shop_catalog wp-post-image\"]//following::h3")
	List<WebElement> headers;
	
	@FindBy(xpath="//img[@class=\"n2-ss-slide-background-image n2-ss-slide-fill n2-ow\"]")
	List<WebElement> imgList;
	
	@FindBy(xpath="Automation Practice Site")
	WebElement title;
	
	
	public boolean newArrivalsDisplayed ()
	{
		return newArrivalsEle.isDisplayed();
	}
	
	public ArrayList<String> checkHeadersTitles()
	{
		ArrayList<String> al=new ArrayList<String>();	
		for(WebElement head:headers)
		{
			al.add(head.getText());
		}
		return al;
	}
	
	public int getHomePageThreeSliders()
	{
		return imgList.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}










