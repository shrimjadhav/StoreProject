package com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.util.ScreenShot;

public class BaseTest {

	public static WebDriver driver;     //global ,public , static so we can use it in other classes also without creating object.
	
	//first we create the driver and do the setup in BaseTest, then we pass driver to other sub classes through inheritance and extends keyword.
	//go to hometest===>
	
	//common methods annotation for all test classes
		public 	static Properties prop;
		public  static ExtentHtmlReporter htmlreporter;
		public static  ExtentReports extent;
		public  static ExtentTest test;
		public static	Logger logger;
		
		@BeforeSuite
		public void propertySetup()     
		{                                     
			try{
			prop=new Properties();  //here we created obj of proerties class.we created folder the added config prorperties file
			FileInputStream ip=new FileInputStream(".\\src\\test\\resources\\config.properties");//add properties in cofig file.then it accessed using prop.
			prop.load(ip);                                                 //prop is used to read cofig file
		}catch(FileNotFoundException e)
		{
		e.printStackTrace();	
		}catch(IOException e)
		{
		e.printStackTrace();	//here we created the constructor, to create obj for logger class
		}                         //// log give info aboutthe execution.to creat log report we used log4j jar in pom
		logger=Logger.getLogger(BaseTest.class); //this step==>start logging from bastest and its subclasses
		PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");//here we define the format of log
		}              
		//\\src\\test\\resources here we r putting lg4j properties ffiles ..from it, using
        // config.properties and we get log setup/report
	
	
		@BeforeTest
		public void initDriver()  //initialize the browser
		{
		//	String browserName=	prop.getProperty("browser");  //if u r using multiple browsers
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeexepath") );
			driver=new ChromeDriver();	
			logger.debug("Browser is Set");
		}
			
		@AfterTest
		public void tearDown()
		{
			driver.quit();
			logger.info("Browser closed successfully");
		}
	
	
		@BeforeTest
		public void setupExtentEnv() //it genrate/setup extend report and it contaains location of report,title,report name
		{                            //theme,report detailss.
			htmlreporter =new ExtentHtmlReporter(".\\extentreport\\extent-report.html");
			htmlreporter.config().setDocumentTitle("Automation Report");
			htmlreporter.config().setReportName("functional report");
			htmlreporter.config().setTheme(Theme.STANDARD);
			extent=new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("HOST NAME", "LOCALHOST");
			extent.setSystemInfo("OS", "WINDOWS 10");
			extent.setSystemInfo("Tester NAME", "Shridhar");
			extent.setSystemInfo("Browser", "Chrome");
			logger.info("extent report set");
		}
	
	
		@BeforeMethod //it stores the all the method names of test cases which will be executed.store in extend report
		public void register(Method method) {
			String testname=method.getName();
				test=extent.createTest(testname);
				
		}
                        
						//it stores the result of all testcases after execution i.e pass/fail/skipped.alsoit add exception ,screenshot
		@AfterMethod   //for this we r using ItestResult class.stores execution results
		public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "TEST CASE FAILED is"+result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED is"+result.getThrowable());
			String screenshotpath=ScreenShot.getScreenshot(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "TEST CASE SkIPPED:"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "TEST CASE PASSED:"+result.getName());
		}
		}

		@AfterTest
		public void cleanup()
		{
			extent.flush();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

	
}