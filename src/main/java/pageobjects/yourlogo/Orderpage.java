package pageobjects.yourlogo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.tools.DocumentationTool.Location;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * @This class is to order the product and validate
 * @author vbaskar
 *
 */
public class Orderpage extends CommonActionMethods {
	public static String product1 = null;
	public static String price1 = null;
	public static String product2 = null;
	public static String price2 = null;
	public static String address1 = null;
	public static String address2 = null;
	public static String address3 = null;
	public static String address4 = null;
	public static String address5 = null;
	public static String address6 = null;
	public static String billing1 = null;
	public static String billing2 = null;
	public static String billing3 = null;
	public static String billing4 = null;
	public static String billing5 = null;
	public static String billing6 = null;
	public static String totalprice1 = null;
	public static String totalprice2 = null;

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Women']")
	public static WebElement dresstype;

	@FindBy(xpath = "//div[@id='uniform-selectProductSort']//select")
	public static WebElement sortproduct;

	@FindBy(xpath = "//div[@class='product-container']//img[@title='Faded Short Sleeve T-shirts']")
	public static WebElement chooseproduct;

	@FindBy(xpath = "//iframe[@id='fancybox-frame1658215203142']")
	public static WebElement frame;

	@FindBy(id = "add_to_cart")
	public static WebElement addcart;

	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	public static WebElement continueshopping;

	@FindBy(xpath = "//ul[@class='product_list grid row']//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")
	public static WebElement choosingproduct;

	@FindBy(xpath = "//button[@name='Submit']")
	public static WebElement addtocart;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	public static WebElement continueshop;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	public static WebElement cart;

	@FindBy(xpath = "//div[@class='button-container']//a[@title='Proceed to checkout']")
	public static WebElement proceedtocheckout;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	public static WebElement summaryproceedtocheckout;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@name='processAddress']")
	public static WebElement processaddress;

	@FindBy(xpath = "//div[@class='checker']//input[@id='cgv']")
	public static WebElement agreeshippingbox;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
	public static WebElement processshipping;

	@FindBy(xpath = "//div[@class='col-xs-12 col-md-6']//a[@title='Pay by bank wire']")
	public static WebElement paybybankwire;

	@FindBy(xpath = "//p[@id='cart_navigation']//button[@type='submit']")
	public static WebElement confromorder;

	@FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
	public static WebElement namevalidation;

	@FindBy(xpath = "(//span[@class='price product-price'])[2]")
	public static WebElement pricevalidation;

	@FindBy(xpath = "//a[text()='Faded Short Sleeve T-shirts']")
	public static WebElement cartvalidation;

	@FindBy(xpath = "(//span[@class='price'])[5]")
	public static WebElement cardpricevalidation;

	@FindBy(xpath = "(//a[@title=\"Blouse\"])[2]")
	public static WebElement nametwovalidation;

	@FindBy(xpath = "(//span[@class='price product-price'])[4]")
	public static WebElement pricetwovalidation;

	@FindBy(xpath = "(//a[text()='Blouse'])[2]")
	public static WebElement cardtwovalidation;

	@FindBy(xpath = "(//span[@class='price'])[8]")
	public static WebElement cardprice2;

	@FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
	public static WebElement completeorder;

	@FindBy(xpath = "(//span[@class='address_name'])[1]")
	public static WebElement addressvalidation2;

	@FindBy(xpath = "(//span[@class='address_company'])[1]")
	public static WebElement addressvalidation3;

	@FindBy(xpath = "(//span[@class='address_address1'])[1]")
	public static WebElement addressvalidation4;

	@FindBy(xpath = "(//span[@class='address_city'])[1]")
	public static WebElement addressvalidation5;

	@FindBy(xpath = "//*[@id=\"center_column\"]/div[3]/div[1]/ul/li[6]/span")
	public static WebElement addressvalidation6;

	@FindBy(xpath = "(//span[@class='address_phone_mobile'])[1]")
	public static WebElement addressvalidation7;

	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[2]")
	public static WebElement billingaddressvalid1;

	@FindBy(xpath = "(//li[@class='address_company'])[2]")
	public static WebElement billingaddressvalid2;

	@FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]")
	public static WebElement billingaddressvalid3;

	@FindBy(xpath = "(//li[@class='address_city address_state_name address_postcode'])[2]")
	public static WebElement billingaddressvalid4;

	@FindBy(xpath = "(//li[@class='address_country_name'])[2]")
	public static WebElement billingaddressvalid5;

	@FindBy(xpath = "(//li[@class='address_phone_mobile'])[2]")
	public static WebElement billingaddressvalid6;

	@FindBy(xpath = "//span[@id=\"total_price\"]")
	public static WebElement totalprice;

	@FindBy(id = "total_price_container")
	public static WebElement finalprice;

	@FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name']")
	List<WebElement> productname;

	public Orderpage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}

	/**
	 * @This method should be used for call the elements
	 * @throws Exception
	 */
	public void order() throws Exception {
		webWait(dresstype);
		clickMethod(dresstype, "dresstype");
		fadedShortValidation();
		clickMethod(chooseproduct, "chooseproduct");
		frameByIndex(0);
		clickMethod(addcart, "addcart");
		defaultwindow();
		clickMethod(continueshopping, "continueshopping");
		blouseValidation();
		clickMethod(choosingproduct, "choosingproduct");
		frameByIndex(0);
		clickMethod(addtocart, "addtocart");
		defaultwindow();
		clickMethod(continueshop, "continueshop");
		selectByVisibleText(sortproduct, "Product Name: A to Z");
		verifyProductName();
		clickMethod(cart, "shopping cart");
		nameValidation();
		priceValidation();
		addressvalid();
		clickMethod(summaryproceedtocheckout, "summaryproceedtocheckout");
		billingAddress();
		clickMethod(processaddress, "processaddress");
		clickMethod(agreeshippingbox, "agreeshippingbox");
		clickMethod(processshipping, "processshipping");
		totalPriceValidation();
		clickMethod(paybybankwire, "paybybankwire");
		clickMethod(confromorder, "confromorder");
		isDisplayed(completeorder, "completeorder");
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */
	private void fadedShortValidation() throws Exception {
		product1 = getTextElement(namevalidation, "product1");
		price1 = getTextElement(pricevalidation, "price1");
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */
	private void blouseValidation() throws Exception {
		product2 = getTextElement(nametwovalidation, "product2");
		price2 = getTextElement(pricetwovalidation, "price2");
	}

	/**
	 * @This method validate the product name and price
	 * @throws Exception
	 */
	public void nameValidation() throws Exception {
		checkEquality(product1, getTextElement(cartvalidation, "product1"));
		checkEquality(price1, getTextElement(cardpricevalidation, "price1"));
		checkEquality(product2, getTextElement(cardtwovalidation, "product2"));
		checkEquality(price2, getTextElement(cardprice2, "price2"));
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */

	private void addressvalid() throws Exception {
		address1 = getTextElement(addressvalidation2, "addressvalidation2");
		address2 = getTextElement(addressvalidation3, "addressvalidation3");
		address3 = getTextElement(addressvalidation4, "addressvalidation4");
		address4 = getTextElement(addressvalidation5, "addressvalidation5");
		address5 = getTextElement(addressvalidation6, "addressvalidation6");
		address6 = getTextElement(addressvalidation7, "addressvalidation7");
	}

	/**
	 * @This method validate the address
	 * @throws Exception
	 */

	private void billingAddress() throws Exception {
		checkEquality(address1, getTextElement(billingaddressvalid1, "billing1"));
		checkEquality(address2, getTextElement(billingaddressvalid2, "billing2"));
		checkEquality(address3, getTextElement(billingaddressvalid3, "billing3"));
		checkEquality(address4, getTextElement(billingaddressvalid4, "billing4"));
		checkEquality(address5, getTextElement(billingaddressvalid5, "billing5"));
		checkEquality(address6, getTextElement(billingaddressvalid6, "billing6"));
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */

	private void priceValidation() throws Exception {
		totalprice1 = getTextElement(totalprice, "totalprice");
	}

	/**
	 * @This method validate the total price
	 * @throws Exception
	 */
	private void totalPriceValidation() throws Exception {
		checkEquality(totalprice1, getTextElement(finalprice, "totalprice2"));

	}

	/**
	 * @This method validate sort the product
	 * @throws Exception
	 */

	public void verifyProductName() throws Exception {
		List<String> namearr = new ArrayList<String>();
		for (int i = 0; i < productname.size(); i++) {
			for (WebElement ele : productname) {
				namearr.add(getTextElement(ele, "product name"));
			}
		}
		List<String> afterSortchar = namearr.stream().sorted().collect(Collectors.toList());
		if (namearr.equals(afterSortchar)) {
			logMessage("product name are sorted correctly ");
		} else {
			logMessage("product name are not sorted correctly ");
		}

	}

}
