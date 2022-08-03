package commonuseractions;

import utils.Browserfactory;
import utils.DriverFactory;
import utils.ExcelReader;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.log4j.*;

/**
 * @author vbaskar
 * @This Class has all CommonActionMethods
 * 
 *
 */
public class CommonActionMethods {
	public static ExtentReports extentreport;
	public static ExtentHtmlReporter HtmlReporter;
	public static ExtentTest testcase;
	static String configFilename = "C:\\AutomationTask\\Sucide_Squad_Automation_Repo\\log4j.properties";
	public static Logger log = LogManager.getLogger(CommonActionMethods.class);

	public static ThreadLocal<Map<String, String>> inputdata = ThreadLocal.withInitial(() -> {
		Map<String, String> map = new HashMap<>();

		return map;
	});

	public static Map<String, String> getInputData() {
		return inputdata.get();
	}

	public static void extent(String message) {

		testcase = extentreport.createTest(message).assignAuthor("venkatesh");
	}

	public static void extentpass(String pass) {
		testcase.log(Status.PASS, pass);

	}

	public static void extentfail(String fail) throws Exception {
		testcase.log(Status.FAIL, fail);
		testcase.addScreenCaptureFromPath(takeSnapShot());

	}

	/**
	 * 
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
	 * @This method is used to invoke the browser
	 * @param browser-string     value about the action being performed
	 * @param browsertype-string value about the action being performed
	 * @param url-string         value about the action being performed
	 */
	public static void invokeBrowser(String browser, String browsertype, String url) {
		extentreport = new ExtentReports();
		HtmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		HtmlReporter.config().setTheme(Theme.DARK);
		extentreport.attachReporter(HtmlReporter);
		PropertyConfigurator.configure(configFilename);
		DriverFactory.setDriver(Browserfactory.createBrowser(browser, browsertype));
		DriverFactory.getDriver();
		logMessage(browser + " browser invoked");
		DriverFactory.getDriver().manage().window().maximize();
		logMessage("window maximized");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DriverFactory.getDriver().get(url);
		logMessage(url + " url launched");
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
			extentpass(button+"button  is clicked ");
			element.click();
			logMessage(button + " button is clicked  ");

		} catch (Exception e) {
			extentfail(button+"button is not clicked ");
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
			extentpass(enter+"value is entered");
			key.sendKeys(enter);
			logMessage(enter + " is entered ");

		} catch (Exception e) {
			extentfail(enter+"value is not entered");
			logErrorMessage(" Element is not entered in " + enter);

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
			extentpass(text+"Element selected in dropdown ");
			logMessage(text + " is selected in dropdown ");
		} catch (Exception e) {
			extentfail(text+"Element not in selected dropdown");
			logErrorMessage(text + " Element is not selected ");

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
			extentpass(text+"Element selected in dropdown ");
			logMessage(text + " is selected in dropdown ");

		} catch (Exception e) {
			extentfail(text+"Element not in selected dropdown");
			logErrorMessage(text + " Element is not selected ");

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
			extentpass(Index+"Element selected in dropdown ");
			logMessage(Index + " is selected in dropdown ");

		} catch (Exception e) {
			extentfail(Index+"Element not in selected dropdown");
			logErrorMessage(Index + " Element is not selected ");

		}

	}

	/**
	 * @return
	 * @This method is used to take a screenshot
	 * @throws Exception
	 */
	public static String takeSnapShot() throws Exception {
		try {
			File SrcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			File filepath = new File("./Snaps/" + System.currentTimeMillis() + ".png");
			String pathlocation = filepath.getAbsolutePath();
			FileUtils.copyFile(SrcFile, filepath);
			extentpass("Screenshot taken-stored in the given path");
			logMessage(" Screenshot taken-stored in the given path ");
			return pathlocation;
		} catch (Exception e) {
			extentfail("Screenshot is not taken");
			logErrorMessage(" Screenshot is not taken ");
		}
		return null;

	}

	/**
	 * @This method is used for windowhandle
	 * @throws Exception
	 * 
	 */
	public static void windowHandle() throws Exception {
		try {
			String hand = DriverFactory.getDriver().getWindowHandle();
			List<String> wind = (List<String>) DriverFactory.getDriver().getWindowHandles();
			for (String window : wind) {
				if (!window.equalsIgnoreCase(hand)) {
					DriverFactory.getDriver().switchTo().window(window);
				}
			}
			extentpass(" windowhandle is successful");
			logMessage(" windowhandle is successful ");
		} catch (Exception e) {
			extentfail("windowhandle is not successful");
			logErrorMessage(" windowhandle is not successful ");

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
			DriverFactory.getDriver().switchTo().frame(element);
			extentpass("framehandle is successful by webelement");
			logMessage(" framehandle is successful by webelement ");

		} catch (Exception e) {
			extentfail("no such frame exception");
			logErrorMessage(" no such frame exception ");

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
			DriverFactory.getDriver().switchTo().frame(Index);
			extentpass(" framehandle is successful by index ");
			logMessage(" framehandle is successful by index ");

		} catch (Exception e) {
			extentfail(" no such frame exception ");
			logErrorMessage(" no such frame exception ");

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
			DriverFactory.getDriver().switchTo().frame(nameORid);
			extentpass(" framehandle is successful by name or id ");
			logMessage(" framehandle is successful by name or id ");

		} catch (Exception e) {
			extentfail(" no such frame exception ");
			logErrorMessage(" no such frame exception ");

		}

	}

	/**
	 * @This method is used for default window
	 * @throws Exception
	 * 
	 */
	public static void defaultwindow() throws Exception {
		try {
			DriverFactory.getDriver().switchTo().defaultContent();
			extentpass(" Switched to defaultwindow ");
			logMessage(" Switched to defaultwindow ");

		} catch (Exception e) {
			extentfail(" Not switched to defaultwindow ");
			logErrorMessage(" Not switched to defaultwindow ");
		}

	}

	/**
	 * @This method is for get current page title
	 * @return
	 */

	public static String getTitle() {
		String title = DriverFactory.getDriver().getTitle();
		return title;
	}

	/**
	 * @This method is for get a current url
	 * @return
	 */
	public static String getURL() {
		String url = DriverFactory.getDriver().getCurrentUrl();
		return url;
	}

	/**
	 * 
	 * @This method is for element is displayed
	 * @param element     -WebElement to check whether is displayed or not
	 * @param ElementName
	 * @throws Exception
	 */

	public static void isDisplayed(WebElement element, String ElementName) throws Exception {
		try {

			if (element.isDisplayed()) {
				extentpass(ElementName+"Element is displayed ");
				logMessage(ElementName + " is displayed ");
			} else {
				extentfail(ElementName+"Element is not displayed ");
				logErrorMessage(ElementName + " is not displayed in else block ");
			}
		} catch (Exception e) {
			extentfail(ElementName+"Element is not displayed ");
			logErrorMessage(ElementName + " is not displayed in catch block ");

		}

	}

	/**
	 *
	 * @This method is for element is selected
	 * @param element     -WebElement to check whether is Selected or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isSelected(WebElement element, String ElementName) throws Exception {
		try {
			if (element.isSelected()) {
				extentpass(ElementName+"Element is selected");
				logMessage(ElementName + " is selected");
			} else {
				extentfail(ElementName+"Element is not selected ");
				logErrorMessage(ElementName + " is not selected in else block ");
			}
		} catch (Exception e) {
			extentfail(ElementName+"Element is not selected ");
			logErrorMessage(ElementName + " is not selected in catch block ");

		}

	}

	/**
	 * 
	 * @This method is for element is enabled
	 * @param element     -WebElement to check whether is Enabled or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isEnabled(WebElement element, String ElementName) throws Exception {
		try {
			if (element.isEnabled()) {
				extentpass(ElementName+"Element is enabled ");
				logMessage(ElementName + " is enabled ");
			} else {
				extentfail(ElementName+"Element is not enabled ");
				logErrorMessage(ElementName + " is not enabled in else block ");
			}
		} catch (Exception e) {
			extentfail(ElementName+"Element is not enabled ");
			logErrorMessage(ElementName + " is not enabled in catch block ");

		}

	}

	/**
	 * @This method is used to check the variable are equal
	 * @param intial-object   value about the action being performed
	 * @param end-object      value about the action being performed
	 * @param obj1name-string value about the action being performed
	 * @param obj2name-string value about the action being performed
	 * @throws Exception
	 */
	public static void checkEquality(Object intial, Object end) throws Exception {
		
			if (intial.equals(end)) {
				extentpass(intial + "&" + end +" is equal ");
				logMessage(intial + "&" + end + "is equal");
			} else {
				extentfail(intial + "&" + end +" is not equal ");
				logErrorMessage(intial + "&" + end + "is not equal");
			}
	}

	/**
	 * This method for getting the data from the hash map and returns the value
	 * 
	 * @param Name It is the name of the column
	 * @return
	 * @throws Exception
	 */
	public static String getdata(String Name) throws Exception {

		String data = "";
		if (inputdata.get().containsKey(Name)) {
			data = inputdata.get().get(Name);
		} else {
			extentfail("Given Column name is not available in the Excel"+Name);
			logErrorMessage(" Given Column name is not available in the Excel " + Name);
		}
		return data;

	}

	/**
	 * This method is to click the respective element by its text from the list of
	 * webelements.
	 * 
	 * @param listelement
	 * @param Toselect
	 * @throws Exception
	 */
	public static void listDrop(List<WebElement> listelement, String Toselect) throws Exception {
		for (WebElement element : listelement) {
			String name = element.getText();
			if (name.contains(Toselect)) {
				webWait(element);
				clickMethod(element, Toselect);
				extentpass(Toselect+"is clicked");
				logMessage(Toselect + "  is clicked");
				break;
			}
		}
	}

	/**
	 * This method is to split the given given string by comma.
	 * 
	 * @param data
	 * @return
	 */
	public static String[] splitString(String data, String symbol) {
		String arr[] = data.split(symbol);
		return arr;
	}

	public static void scrollToElement(WebElement ele) {
		JavascriptExecutor scrl = (JavascriptExecutor) DriverFactory.getDriver();
		scrl.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	/**
	 * This method is to get the text data from excel
	 * 
	 * @param sheetname
	 * @return
	 * @throws Exception
	 */
	public static Iterator<Object[]> getTestData(String sheetname) throws Exception {
		ExcelReader xlRead = null;
		int xlRowCount = 0;
		xlRead = new ExcelReader("database.xlsx", sheetname);
		xlRowCount = xlRead.getRowCount();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for (int i = 1; i < xlRowCount; i++) {
			data.add(new Object[] { xlRead.xlReader(i) });
		}
		return data.iterator();
	}

	/**
	 * This method is to get text of the element
	 * 
	 * @param element
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static String getTextElement(WebElement element, String name) throws Exception {
		String text = "";
		try {
			text = element.getText();
		} catch (Exception e) {
			extentfail("The object "+name+" is not displayed");
			logErrorMessage(" The object  " + name + " is not displayed");
		}
		return text;
	}

	/**
	 * This method waits for the given element until it is clickable
	 * 
	 * @param ele
	 */

	public static void webWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	

}