package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import utils.drivermanager.Chromedrivermanager;
import utils.drivermanager.Firefoxdrivermanager;
import utils.drivermanager.Safaridrivermanager;

public class DriverFactory {

	public static WebDriver launchBrowser(String browser, String browsertype) {
		WebDriver driver;

		browserList browsername = browserList.valueOf(browser.toUpperCase());

		switch (browsername) {

		case CHROME:
			driver = new Chromedrivermanager().createDriver(browsertype);
			break;

		case FIREFOX:
			driver = new Firefoxdrivermanager().createDriver(browsertype);
			break;

		case SAFARI:
			driver = new Safaridrivermanager().createDriver(browsertype);
			break;
		default:
			throw new UnreachableBrowserException(browsertype);
		}
		return driver;
	}

	public enum browserList {

		CHROME, FIREFOX, SAFARI

	}

}
