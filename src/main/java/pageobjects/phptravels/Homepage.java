package pageobjects.phptravels;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Homepage extends CommonActionMethods {
	@FindBy(xpath = "(//ul[@class='nav nav-tabs listitems']//button)[2]")
	static WebElement flightbutton;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[1]")
	static WebElement depcity;

	@FindBy(xpath = "(//div[@class='row contact-form-action g-1']//input)[2]")
	static WebElement descity;

	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[1]//strong")
	List<WebElement> depcitylist;

	@FindBy(xpath = "(//div[@class='autocomplete-results troll intro in'])[2]//strong")
	List<WebElement> descitylist;

	@FindBy(xpath = "((//table[@class=' table-condensed'])[3]//i)[2]")
	WebElement nextarrow;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//th[@class='switch']")
	WebElement month;

	@FindBy(xpath = "(//table[@class=' table-condensed'])[3]//td[@class='day ']")
	List<WebElement> date;

	@FindBy(xpath = "(//div[@class='form-group'])[8]//input")
	WebElement calenderbox;
	
	@FindBy(xpath = "//div[@id='onereturn']//button")
	WebElement searchbutton;

	public Homepage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}

	public void SearchFlight() throws Exception {
		getTitle();
		getURL();
		logMessage("Current URL:" + getURL());
		logMessage("Current page title:" + getTitle());
		clickMethod(flightbutton, "Flight button");
		sendKeysMethod(depcity, "MAA");
		listDrop(depcitylist, " Chennai Intl");
		sendKeysMethod(descity, "LAS");
		listDrop(depcitylist, " Mc Carran Intl");
		clickMethod(calenderbox, "Calender box");
		while (true) {
			if (month.getText().equalsIgnoreCase("August 2022")) {
				break;
			} else {
				clickMethod(nextarrow, "next arrow");
			}
		}
		listDrop(date, "1");
		clickMethod(searchbutton, "Searchh button");
	}
}
