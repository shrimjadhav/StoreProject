package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	//if we call this screenshot() method,it will access the driver,then take sceernshot
	//store it at folder.
	//we call this method in basetest after method if testcase fails take screenshot
	
	
	public ScreenShot() throws IOException {
		super();
	}
	
	public static String getScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/screenshots/"+name+System.currentTimeMillis()+".png";
		File finaldestination=new File(destination);
		FileUtils.copyFile(source, finaldestination);
		return destination;
	}

}
