package commonuseractions;

import java.io.File;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author vbaskar
 * @This Class has all CommonActionMethods
 * 
 *
 */

public class CommonActionMethods {

	static WebDriver driver;

	public static Logger log = Logger.getLogger(CommonActionMethods.class);

	/**
	 * @This method is used to print the log message in console
	 * @param message -string value about the action being performed
	 */
	public static void logMessage(String message) {
		log.info(message);
	}

	/**
	 * @This method is used to print the log error message in console and stop the
	 *       execution
	 * @param MessageStopExecution -string value about the action being performed
	 * @throws Exception
	 */

	public static void logErrorMessage(String MessageStopExecution) throws Exception {
		log.error(MessageStopExecution);
		takeSnapShot();
		throw new RuntimeException(MessageStopExecution);
	}

	/**
	 *
	 * @This method is for click the element
	 * @param element -Webelement to click
	 * @param button  -string value about the action being performed
	 * @throws Exception
	 */
	public static void clickMethod(WebElement element, String button) throws Exception {
		try {
			element.click();
			logMessage(button + " button is clicked  ");

		} catch (Exception e) {
			logErrorMessage(button + " button is not clicked ");

		}
	}

	/**
	 * 
	 * @This method is for enter the value
	 * @param key   -Webelement of the textbox to send the text
	 * @param enter -string value about the action being performed
	 * @throws Exception
	 * 
	 */
	public static void sendKeysMethod(WebElement key, String enter) throws Exception {
		try {
			key.sendKeys(enter);
			logMessage(enter + "enter the value ");

		} catch (Exception e) {
			logErrorMessage("Element not entered in" + enter);

		}

	}

	/**
	 *
	 * @This method is for selectByVisibleText
	 * @param element     -Webelement to select an option from the dropdown
	 *                    ByVisibleText
	 * @param text-string value about the action being performed
	 * @throws Exception
	 */

	public static void selectByVisibleText(WebElement element, String text) throws Exception {
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
			logMessage(text + "is selected in dropdown");

		} catch (Exception e) {
			logErrorMessage(text + "Element not selected");

		}

	}

	/**
	 * 
	 * @This method is for selectByValue
	 * @param element-Webelement to select an option from the dropdown ByValue
	 * @param text-string        value about the action being performed
	 * @throws Exception
	 */
	public static void selectByValue(WebElement element, String text) throws Exception {
		try {
			Select sel = new Select(element);
			sel.selectByValue(text);
			logMessage(text + "is selected in dropdown");

		} catch (Exception e) {
			logErrorMessage(text + "Element not selected");

		}
	}

	/**
	 * 
	 * @This method is for selectByIndex
	 * @param element-Webelement to select an option from the dropdown ByIndex
	 * @param Index-string       value about the action being performed
	 * @throws Exception
	 */
	public static void selectByIndex(WebElement element, int Index) throws Exception {
		try {
			Select sel = new Select(element);
			sel.selectByIndex(Index);
			logMessage(Index + "is selected in dropdown");

		} catch (Exception e) {
			logErrorMessage(Index + "Element not selected");

		}

	}

	/**
	 * @This method is used to take a screenshot
	 * @throws Exception
	 */
	public static void takeSnapShot() throws Exception {
		try {
			File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(SrcFile, new File("./Snaps/" + System.currentTimeMillis() + ".png"));
			logMessage("Screenshot taken-stored in the given path");
		} catch (Exception e) {
			logErrorMessage("Screenshot is not taken ");
		}
	}

	/**
	 * @This method is used for windowhandle
	 * @throws Exception
	 * 
	 */
	public static void windowHandle() throws Exception {
		try {
			String hand = driver.getWindowHandle();
			List<String> wind = (List<String>) driver.getWindowHandles();
			for (String window : wind) {
				if (!window.equalsIgnoreCase(hand)) {
					driver.switchTo().window(window);
				}
			}
			logMessage("windowhandle is successful");
		} catch (Exception e) {
			logErrorMessage("windowhandle is not successful");

		}

	}

	/**
	 * 
	 * @This method is used for frameByElement
	 * @param element -Webelement of the frame to switch the driver
	 * @throws Exception
	 */

	public static void frameByElement(WebElement element) throws Exception {
		try {
			driver.switchTo().frame(element);
			logMessage("framehandle is successful by webelement");

		} catch (Exception e) {
			logErrorMessage("no such frame exception");

		}

	}

	/**
	 *
	 * @This method is used for frameByIndex
	 * @param Index -Integer index of the frame
	 * @throws Exception
	 */
	public static void frameByIndex(int Index) throws Exception {
		try {
			driver.switchTo().frame(Index);
			logMessage("framehandle is successful by index");

		} catch (Exception e) {
			logErrorMessage("no such frame exception");

		}

	}

	/**
	 *
	 * @This method is used for frameByNameorID
	 * @param nameORid-string value about the action being performed
	 * @throws Exception
	 */
	public static void frameByNameorID(String nameORid) throws Exception {
		try {
			driver.switchTo().frame(nameORid);
			logMessage("framehandle is successful by name or id");

		} catch (Exception e) {
			logErrorMessage("no such frame exception");

		}

	}

	/**
	 * @This method is used for defaultwindow
	 * @throws Exception
	 * 
	 */
	public static void defaultwindow() throws Exception {
		try {
			driver.switchTo().defaultContent();
			logMessage("defaultwindow is sucessful");

		} catch (Exception e) {
			logErrorMessage("defaultwindow is not sucessful");
		}

	}

	/**
	 * @This method is for get current page title
	 * @return
	 */

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @This method is for get a current url
	 * @return
	 */
	public static String getURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * 
	 * @This method is for element is displayed
	 * @param element     -Webelement to check whether is displayed or not
	 * @param ElementName
	 * @throws Exception
	 */

	public static void isDisplyaed(WebElement element, String ElementName) throws Exception {
		try {

			if (element.isDisplayed()) {
				logMessage(ElementName + "is displayed");
			} else {
				logErrorMessage(ElementName + "is not displayed in else block ");
			}
		} catch (Exception e) {
			logErrorMessage(ElementName + "is not displayed in catch block ");

		}

	}

	/**
	 *
	 * @This method is for element is selected
	 * @param element     -Webelement to check whether is Selected or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isSelected(WebElement element, String ElementName) throws Exception {
		try {
			if (element.isSelected()) {
				logMessage(ElementName + "is selected");
			} else {
				logErrorMessage(ElementName + "is not selected in else block ");
			}
		} catch (Exception e) {
			logErrorMessage(ElementName + "is not selected in catch block ");

		}

	}

	/**
	 * 
	 * @This method is for element is enabled
	 * @param element     -Webelement to check whether is Enabled or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isEnabled(WebElement element, String ElementName) throws Exception {
		try {
			if (element.isEnabled()) {
				logMessage(ElementName + "is enabled");
			} else {
				logErrorMessage(ElementName + "is not enabled in else block ");
			}
		} catch (Exception e) {
			logErrorMessage(ElementName + "is not enabled in catch block ");

		}

	}

}