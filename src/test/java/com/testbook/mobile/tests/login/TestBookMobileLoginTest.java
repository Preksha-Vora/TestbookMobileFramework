package com.testbook.mobile.tests.login;




import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.b2b.vo.B2BMobileConfigurationVO;
import com.testbook.mobile.pages.login.TestBookMobileLoginPage;
import com.testbook.mobile.pages.login.TestBookWebLoginPage;
import com.testbook.mobile.tests.base.TestBookBaseMobileAutomationTest;
import com.testbook.mobile.utils.TakeScreenshot;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login")
@Feature("User Login")
public class TestBookMobileLoginTest extends TestBookBaseMobileAutomationTest {
	private static final Logger logger = Logger.getLogger(TestBookMobileLoginTest.class);
	TestBookMobileLoginPage tutorLoginPage = null;
	Method method= null;
	
	
	@BeforeClass
	@Parameters({ "deviceName_one", "udid_one", "platformName_one", "platformVersion_one", "url","clientApiKey","browser","otp"})
	public void initClass(String deviceName_one, String udid_one, String platformName_one, String platformVersion_one,String url,String clientApiKey,String browser,String otp) throws Exception {
		logger.info("Starting of LoginClass method in LoginTest");

		B2BMobileConfigurationVO mobileConfigurationVO = new B2BMobileConfigurationVO(deviceName_one, udid_one, platformName_one,platformVersion_one,clientApiKey);
		this.initMobileDriver(mobileConfigurationVO,url);
		
		this.tutorLoginPage = new TestBookMobileLoginPage(this.getMobileDriver(udid_one));
	//	this.tutorLoginPage.loginToClassplusUsingMobileNumber(TUTOR_MOBILE, otp);

		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Change Environment in CLP-Staging")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify Change Environment in CLP-Staging")
	@Story("Verify Change Environment in CLP-Staging")
	public void testChangeEnvironment() {
		logger.info("Starting of testChangeEnvironment method ");

		try {
			
			tutorLoginPage.clickOnImgInfo();
			tutorLoginPage.clickOnChangeEnvironmentButton();
			tutorLoginPage.clickOnNoneOfTheAbove();
			
			// Assertion for LoginOrSignUp Page Title
			String lblLoginOrSignUp = tutorLoginPage.getLblLoginOrSignUpText();
			Assert.assertEquals(lblLoginOrSignUp, expectedAssertionsProp.getProperty("login.or.signup"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Change Environment : " + e.getMessage());
			logger.error("Error occured while testing Change Environment ", e);
		}

		logger.info("Ending of testChangeEnvironment method");
	}

	@Test(priority = 2, description = " Verify Login With Valid Number in Login or SignUp Page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:  Verify Login With Valid Number in Login or SignUp Page")
	@Story("Verify Login With Valid Number in Login or SignUp")
	public void testLoginWithValidNumber() {
		logger.info("Starting of testLoginWithValidNumber method");

		try {
			tutorLoginPage.clickOnUseAnotherMethodLabel();
			tutorLoginPage.setMobileNumber(TUTOR_MOBILE);

			// Assertion for Verify Your Mobile Number Page Title
			String lblverifyNumber = tutorLoginPage.getLblVerifyNumberText();
			Assert.assertEquals(lblverifyNumber, expectedAssertionsProp.getProperty("verify.your.mobilenumber"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Login With Valid Number : " + e.getMessage());
			logger.error("Error occured while testing Login With Valid Number", e);
		}

		logger.info("Ending of testLoginWithValidNumber method");
	}

	
	@Test(priority = 3, description = "Verify OTP")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify OTP")
	@Story("Verify OTP")
	public void testVerifyOTP() {
		logger.info("Starting of testVerifyOTP method");

		try {
			tutorLoginPage.setOTP(testDataProp.getProperty("otp.text"));

			// Assertion for CongratesInfo PopUp Page Info
			String lblCongratesInfoPopUp = tutorLoginPage.getLblPopUpDescriptionText();
			Assert.assertEquals(lblCongratesInfoPopUp, expectedAssertionsProp.getProperty("congratesInfo.popup"));

			tutorLoginPage.clickOnCloseButton();

			// Assertion for btnClose in PopUp Page Info
			String btnClose = tutorLoginPage.getLblHomeTitleText();
			Assert.assertEquals(btnClose, expectedAssertionsProp.getProperty("homePage.title"));
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify OTP : " + e.getMessage());
			logger.error("Error occured while testing  Verify OTP ", e);
		}

		logger.info("Ending of testVerifyOTP method");
	}
	
	@AfterMethod
	@Parameters({"udid_one"})
	public void take_screenshot_on_failure(ITestResult result, String udid_one) throws Exception {

		TakeScreenshot takescreenshot = new TakeScreenshot(this.getClass().getName(), this.getMobileDriver(udid_one));
		takescreenshot.takeScreenShotOnException(result);
	}
	
	@Parameters({ "udid_one" })
	@AfterClass
	public void quitDriver(String udid1) {
		logger.info("Starting of quitDriver method in LoginTest");
		try {
			quitMobileDriver(udid1);
		} catch (Exception e) {
			logger.error("Error occured while testing quitDriver", e);
		}
		logger.info("Ending of quitDriver method in LoginTest"); 
	}
}
