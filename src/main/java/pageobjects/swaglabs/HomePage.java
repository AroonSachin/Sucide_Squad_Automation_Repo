package pageobjects.swaglabs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Decimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class HomePage extends CommonActionMethods{
	public HomePage()
	{
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	@FindBy(id="react-burger-menu-btn")
	private static WebElement hamburgerButton; 
	
	@FindBy (className="inventory_item_name")
	private static List<WebElement> itemName;
	
	@FindBy (className="inventory_item_price")
	private static List<WebElement> itemPrice;
	
	@FindBy(xpath="//button[contains(@id,'add-to-cart')]")
	private static List<WebElement> addItems;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private static WebElement cart;
	
	@FindBy(id="logout_sidebar_link")
	private static WebElement logout;
	
	@FindBy(className="product_sort_container")
	private static WebElement filterprice;
	





public void verifyLogin() throws Exception
{
	clickMethod(hamburgerButton, "hamburger");
	webWait(logout);
	isDisplayed(logout, "Logout button");
}

public void selectItem(String qty) throws Exception
{
	for(int q=0; q<Integer.parseInt(qty);q++)
	{
		clickMethod(addItems.get(q), "product "+(q+1));
	}
	
}

public void clickCart() throws Exception
{
	clickMethod(cart, "clickCart");
	
}

public void sortPrice() throws Exception
{
	selectByValue(filterprice, "lohi");
}




public void verifyPrice() throws Exception
{
 //List<Double> pricearr = new ArrayList<Double>();
	double[] pricearr = new double[itemPrice.size()];
	double temp = 0;
 for(int i=0; i<itemPrice.size(); i++)
 {
	pricearr[i]=Double.parseDouble(getTextElement(itemPrice.get(i), "price").replaceAll("\\s|\\n|\\$|\"",""));
	// double rate2 = Double.parseDouble(getTextElement(price.get(i+1), "price").replaceAll("\\s|\\n|\\$|\"",""));
	 }
 for(int i=0; i<itemPrice.size(); i++)
 {
	 for(int j=1; j<itemPrice.size(); j++)
	 {
		 double price1 = pricearr[i];
		 double price2 = pricearr[j];
	 if(pricearr[i]>pricearr[j])
	 {
		 temp=pricearr[i];
		 pricearr[i]=pricearr[j];
		 pricearr[j]=temp;
	 }
	 
 }
	 

}
 for(int a=0; a<pricearr.length; a++)
 {
 System.out.println(pricearr[a]);
}
}
}

