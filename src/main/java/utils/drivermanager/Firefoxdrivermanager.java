package utils.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Firefoxdrivermanager {
	public WebDriver createDriver(String browsertype) {
		if (!browsertype.equalsIgnoreCase("Headless")) {
		WebDriverManager.firefoxdriver().setup();
		return  new FirefoxDriver();
		}
		else {
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--Headless");
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		}
 		 
	}
}
