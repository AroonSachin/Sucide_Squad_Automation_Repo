package utils.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chromedrivermanager{
	public WebDriver createDriver(String browsertype) {
		
		if (!browsertype.equalsIgnoreCase("Headless")) {
		WebDriverManager.chromedriver().setup();
		return  new ChromeDriver();
		}
		else {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--Headless");
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(opt);
		}
 		 
	}
	
}
