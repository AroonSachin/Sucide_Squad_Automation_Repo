package pageobjects.swaglabs;

import java.util.LinkedList;
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
 * @this class contains methods from the checkout page
 */
public class Checkout extends CommonActionMethods {



	@FindBy(xpath="//button[@name='checkout']")
	WebElement checkoutButton;

	@FindBy(className = "inventory_item_name")
	List<WebElement> pName;

	@FindBy(className = "inventory_item_price")
	List<WebElement> pPrice;

	@FindBy(className = "cart_quantity")
	List<WebElement> pQuantity;

	public Checkout() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
    @Step("To click a checkout button")
	public void clickOnCheckoutButton() throws Exception {
		clickMethod(checkoutButton, "checkout");

	}

	/**
	 * @this method is used to validate the product information
	 * @throws Exception
	 */

	public void validateProductInfo() throws Exception {
		List<String> productNameList = new LinkedList<>(HomePage.getproductName());
		List<String> productPriceList = new LinkedList<>(HomePage.getproductPrice());
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

	public void validateQuantity(String qty) throws Exception {
		int prd = 0;

		for (WebElement element : pQuantity) {
			prd = prd + Integer.parseInt(getTextElement(element, "Number of product quantity"));
		}
		if (prd == Integer.parseInt(qty)) {
			logMessage("The expected product quantity " + qty + " matches the actual product quantity "
					+ prd);

		} else {
			logErrorMessage("The expected product quantity " + qty
					+ " does not matches the actual product quantity " + prd);

		}

	}

	/**
	 * @this method is for validation in checkout page
	 * @throws Exception
	 */
    @Step("To validating checkoutvalidation")
	public synchronized void checkoutValidation() throws Exception {
		validateProductInfo();
	}

}
