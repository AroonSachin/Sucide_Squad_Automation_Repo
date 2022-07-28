package pageobjects.yourlogo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Orderpage  extends CommonActionMethods{

	@FindBy(xpath = "//div[@id='block_top_menu']//a[@title='Women']")
	public static WebElement dresstype;

	@FindBy(xpath = "//div[@id='uniform-selectProductSort']")
	public static WebElement sortproduct;

	@FindBy(xpath = "//div[@class='product-container']//img[@title='Faded Short Sleeve T-shirts']")
	public static WebElement chooseproduct;

	@FindBy(xpath = "//div[@class='button-container']//a[@data-id-product='1']")
	public static WebElement addcart;

	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	public static WebElement continueshopping;

	@FindBy(xpath = "//div[@class='button-container']//a[@data-id-product='2']")
	public static WebElement choosingproduct;

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
	public Orderpage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);

	}
	
	public void order() throws Exception {
		
		extent("order page is passed ");
		Thread.sleep(10000);
		clickMethod(dresstype,"dresstype");
		clickMethod(chooseproduct,"chooseproduct");
		//frameByIndex(0);
		Thread.sleep(10000);
		clickMethod(addcart,"addcart");
		defaultwindow();
		/*
		 * clickMethod(continueshopping,"continueshopping"); Thread.sleep(10000);
		 * clickMethod(choosingproduct,"choosingproduct"); frameByIndex(0);
		 * //clickMethod(addtocart, "addtocart"); defaultwindow();
		 * clickMethod(proceedtocheckout,"proceedtocheckout");
		 * clickMethod(summaryproceedtocheckout,"summaryproceedtocheckout");
		 * clickMethod(processaddress,"processaddress");
		 * clickMethod(agreeshippingbox,"agreeshippingbox");
		 * clickMethod(processshipping,"processshipping");
		 * clickMethod(paybybankwire,"paybybankwire");
		 * clickMethod(confromorder,"confromorder");
		 */
	}
}
