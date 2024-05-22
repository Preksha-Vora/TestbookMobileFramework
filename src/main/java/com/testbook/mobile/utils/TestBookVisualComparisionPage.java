package com.testbook.mobile.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.b2b.mobile.pages.base.B2BVisualComparisionPage;

import io.appium.java_client.AppiumDriver;

public class TestBookVisualComparisionPage extends B2BVisualComparisionPage {
	private AppiumDriver<WebElement> driver = null; 
	private String destDir = System.getProperty("user.dir");
	private String destFile2 = null;
	String destFile1=null;
	public TestBookVisualComparisionPage(AppiumDriver<WebElement> driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public synchronized void takeSecondScreenShot(Enum<?> SCREEN_ID) {
		File compFile = null;
		// destDir = "screenshots";

		File mkdir = new File(destDir);
		mkdir.mkdirs();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		destFile2  = SCREEN_ID.name() + "_COMP.png";

		compFile = new File(destDir + "/" + destFile2);
		Boolean override = true;
		if (!compFile.exists() || override) {
			try {
				FileUtils.copyFile(scrFile, compFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * try { System.out.println("sleep===============================" );
		 * Thread.sleep(30000);
		 * System.out.println("sleep===============================" );
		 * 
		 * } catch (InterruptedException e) { e.printStackTrace(); }
		 */
	}
	public synchronized double visualDifference(Enum<?> SCREEN_ID) {
		BufferedImage imgA = null;
		BufferedImage imgB = null;
		double percentage = 0;
		//BufferedImage dest = imgA.getSubimage(0, 0, 100, 50);

		try {
			File fileA = new File(destDir + "/" + SCREEN_ID.name() + "_COMP.png");
			System.out.println("==========================" + destDir + "/" + SCREEN_ID + "_COMP.png");

			File fileB = new File(destDir + "/" + SCREEN_ID.name() + ".png");
			System.out.println("==========================" + destDir + "/" + SCREEN_ID + ".png");

			imgA = ImageIO.read(fileA);
			imgB = ImageIO.read(fileB);
			
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
			// So total number of pixels = width  height  3
			double total_pixels = width1*height1 *3;

			// Normalizing the value of different pixels
			// for accuracy(average pixels per color
			// component)
			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total

			percentage = (avg_different_pixels / 255) * 100;
			System.out.println("***********************************************************");
			System.out.println("Difference Percentage-->" + SCREEN_ID + "-->" + percentage);
			System.out.println("***********************************************************");
		}

		System.out.println("Ending of visualDifference method");
		return percentage;
	}
	public synchronized void takeScreenShot(Enum<?> SCREEN_ID) {
		System.out.println("Starting of takeScreenShot method");

		File compFile = null;
		// destDir = "screenshots";

		File mkdir = new File(destDir);
		mkdir.mkdirs();

		// No file then create base
		// Base Exists then create Comp
		// Base and comp exist & replace = false then replace COmp
		// Base and comp exists & replace = true then replace Base and Comp

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Set file name using current date time.
		destFile1 = SCREEN_ID.name() + ".png";

		System.out.println("destFile1 is ******************************:" + destFile1);

		// Execute below logic only for the first time or when override is true.

		try {
			File baseFile = new File(destDir + "/" + destFile1);

			System.out.println("baseFile is : " + baseFile);
			Boolean override = false;
			if (!baseFile.exists() || override) {
				FileUtils.copyFile(scrFile, baseFile);

			}

			/*
			 * try { System.out.println("sleep===============================" );
			 * Thread.sleep(30000);
			 * System.out.println("sleep===============================" );
			 * 
			 * } catch (InterruptedException e) { e.printStackTrace(); }
			 */

			destFile2 = SCREEN_ID.name() + "_COMP.png";

			compFile = new File(destDir + "/" + destFile2);
			override = true;
			if (!compFile.exists() || override) {
				FileUtils.copyFile(scrFile, compFile);
			}

			/*
			 * try { System.out.println("sleep===============================" );
			 * Thread.sleep(30000);
			 * System.out.println("sleep===============================" );
			 * 
			 * } catch (InterruptedException e) { e.printStackTrace(); }
			 */

		} catch (IOException e) {
			System.out.println(e.getMessage());

			System.out.println("Ending of takeScreenShot method");
		}
	}

}
