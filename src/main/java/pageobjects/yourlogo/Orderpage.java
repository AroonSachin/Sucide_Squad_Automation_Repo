package pageobjects.yourlogo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import commonuseractions.CommonVariables;
import utils.DriverFactory;

/**
 * @This class is to order the product and validate
 * @author vbaskar
 *
 */
public class Orderpage extends CommonActionMethods {
	
	 
	 static String billing1 = null;
	 static String billing2 = null;
	 static String billing3 = null;
	 static String billing4 = null;
	 static String billing5 = null;
	 static String billing6 = null;
	 
	
	@FindBy(xpath = "//div[@class='header_user_info']//a[@title='Log in to your customer account']")
	public  WebElement signin;
	
	@FindBy(id="email")
	public  WebElement mailaddress;
	
	@FindBy(id="passwd")
	public  WebElement mailpassword;
	
	@FindBy(id="SubmitLogin")
	public  WebElement submit;

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Women']")
	public  WebElement dresstype;

	@FindBy(xpath = "//div[@id='uniform-selectProductSort']//select")
	public  WebElement sortproduct;

	@FindBy(xpath = "//div[@class='product-container']//img[@title='Faded Short Sleeve T-shirts']")
	public  WebElement chooseproduct;

	@FindBy(xpath = "//iframe[@id='fancybox-frame1658215203142']")
	public  WebElement frame;

	@FindBy(id = "add_to_cart")
	public  WebElement addcart;

	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	public  WebElement continueshopping;

	@FindBy(xpath = "//ul[@class='product_list grid row']//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")
	public  WebElement choosingproduct;

	@FindBy(xpath = "//button[@name='Submit']")
	public  WebElement addtocart;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	public  WebElement continueshop;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	public  WebElement cart;

	@FindBy(xpath = "//div[@class='button-container']//a[@title='Proceed to checkout']")
	public  WebElement proceedtocheckout;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	public  WebElement summaryproceedtocheckout;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@name='processAddress']")
	public  WebElement processaddress;

	@FindBy(xpath = "//div[@class='checker']//input[@id='cgv']")
	public  WebElement agreeshippingbox;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//button[@type='submit']")
	public  WebElement processshipping;

	@FindBy(xpath = "//div[@class='col-xs-12 col-md-6']//a[@title='Pay by bank wire']")
	public  WebElement paybybankwire;

	@FindBy(xpath = "//p[@id='cart_navigation']//button[@type='submit']")
	public  WebElement confromorder;

	@FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[2]")
	public  WebElement namevalidation;

	@FindBy(xpath = "(//span[@class='price product-price'])[2]")
	public  WebElement pricevalidation;

	@FindBy(xpath = "//a[text()='Faded Short Sleeve T-shirts']")
	public  WebElement cartvalidation;

	@FindBy(xpath = "(//span[@class='price'])[5]")
	public  WebElement cardpricevalidation;

	@FindBy(xpath = "(//a[@title=\"Blouse\"])[2]")
	public  WebElement nametwovalidation;

	@FindBy(xpath = "(//span[@class='price product-price'])[4]")
	public  WebElement pricetwovalidation;

	@FindBy(xpath = "(//a[text()='Blouse'])[2]")
	public  WebElement cardtwovalidation;

	@FindBy(xpath = "(//span[@class='price'])[8]")
	public  WebElement cardprice2;

	@FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
	public  WebElement completeorder;

	@FindBy(xpath = "(//span[@class='address_name'])[1]")
	public  WebElement addressname;

	@FindBy(xpath = "(//span[@class='address_company'])[1]")
	public  WebElement addresscompany;

	@FindBy(xpath = "(//span[@class='address_address1'])[1]")
	public  WebElement addressvalidation;

	@FindBy(xpath = "(//span[@class='address_city'])[1]")
	public  WebElement addresscity;

	@FindBy(xpath = "//ul[@class='address first_item item box']//li[6]")
	public  WebElement addressstate;

	@FindBy(xpath = "(//span[@class='address_phone_mobile'])[1]")
	public  WebElement addressmobilenumber;

	@FindBy(xpath = "(//li[@class='address_firstname address_lastname'])[2]")
	public  WebElement billingaddressname;

	@FindBy(xpath = "(//li[@class='address_company'])[2]")
	public  WebElement billingaddresscompany;

	@FindBy(xpath = "(//li[@class='address_address1 address_address2'])[2]")
	public  WebElement billingaddressvalidation;

	@FindBy(xpath = "(//li[@class='address_city address_state_name address_postcode'])[2]")
	public  WebElement billingaddresscity;

	@FindBy(xpath = "(//li[@class='address_country_name'])[2]")
	public  WebElement billingaddressstate;

	@FindBy(xpath = "(//li[@class='address_phone_mobile'])[2]")
	public  WebElement billingaddressmobilenumber;

	@FindBy(xpath = "//span[@id=\"total_price\"]")
	public  WebElement totalprice;

	@FindBy(id = "total_price_container")
	public  WebElement finalprice;

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
		namevalidating();
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
		CommonVariables.setProduct1(getTextElement(namevalidation, "product1")); 
		CommonVariables.setPrice1(getTextElement(pricevalidation, "price1")); 
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */
	private void blouseValidation() throws Exception {
		CommonVariables.setProduct2(getTextElement(nametwovalidation, "product2")); 
		CommonVariables.setPrice2(getTextElement(pricetwovalidation, "price2")); 
	}

	/**
	 * @This method validate the product name and price
	 * @throws Exception
	 */
	public void namevalidating() throws Exception {
		checkEquality(CommonVariables.getProduct1(), getTextElement(cartvalidation, "product1"));
		checkEquality(CommonVariables.getPrice1(), getTextElement(cardpricevalidation, "price1"));
		checkEquality(CommonVariables.getProduct2(), getTextElement(cardtwovalidation, "product2"));
		checkEquality(CommonVariables.getPrice2(), getTextElement(cardprice2, "price2"));
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */

	private void addressvalid() throws Exception {
		CommonVariables.setAddress1(getTextElement(addressname, "addressvalidation2")); 
		CommonVariables.setAddress2( getTextElement(addresscompany, "addressvalidation3")); 
		CommonVariables.setAddress3(getTextElement(addressvalidation, "addressvalidation4"));
		CommonVariables.setAddress4(getTextElement( addresscity, "addressvalidation5")); 
		CommonVariables.setAddress5(getTextElement(addressstate, "addressvalidation6")); 
		CommonVariables.setAddress6(getTextElement(addressmobilenumber, "addressvalidation7")); 
	}

	/**
	 * @This method validate the address
	 * @throws Exception
	 */

	private void billingAddress() throws Exception {
		checkEquality(CommonVariables.getAddress1(), getTextElement(billingaddressname, "billing1"));
		checkEquality(CommonVariables.getAddress2(), getTextElement(billingaddresscompany, "billing2"));
		checkEquality(CommonVariables.getAddress3(), getTextElement(billingaddressvalidation, "billing3"));
		checkEquality(CommonVariables.getAddress4(), getTextElement(billingaddresscity, "billing4"));
		checkEquality(CommonVariables.getAddress5(), getTextElement(billingaddressstate, "billing5"));
		checkEquality(CommonVariables.getAddress6(), getTextElement(billingaddressmobilenumber, "billing6"));
	}

	/**
	 * @This method gettext from the element and store in the given variable
	 * @throws Exception
	 */

	private void priceValidation() throws Exception {
		CommonVariables.setTotalprice1( getTextElement(totalprice, "totalprice")); 
	}

	/**
	 * @This method validate the total price
	 * @throws Exception
	 */
	private void totalPriceValidation() throws Exception {
		checkEquality(CommonVariables.getTotalprice1(), getTextElement(finalprice, "totalprice2"));

	}

	/**
	 * @This method validate sort the product
	 * @throws Exception
	 */

	public void verifyProductName() throws Exception {
		List<String> namearr = new ArrayList<>();
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
	
	/**
	 * @This method for enter the valid mail address
	 * @throws Exception
	 */
	public void mailaddressed(String mail) throws Exception {
		sendKeysMethod(mailaddress, mail);
	}
	/**
	 * @This method for Clicking a submit button
	 * @throws Exception
	 */
    public void submited() throws Exception {
		clickMethod(submit,"submitbutton");
	}
    /**
     * @This method for Clicking a dresstype button
     * @throws Exception
     */
    public void dresstypes() throws Exception {
    	clickMethod(dresstype, "dresstype");
	}
    /**
     * @This method validate a product name
     * @throws Exception
     */
    public void validateProductName() throws Exception {
    	fadedShortValidation();
		
	}
    /**
     * @This method for Clicking a product button
     * @throws Exception
     */
    public void chooseproducts() throws Exception {
    	clickMethod(chooseproduct, "chooseproduct");

	}
    /**
     * @This method for Clicking a Addtocard button
     * @throws Exception
     */
    public void addCard() throws Exception {
    	frameByIndex(0);
		clickMethod(addcart, "addcart");
	}
    /**
     * @This method for Clicking a continue shopping button
     * @throws Exception
     */
    public void continueshoppings() throws Exception {
		defaultwindow();
		webWait(continueshopping);
    	clickMethod(continueshopping, "continueshopping");
	}
    /**
     * @This method validate the product name
     * @throws Exception
     */
    public void validateProduct2Name() throws Exception {
    	blouseValidation();
	}
    /**
     * @This method for Clicking a product button
     * @throws Exception
     */
    public void secondProduct() throws Exception {
    	webWait(choosingproduct);
		clickMethod(choosingproduct, "choosingproduct");
	}
    /**
     * @This method for Clicking a addtocard button
     * @throws Exception
     */
    public void addToCard() throws Exception {
    	frameByIndex(0);
		clickMethod(addtocart, "addtocart");
		
	}
    /**
     * @This method for Clicking a continue shopping button
     * @throws Exception
     */
    public void continueshoping() throws Exception {
    	defaultwindow();
    	clickMethod(continueshop, "continueshop");
	}
    /**
     * @This method for Clicking a sortproduct button
     * @param productName
     * @throws Exception
     */
    public void sortBYProduct(String productName) throws Exception {
    	selectByVisibleText(sortproduct, productName );    	
	}
    /**
     * @This method for Clicking a cart button
     * @throws Exception
     */
    public void cardButton() throws Exception {
    	clickMethod(cart, "shopping cart");
	}
    /**
     * @This method validate a product Name
     * @throws Exception
     */
    public void totalNameValidation() throws Exception {
    	namevalidating();
	}
    /**
     * @This method validate a productPrice
     * @throws Exception
     */
     public void productPriceValid() throws Exception {
    	 priceValidation();
	}
     /**
      * @This method validate a address
      * @throws Exception
      */
     public void addressvalidations() throws Exception {
    	 addressvalid();
	}
     /**
      * @This method for Clicking a summaryProceedtoCheckout button
      * @throws Exception
      */
     public void summaryproceedcheckout() throws Exception {
    	 clickMethod(summaryproceedtocheckout, "summaryproceedtocheckout");
	}
     /**
      * @This method validate a shipping address
      * @throws Exception
      */
     public void shippingBillingAddress() throws Exception {
    	 billingAddress();         
	}
     /**
      * @This method for Clicking a processAddress button
      * @throws Exception
      */
    public void processaddressed() throws Exception {
    	clickMethod(processaddress, "processaddress");	
	}
    /**
     * @This method for Clicking a agreeShippingBox button
     * @throws Exception
     */
    public void agreeshippingboxs() throws Exception {
    	clickMethod(agreeshippingbox, "agreeshippingbox");
	}
    /**
     * @This method for Clicking a processShipping button
     * @throws Exception
     */
    public void processshippings() throws Exception {
		clickMethod(processshipping, "processshipping");
	}
    /**
     * @This method validate a total price
     * @throws Exception
     */
    public void totalPriceValid() throws Exception {
		totalPriceValidation();
	}
	/**
	 * @This method for Clicking a payByBankWire button
	 * @throws Exception
	 */
    public void paybybankwires() throws Exception {
    	clickMethod(paybybankwire, "paybybankwire");
	}
    /**
     * @This method for Clicking a confromOrder button
     * @throws Exception
     */
    public void confromordered() throws Exception {
		clickMethod(confromorder, "confromorder");
	}
    /**
     * @This method validate a completeorder screen will be displayed or not
     * @throws Exception
     */
    public void completeordered() throws Exception {
		isDisplayed(completeorder, "completeorder");
	}
}
