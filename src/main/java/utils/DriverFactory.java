package utils;

import org.openqa.selenium.WebDriver;

/**
 * The class creates a thread for the given driver.
 * 
 * @author aroon
 */
public class DriverFactory {
	// This line creates a seperate thread for the given driver
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/**
	 * This method sets the driver to the threadlocal to create a thread of that
	 * driver.
	 * 
	 * @param driverparam
	 */
	public static void setDriver(WebDriver driverparam) {
		driver.set(driverparam);
	}

	/**
	 * This method gets the driver with its respective thread id.
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * This method quits the driver and removes the thread.
	 */
	public static void closeDriver() {
		driver.get().quit();
		driver.remove();
	}

}
