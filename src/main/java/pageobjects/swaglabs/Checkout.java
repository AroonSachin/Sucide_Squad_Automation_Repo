package pageobjects.swaglabs;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

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

	public void clickOnCheckoutButton() throws Exception {
		clickMethod(checkoutButton, "checkout");
		logMessage("Checkout button is clicked");
	}

}
