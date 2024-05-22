/**
 * 
 */
package com.testbook.mobile.tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import com.b2b.support.ParameterProvider;
import com.testbook.mobile.pages.login.TestBookWebLoginPage;


public class TestBookLoginBaseTest extends TestBookBaseMobileAutomationTest {
	private static final Logger log = Logger.getLogger(TestBookLoginBaseTest.class);

	protected TestBookWebLoginPage loginPage;

	/*
	 * public void launchWebSite(WebDriver webDriver) throws Exception {
	 * super.launchWebSite(webDriver); this.loginPage = new
	 * ClassplusWebLoginPage(webDriver); }
	 */

	public void siteLogin(String strOrgCode, String strMobileNumber, String strEmailAddress, WebDriver driver) {
		log.info("Starting siteLogin method");

		driver.get(loginURL);
		this.loginPage.clickOutside();
		this.loginPage.loginToClassplusUsingMobileNumber(strOrgCode, strMobileNumber, strEmailAddress);

		log.info("Ending siteLogin method");
	}

	public void logOut() {
		// this.loginPage.logOut();
	}

	public String getProperty(String fileName, String property) {
		return ParameterProvider.getInstance().getParameter(fileName, property);
	}

}