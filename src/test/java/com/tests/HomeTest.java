package com.tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class HomeTest extends BaseTest {
	
	//we get driver access from base test.now we have to give access to HmoePage.so we crearted the obj.of homepage
	// and in constructor we pass the driver.we did it in before class so 1st we give driver access to homepage
	// and locate the webelements and run the methods or actions
	//after that we do the final excution or validation here.
	// after passing the driver in constructor of homepage.it will ask to create the construtor in homepage.so we created it.
	//goto the homepage==>
	
	HomePage hp;

	@BeforeClass
	public void browserSetup()
	{
		hp=new HomePage(driver);
		driver.get("https://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("HomePage browser opened");
	}
	
	@Test(priority=1, description="To verify New Arrival is displayed on Home page")
	public void verifyNewArrivalsIsDisplayed()
	{
		boolean actual=hp.newArrivalsDisplayed();
		Assert.assertEquals(actual, true);
	}

	@Test
	public void verifyBookTitles()
	{
		ArrayList<String> bookTitles =hp.checkHeadersTitles();
		
		Assert.assertTrue(bookTitles.contains("Selenium Ruby"));
		Assert.assertTrue(bookTitles.contains("Thinking in HTML"));
		Assert.assertTrue(bookTitles.contains("Mastering JavaScript"));	
	}
	
	@Test
	public void verifyHomePageThreeSliders()
	{
		Assert.assertEquals(hp.getHomePageThreeSliders(), 3);
	}
	
	@Test
	public void verifyTitle()
	{
		Assert.assertEquals(hp.getTitleofPage(), "Automation Practice site");
	}
	
	
	
	
	
	

}
