package pageobjects.swaglabs;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * 
 * @author svenkateshwaran
 * @this class contains methods from the checkout page
 */
public class Checkout extends CommonActionMethods {

	public Checkout() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	@FindBy(id = "checkout")
	private static WebElement checkoutButton;

	@FindBy(className = "inventory_item_name")
	private static List<WebElement> pName;

	@FindBy(className = "inventory_item_price")
	private static List<WebElement> pPrice;

	@FindBy(className = "cart_quantity")
	private static List<WebElement> pQuantity;

	public void clickOnCheckoutButton() throws Exception {
		clickMethod(checkoutButton, "checkout");

	}

	/**
	 * @this method is used to validate the product information
	 * @throws Exception
	 */

	public void validateProductInfo() throws Exception {
		List<String> productNameList = new LinkedList<String>(HomePage.getproductName());
		List<String> productPriceList = new LinkedList<String>(HomePage.getproductPrice());
		for (int p = 0; p < pName.size(); p++) {
			String prdtName = getTextElement(pName.get(p), "product name");
			if (prdtName.equals(productNameList.get(p))) {
				logMessage("The expected product name " + productNameList.get(p) + " matches the actual product name "
						+ prdtName);
			} else {
				logErrorMessage("The expected product name " + productNameList.get(p)
						+ " does not matches the actual product name " + prdtName);
			}

			String prdtPrice = getTextElement(pPrice.get(p), "product price");

			if (prdtPrice.equals(productPriceList.get(p))) {
				logMessage("The expected product price " + productPriceList.get(p)
						+ " matches the actual product price " + prdtPrice);
			} else {
				logErrorMessage("The expected product price " + productPriceList.get(p)
						+ " does not matches the actual product price " + prdtPrice);
			}

		}
	}

	/**
	 * @this method is used to validate the number of products
	 * @throws Exception
	 */

	public void validateQuantity() throws Exception {
		int prd = 0;

		for (int q = 0; q < pQuantity.size(); q++) {
			prd = prd + Integer.parseInt(getTextElement(pQuantity.get(q), "Number of product quantity"));
		}
		if (prd == Integer.parseInt(getdata("Quantity"))) {
			logMessage("The expected product quantity " + getdata("Quantity") + " matches the actual product quantity "
					+ prd);

		} else {
			logErrorMessage("The expected product quantity " + getdata("Quantity")
					+ " does not matches the actual product quantity " + prd);

		}

	}

	/**
	 * @this method is for validation in checkout page
	 * @throws Exception
	 */

	public void checkoutValidation() throws Exception {
		validateProductInfo();
		validateQuantity();
	}

}
