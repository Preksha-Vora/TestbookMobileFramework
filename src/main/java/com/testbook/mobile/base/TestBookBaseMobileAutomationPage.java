package com.testbook.mobile.base;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.b2b.mobile.pages.base.B2BBaseMobileAutomationPage;
import com.b2b.mobile.pages.base.B2BVisualComparisionPage;
import com.b2b.support.B2BPageFactory;
import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestBookBaseMobileAutomationPage extends B2BBaseMobileAutomationPage {

	protected AppiumDriver<WebElement> driver = null;

	protected B2BVisualComparisionPage visualComparisionPage = null;

	public static final Logger logger = LogManager.getLogger(TestBookBaseMobileAutomationPage.class);

	public TestBookBaseMobileAutomationPage(AppiumDriver<WebElement> driver) {
		super(driver);
		this.driver = driver;
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

	public void horizontalScroll() {
		logger.info("Starting of horizontalScroll Method");

		
		  Dimension size = driver.manage().window().getSize();
		  
		  int startX = (int) (size.width * 0.8);
		  
		  int endX = (int) (size.width * 0.3);
		  
		  int startY = size.height / 2;
		  
		  int endY = startY;
		  
		  for (int i = 0; i < 1; i++) {
		  
		  TouchAction t = new TouchAction((PerformsTouchActions) driver);
		  
		  t.press(PointOption.point(startX,
		  startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(000)))
		  .moveTo(PointOption.point(endX, endY)).release().perform(); }
		
		logger.info("Ending of horizontalScroll Method");
	}

	// LongPressAction Method
	protected void getLongPressAction(WebElement lbltapandhold) {

		AndroidTouchAction t = new AndroidTouchAction(driver);
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(lbltapandhold))
				.withDuration(Duration.ofMillis(3000))).release().perform();
	}
		
	public Integer getCountText(String lblCount) {
		logger.info("Starting of getCountText method");

		String batchCount = lblCount;
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

	public synchronized double visualDifference(BufferedImage file_One, BufferedImage file_Two) {

		BufferedImage imgA = null;
		BufferedImage imgB = null;
		double percentage = 0;

		try {

			//System.out.println("==========================" + file_One);

			//File fileB = new File(file_Two);
			//System.out.println("==========================" + file_Two);

			imgB = file_Two;
			//File fileA = new File(file_Two);
			imgA = file_One;

			// imgA = ImageIO.read(fileA);
			System.out.println("File a IO done==========================" + imgA);
			System.out.println("File b IO done==========================" + imgB);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2)) {
			System.out.println("Error: Images dimensions" + " mismatch");
		return 100;
		}
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
			// So total number of pixels = width  height  3
			double total_pixels = width1*height1*3;

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
	
public void scrollUp()
{
	Dimension size = driver.manage().window().getSize();
	int endY = (int) (size.height * 0.70);
	int startY = (int) (size.height * 0.30);
    int startX = (size.width / 2);
    new TouchAction(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(000)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();
            }
	
public List<String> getListElementsText(List<WebElement> element) {
	logger.info("starting of getListElementsText method ");
	logger.info("ending of getListElementsText method");

	List<String> filterType = new ArrayList<String>();
	for (WebElement e : element) {
		filterType.add(e.getText());
	}
	return filterType;
}

public void verticalToElement(WebElement ele) throws InterruptedException {
	logger.info("Starting of verticalToElement Method");			
	
	int i=1;
	while(i<=50) {
	try {
		ele.isDisplayed();
		break;
	}
	catch(Exception e) {
		verticalScroll();
	}
	i++;
	}
	logger.info("Ending of verticalToElement Method");
}

public boolean isDisplayedCards(List<WebElement> element) {
	logger.info("starting of isDisplayedCards method ");
	logger.info("ending of isDisplayedCards method");

	try {
		if (element.get(0).isDisplayed()) {
			if (element.size() > 0) {
				return true;
			}
		}
	} catch (NoSuchElementException e) {
		return false;
	}
	return false;
}

public void clickOnFilterCheckBox(String filterType, List<WebElement> lblBeforeCheckBox,
		List<WebElement> chkelement) {
	logger.info("starting of clickOnFilterCheckBox method ");

	for (int i = 0; i < lblBeforeCheckBox.size(); i++) {
		System.out.println(lblBeforeCheckBox.get(i).getText());
		if (lblBeforeCheckBox.get(i).getText().equalsIgnoreCase(filterType)) {
			chkelement.get(i).click();
			break;
		}
	}
	logger.info("ending of clickOnFilterCheckBox method");
}


public boolean isFilterCheckBox(String filterType, List<WebElement> lblBeforeCheckBox,
		List<WebElement> chkelement) {
	logger.info("starting of clickOnFilterCheckBox method ");

	for (int i = 0; i < lblBeforeCheckBox.size(); i++) {
		System.out.println(lblBeforeCheckBox.get(i).getText());
		if (lblBeforeCheckBox.get(i).getText().equalsIgnoreCase(filterType)) {
			if(chkelement.get(i).isSelected());
			return true;
		}
	}
	logger.info("ending of clickOnFilterCheckBox method");
	
	return false;
}


public boolean getFilteredLabels(List<WebElement> element, String filterType) {
	logger.info("starting of getFilteredLabels method ");
	logger.info("ending of getFilteredLabels method");
	for (int i = 0; i < element.size(); i++) {
		if (!(element.get(i).getText().trim().contains(filterType))) {
			return false;
		}
	}
	return true;
}

public void horizontalScroll(WebElement ele01) {
	logger.info("Starting of horizontalScroll Method");

	// Scrollable Element
	// WebElement ele01 = driver.findElement(AppiumBy.id("elementID"));

	int centerY = ele01.getRect().y + (ele01.getSize().height / 2);

	double startX = ele01.getRect().x + (ele01.getSize().width * 0.9);

	double endX = ele01.getRect().x + (ele01.getSize().width * 0.1);
	// Type of Pointer Input
	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	// Creating Sequence object to add actions
	Sequence swipe = new Sequence(finger, 1);
	// Move finger into starting position
	swipe.addAction(
			finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
	// Finger comes down into contact with screen
	swipe.addAction(finger.createPointerDown(0));
	// Finger moves to end position
	swipe.addAction(
			finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
	// Get up Finger from screen
	swipe.addAction(finger.createPointerUp(0));

	// Perform the actions

	driver.perform(Arrays.asList(swipe));

	logger.info("Ending of horizontalScroll Method");
}

public boolean isScrollableStatsCards(WebElement element) {
	try {
		if (element.isDisplayed()) {
			horizontalScroll(element);
			return true;
		}
	} catch (Exception e) {
		return false;
	}
	return false;
}

public boolean isDisplayedListOfElements(List<WebElement> element) {
	for (int i = 0; i <= element.size(); i++) {
		if (!element.get(i).isDisplayed()) {
			return false;
		}
	}
	return true;
}

//public void refreshPage() {
//	logger.info("Starting of refreshPage method");
//
//	Dimension size = driver.manage().window().getSize();
//
//	int startX = size.width / 2;
//
//	int endX = startX;
//
//	int startY = (int) (size.height * 0.2);
//
//	int endY = (int) (size.height * 0.9);
//
//	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//	// Creating Sequence object to add actions
//	Sequence swipe = new Sequence(finger, 0);
//	// Move finger into starting position
//	swipe.addAction(
//			finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, startY));
//	// Finger comes down into contact with screen
//	swipe.addAction(finger.createPointerDown(0));
//	// Finger moves to end position
//	swipe.addAction(
//			finger.createPointerMove(Duration.ofMillis(5000), PointerInput.Origin.viewport(), startX, endY));
//	// Get up Finger from Srceen
//	swipe.addAction(finger.createPointerUp(0));
//
//	// Perform the actions
//	driver.perform(Arrays.asList(swipe));
//
//	logger.info("Ending of refreshPage method");
//}



public void androidScrollUsingText(String text,AppiumDriver<WebElement> driver) {
logger.info("Starting of androidScrollUsingText method");
driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
		+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

logger.info("Ending of androidScrollUsingText method");
}

public void androidScrollUsingText(String text) {

	logger.info("Starting of androidScrollUsingText method");
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
			+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

	logger.info("Ending of androidScrollUsingText method");
}


public Integer getCountText(WebElement lblCount) {
	logger.info("Starting of getCountText method");

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
			.moveTo(PointOption.point(endX,-endY)).release().perform();
	
	logger.info("Ending of verticalScrollDown Method");
}




public int getCurrentDayOfMonth()
{
	 LocalDate currentdate = LocalDate.now();
	 int currentDay = currentdate.getDayOfMonth();
	 return currentDay;
}

public String getCurrentCalenderYYYYMMDD()
{
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, -1);
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
	
	String formatted = format1.format(cal.getTime());
	System.out.println(formatted);
	return formatted;
}

public void hideKeyboard()
{
	driver.hideKeyboard();
}
}
