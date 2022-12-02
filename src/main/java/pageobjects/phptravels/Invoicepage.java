package pageobjects.phptravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import io.qameta.allure.Step;
import utils.DriverFactory;

public class Invoicepage extends CommonActionMethods{
	@FindBy(id = "form")
	WebElement proceedbutton;

	@FindBy(xpath = "//div[@class='d-flex align-items-center mb-4']//i")
	WebElement Confirmationele;

	@FindBy(xpath = "//span[@class='text-right']")
	WebElement reservationnum;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//span)[1]")
	WebElement adultnum;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//span)[2]")
	WebElement childnum;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//li)[1]")
	WebElement infantnum;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//li)[2]")
	WebElement bookingtax;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//li)[3]")
	WebElement depositprice;

	@FindBy(xpath = "(//ul[@class='list-group list-group-flush']//li)[4]")
	WebElement totalprice;
	/**
	 * Constructor to store the webelements.
	 */
	public Invoicepage(){
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	/**
	 * This method validates the number of passenger's and the price.
	 * @param actladlt
	 * @param actlchld
	 * @param actlinfnt
	 * @throws Exception
	 */
	@Step("To validate the flight detail's and price")
	public void invoiceValidation() throws Exception {
		getTitle();
		getURL();
//		isDisplayed(Confirmationele,"Confirmation ");
		logMessage("Resrvation number: "+getTextElement(reservationnum,"Resrvation number" ));
		double actlnewtotal = Paxdetailspage.returntotal();
		String totl = getTextElement(totalprice, " ");
		String[] finalprz = splitString(totl, " ");
		double finlprz = Double.valueOf(finalprz[3]);
		checkEquality(actlnewtotal, finlprz);
	}
	/**
	 * This method is to click proceed button.
	 * @throws Exception
	 */
	@Step("To click Proceed to pay button")
	public void proceed() throws Exception {
		clickMethod(proceedbutton, "Proceed button");
	}
}
