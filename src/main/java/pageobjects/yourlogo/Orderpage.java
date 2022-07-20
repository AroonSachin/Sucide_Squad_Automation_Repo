package pageobjects.yourlogo;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Orderpage extends CommonActionMethods{

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Women']")
	public static WebElement dresstype;

	@FindBy(xpath = "//div[@id='uniform-selectProductSort']")
	public static WebElement sortproduct;

	@FindBy(xpath = "//div[@class='product-container']//img[@title='Faded Short Sleeve T-shirts']")
	public static WebElement chooseproduct;
	
	@FindBy(xpath="//iframe[@id='fancybox-frame1658215203142']")
	public static WebElement frame;

	@FindBy(xpath="//button[@name='Submit']")
	public static WebElement addcart;

	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	public static WebElement continueshopping;

	@FindBy(xpath = "//ul[@class='product_list grid row']//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")
	public static WebElement choosingproduct;
	
	@FindBy(xpath="//button[@name='Submit']")
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
	
	@FindBy(xpath="(//a[@title='Faded Short Sleeve T-shirts'])[2]")
	public static WebElement namevalidation;
	
	@FindBy(xpath="(//div[@class='content_price'])[2]")
	public static WebElement pricevalidation;
	
	@FindBy(xpath="//a[text()='Faded Short Sleeve T-shirts']")
	public static WebElement cartvalidation;
	
	@FindBy(id="product_price_1_1_722123")
	public static WebElement cardpricevalidation;
	
	@FindBy(xpath="(//a[@title=\"Blouse\"])[2]")
	public static WebElement nametwovalidation;
	
	@FindBy(xpath="(//span[@class=\"price product-price\"])[4]")
	public static WebElement pricetwovalidation;
	
	@FindBy(xpath="(//a[text()='Blouse'])[2]")
	public static WebElement cardtwovalidation;
	
	@FindBy(id="product_price_2_7_722123")
    public static WebElement cardprice2;	
	
	public Orderpage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}
	
	public void order() throws Exception {
		Thread.sleep(10000);
		clickMethod(dresstype,"dresstype");
		clickMethod(chooseproduct,"chooseproduct");
		frameByIndex(0);
		Thread.sleep(10000);
		clickMethod(addcart,"addcart");
		defaultwindow();
		clickMethod(continueshopping,"continueshopping");
		Thread.sleep(10000);
		clickMethod(choosingproduct,"choosingproduct");
		frameByIndex(0);
		clickMethod(addtocart, "addtocart");
		defaultwindow();
		clickMethod(proceedtocheckout,"proceedtocheckout");
		clickMethod(summaryproceedtocheckout,"summaryproceedtocheckout");
		clickMethod(processaddress,"processaddress");
		clickMethod(agreeshippingbox,"agreeshippingbox");
		clickMethod(processshipping,"processshipping");
		clickMethod(paybybankwire,"paybybankwire");
		clickMethod(confromorder,"confromorder");
	}
	public void validation() throws Exception {
		
	    product1=getTextElement(namevalidation, "product1");
		checkEquality(product1, getTextElement(cartvalidation, "product1"));
		
		price1=getTextElement(pricevalidation, "price1");
		checkEquality(price1, getTextElement(cardpricevalidation, "price1"));
		
		product2=getTextElement(nametwovalidation, "product2");
		checkEquality(product2, getTextElement(cardtwovalidation, "product2"));
		
		price2=getTextElement(pricetwovalidation, "price2");
		checkEquality(price2, getTextElement( cardprice2, "price2"));
	}
	

}
