package com.testbook.mobile.pages.login;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.b2b.mobile.pages.base.B2BVisualComparisionPage;
import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.testbook.mobile.base.TestBookBaseMobileAutomationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class TestBookMobileLoginPage extends TestBookBaseMobileAutomationPage {

	@B2BFindBy(xpath = "{tutorloginpage.btnnoneoftheabove.xpath}")
	private WebElement btnNoneOfTheAbove;

	@B2BFindBy(id = "{tutorloginpage.imginformation.id}")
	private WebElement imgInformation;

	@B2BFindBy(id = "{tutorloginpage.txtOrgId.id}")
	private WebElement txtOrgId;

	@B2BFindBy(id = "{tutorloginpage.txtOrgCode.id}")
	private WebElement txtOrgCode;

	@B2BFindBy(xpath = "{tutorloginpage.lblclpstaging.xpath}")
	private WebElement lblClpStaging;

	@B2BFindBy(xpath = "{tutorloginpage.lblloginorsignup.xpath}")
	private WebElement lblLoginOrSignUp;

	@B2BFindBy(xpath = "{tutorloginpage.lblverifynumber.xpath}")
	private WebElement lblVerifyNumber;

	@B2BFindBy(id = "{tutorloginpage.lblpopupdescription.id}")
	private WebElement lblPopUpDescription;

	@B2BFindBy(xpath = "{tutorloginpage.lblhometitle.xpath}")
	private WebElement lblHomeTitle;

	@B2BFindBy(id = "{tutorloginpage.txtmobilenumber.id}")
	private WebElement txtMobileNumber;

	@B2BFindBy(id = "{loginpage.lblRegistrationPageTitle.id}")
	private WebElement lblRegistrationPageTitle;

	@B2BFindBy(id = "{loginpage.btnLetsGetStarted.id}")
	private WebElement btnLetsGetStarted;

	@B2BFindBy(id = "{loginpage.lblNewEmail.id}")
	private WebElement lblNewEmail;

	@B2BFindBy(id = "{loginpage.tglSignUpAsParent.id}")
	private WebElement tglSignUpAsParent;

	@B2BFindBy(id = "{loginpage.lblLoginWithDifferentUser.id}")
	private WebElement lblLoginWithDifferentUser;

	@B2BFindBy(xpath = "{tutorloginpage.txtentermobilenumberfield.xpath}")
	private WebElement txtEnterMobileNumberField;

	@B2BFindBy(id = "{tutorloginpage.btnproceedsecurelybutton.id}")
	private WebElement btnProceedSecurelyButton;

	@B2BFindBy(id = "{loginpage.lblNewUserName.id}")
	private WebElement lblNewUserName;

	@B2BFindBy(id = "{loginpage.msgError.id}")
	private WebElement msgError;

	@B2BFindBy(id = "{loginpage.lblParentLoginHeader.id}")
	private WebElement lblParentLoginHeader;

	@B2BFindBy(id = "{loginpage.btnUnderstood.id}")
	private WebElement btnUnderstood;

	@B2BFindBy(id = "{loginpage.imgInfo.id}")
	private WebElement imgInfo;

	@B2BFindBy(id = "{loginpage.lblLoginAsDiffernetUser.id}")
	private WebElement lblLoginAsDiffernetUser;

	@B2BFindBy(id = "{loginpage.btnContinueWithMobileNumber.id}")
	private WebElement btnContinueWithMobileNumber;

	@B2BFindBy(id = "{loginpage.lblYourLoggingIn.id}")
	private WebElement lblYourLoggingIn;

	@B2BFindBy(id = "{loginpage.msgSnackBarTxt.id}")
	private WebElement msgSnackBarTxt;

	@B2BFindBy(id = "{loginpage.lblContinueWithEmail.id}")
	private WebElement lblContinueWithEmail;

	@B2BFindBy(id = "{loginpage.txtEnterEmailField.id}")
	private WebElement txtEnterEmailField;

	@B2BFindBy(id = "{loginpage.txtEmail.id}")
	private WebElement txtEmail;

	@B2BFindBy(id = "{tutorloginpage.txtotpfield.id}")
	private WebElement txtOTPField;

	@B2BFindBy(id = "{tutorloginpage.btnverifyotp.id}")
	private WebElement btnVerifyOTP;

	@B2BFindBy(id = "{tutorloginpage.btnchangeenvironment.id}")
	private WebElement btnChangeEnvironment;

	@B2BFindBy(xpath = "{tutorloginpage.rdopreprod.xpath}")
	private WebElement rdoPreprod;

	@B2BFindBy(xpath = "{tutorloginpage.rdoQA.xpath}")
	private WebElement rdoQA;

	@B2BFindBy(xpath = "{tutorloginpage.rdobaseurl.xpath}")
	private WebElement rdoBaseURL;

	@B2BFindBy(xpath = "{tutorloginpage.rdocamsurl.xpath}")
	private WebElement rdoCAMSURL;

	@B2BFindBy(xpath = "{tutorloginpage.rdourl.xpath}")
	private WebElement rdoURL;

	@B2BFindBy(xpath = "{tutorloginpage.rdochatsocketurl.xpath}")
	private WebElement rdoChatSocketURL;

	@B2BFindBy(xpath = "{tutorloginpage.rdoamschatsocketurl.xpath}")
	private WebElement rdoAMSChatSocketURL;

	@B2BFindBy(id = "{tutorloginpage.btnsave.id}")
	private WebElement btnSave;

	@B2BFindBy(id = "{tutorloginpage.btncloseaddpopup.id}")
	private WebElement btnCloseAddPopUp;

	@B2BFindBy(xpath = "{tutorloginpage.imgMenuBar.xpath}")
	private WebElement imgMenuBar;

	@B2BFindBy(xpath = "{tutorloginpage.lblSettings.xpath}")
	private WebElement lblSettings;

	@B2BFindBy(xpath = "{tutorloginpage.lblSignOut.xpath}")
	private WebElement lblSignOut;

	@B2BFindBy(id = "{tutorloginpage.btnCancel.id}")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "{tutorloginpage.btnSignOut.xpath}")
	private WebElement btnSignOut;

	@B2BFindBy(id = "{tutorloginpage.btnHome.id}")
	private WebElement btnHome;

	@B2BFindBy(xpath = "{tutorloginpage.navigateback.xpath}")
	private WebElement btnNavigateBack;

	@B2BFindBy(xpath = "{tutorloginpage.navigationback.xpath}")
	private WebElement btnNavigationBack;

	@B2BFindBy(xpath = "{tutorloginpage.btnsidedrawer.xpath}")
	private WebElement btnsidedrawer;

	@B2BFindBy(id = "{tutorloginpage.lbltutorname.id}")
	private WebElement lbltutorname;

	@B2BFindBy(id = "{tutorloginpage.lblUseAnotherMethod.id}")
	private WebElement lblUseAnotherMethod;

	@B2BFindBy(id = "{classplusLoginPage.lblLoginHeading.id}")
	private WebElement lblLoginHeading;

	@B2BFindBy(id = "{classplusLoginPage.lblOtpHeading.id}")
	private WebElement lblOtpHeading;

	@B2BFindBy(id = "{classplusLoginPage.lblClassplusHeading.id}")
	private WebElement lblClassplusHeading;

	@B2BFindBy(xpath = "{classplusLoginPage.btnSettings.xpath}")
	private WebElement btnSettings;

	@B2BFindBy(id = "{classplusLoginPage.imgProfile.id}")
	private WebElement imgProfile;

	@B2BFindBy(xpath = "{classplusLoginPage.lblOrgCode.xpath}")
	private WebElement lblOrgCode;

	@B2BFindBy(id = "{classplusLoginPage.btnSignout.id}")
	private WebElement btnSignout;

	@B2BFindBy(id = "{classplusLoginPage.lblSigout.id}")
	private WebElement lblSigoutMessage;

	@B2BFindBy(id = "{classplusLoginPage.btnConfirmSigout.id}")
	private WebElement btnConfirmSigout;

	@B2BFindBy(id = "{classplusLoginPage.lblContinue.id}")
	private WebElement lblContinue;

	@B2BFindBy(id = "{classplusLoginPage.btnLoginDifferentUser.id}")
	private WebElement btnLoginDifferentUser;

	@B2BFindBy(id = "{classplusLoginPage.btnExploreGuest.id}")
	private WebElement btnExploreGuest;

	@B2BFindBy(xpath = "{tutorloginpage.lstTabNames.xpath}")
	private List<WebElement> lstTabNames;

	@B2BFindBy(id = "{tutorloginpage.btnGusetSignUp.id}")
	private WebElement btnGuesttSignUp;

	@B2BFindBy(id = "{classplusLoginPage.btnContactSave.id}")
	private WebElement btnContactSave;

	@B2BFindBy(xpath = "{classplusLoginPage.txtContactNumber.xpath}")
	private WebElement txtContactNumber;

	@B2BFindBy(xpath = "{classplusLoginPage.txtFirstName.xpath}")
	private WebElement txtFirstName;

	@B2BFindBy(id = "{classplusLoginPage.btnAddContact.id}")
	private WebElement btnAddContact;

//	@B2BFindBy(xpath = "{classplusLoginPage.lstContacts.xpath}")
//	private List<WebElement> lstContacts;

	@B2BFindBy(id = "{classplusLoginPage.icnSearch.id}")
	private WebElement icnSearch;

	@B2BFindBy(id = "{classplusLoginPage.txtSearch.id}")
	private WebElement txtSearch;

	@B2BFindBy(xpath = "{classplusLoginPage.btnThreeDots.xpath}")
	private WebElement btnThreeDots;

	@B2BFindBy(xpath = "{classplusLoginPage.btnDeleteContact.xpath}")
	private WebElement btnDeleteContact;

	@B2BFindBy(id = "{classplusLoginPage.lblSignOutHeader.id}")
	private WebElement lblSignOutHeader;

	@B2BFindBy(id = "{classplusLoginPage.lnkTermsAndCodtion.id}")
	private WebElement lnkTermsAndCodtion;

	@B2BFindBy(xpath = "{classplusLoginPage.lblTermsAndCondition.xpath}")
	private WebElement lblTermsAndCondition;

	@B2BFindBy(xpath = "{classplusLoginPage.lblPrivacyPolicy.xpath}")
	private WebElement lblPrivacyPolicy;

	@B2BFindBy(id = "{classplusLoginPage.btnPrivacyPolicy.id}")
	private WebElement btnPrivacyPolicy;

	@B2BFindBy(id = "{classplusLoginPage.btnShare.id}")
	private WebElement btnShare;

	@B2BFindBy(xpath = "{classplusLoginPage.lblShareScreenPop.xpath}")
	private WebElement lblShareScreenPop;

	@B2BFindBy(xpath = "{classplusLoginPage.btnOnce.xpath}")
	private WebElement btnOnce;

	@B2BFindBy(xpath = "{classplusLoginPage.btnAlways.xpath}")
	private WebElement btnAlways;

	@B2BFindBy(id = "{classplusLoginPage.btnNotification.id}")
	private WebElement btnNotification;

	@B2BFindBy(xpath = "{classplusLoginPage.lblDefault.xpath}")
	private WebElement lblDefault;

	@B2BFindBy(id = "{classplusLoginPage.btnGoToSettings.id}")
	private WebElement btnGoToSettings;

	@B2BFindBy(id = "{classplusLoginPage.btnConfirmDelete.id}")
	private WebElement btnConfirmDelete;

	@B2BFindBy(id = "{classplusLoginPage.lblEnterNumberEmail}")
	private WebElement lblEnterNumberEmail;

	@B2BFindBy(id = "{classplusLoginPage.lblPhoneNumber}")
	private WebElement lblPhoneNumber;

	@B2BFindBy(id = "{TutorAndStudentPage.btnAllow.id}")
	private WebElement btnAllow;

	private String lstContacts = "(//android.widget.TextView[contains(@content-desc,'${text}')])[1]";
	public WebElement scrollToElement = null;

	public TestBookMobileLoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
		logger.info("Starting of TutorLoginPage method");

		B2BPageFactory.initElements(driver, this);
		visualComparisionPage = new B2BVisualComparisionPage(driver);

		logger.info("Ending of TutorLoginPage method");
	}

	private static final Logger logger = Logger.getLogger(TestBookMobileLoginPage.class);

	public void clickOnImgInfo() {
		logger.info("Starting of clickOnImgInfo method");

		// hardWait(2);
		// findElement(imgInformation, MOBILE_ACTIONS.CLICK);
		try {
			hardWait(5);
			this.imgInformation.click();
		} catch (Exception e) {
			hardWait(5);
			clickOnWebElement(imgInformation);
		}
		logger.info("Ending of clickOnImgInfo method");
	}

	public void clickOnCloseButton() {
		logger.info("Starting of clickOnCloseButton method");

		try {
			hardWait(2);
			// findElement(btnCloseAddPopUp, MOBILE_ACTIONS.CLICK);
			this.btnCloseAddPopUp.click();
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnCloseButton method");
	}

	public void clickOnChangeEnvironmentButton() {
		logger.info("Starting of clickOnChangeEnvironmentButton method");

		hardWait(2);
		this.btnChangeEnvironment.click();
		hardWait(3);
		setOrgText();

		this.rdoQA.click();
		/*
		 * try { this.verticalScroll(); } catch (InterruptedException e1) {
		 * e1.printStackTrace(); }
		 * 
		 * //this.rdoBaseURL.click(); //this.rdoCAMSURL.click();
		 * 
		 * try { this.verticalScroll(); } catch (InterruptedException e1) {
		 * e1.printStackTrace(); }
		 * 
		 * //this.rdoURL.click();
		 * 
		 * try { this.verticalScroll();
		 * 
		 * } catch (InterruptedException e1) { e1.printStackTrace(); }
		 * 
		 * //this.rdoChatSocketURL.click();
		 * 
		 * this.rdoChatSocketURL.click();
		 */

		try {
			this.verticalScroll();
			this.verticalScroll();
			this.verticalScroll();
			this.verticalScroll();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		this.btnSave.click();

		logger.info("Ending of clickOnChangeEnvironmentButton method");
	}

	public void clickOnNoneOfTheAbove() {
		logger.info("Starting of clickOnNoneOfTheAbove method");

		try {
			hardWait(8);
			// findElement(btnNoneOfTheAbove, MOBILE_ACTIONS.CLICK);
			this.btnNoneOfTheAbove.click();
		} catch (NoSuchElementException e) {

		}

		logger.info("Ending of clickOnNoneOfTheAbove method");
	}

	public void setMobileNumber(String mobilenumber) {
		logger.info("Starting of setMobileNumber method");
		hardWait(5);
		this.txtMobileNumber.click();
		hardWait(3);
		this.txtMobileNumber.clear();
		hardWait(4);
		this.explicitWait(txtMobileNumber);
//		JavascriptExecutor jse =( (JavascriptExecutor)driver);
//		jse.executeScript("arguments[0].value='"+mobilenumber+"';",txtMobileNumber);
		hardWait(4);
		this.txtMobileNumber.sendKeys(mobilenumber);
		hardWait(4);
		this.btnProceedSecurelyButton.click();

		logger.info("Ending of setMobileNumber method");
	}

	public void setOTP(String otp) {
		logger.info("Starting of setOTP method");

		hardWait(2);
		findElement(txtOTPField, MOBILE_ACTIONS.VISIBILE);
		this.txtOTPField.clear();
		this.txtOTPField.sendKeys(otp);
		this.btnVerifyOTP.click();
		hardWait(5);

		logger.info("Ending of setOTP method");
	}

//	public String getLblClpStagingText() {
//		logger.info("Starting of getLblClpStagingText method");
//		logger.info("Ending of getLblClpStagingText method");
//
//		return lblClpStaging.getText();
//	}

	public String getLblLoginOrSignUpText() {
		logger.info("Starting of getLblLoginOrSignUpText method");

		findElement(lblLoginOrSignUp, MOBILE_ACTIONS.VISIBILE);

		logger.info("Ending of getLblLoginOrSignUpText method");

		return lblLoginOrSignUp.getText();
	}

	public String getLblVerifyNumberText() {
		logger.info("Starting of getLblVerifyNumberText method");
		logger.info("Ending of getLblVerifyNumberText method");

		return lblVerifyNumber.getText();
	}

	public String getLblPopUpDescriptionText() {
		logger.info("Starting of getLblPopUpDescriptionText method");

		hardWait(2);
		findElement(lblPopUpDescription, MOBILE_ACTIONS.VISIBILE);

		logger.info("Ending of getLblPopUpDescriptionText method");

		return lblPopUpDescription.getText();
	}

	public String getLblHomeTitleText() {
		logger.info("Starting of getLblHomeTitleText method");

		hardWait(2);

		logger.info("Ending of getLblHomeTitleText method");

		return lblHomeTitle.getText();
	}

	public void setOrgText() {
		logger.info("Starting of setOrgText method");

		hardWait(5);
		txtOrgId.clear();
		txtOrgId.sendKeys("170");
		txtOrgCode.clear();
		txtOrgCode.sendKeys("learn");

		logger.info("Ending of setOrgText method");

	}

	public void clickOnSideDrawer() {
		logger.info("Starting of clickOnSideDrawer method");

		hardWait(3);
		this.btnsidedrawer.click();

		logger.info("Ending of clickOnSideDrawer method");
	}

	public String getTutorNameText() {
		logger.info("Starting of getTutorNameText method");
		logger.info("Ending of getTutorNameText method");

		this.clickOnMenuBar();
		return lbltutorname.getText();
	}

	public String getUserName() {
		logger.info("Starting of getTutorName method");
		logger.info("Ending of getTutorName method");

		return lbltutorname.getText();
	}

	public String getGuestNameText() {
		logger.info("Starting of getGuestNameText method");

		hardWait(4);

		logger.info("Ending of getGuestNameText method");

		return lbltutorname.getText();
	}

	public void clickOnSideScreen() {
		logger.info("Starting of clickOnSideScreen method");

		hardWait(3);
		this.horizontalScroll();

		logger.info("Ending of clickOnSideScreen method");
	}

	public void loginToClassplusUsingMobileNumber(String strMobileNumber, String strOTP) {
		logger.info("Starting of LoginToClassplusUsingMobileNumber method");

		try {
			hardWait(8);
			this.clickOnImgInfo();
			this.clickOnChangeEnvironmentButton();
			hardWait(8);
			// this.clickOnNoneOfTheAbove();
		} catch (Exception e) {
			logger.debug(e);
		}
		try {
			this.clickOnUseAnotherMethodLabel();
		} catch (Exception e) {
			logger.debug(e);
		}
		try {
			this.setMobileNumber(strMobileNumber);
			this.setOTP(strOTP);
			hardWait(8);
			if (strMobileNumber.equals("9871389116")) {
				this.clickOnCloseButton();
			}
		} catch (Exception e) {
			logger.debug(e);

		}
		logger.info("Ending of LoginToClassplusUsingMobileNumber method");
	}

	private void clickOnUseAnotherMethod() {
		logger.info("Starting of clickOnUseAnotherMethod method");
		try {
			hardWait(3);
			this.lblUseAnotherMethod.click();
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnUseAnotherMethod method");

	}

	public void clickOnMenuBar() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.imgMenuBar.click();

		logger.info("Ending of clickOnMenuBar method");
	}

	public void clickOnSettingsButton() {
		logger.info("Starting of clickOnSettingsButton method");

		try {

			scrollToElement = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Settings\"));\""));

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.lblSettings.click();

		logger.info("Ending of clickOnSettingsButton method");
	}

	public void clickOnSignOutLabel() {
		logger.info("Starting of clickOnSignOutButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.lblSignOut.click();

		logger.info("Ending of clickOnSignOutButton method");
	}

	public void clickOnCancelButton() {
		logger.info("Starting of clickOnCancelButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.btnCancel.click();

		logger.info("Ending of clickOnCancelButton method");
	}

	public void clickOnSignOutButton() {
		logger.info("Starting of clickOnSignOutButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.btnSignOut.click();

		logger.info("Ending of clickOnSignOutButton method");

	}

	public void clickOnSignOut() {
		logger.info("Starting of clickOnSignOut method");

		this.clickOnMenuBar();
		this.clickOnSettingsButton();
		this.clickOnSignOutLabel();
		this.clickOnSignOutButton();

		logger.info("Ending of clickOnSignOut method");
	}

	public void moveToHomeTab() {
		logger.info("Starting of moveToHomeTab method");

		hardWait(2);
		for (int i = 1; i < 7; i++) {
			if (isHomeTab()) {
				break;
			}
			// clickOnBack();
			// btnNavigateBack.click();
			driver.navigate().back();
		}

		logger.info("Ending moveToHomeTab method");
	}

	public void moveToStudentHomeTab() {
		logger.info("Starting of moveToStudentHomeTab method");
		logger.info("Ending moveToStudentHomeTab method");

		for (int i = 1; i < 5; i++) {
			if (isHomeTab()) {
				break;
			}
			// clickOnBack();
			btnNavigationBack.click();
		}
	}

	public boolean isHomeTab() {
		logger.info("starting of isHomeTab method");
		logger.info("Ending of isHomeTab method");

		try {
			this.hardWait(2);
			return this.btnHome.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnHomeTab() {
		logger.info("starting of clickOnHomeTab method");
		logger.info("Ending of clickOnHomeTab method");

		try {
			this.hardWait(4);
			this.btnHome.click();

		} catch (Exception e) {
			clickOnElement(btnHome);
		}
	}

	public String getLoginHeadingText() {
		logger.info("Starting of getLoginHeadingText method");
		logger.info("Ending of getLoginHeadingText method");

		hardWait(3);
		explicitWait(lblLoginHeading);
		return lblLoginHeading.getText();
	}

	public void clickOnLoginWithDifferentUser() {
		logger.info("starting of clickOnLoginWithDifferentUser method");

		this.lblLoginWithDifferentUser.click();

		logger.info("Ending of clickOnLoginWithDifferentUser method");
	}

	public void clickOnContinueWithEmail() {
		logger.info("starting of clickOnContinueWithEmail method");

		this.lblContinueWithEmail.click();

		logger.info("Ending of clickOnContinueWithEmail method");
	}

	/*
	 * public String setEmail() { logger.info("starting of setEmail method");
	 * 
	 * hardWait(2); this.txtEmail.click(); findElement(txtEnterEmailField,
	 * MOBILE_ACTIONS.VISIBILE); this.getElementIfVisible(driver,
	 * txtEnterEmailField); this.txtEnterEmailField.sendKeys(emailAddress);
	 * this.btnProceedSecurelyButton.click();
	 * 
	 * logger.info("Ending of setEmail method"); }
	 */
	public String getRegistrationPageTitle() {
		logger.info("starting of getRegistrationPageTitle method");
		logger.info("Ending of getRegistrationPageTitle method");

		return lblRegistrationPageTitle.getText();
	}

	public boolean isDisableStateLetsGetStarted() {
		logger.info("starting of isDisableStateLetsGetStarted method");
		logger.info("Ending of isDisableStateLetsGetStarted method");

		return btnLetsGetStarted.isEnabled();
	}

	public void setEmailInRegistrationPage(String property) {
		logger.info("starting of setEmailInRegistrationPage method");

		this.lblNewEmail.click();
		this.lblNewEmail.sendKeys();

		logger.info("ending of setEmailInRegistrationPage method");
	}

	public void clickOnToggleSignUpAsParent() {
		logger.info("starting of setEmail method");

		this.tglSignUpAsParent.click();

		logger.info("ending of setEmail method");

	}

	public void clickOnLetsGetStartedButton() {
		logger.info("starting of setEmail method");

		this.btnLetsGetStarted.click();

		logger.info("ending of setEmail method");

	}

	public void setNameInRegistrationPage(String randomAlphabetic) {
		logger.info("starting of setNameInRegistrationPage method");

		this.lblNewUserName.click();
		this.lblNewUserName.sendKeys(randomAlphabetic);

		logger.info("ending of setNameInRegistrationPage method");

	}

	public String getErrorToastTxt() {
		logger.info("starting of getErrorToastTxt method");
		logger.info("ending of getErrorToastTxt method");
		hardWait(5);

		return msgError.getText();
	}

	public String getParentLoginPopUpHearder() {
		logger.info("starting of getCountryCode method");
		logger.info("ending of getCountryCode method");
		hardWait(5);

		return lblParentLoginHeader.getText();
	}

	public String isDisplayedUnderstoodButton() {
		logger.info("starting of isDisplayedUnderstoodButton method");
		logger.info("ending of isDisplayedUnderstoodButton method");
		hardWait(5);

		return btnUnderstood.getText();
	}

	public void clickOnIIcon() {
		logger.info("starting of clickOnIIcon method");

		this.imgInfo.click();

		logger.info("ending of clickOnIIcon method");
	}

	public boolean isParentRegistrationToggleEnable() {
		logger.info("starting of isParentRegistrationToggleEnable method");
		logger.info("ending of isParentRegistrationToggleEnable method");
		hardWait(5);

		return tglSignUpAsParent.isEnabled();
	}

	public String getLoginAsDifferentUser() {
		logger.info("starting of getLoginAsDifferentUser method");
		logger.info("ending of getLoginAsDifferentUser method");

		return this.lblLoginAsDiffernetUser.getText();
	}

	public void clickOnLoginAsDifferntUser() {
		logger.info("starting of clickOnLoginAsDifferntUser method");

		this.lblLoginAsDiffernetUser.click();

		logger.info("ending of clickOnLoginAsDifferntUser method");
	}

	public String getContinueWithMobileNumber() {
		logger.info("starting of getContinueWithMobileNumber method");
		logger.info("ending of getContinueWithMobileNumber method");

		System.out.println(btnContinueWithMobileNumber.getText());
		return this.btnContinueWithMobileNumber.getText();
	}

	public void clickOnContinueWithButton() {
		logger.info("starting of clickOnContinueWithButton method");
		logger.info("ending of clickOnContinueWithButton method");

		this.btnContinueWithMobileNumber.click();

	}

	public String getYourLoggingInTxt() {
		logger.info("starting of getYourLoggingInTxt method");
		logger.info("ending of getYourLoggingInTxt method");

		return this.lblYourLoggingIn.getText();
	}

	public String getSnackBarTxt() {
		logger.info("starting of getSnackBarTxt method");
		logger.info("ending of getYourLoggingInTxt method");

		return this.msgSnackBarTxt.getText();
	}

	public String getOTPHeadingText() {
		logger.info("Starting of getOTPHeadingText method");
		logger.info("Ending of getOTPHeadingText method");

		explicitWait(lblOtpHeading);
		return lblOtpHeading.getText();
	}

	public String getClassplusHeadingText() {
		logger.info("Starting of getClassplusHeadingText method");
		logger.info("Ending of getClassplusHeadingText method");

		explicitWait(lblClassplusHeading);
		return lblClassplusHeading.getText();
	}

	public String getSettingsText(String text) {
		logger.info("Starting of getSettingsText method");
		logger.info("Ending of getSettingsText method");

		androidScrollUsingText(text);
		explicitWait(btnSettings);
		return btnSettings.getText();
	}

	public String getSettingsText() {
		logger.info("Starting of getSettingsText method");
		logger.info("Ending of getSettingsText method");

		explicitWait(btnSettings);
		return btnSettings.getText();
	}

	public void clickOnSignout() {
		logger.info("Starting of clickOnSignout method");

		hardWait(2);
		try {
			this.btnSignout.click();
		} catch (Exception e) {
			clickOnWebElement(btnSignout);
		}

		logger.info("Ending of clickOnSignout method");
	}

	public String getSignoutPopupText() {
		logger.info("Starting of getSignoutPopupText method");
		logger.info("Ending of getSignoutPopupText method");

		explicitWait(lblSigoutMessage);
		return lblSigoutMessage.getText();
	}

	public void clickOnConfirmSignout() {
		logger.info("Starting of clickOnSignout method");

		hardWait(2);
		try {
			this.btnConfirmSigout.click();
		} catch (Exception e) {
			clickOnWebElement(btnConfirmSigout);
		}

		logger.info("Ending of clickOnSignout method");
	}

	public String getContinueText() {
		logger.info("Starting of getContinueText method");
		logger.info("Ending of getContinueText method");

		explicitWait(lblContinue);
		return lblContinue.getText();
	}

	public void clickOnSigninWithDifferentUserText() {
		logger.info("Starting of clickOnSigninWithDifferentUserText method");

		hardWait(2);
		try {
			this.btnLoginDifferentUser.click();
		} catch (Exception e) {
			clickOnWebElement(btnLoginDifferentUser);
		}

		logger.info("Ending of clickOnSigninWithDifferentUserText method");
	}

	public boolean isDisplayedHomeTitleLabel() {

		try {
			return lblHomeTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSettings() {
		logger.info("Starting of clickOnSettings method");

		hardWait(2);
		try {
			this.btnSettings.click();
		} catch (Exception e) {
			clickOnWebElement(btnSettings);
		}

		logger.info("Ending of clickOnSettings method");
	}

	public boolean isDisplayedProfileImage() {
		logger.info("Starting of isDisplayedProfileImage method");
		logger.info("Ending of isDisplayedProfileImage method");

		try {
			return imgProfile.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnExploreGuestButton() {
		logger.info("Starting of clickOnExploreGuestButton method");

		try {
			hardWait(2);
			findElement(btnExploreGuest, MOBILE_ACTIONS.CLICK);
			this.btnExploreGuest.click();
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnExploreGuestButton method");
	}

	public String getExploreGuestText() {
		logger.info("Starting of getExploreGuestText method");
		logger.info("Ending of getExploreGuestText method");

		explicitWait(btnExploreGuest);
		return btnExploreGuest.getText();
	}

	public List<String> getTabsListText() {
		logger.info("Starting of getTabsListText method");

		hardWait(5);
		List<String> tabNames = new ArrayList<>();
		for (WebElement e : lstTabNames)
			tabNames.add(e.getAttribute("content-desc"));

		logger.info("Ending of getTabsListText method");

		return tabNames;
	}

	public String getGuestSignupText() {
		logger.info("Starting of getGuestSignupText method");
		logger.info("Ending of getGuestSignupText method");

		explicitWait(btnGuesttSignUp);
		return btnGuesttSignUp.getText();
	}

	public void clickOnGuestSignupButton() {
		logger.info("Starting of clickOnGuestSignupButton method");

		try {
			hardWait(2);
			findElement(btnGuesttSignUp, MOBILE_ACTIONS.CLICK);
			this.btnGuesttSignUp.click();
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnGuestSignupButton method");
	}

	public void clickOnAddContactButton() {
		logger.info("Starting of clickOnAddContactButton method");

		hardWait(5);
		this.explicitWait(btnAddContact);
		this.btnAddContact.click();

		logger.info("Ending of clickOnAddContactButton method");
	}

	public void setFirstName(String firstName) {
		logger.info("Starting of setFirstName method");

		hardWait(6);
		this.explicitWait(txtFirstName);
		this.txtFirstName.click();
		this.txtFirstName.clear();
		this.txtFirstName.sendKeys(firstName);
		driver.hideKeyboard();

		logger.info("Ending of setFirstName method");
	}

	public void setContactNumber(String number) {
		logger.info("Starting of setContactNumber method");

		try {
			verticalScroll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hardWait(6);
		this.txtContactNumber.click();
		this.txtContactNumber.clear();
		this.txtContactNumber.sendKeys(number);
		driver.hideKeyboard();

		logger.info("Ending of setContactNumber method");
	}

	public void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton method");

		hardWait(3);
		this.explicitWait(btnContactSave);
		this.btnContactSave.click();
		hardWait(3);

		logger.info("Ending of clickOnSaveButton method");
	}

	public void clickOnSearchContactsButton() {
		logger.info("Starting of clickOnSearchContactsButton method");

		hardWait(3);
		this.explicitWait(icnSearch);
		this.icnSearch.click();

		logger.info("Ending of clickOnSearchContactsButton method");
	}

	public void clickOnDeleteCOntacts() {
		logger.info("Starting of clickOnDeleteCOntacts method");

		try {
			hardWait(4);
			btnThreeDots.click();
			hardWait(4);
			btnDeleteContact.click();
			hardWait(4);
			btnConfirmDelete.click();
		} catch (NoSuchElementException e) {
			driver.navigate().back();
			// TODO: handle exception
		}
		logger.info("Ending of clickOnDeleteCOntacts method");
	}

	public void setSearchContact(String firstName) {
		logger.info("Starting of setSearchContact method");

		hardWait(6);
		this.explicitWait(txtSearch);
		this.txtSearch.click();
		this.txtSearch.clear();
		this.txtSearch.sendKeys(firstName);
		driver.hideKeyboard();

		logger.info("Ending of setSearchContact method");
	}

	public boolean isContactsDispalyed(String name) {
		logger.info("Starting of isContactsDispalyed method");

		hardWait(6);
		try {
			return driver.findElements(By.xpath(lstContacts.replace("${text}", name))).get(0).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getOrgCodeText() {
		logger.info("starting of getOrgCodeText method");
		logger.info("ending of getOrgCodeText method");

		return this.lblOrgCode.getText();
	}

	public void deleteAllSearchedContacts(String name) {
		logger.info("Starting of deleteAllSearchedContacts method");
		List<WebElement> contactlist = driver.findElements(By.xpath(lstContacts.replace("${text}", name)));

		hardWait(3);
		if (contactlist.size() > 0) {
			System.out.println("list size******************" + contactlist.size());
			for (int i = 0; i < contactlist.size(); i++) {
				hardWait(5);
				contactlist.get(0).click();
				clickOnDeleteCOntacts();
			}

		}

		logger.info("Ending of deleteAllSearchedContacts method");
	}

	public void clickOnUseAnotherMethodLabel() {
		logger.info("Starting of clickOnUseAnotherMethodLabel method");
		try {
			hardWait(5);
			lblUseAnotherMethod.click();
		} catch (NoSuchElementException e) {

		}

		logger.info("Ending of clickOnUseAnotherMethodLabel�method");
	}

	public String getSignOutHeaderText() {
		logger.info("starting of getSignOutHeaderText method");
		logger.info("ending of getSignOutHeaderText method");

		return this.lblSignOutHeader.getText().trim();
	}

	public boolean isDisplayedSignOutHeaderText() {
		logger.info("starting of isDisplayedSignOutHeaderText method");
		logger.info("ending of isDisplayedSignOutHeaderText method");
		try {
			return this.lblSignOutHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getCancelButtonText() {
		logger.info("starting of getSignOutHeaderText method");
		logger.info("ending of getSignOutHeaderText method");

		return this.btnCancel.getText();
	}

	public String getSignOutButtonText() {
		logger.info("starting of getSignOutHeaderText method");
		logger.info("ending of getSignOutHeaderText method");

		return this.btnSignOut.getText();
	}

	public void clickOnTermsAndCondition() {
		logger.info("Starting of clickOnTermsAndCondition method");
		try {
			this.lnkTermsAndCodtion.click();
		} catch (Exception e) {
			this.clickOnWebElement(lnkTermsAndCodtion);

		}

		logger.info("Ending of clickOnTermsAndCondition method");

	}

	public String getTermsAndConditionText() {
		logger.info("Starting of getTermsAndConditionText method");
		logger.info("Ending of getTermsAndConditionText method");

		return this.lblTermsAndCondition.getText();
	}

	public void clickOnPrivacyPolicy() {
		logger.info("Starting of clickOnPrivacyPolicy method");

		this.btnPrivacyPolicy.click();

		logger.info("Ending of clickOnPrivacyPolicy method");

	}

	public String getPrivacyPolicyText() {
		logger.info("starting of getSignOutHeaderText method");
		logger.info("ending of getSignOutHeaderText method");

		return this.lblPrivacyPolicy.getText();
	}

	public void clickOnShareButton() {
		logger.info("Starting of clickOnShareButton method");

		this.btnShare.click();

		logger.info("Ending of clickOnShareButton method");

	}

	public String getJustOnceButtonText() {
		logger.info("starting of getJustOnceButtonText method");
		logger.info("ending of getJustOnceButtonText method");

		return this.btnOnce.getText();
	}

	public String getAlwaysButtonText() {
		logger.info("starting of getAlwaysButtonText method");
		logger.info("ending of getAlwaysButtonText method");

		return this.btnAlways.getText();
	}

	public String getShareScreenPopUpText() {
		logger.info("starting of getSignOutHeaderText method");
		logger.info("ending of getSignOutHeaderText method");

		return this.lblShareScreenPop.getText();
	}

	public void clickOnNotificationButton() {
		logger.info("Starting of clickOnNotificationButton method");

		this.btnNotification.click();

		logger.info("Ending of clickOnNotificationButton method");

	}

	public String getDefaultNotificationText() {
		logger.info("starting of getDefaultNotificationText method");
		logger.info("ending of getDefaultNotificationText method");

		hardWait(5);
		return this.lblDefault.getText();
	}

	public void clickOnGoToSettingsButton() {
		logger.info("Starting of clickOnGoToSettingsButton method");

		this.btnGoToSettings.click();

		logger.info("Ending of clickOnGoToSettingsButton method");

	}

	public void clickOnAllow() {
		logger.info("Starting of clickOnAllow method");

		this.btnAllow.click();

		logger.info("Ending of clickOnAllow method");

	}
}
