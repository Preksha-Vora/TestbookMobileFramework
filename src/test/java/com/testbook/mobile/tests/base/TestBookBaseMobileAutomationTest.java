package com.testbook.mobile.tests.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.b2b.mobile.tests.base.B2BBaseMobileAutomationTest;
import com.b2b.vo.B2BMobileConfigurationVO;
import com.testbook.mobile.pages.login.TestBookMobileLoginPage;
import com.testbook.mobile.pages.login.TestBookWebLoginPage;
import com.testbook.mobile.utils.B2BConstants;
import com.testbook.mobile.utils.TakeScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBookBaseMobileAutomationTest extends B2BBaseMobileAutomationTest {

	private TestBookMobileLoginPage mobileLoginPage = null;
	private TestBookWebLoginPage webLoginPage = null;

	protected String loginURL = null;
	protected WebDriver web_driver = null;
	protected String time = null;
	Dimension size;
	protected List<WebDriver> lstWebDriver = new ArrayList<WebDriver>();
	protected List<WebDriver> lstAppiumDriver = new ArrayList<WebDriver>();

	private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();

	private static final Logger logger = Logger.getLogger(TestBookBaseMobileAutomationTest.class);
	protected WebDriver childWebDriver = null;
	protected AndroidDriver<WebElement> android_driver = null;
	protected TestBookMobileLoginPage classplusLoginPage = null;
	static String CODE = "learn";
	protected static String EMAIL = "gunjan@classplusappp.com";
	protected static String TUTOR_NUMBER = "9871389116";
	protected static String FACULTY_NUMBER = "8010453789";
	protected static String STUDENT_NUMBER = "9502247373";
	protected static String PARENT_NUMBER = "9716110240";
	protected static Properties runDataProp = null;
	
	protected static final String ORG_CODE = ((System.getProperty("wl_org_code") == null)) ? CODE
			: (System.getProperty("wl_org_code"));

	protected static final String emailAddress = ((System.getProperty("wl_email_address") == null)) ? EMAIL
			: System.getProperty("wl_email_address");

	protected static final String TUTOR_MOBILE = System.getProperty("wl_tutor_mobile_number") != null
			? System.getProperty("wl_tutor_mobile_number")
			: "9871389116";

	protected static final String FACULTY_MOBILE = System.getProperty("wl_faculty_mobile_number") != null
			? System.getProperty("wl_faculty_mobile_number")
			: "8010453789";

	protected static final String STUDENT_MOBILE = System.getProperty("wl_student_mobile_number") != null
			? System.getProperty("wl_student_mobile_number")
			: "9502247373";

	protected static final String PARENT_MOBILE = System.getProperty("wl_parent_mobile_number") != null
			? System.getProperty("wl_parent_mobile_number")
			: "9716110240";

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "language" })
	public void initAutomation(@Optional("en") String language) {
		logger.info("inside inti automation method");

		this.initApplication(language);
		if (runDataProp == null) {
			FileReader runDataReader = null;

			try {
				runDataReader = new FileReader("src/main/resources/runtime.properties");

				runDataProp = new Properties();
				runDataProp.load(runDataReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					runDataReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		logger.debug("Site URL :{} ");
		logger.info("inside inti automation method");
	}
	
	

	public enum WEB_DRIVER {

		TUTOR_DRIVER, STUDENT_ONE_DRIVER, STUDENT_TWO_DRIVER, TUTOR_SETTING_TEST;
	}


	protected synchronized WebDriver getWebDriver(String browser) {
		logger.info("Starting of method getWebDriver");

		String osPath = System.getProperty("os.name");

		if (osPath.contains("Linux")) {

			if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				// chromeOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("allow-file-access-from-files");
				firefoxOptions.addArguments("use-fake-device-for-media-stream");
				firefoxOptions.addArguments("use-fake-ui-for-media-stream");
				web_driver = new FirefoxDriver(firefoxOptions);
			} else if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");
			

				web_driver = new ChromeDriver(chromeOptions);
			}
		} else if (osPath.contains("Mac OS X")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				//WebDriverManager.chromedriver().setup();
				System.setProperty("webdriver.chrome.driver", BASE_DIR+"/src/main/resources/driver/chromedriver");
				ChromeOptions options = new ChromeOptions();

				options.setHeadless(false);
				options.addArguments("--no-sandbox");
				options.addArguments("allow-file-access-from-files");
				options.addArguments("use-fake-device-for-media-stream");
				options.addArguments("use-fake-ui-for-media-stream");
				web_driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				web_driver = new FirefoxDriver();

			}
		} else {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(false);

				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");
				chromeOptions.addArguments("--remote-allow-origins=*");
				
				chromeOptions.addArguments("--no-sandbox");
				web_driver = new ChromeDriver(chromeOptions);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(false);
				firefoxOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("allow-file-access-from-files");
				firefoxOptions.addArguments("use-fake-device-for-media-stream");
				firefoxOptions.addArguments("use-fake-ui-for-media-stream");
				web_driver = new FirefoxDriver(firefoxOptions);
			} else if (browser.equalsIgnoreCase("Chromium")) {
				WebDriverManager.chromiumdriver().setup();
				web_driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("IEDriverServer")) {
				WebDriverManager.iedriver().setup();
				web_driver = new InternetExplorerDriver();
			}
		}

		web_driver.manage().window().maximize();
		web_driver.manage().deleteAllCookies();
		web_driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		web_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("********* Driver Successfully Created ******** " + web_driver.getTitle());
		logger.info("End of method getWebDriver");

		// webDriverPool.put(webDriver, web_driver);
		lstWebDriver.add(web_driver);
		return web_driver;
	}

	protected synchronized void quitDriver(WEB_DRIVER webDriver) {
		logger.info("Starting of method quitDriver in BaseClassplusAutomationTest ");

		WebDriver web_driver = webDriverPool.get(webDriver);
		try {
			if (web_driver != null) {
				web_driver.quit();
				web_driver = null;
				webDriverPool.remove(webDriver);
				logger.debug(webDriver + " Web web_driver quit successfully in BaseClassplusAutomationTest ");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			web_driver = null;
		}
		logger.info("Ending of method quitDriver in BaseClassplusAutou0" + "ationTest");
	}

	public synchronized void goToSite(String siteURL, WebDriver web_driver) {
		logger.info("starting of method goToSite");

		logger.debug("Login URL is" + siteURL);
		web_driver.get(siteURL);

		logger.info("Ending of method goToSite");
	}

	public WebDriver getChildWebDriver() {
		return this.childWebDriver;
	}

	public List<WebDriver> getWebDriversList() {
		return lstWebDriver;
	}

	/**
	 * public List<AppiumDriver<WebElement>> getAppiumDriverList() { return
	 * lstAppiumDriver; }
	 */

	public void siteLogin(String strOrgCode, String strMobileNumber, String strEmailAddress, WebDriver driver) {
		logger.info("Starting siteLogin method");

		driver.get(loginURL);
		this.webLoginPage.clickOutside();
		this.webLoginPage.loginToClassplusUsingMobileNumber(strOrgCode, strMobileNumber, strEmailAddress);

		logger.info("Ending siteLogin method");
	}

	public void loginToApplication(TestBookWebLoginPage loginPage, WebDriver driver, String orgCode, String mobileNum,
			String emailAddress, String otp, String siteURL) throws Exception {
		// launchWebSite(driver);
		OutputStream outputStream = new FileOutputStream("src/main/resources/runtime.properties");
		driver.get(siteURL);
		loginPage.clickOutside();
		loginPage.loginToClassplusUsingMobileNumber(orgCode, mobileNum, emailAddress);
		loginPage.setOTP(otp);
		loginPage.clickVerifyOTP();

		if (mobileNum.equals(TUTOR_MOBILE)) {
			runDataProp.setProperty("tutor.name", loginPage.getTutorNameText());

		}
		if (mobileNum.equals(FACULTY_MOBILE)) {
			runDataProp.setProperty("faculty.name", loginPage.getTutorNameText());

		}

		if (mobileNum.equals(STUDENT_MOBILE)) {
			runDataProp.setProperty("student.name", loginPage.getTutorNameText());

		}
		runDataProp.store(outputStream, null);
		outputStream.close();

	}

	public List<String> getPropertyList(String name) {
		List<String> list = Arrays.asList(name.toString().split("\\,"));
		System.out.println(list);
		return list;
	}

	public void verticalScrollDown(AppiumDriver<WebElement> driver) throws InterruptedException {
		logger.info("Starting of verticalScrollDown Method");

		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int endX = startX;
		int startY = (int) (size.height * 0.7);
		int endY = (int) (size.height * 0.2);
		TouchAction t = new TouchAction(driver);
		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, -endY)).release().perform();

		logger.info("Ending of verticalScrollDown Method");
	}

	public void loginToClassplusUsingMobileNumber(TestBookMobileLoginPage classplusLoginPage, String strMobileNumber,
			String strOTP) {
		logger.info("Starting of LoginToClassplusUsingMobileNumber method");

		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			OutputStream outputStream = new FileOutputStream("src/main/resources/runtime.properties");
			System.out.println("***************" + strMobileNumber);
			classplusLoginPage.loginToClassplusUsingMobileNumber(strMobileNumber, strOTP);
			if (strMobileNumber.equals(TUTOR_MOBILE)) {
				runDataProp.setProperty("tutor.name", classplusLoginPage.getTutorNameText());
			}
			if (strMobileNumber.equals(FACULTY_MOBILE)) {
				runDataProp.setProperty("faculty.name", classplusLoginPage.getTutorNameText());
			}

			if (strMobileNumber.equals(STUDENT_MOBILE)) {
				runDataProp.setProperty("student.name", classplusLoginPage.getTutorNameText());

			}
			if (strMobileNumber.equals(PARENT_MOBILE)) {
				runDataProp.setProperty("parent.name", classplusLoginPage.getTutorNameText());

			}

			runDataProp.store(outputStream, null);
			outputStream.close();
			classplusLoginPage.clickOnSideScreen();

		} catch (Exception e) {
			logger.debug(e);

		}
		logger.info("Ending of LoginToClassplusUsingMobileNumber method");
	}

	
	public void pushImages(String image) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/image.jpg",
					new File(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}
	
	public void pushMultipleImages(int num) {
		for (int i = 1; i <= num; i++)
			pushImages(B2BConstants.BASE_PATH + File.separator + "testdata" + File.separator
					+ testDataProp.getProperty("attachpdf.file.image"), "b2btesters" + i);
	}

	public void pushImages(String file, String name) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/" + name + ".jpg",
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}

	public void pushPDF(String file) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/b2btesters.pdf",
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}

	public void pushPDF(String file, String name) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/" + name + ".pdf",
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}
	
	public void pushFile(String file, String name) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/" + name,
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}

	public void pushExcel(String file) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/b2btesters.xlsx",
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}

	public void pushDocument(String file) {
		try {
			((AndroidDriver<WebElement>) android_driver).pushFile("/storage/emulated/0/Download/b2btesters.docx",
					new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("image pushed");
	}

	protected synchronized void initAndroidMobileDriver(B2BMobileConfigurationVO mobileConfigurationVO, String url)
			throws MalformedURLException {

		logger.info("Starting of method initMobileDriver");

		// AppiumDriver<WebElement> driver = null;

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", mobileConfigurationVO.getDeviceName());
		cap.setCapability("udid", mobileConfigurationVO.getUdId());
		cap.setCapability("platformName", mobileConfigurationVO.getPlatformName());
		cap.setCapability("platformVersion", mobileConfigurationVO.getPlatformVersion());
		cap.setCapability("autoAcceptAlerts", "true");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15000);
		cap.setCapability("clientApiKey", mobileConfigurationVO.getClientApiKey());
		// cap.setCapability("isHeadless", true);
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("appPackage", "co.classplus.app.test");
		cap.setCapability("appActivity", "co.classplus.app.ui.common.splash.KSplashActivity");
		cap.setCapability("platformName", "Android");
		if (url.equalsIgnoreCase("Local")) {
			logger.info("url*******************local");
			android_driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), cap);
		} else {
			logger.info("url*******************mobile labs");
			//android_driver = new AndroidDriver<WebElement>(new URL("http://b2bmobilelab.com:8080/wd/hub"), cap);
		}
		driversMap.put(mobileConfigurationVO.getUdId(), android_driver);
		driver = android_driver;
		lstDriver.add(android_driver);

		logger.info("Ending of method initMobileDriver");
	}

	public void refreshPage() {
		logger.info("Starting of refreshPage method");

		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.9);

		int endX = startX;

		int startY = (int) (size.height * 0.2);

		int endY = (int) (size.height * 0.9);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		// Creating Sequence object to add actions
		Sequence swipe = new Sequence(finger, 1);
		// Move finger into starting position
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, (int) startY));
		// Finger comes down into contact with screen
		swipe.addAction(finger.createPointerDown(0));
		// Finger moves to end position
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(5000), PointerInput.Origin.viewport(), startX, (int) endY));
		// Get up Finger from Srceen
		swipe.addAction(finger.createPointerUp(0));

		// Perform the actions
		driver.perform(Arrays.asList(swipe));

		logger.info("Ending of refreshPage method");
	}

	public String randomNumber(int digits) {
		logger.info("Starting of randomNumber method");
		logger.info("Ending of randomNumber method");

		return String.valueOf(RandomStringUtils.randomNumeric(digits));
	}

	public void addContactsToAndroidDevice(TestBookMobileLoginPage loginPage, String name, String number)
			throws InterruptedException {

		String currentAct =  android_driver.getCurrentPackage();

		System.out.println(currentAct);

		Thread.sleep(10000);
		
		((StartsActivity) android_driver)
				.startActivity(new Activity("com.google.android.contacts", "com.android.contacts.activities.PeopleActivity"));
		System.out.println(android_driver.currentActivity());
		
		//loginPage.clickOnAllow();
		try {
			Thread.sleep(10000);
			loginPage.clickOnSearchContactsButton();
			loginPage.setSearchContact(name);
			loginPage.deleteAllSearchedContacts(name);
			android_driver.navigate().back();
			loginPage.clickOnAddContactButton();
			loginPage.setFirstName(name);
			loginPage.setContactNumber(number);
			loginPage.clickOnSaveButton();
		} catch (Exception e) {
			logger.error("Error occured while testing addContacts ", e);
		} finally {
			driver.activateApp(currentAct);

			Thread.sleep(10000);
		}

	}
}
