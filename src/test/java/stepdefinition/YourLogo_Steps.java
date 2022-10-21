package stepdefinition;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import commonuseractions.CommonActionMethods;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.yourlogo.LoginPage;
import pageobjects.yourlogo.Orderpage;
import utils.Browserfactory;
import utils.DriverFactory;

public class YourLogo_Steps extends CommonActionMethods {

	@Given("I Launch the chrome browser")
	public void i_launch_the_chrome_browser() throws Exception {
		PropertyConfigurator.configure(configFilename);
		DriverFactory.setDriver(Browserfactory.createBrowser("chrome", "normal"));
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user enter url {string}")
	public void user_enter_url(String url) {
		DriverFactory.getDriver().get(url);
	}

	@Then("click on the sigin button")
	public void click_on_the_sigin_button() throws Exception {
		new LoginPage().siginButton();

	}

	@Then("user enter the valid email address")
	public void user_enter_the_valid_email_address() throws Exception {
		new LoginPage().email();

	}

	@Then("click on the create an account button")
	public void click_on_the_create_an_account_button() throws Exception {
		new LoginPage().createAccount();

	}

	@Then("Click the gender button")
	public void click_the_gender_button() throws Exception {
		new LoginPage().gender();
	}

	@Then("user enter the first name {string}")
	public void user_enter_the_first_name(String firstName) throws Exception {
		new LoginPage().firstName(firstName);

	}

	@Then("user enter the last name {string}")
	public void user_enter_the_last_name(String lastname) throws Exception {
		new LoginPage().lastName(lastname);

	}

	@Then("click the email checkbox")
	public void click_the_email_checkbox() throws Exception {
		new LoginPage().emailCheckBox();
	}

	@Then("user enter the valid password {string}")
	public void user_enter_the_valid_password(String Password) throws Exception {
		new LoginPage().passWord(Password);
	}

	@Then("select the date of birth {string}")
	public void select_the_date_of_birth(String DateOfBirth) throws Exception {
		new LoginPage().dateOfBirth(DateOfBirth);
	}

	@Then("click the first name")
	public void click_the_first_name() throws Exception {
		new LoginPage().addressfirstname();
	}

	@Then("click the last name")
	public void click_the_last_name() throws Exception {
		new LoginPage().addresslastname();
	}

	@Then("user enter the company name {string}")
	public void user_enter_the_company_name_it_trident(String CompanyName) throws Exception {
		new LoginPage().companyName(CompanyName);
	}

	@Then("user enter the valid address {string}")
	public void user_enter_the_valid_address(String Address) throws Exception {
		new LoginPage().address(Address);
	}

	@Then("user enter the city name {string}")
	public void user_enter_the_city_name_chennai(String CityName) throws Exception {
		new LoginPage().cityName(CityName);
	}

	@Then("select the state name {string}")
	public void select_the_state_name(String StateName) throws Exception {
		new LoginPage().stateName(StateName);
	}

	@Then("user enter the valid zip postal code {string}")
	public void user_enter_the_valid_zip_postal_code(String PostalCode) throws Exception {
		new LoginPage().postalCode(PostalCode);
	}

	@Then("click the country name")
	public void click_the_country_name() throws Exception {
		new LoginPage().countryName();
	}

	@Then("user enter the valid phone number {string}")
	public void user_enter_the_valid_phone_number(String PhoneNumber) throws Exception {
		new LoginPage().phoneNumber(PhoneNumber);
	}

	@Then("click the register button")
	public void click_the_register_button() throws Exception {
		new LoginPage().registerButton();
	}

	@Then("user enter the valid email address {string}")
	public void user_enter_the_valid_email_address_venkatesh22_gmail_com(String MailAddress) throws Exception {
		new Orderpage().mailAddress(MailAddress);
	}

	@Then("Click the signin button")
	public void click_the_signin_button() throws Exception {
		new Orderpage().submit();
		;
	}

	@Then("click the dresstype")
	public void click_the_dresstype() throws Exception {
		new Orderpage().dressType();
	}

	@Then("validate the product name")
	public void validate_the_product_name() throws Exception {
		new Orderpage().validateProductName();

	}

	@Then("click the first product")
	public void click_the_first_product() throws Exception {
		new Orderpage().chooseProduct();
	}

	@Then("click the add to card button")
	public void click_the_add_to_card_button() throws Exception {
		new Orderpage().addCard();
	}

	@Then("click the continue shopping")
	public void click_the_continue_shopping() throws Exception {
		new Orderpage().continueShopping();
	}

	@Then("validate the product2 name")
	public void validate_the_product2_name() throws Exception {
		new Orderpage().validateProduct2Name();
	}

	@Then("click the second product")
	public void click_the_second_product() throws Exception {
		new Orderpage().secondProduct();
	}

	@Then("click the add to card button1")
	public void click_the_add_to_card_button1() throws Exception {
		new Orderpage().addToCard();
	}

	@Then("click the continue shopping button")
	public void click_the_continue_shopping_button() throws Exception {
		new Orderpage().continueshop();
	}

	@Then("select the sort product button {string}")
	public void select_the_sort_product_button(String ProductName) throws Exception {
		new Orderpage().sortBYProduct(ProductName);
	}

	@Then("click the card button")
	public void click_the_card_button() throws Exception {
		new Orderpage().cardButton();

	}

	@Then("validate the total product name")
	public void validate_the_total_product2_name() throws Exception {
		new Orderpage().totalNameValidation();
		;
	}

	@Then("validate the total price")
	public void validate_the_total_price() throws Exception {
		new Orderpage().productPriceValid();
	}

	@Then("validate the adress")
	public void validate_the_adress() throws Exception {
		new Orderpage().addressValid();
	}

	@Then("click the summary proceed to checkout button")
	public void click_the_summary_proceed_to_checkout_button() throws Exception {
		new Orderpage().summaryProceedtoCheckout();
	}

	@Then("validate the billing address")
	public void validate_the_billing_address() throws Exception {
		new Orderpage().shippingBillingAddress();
	}

	@Then("click the address proceed to checkout button")
	public void click_the_address_proceed_to_checkout_button() throws Exception {
		new Orderpage().processAddress();
	}

	@Then("click the agree shipping checkout")
	public void click_the_agree_shipping_checkout() throws Exception {
		new Orderpage().agreeShippingBox();
	}

	@Then("click the shipping proceed to checkout button")
	public void click_the_shipping_proceed_to_checkout_button() throws Exception {
		new Orderpage().processShipping();
	}

	@Then("validate the total price of product")
	public void validate_the_total_price_of_product() throws Exception {
		new Orderpage().totalPriceValid();
	}

	@Then("click the pay by bankwire")
	public void click_the_pay_by_bankwire() throws Exception {
		new Orderpage().payByBankWire();
	}

	@Then("click the I confrom my order button")
	public void click_the_i_confrom_my_order_button() throws Exception {
		new Orderpage().confromOrder();
	}

	@Then("validate the complete order screen is displayed")
	public void validate_the_complete_order_screen_is_displayed() throws Exception {
		new Orderpage().completeorder();
	}

	@After
	public void closeBrowser() {
		DriverFactory.closeDriver();
	}

}
