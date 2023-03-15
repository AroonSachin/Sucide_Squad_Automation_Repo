package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import commonuseractions.CommonActionMethods;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.phptravels.Flightchoosepage;
import pageobjects.phptravels.Homepage;
import pageobjects.phptravels.Invoicepage;
import pageobjects.phptravels.Paxdetailspage;
import utils.Browserfactory;
import utils.DriverFactory;

public class PhpTravels_Steps extends CommonActionMethods {

//	Homepage home;
//	Flightchoosepage flightchoose;
//	Paxdetailspage paxDetails;
//	static String trip = "round trip";
//
////	@Given("I launch the {string} browser.")
////	public void i_launch_the_chrome_browser(String browser) throws Exception {
////		PropertyConfigurator.configure(configFilename);
////		DriverFactory.setDriver(Browserfactory.createBrowser(browser, "Normal"));
////		DriverFactory.getDriver().manage().window().maximize();
////		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////		logMessage(" Url Launched ");
////		home = new Homepage();
////		flightchoose = new Flightchoosepage();
////		paxDetails = new Paxdetailspage();
////	}
//
//	@Given("I Enter the URL {string}.")
//	public void i_enter_the_url(String link) throws Exception {
//		try {
//			DriverFactory.getDriver().get(link);
//		} catch (Exception e) {
//			logErrorMessage(" Url not launched ");
//		}
//	}
//
//	@Then("I click on the Flights tab.")
//	public void i_click_on_the_flights_tab() throws Exception {
//		home.clickingFlightTab();
//	}
//
//	@Then("I enter the departure city {string} and destination city {string}.")
//	public void I_enter_the_departure_city_and_city(String departure, String destination) throws Exception {
//		home.enterCities(departure, destination);
//	}
//
//	@Then("i choose trip type {string}.")
//	public void i_choose_trip_type(String tripType) throws Exception {
//		trip = tripType;
//		home.chooseTrip(tripType);
//	}
//
//	@Then("I select the departure date {string} and return date {string}.")
//	public void i_select_the_and(String depDate, String desDate) throws InterruptedException, Exception {
//		home.selectDate(depDate, desDate, trip);
//	}
//
//	@Then("I select the number of passengers {string}.")
//	public void i_select_the_number_of(String pax) throws Exception {
//		home.selectNoOfPax(pax);
//	}
//
//	@Then("I click the search button.")
//	public void i_click_the_search_button() throws Exception {
//		home.clickingsrchBtn();
//	}
//
//	@Then("I Validate the Search outcomes.")
//	public void i_validate_the_search_outcomes() throws Exception {
//		flightchoose.validateFlight(trip);
//	}
//
//	@Then("I click on the book button.")
//	public void i_click_on_the_book_button() throws Exception {
//		flightchoose.chooseFlight();
//	}
//
//	@Then("I fill the passengerdetails.")
//	public void i_fill_the_passengerdetails() throws Exception {
//		paxDetails.personalDet();
//		paxDetails.paxTitle();
//		paxDetails.paxdobMonth();
//		paxDetails.dobday();
//		paxDetails.dobYear();
//		paxDetails.pidMonth();
//		paxDetails.pidDay();
//		paxDetails.pidYear();
//		paxDetails.pedMonth();
//		paxDetails.pedDay();
//		paxDetails.pedYear();
//		paxDetails.firstName();
//		paxDetails.lastName();
//		paxDetails.passportID();
//		paxDetails.nationality();
//	}
//
//	@Then("I Validate the price.")
//	public void i_validate_the_price() throws Exception {
//		paxDetails.validatePrice();
//	}
//
//	@Then("I click on the Terms and conditions checkBox.")
//	public void i_click_on_the_terms_and_conditions_check_box() throws Exception {
//		paxDetails.tcCheckBox();
//	}
//
//	@Then("I click on the Confirm booking button.")
//	public void i_click_on_the_confirm_booking_button() throws Exception {
//		paxDetails.clickBook();
//	}
//
//	@Then("I validate the Total Price.")
//	public void i_validate_the_total_price() throws Exception {
//		new Invoicepage().invoiceValidation();
//	}
//
//	@Then("I click on Proceed button.")
//	public void i_click_on_proceed_button() throws Exception {
//		new Invoicepage().proceed();
//	}
//
//	@After
//	public void quit() {
//		DriverFactory.closeDriver();
//	}

}
