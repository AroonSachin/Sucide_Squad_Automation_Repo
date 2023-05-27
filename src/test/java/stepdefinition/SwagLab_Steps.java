package stepdefinition;


import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.swaglabs.Checkout;
import pageobjects.swaglabs.Confirmation;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.InfoPage;
import pageobjects.swaglabs.LoginPage;
import utils.Browserfactory;
import utils.DriverFactory;

public class SwagLab_Steps {
	
	
	LoginPage login;
	HomePage home;
	Checkout check;
	InfoPage info;
	Confirmation confirm;
	
	
	@Given("I launch the {string} browser.")
	public void i_launch_the_chrome_browser(String browser) throws Exception {
		DriverFactory.setDriver(Browserfactory.createBrowser(browser, "normal"));
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    login = new LoginPage();
	    home = new HomePage();
	    check = new Checkout();
	    info  = new InfoPage();
	    confirm = new Confirmation();
	}

	@Given("I Enter the URL {string}.")
	public void i_enter_the_url(String url) {
	     
		DriverFactory.getDriver().get(url);
	}

	@Then("I enter username {string} and password {string}.")
	public void i_enter_username_and_password(String username, String password) throws Exception {
	    login.enterUsernamePassword(username, password);
	     
	}

	@Then("I click on the Login button.")
	public void i_click_on_the_login_button() throws Exception {
	     
	     login.clickLogin();
	}

	@Then("I validate whether I have logged into the website successfully.")
	public void i_validate_whether_i_have_logged_into_the_website_successfully() throws Exception {
	     
	     home.verifyLogin();
	}

	@Then("I validate the prices of the product and check if the products are sorted correctly.")
	public void i_validate_the_prices_of_the_product_and_check_if_the_products_are_sorted_correctly() throws Exception {
		
		home.homepageValidation();
	     
	     
	}

	@Then("I select the products that I desire to buy.")
	public void i_select_the_products_that_i_desire_to_buy() throws Exception {
	     
	    home.selectItem(); 
	}

	@Then("I click on the Cart button.")
	public void i_click_on_the_cart_button() throws Exception {
	     
	    home.clickCart(); 
	}


	@Then("I validate product information and the product quantity {string}.")
	public void i_validate_product_information_and_the_product_quantity(String qty) throws Exception {
	     check.validateProductInfo();
	     check.validateQuantity(qty);
	     
	}

	@Then("I click on the Checkout button.")
	public void i_click_on_the_checkout_button() throws Exception {
	     check.clickOnCheckoutButton();
	     
	}

	@Then("I enter the personal information")
	public void i_enter_the_personal_information() throws Exception {
	     
	     info.info();
	    
	}

	@Then("I complete the checkout process by clicking Continue button.")
	public void i_complete_the_checkout_process_by_clicking_continue_button() throws Exception {
	     
	     info.clickContinue();
	}

	@Then("I click on the Finish button and complete the payment process.")
	public void i_click_on_the_finish_button_and_complete_the_payment_process() throws Exception {
	     
	     confirm.clickOnFinishButton();
	}

	@Then("I check whether THANK YOU FOR YOUR ORDER message is displayed which confirms that the desired products are ordered successfully.")
	public void i_check_whether_thank_you_for_your_order_message_is_displayed_which_confirms_that_the_desired_products_are_ordered_successfully() throws Exception {
	     
	     confirm.verifyOrderConfirmation();
	}


}
