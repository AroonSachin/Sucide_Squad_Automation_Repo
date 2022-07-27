package pageobjects.yourlogo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Orderpage extends CommonActionMethods {

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Women']")
	public static WebElement dresstype;

	@FindBy(xpath = "//div[@id='uniform-selectProductSort']//select")
	public static WebElement sortproduct;

	@FindBy(xpath = "//div[@class='product-container']//img[@title='Faded Short Sleeve T-shirts']")
	public static WebElement chooseproduct;

	@FindBy(xpath = "//iframe[@id='fancybox-frame1658215203142']")
	public static WebElement frame;

	@FindBy(xpath = "//button[@name='Submit']")
	public static WebElement addcart;

	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	public static WebElement continueshopping;

	@FindBy(xpath = "//ul[@class='product_list grid row']//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")
	public static WebElement choosingproduct;

	@FindBy(xpath = "//button[@name='Submit']")
	public static WebElement addtocart;

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

	@FindBy(xpath = "(//div[@class='content_price'])[2]")
	public static WebElement pricevalidation;

	@FindBy(xpath = "//a[text()='Faded Short Sleeve T-shirts']")
	public static WebElement cartvalidation;

	@FindBy(xpath = "//span[text()='$16.51']")
	public static WebElement cardpricevalidation;

	@FindBy(xpath = "(//a[@title=\"Blouse\"])[2]")
	public static WebElement nametwovalidation;

	@FindBy(xpath = "(//span[@class=\"price product-price\"])[4]")
	public static WebElement pricetwovalidation;

	@FindBy(xpath = "(//a[text()='Blouse'])[2]")
	public static WebElement cardtwovalidation;

	@FindBy(xpath = "//span[text()='$27.00']")
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

	@FindBy(xpath = "(//li[text()='venkatesh baskar'])[2]")
	public static WebElement billingaddressvalid1;

	@FindBy(xpath = "(//li[text()='it trident'])[2]")
	public static WebElement billingaddressvalid2;

	@FindBy(xpath = "(//li[text()='5.IT trident ,northusman road ,3rd floor,tnagar,chennai '])[2]")
	public static WebElement billingaddressvalid3;

	@FindBy(xpath = "(//li[text()='chennai, Alabama 61291'])[2]")
	public static WebElement billingaddressvalid4;

	@FindBy(xpath = "(//li[text()='United States'])[2]")
	public static WebElement billingaddressvalid5;

	@FindBy(xpath = "(//li[text()='9585153985'])[2]")
	public static WebElement billingaddressvalid6;
	
	@FindBy(xpath="//span[@id=\"total_price\"]")
	public static WebElement totalprice;
	
	@FindBy(xpath="//span[text()='$47.33']")
	public static WebElement finalprice;
	
	@FindBy(xpath="//ul[@class='product_list grid row']//a[@class='product-name']")
    List<WebElement> productname;
	
	public Orderpage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}

	public void order() throws Exception {
		Thread.sleep(10000);
		clickMethod(dresstype, "dresstype");
		selectByVisibleText(sortproduct, "Product Name: A to Z");
		verifyPrice();
		product1 = getTextElement(namevalidation, "product1");
		price1 = getTextElement(pricevalidation, "price1");
		clickMethod(chooseproduct, "chooseproduct");
		frameByIndex(0);
		Thread.sleep(10000);
		clickMethod(addcart, "addcart");
		defaultwindow();
		clickMethod(continueshopping, "continueshopping");
		Thread.sleep(10000);
		product2 = getTextElement(nametwovalidation, "product2");
		price2 = getTextElement(pricetwovalidation, "price2");
		clickMethod(choosingproduct, "choosingproduct");
		frameByIndex(0);
		clickMethod(addtocart, "addtocart");
		defaultwindow();
		clickMethod(proceedtocheckout, "proceedtocheckout");
		validation();
		totalprice1=getTextElement(totalprice, "totalprice");
		addressvalid();
		clickMethod(summaryproceedtocheckout, "summaryproceedtocheckout");
		billingAddress();
		clickMethod(processaddress, "processaddress");
		clickMethod(agreeshippingbox, "agreeshippingbox");
		clickMethod(processshipping, "processshipping");
		checkEquality(totalprice1, getTextElement(finalprice, "totalprice2"));
		clickMethod(paybybankwire, "paybybankwire");
		clickMethod(confromorder, "confromorder");
		isDisplayed(completeorder, "completeorder");
	}

	public void validation() throws Exception {

		checkEquality(product1, getTextElement(cartvalidation, "product1"));
		checkEquality(price1, getTextElement(cardpricevalidation, "price1"));
		checkEquality(product2, getTextElement(cardtwovalidation, "product2"));
		checkEquality(price2, getTextElement(cardprice2, "price2"));
	}
	
	private void addressvalid() throws Exception {
		address1 = getTextElement(addressvalidation2, "addressvalidation2");
		address2 = getTextElement(addressvalidation3, "addressvalidation3");
		address3 = getTextElement(addressvalidation4, "addressvalidation4");
		address4 = getTextElement(addressvalidation5, "addressvalidation5");
		address5 = getTextElement(addressvalidation6, "addressvalidation6");
		address6 = getTextElement(addressvalidation7, "addressvalidation7");
	}
	private void billingAddress() throws Exception {
		checkEquality(address1, getTextElement(billingaddressvalid1, "billing1"));
		checkEquality(address2, getTextElement(billingaddressvalid2, "billing2"));
		checkEquality(address3, getTextElement(billingaddressvalid3, "billing3"));
		checkEquality(address4, getTextElement(billingaddressvalid4, "billing4"));
		checkEquality(address5, getTextElement(billingaddressvalid5, "billing5"));
		checkEquality(address6, getTextElement(billingaddressvalid6, "billing6"));
	}
	
		public void verifyPrice() throws Exception {
			String[] price;
			List<String> pricearr = new ArrayList<String>();
			boolean flag = true;
			for (int i = 0; i < productname.size(); i++) {
				//pricearr.add(getTextElement(productname.get(i), ""));
			//	 price[i]=getTextElement(productname.get(i), "");
						
			}
			List<Character> pdChar = new ArrayList<Character>();
			for (int i = 0; i < pricearr.size(); i++) {
		        Character pdName=pricearr.get(i).charAt(0);
		        System.out.println(pdName);
		        pdChar.add(pdName);
					
				}
			
			List<Character> afterSortchar = new ArrayList<Character>();
			//String[].sort(price);
			
		}

	}

		
