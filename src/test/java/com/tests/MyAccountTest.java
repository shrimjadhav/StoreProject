package com.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.MyAccountPage;

public class MyAccountTest extends BaseTest {

	MyAccountPage map;
	
	@BeforeClass
	public void openBrowser()
	{
		map=new MyAccountPage(driver);
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	@Test
	public void verifyPageTitle()
	{
		Assert.assertEquals(map.getTitleofPage(), "My Account – Automation Practice Site");
	}
	
	@Test   //here we take username and pass from config properties.cofig is only applicable for tests,as we have given path src/test
	public void loginToMyAccount()   //1st we call property,then store in string with varibale,pass to method ,then it will crete string is repec page.
	{
		String user=prop.getProperty("username");
		String pass=prop.getProperty("password");
		Assert.assertTrue(map.loginToAccount(user, pass));
		logger.info("user logged in");
	}
	
	
}
