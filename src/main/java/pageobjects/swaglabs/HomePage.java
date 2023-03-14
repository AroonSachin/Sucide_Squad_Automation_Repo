package pageobjects.swaglabs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import io.qameta.allure.Step;
import utils.DriverFactory;

/**
 *
 * @author svenkateshwaran
 * @this class contains methods of home page
 */
public class HomePage extends CommonActionMethods {


	@FindBy(id = "react-burger-menu-btn")
	WebElement hamburgerButton;

	@FindBy(className = "inventory_item_name")
	List<WebElement> itemName;

	@FindBy(className = "inventory_item_price")
	List<WebElement> itemPrice;

	@FindBy(xpath = "//button[contains(@id,'add-to-cart') or (text()='Remove')]")
	List<WebElement> addItems;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cart;

	@FindBy(id = "logout_sidebar_link")
	WebElement logout;

	@FindBy(className = "product_sort_container")
	WebElement filterprice;

	public HomePage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	static ThreadLocal<LinkedHashSet<String>> productName = ThreadLocal.withInitial(LinkedHashSet::new);

	public static LinkedHashSet<String> getproductName() {
		return productName.get();
	}

	public static ThreadLocal<LinkedHashSet<String>> productPrice = ThreadLocal.withInitial(LinkedHashSet::new);

	public static LinkedHashSet<String> getproductPrice() {
		return productPrice.get();
	}

	/**
	 * @this method is used to select the products from the list of products
	 * @throws Exception
	 */

	public synchronized void selectItem() throws Exception {
		getproductName().clear();
		getproductPrice().clear();
		for (int q = 0; q < Integer.parseInt("2"); q++) {
			getproductName().add(getTextElement(itemName.get(q), "item name"));
			getproductPrice().add(getTextElement(itemPrice.get(q), "item price"));
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
	public void verifyPrice(String type) throws Exception {
		List<Double> pricearr = new ArrayList<Double>();

		boolean flag = true;
		for (int i = 0; i < itemPrice.size(); i++) {
			pricearr.add(
					Double.parseDouble(getTextElement(itemPrice.get(i), "price").replaceAll("\\s|\\n|\\$|\"", "")));
		}
		for (int i = 0; i < itemPrice.size(); i++) {
			for (int j = i; j < itemPrice.size(); j++) {
				if (pricearr.get(i) > pricearr.get(j) && pricearr.get(i) != pricearr.get(j)
						&& type.equals("lohi")) {
					flag = false;
				} else if (pricearr.get(i) < pricearr.get(j) && pricearr.get(i) != pricearr.get(j)
						&& type.equals("hilo")) {
					flag = false;
				}
			}
		}
		if (flag) {
			if (type.equals("lohi")) {
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
    @Step("To validating a home page")
	public void homepageValidation() throws Exception {
		
		for(int i=1; i<=2; i++)
		{
			
			if(i==1)
			{
				selectByValue(filterprice, "lohi");
				verifyPrice("lohi");
			}
			else
			{
				selectByValue(filterprice, "hilo");
				verifyPrice("hilo");
			}
		}
		verifyLogin();
		selectItem();
		clickCart();
	}

}
