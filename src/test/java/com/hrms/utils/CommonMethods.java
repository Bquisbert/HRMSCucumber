package com.hrms.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;



public class CommonMethods extends PageInitializer {

	/**
	 * method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * this method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrCheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();

			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	/**
	 * method that checks if text is there and then selects it
	 * 
	 * @param element
	 * @param textToSelect
	 */

	public static void selectDdValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement op : options) {
				if (op.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * method that selects value by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * method accepts alerts
	 */

	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}
	}

	/**
	 * method dismiss alert
	 */
	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

	}

	/**
	 * method that gets text of alert
	 * 
	 * @return
	 */

	public static String getAlertText() {

		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

		return alertText;

	}

	/**
	 * method that sends text to alert and catches exception if alert is not present
	 * 
	 * @param Text
	 */

	public static void sendAlertText(String Text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(Text);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static WebDriverWait getWaitObject() {
		
		WebDriverWait wait=new WebDriverWait(driver,Constants.IMPLICIT_WAIT_TIME);
		
		return wait;
	}
	
	
	public static WebElement waitForClickability(WebElement element) {
		
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
		
		
		
	}
	
	
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	
	/**
 	 * A method that would switch focus to multiple windows
 	 * @return set of multiple windows
 	 */
 	 
 	public static Set<String> WindowsHandle() {
 		Set<String> windows= driver.getWindowHandles();
 		for(String windowshandle: windows) {
 			driver.switchTo().window(windowshandle);
 		}
 		return windows;
 	}
 	/**
 	 * Method switches focus to child window
 	 */
 	public static void switchToChildWindow() {
 		String parentWindow=driver.getWindowHandle();
 		
 		Set<String>windows=driver.getWindowHandles();
 		for (String window : windows) {
 			
 			if(!window.equals(parentWindow)) {
 				driver.switchTo().window(window);
 				 break;
 			}
			
		}
 		
 	}
 	
 	public static WebElement waitForVisibility(WebElement element) {
 		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
 	}
 	
 	public static JavascriptExecutor getJSObject() {
 	JavascriptExecutor jse=(JavascriptExecutor)driver;
 	return jse;
 	}
 	
 	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}
	
 public static void jsScrollToElement(WebElement element) {
	 getJSObject().executeScript("Arguements[0].scrollIntoView(true)", element);
 }
 
 /**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
	}
	

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static String takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return destinationFile;
	}

	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
}
