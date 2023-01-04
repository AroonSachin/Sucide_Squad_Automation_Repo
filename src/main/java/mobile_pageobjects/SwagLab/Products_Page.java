package mobile_pageobjects.SwagLab;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;

/**
 * @Class To automate validate sorting and add two products to the cart.
 * @author amaduraiveeran
 *
 */
public class Products_Page extends CommonActionMethods {

	static String product1Name = null;
	static String product2Name = null;
	static double product1Pricevalue = 0.00;
	static double product2Pricevalue = 0.00;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']")
	WebElement product1AddToCartButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']")
	WebElement product1Text;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE']")
	WebElement product1RemoveButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']")
	WebElement product2AddToCartButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']")
	WebElement product2Text;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']/following-sibling::android.view.ViewGroup[@content-desc='test-REMOVE']")
	WebElement product2RemoveButton;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
	WebElement cartButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
	List<WebElement> productTitleList;

	@CacheLookup
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
	WebElement filterButton;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[2]")
	WebElement sortAtoZ;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[3]")
	WebElement sortZtoA;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[4]")
	WebElement sortpriceLowtoHigh;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']/android.view.ViewGroup/android.view.ViewGroup[5]")
	WebElement sortpriceHightoLow;

	@CacheLookup
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
	WebElement swagBotImage;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Onesie']/following-sibling::android.widget.TextView[@content-desc='test-Price']")
	WebElement product1Price;

	@CacheLookup
	@FindBy(xpath = "//android.widget.TextView[@text='Test.allTheThings() T-Shirt (Red)']/following-sibling::android.widget.TextView[@content-desc='test-Price']")
	WebElement product2Price;

	public Products_Page() {
		PageFactory.initElements(appDriver, this);
	}

	/**
	 * @Method To add Two products to cart.
	 * @throws Exception
	 */
	public void addToCart() throws Exception {

		swipeDownToElement(product1AddToCartButton, " Add to cart button ", "click", "");
		product1Name = getTextElement(product1Text, " Product 1 ");
		product1Pricevalue = Double.valueOf(getTextElement(product1Price, " Product one price ").replace("$", ""));
		if (isElementPresent(product1RemoveButton)) {
			logMessage("Remove button appeared");
		} else {
			logErrorMessage("Remove button not appeared");
		}
		swipeDownToElement(product2AddToCartButton, " Add to cart button ", "click", "");
		product2Name = getTextElement(product2Text, "Product 2");
		product2Pricevalue = Double.valueOf(getTextElement(product2Price, " Product one price ").replace("$", ""));
		if (isElementPresent(product1RemoveButton)) {
			logMessage("Remove button appeared");
		} else {
			logErrorMessage("Remove button not appeared");
		}
		swipeDownToElement(cartButton, "Cart button ", "click", null);
	}

	/**
	 * @Method To validate Sorting.
	 * @throws Exception
	 */
	public void sortValidation() throws Exception {
		clickMethod(filterButton, " Fliter button ");
		webWait(sortAtoZ);
		clickMethod(sortAtoZ, " A to Z short ");
		validateAtoZ();
		clickMethod(filterButton, " Filter button ");
		webWait(sortZtoA);
		clickMethod(sortZtoA, " Z to A sort ");
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			swipeDown();
		}
		validateZtoA();
		clickMethod(filterButton, " Filter button ");
		webwaitVisibility(sortpriceLowtoHigh);
		clickMethod(sortpriceLowtoHigh, "Price Low to High short ");
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			swipeDown();
		}
		validatePriceLowToHigh();
		clickMethod(filterButton, " Filter button ");
		webwaitVisibility(sortpriceHightoLow);
		clickMethod(sortpriceHightoLow, "Price High to Low short ");
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			swipeDown();
		}
		validatePriceHighToLow();
	}

	/**
	 * @Method To validate A to Z Sorting.
	 * @throws Exception
	 */
	public void validateAtoZ() throws Exception {
		Set<String> titleSet = new LinkedHashSet<String>();
		while (true) {
			for (WebElement element : appDriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
				titleSet.add(getTextElement(element, " Product Title "));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement element : appDriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
					titleSet.add(getTextElement(element, " Product Title "));
				}
				break;
			}
		}
		System.out.println(titleSet);
		TreeSet<String> titleTree = new TreeSet<String>(titleSet);
		System.out.println("Tree set ---:" + titleSet);
		if (titleSet.equals(titleTree)) {
			logMessage("A to Z validation successful and the products are sorted in the ascending order ");
		} else {
			logErrorMessage("Products are not in ascending order in A to Z sort.");
		}
		titleSet.clear();
		titleTree.clear();
	}

	/**
	 * @Method to validate Z to A Sorting.
	 * @throws Exception
	 */
	public void validateZtoA() throws Exception {
		Set<String> titleSet = new LinkedHashSet<String>();
		while (true) {
			for (WebElement element : appDriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
				titleSet.add(getTextElement(element, " Product Title "));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement element : appDriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
					titleSet.add(getTextElement(element, " Product Title "));
				}
				break;
			}
		}
		System.out.println(titleSet);
		TreeSet<String> titleTree = new TreeSet<String>(titleSet);
		TreeSet<String> titleTreeDesend = (TreeSet<String>) titleTree.descendingSet();
		System.out.println("Tree set ---:" + titleSet);
		System.out.println("Tree set rev---:" + titleTreeDesend);
		if (titleSet.equals(titleTreeDesend)) {
			logMessage("Z to A validation successful and the products are sorted in the ascending order ");
		} else {
			logErrorMessage("Products are not in ascending order in Z to A sort.");
		}
		titleSet.clear();
		titleTree.clear();
		titleTreeDesend.clear();
	}

	/**
	 * @Method tTo validate price Low to High Sorting.
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void validatePriceLowToHigh() throws NumberFormatException, Exception {
		Set<Double> priceSet = new LinkedHashSet<Double>();
		while (true) {
			List<WebElement> priceEle = appDriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"));
			for (WebElement ele : priceEle) {
				priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement ele : appDriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"))) {
					priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
				}
				break;
			}
		}
		TreeSet<Double> priceTree = new TreeSet<Double>(priceSet);
		System.out.println("HEHE-----------:" + priceTree);
		checkEquality(priceSet, priceTree);
	}

	/**
	 * @Method To Validate Price High to Low sorting.
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void validatePriceHighToLow() throws NumberFormatException, Exception {
		Set<Double> priceSet = new LinkedHashSet<Double>();
		while (true) {
			List<WebElement> priceEle = appDriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"));
			for (WebElement ele : priceEle) {
				priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement ele : appDriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"))) {
					priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
				}
				break;
			}
		}
		TreeSet<Double> priceTree = (TreeSet<Double>) new TreeSet<Double>(priceSet).descendingSet();
		System.out.println("HEHE-----------:" + priceTree);
		checkEquality(priceSet, priceTree);
	}

}
