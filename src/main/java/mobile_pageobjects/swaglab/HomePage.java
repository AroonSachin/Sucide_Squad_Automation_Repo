package mobile_pageobjects.swaglab;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonuseractions.CommonActionMethods;

public class HomePage extends CommonActionMethods{
	public HomePage() throws Exception {
		try {
			PageFactory.initElements((appdriver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static String item1 = null;
	static String item2 = null;

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
	WebElement sortButton;

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
	@FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
	WebElement swagBotImage;

	
	public void addProducts() throws Exception {

		swipeDownToElement(product1AddToCartButton, " Add to cart button ", "click", "");
		item1 = getTextElement(product1Text, " Product 1 ");
		if (isElementPresent(product1RemoveButton)) {
			logMessage("Remove button appeared");
		} else {
			logErrorMessage("Remove button not appeared");
		}
		swipeUpToElement(product2AddToCartButton, " Add to cart button ", "click", "");
		item2 = getTextElement(product2Text, "Product 2");
		if (isElementPresent(product1RemoveButton)) {
			logMessage("Remove button appeared");
		} else {
			logErrorMessage("Remove button not appeared");
		}
		swipeDownToElement(cartButton, "Cart button ", "click", "");
	}

	public void homePageValidation() throws Exception {
		clickMethod(sortButton, " Fliter button ");
		webWait(sortAtoZ);
		clickMethod(sortAtoZ, " A to Z short ");
		ascendingValidation();
		clickMethod(sortButton, " Filter button ");
		webWait(sortZtoA);
		clickMethod(sortZtoA, " Z to A sort ");
		Thread.sleep(1000);
		for(int i = 0;i<3;i++) {
			swipeDown();
		}
		descendingValidation();
	}

	public void ascendingValidation() throws Exception {
		Set<String> titleSet = new LinkedHashSet<String>();
		while (true) {
			for (WebElement element : appdriver.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
				titleSet.add(getTextElement(element, " Product Title "));
			}
			swipeUp();
			if(isElementPresent(swagBotImage)) {
				break;
			}
		}
		TreeSet<String> titleTree = new TreeSet<String>(titleSet);
		if(titleSet.equals(titleTree)) {
			logMessage("A to Z validation successful and the products are sorted in the ascending order ");
		}else {
			logErrorMessage("Products are not in ascending order in A to Z sort.");
		}
		titleSet.clear();
		titleTree.clear();
	}
	
	public void descendingValidation() throws Exception {
		Set<String> titleSet = new LinkedHashSet<String>();
		while (true) {
			for (WebElement element : appdriver.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"))) {
				titleSet.add(getTextElement(element, " Product Title "));
			}
			swipeUp();
			if(isElementPresent(swagBotImage)) {
				break;
			}
		}
		TreeSet<String> titleTree = new TreeSet<String>(titleSet);
		TreeSet<String> titleTreeDesend = (TreeSet<String>) titleTree.descendingSet();
		if(titleSet.equals(titleTreeDesend)) {
			logMessage("Z to A validation successful and the products are sorted in the ascending order ");
		}else {
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
	public void priceValidationAscending() throws NumberFormatException, Exception {
		Set<Double> priceSet = new LinkedHashSet<Double>();
		while (true) {
			List<WebElement> priceEle = appdriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"));
			for (WebElement ele : priceEle) {
				priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement ele : appdriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"))) {
					priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
				}
				break;
			}
		}
		TreeSet<Double> priceTree = new TreeSet<Double>(priceSet);
		checkEquality(priceSet, priceTree);
	}

	/**
	 * @Method To Validate Price High to Low sorting.
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void priceValidationDescending() throws NumberFormatException, Exception {
		Set<Double> priceSet = new LinkedHashSet<Double>();
		while (true) {
			List<WebElement> priceEle = appdriver
					.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"));
			for (WebElement ele : priceEle) {
				priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
			}
			swipeUp();
			if (isElementPresent(swagBotImage)) {
				for (WebElement ele : appdriver
						.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Price']"))) {
					priceSet.add(Double.valueOf(getTextElement(ele, " Price element ").replace("$", "")));
				}
				break;
			}
		}
		TreeSet<Double> priceTree = (TreeSet<Double>) new TreeSet<Double>(priceSet).descendingSet();
		checkEquality(priceSet, priceTree);
	}

}
