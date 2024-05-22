package com.testbook.mobile.base;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.b2b.support.ParameterProvider;

import okio.Timeout;


public abstract class TestBookBasePage extends TestBookBaseWebAutomationPage{
	
	public TestBookBasePage(WebDriver driver) {
		super(driver);
		
	}


	public String getProperty(String fileName, String property) {
		return ParameterProvider.getInstance().getParameter(fileName, property);
	}
	
	
	
	

}
