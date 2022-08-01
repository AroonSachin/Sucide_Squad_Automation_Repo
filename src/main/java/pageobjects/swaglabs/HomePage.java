package pageobjects.swaglabs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * 
 * @author svenkateshwaran
 * @this class contains methods of home page
 */
public class HomePage extends CommonActionMethods {
	public HomePage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(id = "react-burger-menu-btn")
	private static WebElement hamburgerButton;

	@FindBy(className = "inventory_item_name")
	private static List<WebElement> itemName;

	@FindBy(className = "inventory_item_price")
	private static List<WebElement> itemPrice;

	@FindBy(xpath = "//button[contains(@id,'add-to-cart') or (text()='Remove')]")
	private static List<WebElement> addItems;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private static WebElement cart;

	@FindBy(id = "logout_sidebar_link")
	private static WebElement logout;

	@FindBy(className = "product_sort_container")
	private static WebElement filterprice;

	public static LinkedHashSet<String> productName = new LinkedHashSet<String>();
	public static LinkedHashSet<String> productPrice = new LinkedHashSet<String>();

	/**
	 * @this method is used to select the products from the list of products
	 * @throws Exception
	 */

	public void selectItem() throws Exception {
		productName.clear();
		productPrice.clear();
		for (int q = 0; q < Integer.parseInt(getdata("Quantity")); q++) {

			productName.add(getTextElement(itemName.get(q), "item name"));
			productPrice.add(getTextElement(itemPrice.get(q), "item price"));
			clickMethod(addItems.get(q), "product " + (q + 1));

		}
	}

	/**
	 * @this method is used to verify the user has logged in successfully
	 * @throws Exception
	 */

	public void verifyLogin() throws Exception {
		clickMethod(hamburgerButton, "hamburger");
		webWait(logout);
		isDisplayed(logout, "Logout button");
	}

	/**
	 * @this method is to click on the cart button
	 * @throws Exception
	 */

	public void clickCart() throws Exception {
		clickMethod(cart, "clickCart");

	}

	/**
	 * @this method is to validate the price of the product
	 * @throws Exception
	 */

	public void verifyPrice() throws Exception {
		List<Double> pricearr = new ArrayList<Double>();
		boolean flag = true;
		for (int i = 0; i < itemPrice.size(); i++) {
			pricearr.add(
					Double.parseDouble(getTextElement(itemPrice.get(i), "price").replaceAll("\\s|\\n|\\$|\"", "")));
		}
		for (int i = 0; i < itemPrice.size(); i++) {
			for (int j = i; j < itemPrice.size(); j++) {
				if (pricearr.get(i) > pricearr.get(j) && pricearr.get(i) != pricearr.get(j)
						&& getdata("Sort").equals("lohi")) {
					flag = false;
				} else if (pricearr.get(i) < pricearr.get(j) && pricearr.get(i) != pricearr.get(j)
						&& getdata("Sort").equals("hilo")) {
					flag = false;
				}
			}
		}
		if (flag) {
			if (getdata("Sort").equals("lohi")) {
				logMessage("The list is in ascending order. The lowest value is " + pricearr.get(0));
			}

			else {
				logMessage("The list is in descending order. The highest value is " + pricearr.get(0));
			}

		} else {
			logErrorMessage("The list is not in ascending order.");
		}

	}

	/**
	 * @this method is used for the validation of the home page
	 * @throws Exception
	 */

	public void homepageValidation() throws Exception {
		selectByValue(filterprice, getdata("Sort"));
		verifyPrice();
		selectItem();
		clickCart();
		verifyLogin();
	}

}
