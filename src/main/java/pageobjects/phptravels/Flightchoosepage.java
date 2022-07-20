package pageobjects.phptravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Flightchoosepage extends CommonActionMethods {
	
	@FindBy(xpath = "(//div[@class='row g-0'])[2]//button")
	static
	WebElement bookbutton;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-city'])[1]")
	WebElement frmcty;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-city'])[2]")
	WebElement tocty;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-city'])[3]")
	WebElement rtrnfrmcity;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-city'])[4]")
	WebElement rtrntocity;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-time'])[1]")
	WebElement deptime;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-time'])[2]")
	WebElement destime;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-time'])[3]")
	WebElement rtrndeptime;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-time'])[4]")
	WebElement rtrndestime;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-date'])[1]")
	WebElement depdate;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-date'])[2]")
	WebElement desdate;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-date'])[3]")
	WebElement rtrndepdate;
	
	@FindBy(xpath = "((//div[@class='row'])[6]//p[@class='theme-search-results-item-flight-section-meta-date'])[4]")
	WebElement rtrndesdate;
	
	public Flightchoosepage(){
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	
	public void chooseFlight() throws Exception {
		getTitle();
		getURL();
		clickMethod(bookbutton, "Book button");
	}
	public void flightDetailValidate() {
		
	}

}
