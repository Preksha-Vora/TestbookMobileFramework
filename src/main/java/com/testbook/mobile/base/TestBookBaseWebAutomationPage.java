package com.testbook.mobile.base;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.b2b.base.B2BBaseAutomationPage;
import com.b2b.support.B2BPageFactory;
import com.google.common.base.Function;
import com.opencsv.CSVReader;

public class TestBookBaseWebAutomationPage extends B2BBaseAutomationPage {

	private static final Logger logger = Logger.getLogger(TestBookBaseWebAutomationPage.class);

	public static String TEST_FILE_PATH = null;

	public TestBookBaseWebAutomationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		logger.debug("in classplus base");
		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();

			logger.debug("In Constructor " + TEST_FILE_PATH);
		}
		logger.debug("middle in classplus base");
		B2BPageFactory.initElements(driver, this);
		logger.debug("end in classplus base");
		logger.debug("in classplus base");
		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();

			logger.debug("In Constructor " + TEST_FILE_PATH);
		}
		logger.debug("middle in classplus base");
		B2BPageFactory.initElements(driver, this);
		logger.debug("end in classplus base");
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	public void explicitWait(WebElement categoryOptions) {
		logger.info("Starting of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(categoryOptions));

		logger.info("Ending of explicitWait method");
	}
	
	public boolean getAddedContentText(List<WebElement> element, String contentName) {
		logger.info("Starting of getAddedContentTexts method");
		logger.info("Ending of getAddedContentTexts method");

		try {
			hardWait(2);
			for (WebElement e : element) {
				hardWait(1);
				if (e.getText().equalsIgnoreCase(contentName)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public void deleteInputFields(WebElement element) {
		if (!System.getProperty("os.name").contains("Mac")) {
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
		} else {
			element.sendKeys(Keys.COMMAND + "a");
			element.sendKeys(Keys.DELETE);

		}
	}

	

	public WebElement webElementWithReplacement(WebElement webElement, String replaceText) {
		logger.info("Starting of webElementWithReplacement method");

		String el = webElement.toString();
		String xpath = el.substring(el.indexOf("//"), el.length() - 1);
		WebElement ele = driver.findElement(By.xpath(xpath.replaceAll("\\$\\{.+\\}", replaceText)));
		logger.info("Ending of webElementWithReplacement method");

		return ele;
	}

	public boolean getPaymentStatus(List<WebElement> paymentDetail, List<WebElement> activeStatus, String FullPayment,
			String ActiveStatus) {

		logger.info("Starting of getPaymentStatus method");
		logger.info("ending of getPaymentStatus method");

		for (int i = 0; i < paymentDetail.size(); i++) {
			if (paymentDetail.get(i).getText().contains(FullPayment)) {
				if (!(activeStatus.get(i).getText().equalsIgnoreCase(ActiveStatus))) {
					return false;
				}
			}
		}
		return true;

	}

	public void clickOnLeftMenuLabels(List<WebElement> ele, String leftmenuLabelName) {
		for (WebElement e : ele) {
			if (e.getText().equalsIgnoreCase(leftmenuLabelName)) {
				clickOnWebElement(e);
				break;
			}
		}
	}

	public List<String> getElementsList(List<WebElement> ele) {
		logger.info("Starting of getElementsList method");
		logger.info("Ending of getElementsList method");

		List<String> courseList = new ArrayList<String>();

		for (WebElement element : ele) {
			System.out.println(element);
			courseList.add(element.getText().trim());
		}
		return courseList;
	}

	public void uploadImage(WebElement element, String image) {
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			element.sendKeys(TEST_FILE_PATH + "/testdata/" + image);

		} else {
			element.sendKeys(TEST_FILE_PATH + File.separator + "testdata" + File.separator + image);
		}

	}

	public static List<String> readTheDataFromCSV() throws Exception {
		Object[][] mydata = new Object[10][10];
		CSVReader reader = null;

		try {
			// Read existing file
			reader = new CSVReader(new FileReader(getLastModified()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		java.util.List<String[]> csvBody = reader.readAll();
		System.out.println(csvBody.toString());
		List<String> courseList = new ArrayList<String>();

		for (String[] strErrorData : csvBody) {

			for (String strReadEachData : strErrorData) {
				courseList.add(strReadEachData);
				System.out.print(strReadEachData + " ");
			}
		}

		reader.close();
		return courseList;
	}

	public void slider(WebElement webElement, int xCoordinate) {

		logger.info("Starting of slider method");

		Actions actions = new Actions(driver);
		actions.dragAndDropBy(webElement, xCoordinate, 0).perform();

		logger.info("Ending of slider method");
	}

	public void switchToDefault() {
		logger.info("starting of clickOnTutorDropdown method");

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of clickOnTutorDropdown method");
	}

	public void navigateBack() {
		logger.info("Starting of navigateBack method");

		driver.navigate().back();

		logger.info("Ending of navigateBack method");
	}

	public static File getLastModified() {
		File directory = new File("C:\\Users\\Hello\\Downloads");
		// String home = System.getProperty("user.home")+"/Downloads/";
		File[] files = directory.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;

		if (files != null) {
			for (File file : files) {
				if (file.lastModified() > lastModifiedTime) {
					chosenFile = file;
					lastModifiedTime = file.lastModified();
				}
			}
		}
		System.out.println("File path is " + chosenFile + "/n");
		return chosenFile;
	}

	public void pickFromWebElementListRadio(List<WebElement> webElements, List<WebElement> textWebElements,
			String containsText) {

		logger.info("Starting of pickFromWebElemetList method");

		WebElement webElement = null;
		WebElement textWebElement = null;
		Object[] webElementsArray = webElements.toArray();
		Object[] xPathArray = textWebElements.toArray();

		for (int i = 0; i < webElements.size(); i++) {
			webElement = (WebElement) webElementsArray[i];
			textWebElement = (WebElement) xPathArray[i];
			System.out.println(textWebElement.getText());
			if (textWebElement.getText().equals(containsText)) {
				if (!webElement.isSelected())

				{
					this.clickOnWebElement(webElement);
					break;
				}
			}
		}
		logger.info("Ending of pickFromWebElemetList method");

	}

	public void pickFromWebElement(List<WebElement> webElements, String containsText) {
		logger.info("Starting of pickFromWebElemetList method");

		for (WebElement webElement : webElements) {
			if (webElement.getText().contains(containsText)) {
				this.clickOnWebElement(webElement);
				break;
			}
		}
		logger.info("Ending of pickFromWebElemetList method");
	}

	public boolean isPresentInWebElementList(List<WebElement> webElements, String containsText) {
		logger.info("Starting of isPresentInWebElementList method");

		for (WebElement webElement : webElements) {
			if (webElement.getText().contains(containsText)) {
				return true;
			}
		}

		logger.info("Ending of isPresentInWebElementList method");
		return false;
	}

	public void uploadFile(String filepath) {

		Robot robot = null;
		try {
			robot = new Robot();

			StringSelection stringSelection = new StringSelection(filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			robot.delay(500);
			robot.keyPress(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.delay(500);

			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e2) {
			e2.printStackTrace();
		}
	}

	public void pickFromWebElementList(List<WebElement> webElements, List<WebElement> textWebElements,
			String containsText) {

		logger.info("Staritng of pickFromWebElemetList method");

		WebElement webElement = null;
		WebElement textWebElement = null;
		Object[] webElementsArray = webElements.toArray();
		Object[] xPathArray = textWebElements.toArray();

		for (int i = 0; i < webElements.size(); i++) {
			webElement = (WebElement) webElementsArray[i];
			textWebElement = (WebElement) xPathArray[i];
			if (textWebElement.getText().contains(containsText)) {
				this.clickOnWebElement(webElement);
				break;
			}
		}

		logger.info("Ending of pickFromWebElemetList method");
	}

	public boolean checkElementDisplayed(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		}

		return flag;
	}

	public String convertDateToFormatDDMMYY(int time) {
		// displaying current date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		cal.add(Calendar.YEAR, time);
		System.out.println("Today's date and time = " + simpleformat.format(cal.getTime()));
		return simpleformat.format(cal.getTime());
	}

	public String convertDateToFormatDDMMYYAddTime(int time) {
		// displaying current date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
		cal.add(Calendar.DATE, time);
		System.out.println("Today's date and time = " + simpleformat.format(cal.getTime()));
		return simpleformat.format(cal.getTime());
	}

	public String convertDateToFormatDDMMMYY(int time) {
		// displaying current date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd MMM yy");
		cal.add(Calendar.YEAR, time);
		System.out.println("Today's date and time = " + simpleformat.format(cal.getTime()));
		return simpleformat.format(cal.getTime());
	}

	public String convertDateToFormatDDMMMYYYY(int time) {
		// displaying current date and time
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd MMM yyyy");
		cal.add(Calendar.YEAR, time);
		System.out.println("Today's date and time = " + simpleformat.format(cal.getTime()));
		return simpleformat.format(cal.getTime());
	}

	public void resetImplicitTimeout(int newTimeOut) {
		try {
			driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}

	public Integer getCountText(WebElement lblCount) {
		logger.info("Starting of getCountText method");
		String count = lblCount.getText();
		logger.info(count);

		String batchCount = lblCount.getText();
		logger.info(batchCount);
		String returnCount = "";
		String str[] = batchCount.split("\\D");
		for (String s : str)
			if (s != "")
				returnCount = s;
		int countValue = 0;
		if (!returnCount.equals(""))
			countValue = Integer.parseInt(returnCount);
		System.out.println("Count=" + countValue);

		logger.info("Ending of getCountText method");

		return countValue;
	}

	public boolean getSeeAllLabel(WebElement webElement, String strSeeAll) {

		logger.info("Starting of getViewAllLabel method");
		logger.info("ending of getViewAllLabel method");

		try {
			if (webElement.getText().contains(strSeeAll)) {
				return true;
			}
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		return false;

	}

	public void switchToNewOpenedTab() {
		logger.info("Starting of switchToNewOpenedTab method");

		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}

			logger.info("Starting of switchToNewOpenedTab method");
		}
	}

	public String getTestFilePath() {
		logger.info("Starting of getTestFilePath method");

		String path = "src/main/resources";
		File file = new File(path);

		logger.info("Ending of getTestFilePath method");

		return file.getAbsolutePath();
	}

	protected void selectDropdown(String id, String value) {
		logger.info("Starting of selectDropdown method");

		Select conditions = new Select(driver.findElement(By.id(id)));
		conditions.selectByValue(value);

		logger.info("Ending of selectDropdown method");
	}

	public void clickOnWebElement(WebElement webelement) {
		logger.info("Starting of clickOnWebElement method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].click();", webelement);

		logger.info("Ending of clickOnWebElement method");
	}

	public void clickOutside() {
		logger.info("Starting of clickOutside method");

		Actions action = new Actions(driver);
		action.moveByOffset(0, 0).click().build().perform();

		logger.info("Ending of clickOutside method");
	}

	public void scrollDown(int scroll) {
		logger.info("Starting of scrollDown method");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + scroll + ")");

		logger.info("Ending of scrollDown method");
	}

	public void mouseHover(WebElement webElement) {
		logger.info("Starting of mouseHoverActions method");

		Actions action = new Actions(driver);
		action.moveToElement(webElement, 5, 0).build().perform();

		logger.info("Ending of mouseHoverActions method");
	}

	public void refresh() {
		logger.info("Starting of refresh method");

		driver.navigate().refresh();

		logger.info("Ending of refresh method");
	}

	public void impicitWait() {
		logger.info("Starting of impicitWait method");

		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		logger.info("Ending of impicitWait method");
	}

	public void explicitWait(List<WebElement> categoryOptions) {
		logger.info("Starting of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(categoryOptions));

		logger.info("Ending of explicitWait method");
	}

	

	public void explicitWaitLong(WebElement categoryOptions) {
		logger.info("Starting of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(categoryOptions));

		logger.info("Ending of explicitWait method");
	}

	public void waitForElementToBeClikable(WebElement categoryOptions) {
		logger.info("Starting of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(categoryOptions));

		logger.info("Ending of explicitWait method");
	}

	public void pickFromWebElementList(List<WebElement> webElements, String containsText) {
		logger.info("Starting of pickFromWebElemetList method");

		for (WebElement webElement : webElements) {
			if (webElement.getText().contains(containsText)) {
				this.clickOnWebElement(webElement);
				break;
			}
		}
		logger.info("Ending of pickFromWebElemetList method");
	}
 
	public void doubleClick(WebElement webElement) {
		logger.info("Starting of doubleclick method");

		Actions actions = new Actions(driver);
		actions.doubleClick(webElement).perform();

		logger.info("Ending of doubleclick method");
	}

	public void impicitLongWait() {
		logger.info("Starting of impicitLongWait method");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Ending of impicitLongWait method");
	}


	public void waitForElementVisibilty(WebElement element) {
		logger.info("Starting of waitForElementVisibilty method");

		WebDriverWait wait = new WebDriverWait(this.driver, 120);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		logger.info("Ending of waitForElementVisibilty method");
	}

	public void scrollIntoView(WebElement element) {
		logger.info("Starting of scrollIntoView method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].scrollIntoView(true);", element);

		logger.info("Ending of scrollIntoView method");
	}

	public void scrollAtWindowHeight() {
		logger.info("Starting of scrollAtWindowHeight method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		logger.info("Ending of scrollAtWindowHeight method");
	}

	public void scrollAtWindowTop() {
		logger.info("Starting of scrollAtWindowHeight method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		logger.info("Ending of scrollAtWindowHeight method");
	}

	public void clearInput(WebElement element) {
		logger.info("Starting of clearInput method");
		element.clear();
		logger.info("Ending of clearInput method");
	}

	public void fluentWaitForElement(String xPath) {

		try {

			// Reference : https://www.guru99.com/implicit-explicit-waits-selenium.html
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);

			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(xPath));
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void fluentWait(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20L))
				.pollingEvery(Duration.ofSeconds(2L)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * public void clickOnElement(WebElement element) { Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20L))
	 * .pollingEvery(Duration.ofSeconds(2L)).ignoring(NoSuchElementException.class)
	 * .ignoring(StaleElementReferenceException.class);
	 * wait.until(ExpectedConditions.visibilityOf(element)); element.click(); }
	 */

	public void waitForPageLoad() {

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	
	protected void closeOSWindow() {
		Robot robot = null;
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				robot = new Robot();
				for (int i = 0; i < 3; i++) {
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyRelease(KeyEvent.VK_TAB);
				}

				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_F4);
				robot.delay(500);
				robot.keyRelease(KeyEvent.VK_F4);
				// robot.keyPress(KeyEvent.VK_ENTER);

				// robot.delay(500);

				// robot.keyRelease(KeyEvent.VK_ENTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean searchFilters(List<WebElement> filterList, List<WebElement> cardList, String searchQuery) {
		logger.info("Starting of setSearchTestsInTimeTable method");
		logger.info("Ending of setSearchTestsInTimeTable method");

		for (WebElement filter : filterList) {

			this.clickOnWebElement(filter);
			this.explicitWait(cardList);

			for (WebElement card : cardList) {
				System.out.println(card.getText());
				if (card.getText().contains(searchQuery))
					return false;
			}

			this.clickOnWebElement(filter);
		}
		return true;
	}

	
	public int countTotal(String ts) {
		String a = "";
		for (int i = 0; i < ts.length(); i++) {
			if (ts.charAt(i) == '(') {
				i++;
				while (ts.charAt(i) != ')' && i < ts.length()) {
					a += ts.charAt(i);
					i++;
				}
			}
		}
		int countFolder = Integer.parseInt(a);
		return countFolder;
	}

	public void switchToWindow() {
		Set<String> windows = driver.getWindowHandles();
		for (int j = 0; j < 5; j++) {
			if (windows.size() < 2) {
				try {
					Thread.sleep(2000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		windows = driver.getWindowHandles();
		String wins[] = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(wins[1]);
	}

	public void switchToParentWindow() {
		logger.info("Starting of switchToParentWindow method");

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		logger.info("Ending of switchToParentWindow method");
	}

	public synchronized double visualDifferenceWithURLImage(String file_One, String file_Two) {

		BufferedImage imgA = null;
		BufferedImage imgB = null;
		double percentage = 0;

		try {

			System.out.println("==========================" + file_One);

			File fileB = new File(file_Two);
			System.out.println("==========================" + file_Two);

			imgB = ImageIO.read(fileB);
			URL urlInput = new URL(file_One);
			imgA = ImageIO.read(urlInput);

			// imgA = ImageIO.read(fileA);
			System.out.println("File a IO done==========================" + imgA);
			System.out.println("File b IO done==========================" + imgB);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2))
			System.out.println("Error: Images dimensions" + " mismatch");
		else {
			long difference = 0;
			for (int y = 0; y < height1; y++) {
				for (int x = 0; x < width1; x++) {
					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;
					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}
			// Total number of red pixels = width * height
			// Total number of blue pixels = width * height
			// Total number of green pixels = width * height
			// So total number of pixels = width * height * 3
			double total_pixels = width1 * height1 * 3;

			// Normalizing the value of different pixels
			// for accuracy(average pixels per color
			// component)
			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total

			percentage = (avg_different_pixels / 255) * 100;
			System.out.println("***********************************************************");
			System.out.println("Difference Percentage-->-->" + percentage);
			System.out.println("***********************************************************");
		}

		System.out.println("Ending of visualDifference method");
		return percentage;
	}

	public boolean checkElementVisibility(String text) {
		logger.info("Starting of checkTextVisibility method");
		logger.info("Ending of checkTextVisibility method");

		return driver.getPageSource().contains(text);

	}

	public void mouseHoverActions(WebElement webElement) {
		logger.info("Starting of mouseHoverActions method");

		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();

		logger.info("Ending of mouseHoverActions method");
	}

	public enum WEB_ACTIONS {
		CLICK, VISIBILE, TOAST
	}

	protected WebElement findElement(WebElement webelement, WEB_ACTIONS webActions) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			switch (webActions) {
			case CLICK:
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				break;
			case VISIBILE:
				wait.until(ExpectedConditions.visibilityOf(webelement));
				break;
			default:
				wait.until(ExpectedConditions.visibilityOf(webelement));

			}
		} catch (StaleElementReferenceException ex) {
			System.out.println("Webelement exception{}" + webelement + "" + ex);
		}
		return webelement;
	}

	protected void clickOnElement(WebElement webelement) {
		findElement(webelement, WEB_ACTIONS.CLICK).click();
	}

	protected String getText(WebElement webelement) {
		return findElement(webelement, WEB_ACTIONS.VISIBILE).getText();
	}

	protected boolean checkElementPresence(WebElement webelement) {
		return findElement(webelement, WEB_ACTIONS.VISIBILE).isDisplayed();
	}

	public String randomNumber(int digits) {
		logger.info("Starting of randomNumber method");
		logger.info("Ending of randomNumber method");

		return String.valueOf(RandomStringUtils.randomNumeric(digits));
	}
}
