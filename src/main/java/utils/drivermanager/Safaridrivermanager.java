package utils.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Safaridrivermanager {
	public WebDriver createDriver(String browsertype) {
		if (browsertype.equalsIgnoreCase("Headless")) {
		WebDriverManager.safaridriver().setup();
		return  new  SafariDriver();
		}
		else {
			System.out.println("Safari won't support Headless");
			return null;
		}
	}
}
