package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The class invokes the requested browser
 * 
 * @author aroon
 *
 */
public class Browserfactory {
	/**
	 * The method will invoke the requested browser in the requested browsertype
	 * 
	 * @param browser
	 * @param browsertype
	 * @return WebDriver
	 */
	public static WebDriver createBrowser(String browser, String browsertype) {
		WebDriver driver = null;
		// To lauunch the requested browser in the requested type
		switch (browser.toUpperCase()) {
		// To launch Chrome.
		case "CHROME":
			if (browsertype.equalsIgnoreCase("headless")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--" + browsertype);
				driver = new ChromeDriver();
				break;
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			// To launch Fire fox
		case "FIREFOX":
			if (browsertype.equalsIgnoreCase("headless")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions opt = new FirefoxOptions();
				opt.addArguments("--" + browsertype);
				driver = new FirefoxDriver();
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			break;
		// To lauch Safari.
		case "SAFARI":
			if (browsertype.equalsIgnoreCase("headless")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				System.out.println("Headless not supported in safari");
			} else {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			break;
		default:
			System.out.println("Browser not found");

		}
		return driver;
	}

}
