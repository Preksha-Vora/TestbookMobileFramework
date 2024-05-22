package com.testbook.mobile.utils;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;


public class TakeScreenshot {
	WebDriver driver;
	String testname;
	String screenshotPath = "/target/Screenshots";
	String method;

	public TakeScreenshot(String testname, WebDriver driver) {
		this.driver = driver;
		this.testname = testname;
		
		
	}


	public void takeScreenshot() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
		Date date = new Date();
		String date_time = dateFormat.format(date);
		File file = new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator
				+ this.testname + File.separator + date_time);
		boolean exists = file.exists();
		if (!exists) {
			new File(System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + this.testname
					+ File.separator + date_time).mkdir();
		}

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String saveImgFile = System.getProperty("user.dir") + File.separator + screenshotPath + File.separator
					+ this.testname + File.separator + date_time + File.separator + "screenshot.png";
			Reporter.log("Save Image File Path : " + saveImgFile, true);
			File destFile= new File(saveImgFile);
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
			+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void takeScreenShotOnException(ITestResult result) {
	       
	        if (result.getStatus() == ITestResult.FAILURE) {
	                try {
	                    if (driver != null) {
	                        takeScreenshot();
	                    }
	                } catch (Exception ex) {
	                    Reporter.log("Driver is null while taking screen shot", true);
	                }
	            
	        }
	    }

}
