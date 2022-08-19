package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

/**
 * The class creates a thread for the given driver.
 * 
 * @author aroon
 */
public final class DriverFactory {
	
	private DriverFactory() {}
	
	// This line creates a separate thread for the given driver
	private static ThreadLocal<WebDriver> trddriver = new ThreadLocal<WebDriver>();
	/**
	 * This method sets the driver to the threadlocal to create a thread of that driver.
	 * @param driver2
	 */
	public static void setDriver(WebDriver driver2) {
		trddriver.set(ThreadGuard.protect(driver2));
	}

	/**
	 * This method gets the driver with its respective thread id.
	 * @return
	 */
	public static WebDriver getDriver() {
		return trddriver.get();
	}

	/**
	 * This method quits the driver and removes the thread.
	 */
	public static void closeDriver() {
		getDriver().quit();
		trddriver.remove();
	}
}