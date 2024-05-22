package com.testbook.mobile.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.testbook.mobile.base.TestBookBasePage;


public class TestBookWebLoginPage extends TestBookBasePage {

	@B2BFindBy(xpath = "{loginHeading}")
	private WebElement lblLoginHeading;

	@B2BFindBy(xpath = "{loginOrgCode}")
	private WebElement orgCode;

	@B2BFindBy(xpath = "{loginMobileNumber}")
	private WebElement loginInput;

	@B2BFindBy(xpath = "{btnProceedSecurely}")
	private WebElement btnProceedSecurely;

	@B2BFindBy(id = "{txtLoginOTP}")
	private WebElement otpInput;

	@B2BFindBy(xpath = "{btnVerifyOTP}")
	private WebElement verifyOTP;

	@B2BFindBy(xpath = "{btnProfileIcon}")
	private WebElement userProfileIcon;

	@B2BFindBy(xpath = "{btnProfile}")
	private WebElement btnProfile;

	@B2BFindBy(xpath = "{btnDashboard}")
	private WebElement dashboard;

	@B2BFindBy(xpath = "{btnLogout}")
	private WebElement logOut;

	@B2BFindBy(xpath = "{btnOk}")
	private WebElement ok;

	@B2BFindBy(xpath = "{lblUserName}")
	private WebElement lblTutorName;
	private static final Logger log = Logger.getLogger(TestBookWebLoginPage.class);

	public TestBookWebLoginPage(WebDriver driver) {
		super(driver);
		log.info("Starting TestBookWebLoginPage method");
		B2BPageFactory.initElements(driver, this);
		log.info("Ending TestBookWebLoginPage method");
	}

	public String getLoginHeadingText() {
		log.info("Starting getLoginHeadingText method");
		log.info("Ending getLoginHeadingText method");

		return lblLoginHeading.getText();
	}

	public void setOrgCode(String strOrgCode) {
		log.info("Starting setOrgCode method");

		this.orgCode.clear();
		this.orgCode.sendKeys(strOrgCode);

		log.info("Ending setOrgCode method");
	}

	public void setMobileNumber(String strMobileNumber) throws Exception {
		log.info("Starting setMobileNumber method");

		//this.explicitWait(loginInput);
		this.loginInput.clear();
		this.loginInput.sendKeys(strMobileNumber);

		log.info("Ending setMobileNumber method");
	}

	public void clickProceedSecurely() {
		log.info("Starting clickProceedSecurely method");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.btnProceedSecurely.click();

		log.info("Ending clickProceedSecurely method");
	}

	public boolean isEnabledProceedSecurelyButton() {
		log.info("Starting clickProceedSecurely method");
		log.info("Ending clickProceedSecurely method");

		return btnProceedSecurely.isEnabled();
	}

	public void loginToClassplusUsingMobileNumber(String strOrgCode, String strMobileNumber, String strEmailAddress) {
		
		log.info("Starting loginToClassplusUsingMobileNumber method");

		try {
			this.setOrgCode(strOrgCode);
			this.setMobileNumber(strMobileNumber);
		} catch (Exception e) {

			try {
				this.setMobileNumber(strMobileNumber);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (isEnabledProceedSecurelyButton() == true) {
			this.clickProceedSecurely();
		} else {
			this.hardWait(5);
			this.clickProceedSecurely();

		}

		log.info("Ending loginToClassplusUsingMobileNumber method");
	}

	public void setOTP(String strOTP) {
		log.info("Starting setOTP method");

		this.otpInput.sendKeys(strOTP);

		log.info("Ending setOTP method");
	}

	public boolean isEnabledVerifyOTP() {
		log.info("Starting isEnabledVerifyOTP method");
		log.info("Ending isEnabledVerifyOTP method");

		return verifyOTP.isEnabled();
	}

	public void clickVerifyOTP() {
		log.info("Starting clickVerifyOTP method");

		if (isEnabledVerifyOTP() == true) {
			clickOnWebElement(verifyOTP);
		} else {
			this.hardWait(5);
			this.verifyOTP.click();
		}

		log.info("Ending clickVerifyOTP method");
	}

	public void clickOnOk() {
		log.info("Starting of clickOnOK method");

		try {
			this.ok.click();
		} catch (Exception e) {
			this.clickOnWebElement(ok);
		}

		log.info("Ending of clickOnOk method");
	}

	public void clickOnLogOut() {
		log.info("Starting of clickOnLogOut method ");

		this.clickOnWebElement(userProfileIcon);
		this.clickOnWebElement(logOut);
		this.clickOnOk();

		log.info("Ending of clickOnLogOut method");
	}

	public void clickOnProfileIcon() {
		log.info("Starting of clickOnProfileIcon method ");

		try {
			this.userProfileIcon.click();
		} catch (Exception e) {
			this.clickOnWebElement(userProfileIcon);
		}

		log.info("Ending of clickOnProfileIcon method");
	}

	public void clickOnProfile() {
		log.info("Starting of clickOnProfile method ");

		try {
			this.btnProfile.click();
		} catch (Exception e) {
			this.explicitWait(btnProfile);
			this.clickOnWebElement(btnProfile);
		}

		log.info("Ending of clickOnProfile method");
	}

	public void clickDashboard() {
		log.info("Starting of clickDashboard method ");

		try {
			this.dashboard.click();
		} catch (Exception e) {
			this.clickOnWebElement(dashboard);
		}

		log.info("Ending of clickDashboard method");
	}
	public String getTutorNameText() {
		log.info("Starting of getTutorNameText method");
		log.info("Ending of getTutorNameText method");
		
		return lblTutorName.getText();
	} 

}
