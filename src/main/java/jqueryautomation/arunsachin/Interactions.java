package jqueryautomation.arunsachin;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class Interactions extends CommonActionMethods {

	static Actions act = new Actions(DriverFactory.getDriver());

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement frameHeading;

	@FindBy(xpath = "//a[contains(text(),'Draggable')]")
	WebElement draggableButton;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	WebElement demoFrame;

	@FindBy(id = "draggable")
	WebElement dragbox;

	@FindBy(id = "droppable")
	WebElement dropBox;

	@FindBy(xpath = "//a[contains(text(),'Droppable')]")
	WebElement droppableButton;

	@FindBy(xpath = "//a[contains(text(),'Resizable')]")
	WebElement resizeButton;

	@FindBy(xpath = "//div[contains(@class,'resizable-se ui-icon ui-icon-gripsmall-diagonal-se')]")
	WebElement resizeSlider;

	@FindBy(id = "resizable")
	WebElement resizeBox;

	@FindBy(xpath = "//a[contains(text(),'Selectable')]")
	WebElement selectableButton;

	@FindBy(xpath = "//li[contains(@class,'selectee')]")
	List<WebElement> itemList;

	@FindBy(xpath = "//a[contains(text(),'Sortable')]")
	WebElement sortableButton;

	@FindBy(xpath = "//li[contains(@class,'ui-sortable-handle')]")
	List<WebElement> sortableEle;

	@FindBy(xpath = "//a[contains(text(),'Accordion')]")
	WebElement accordButton;

	@FindBy(xpath = "//h3[contains(text(),'2')]")
	WebElement section2;

	@FindBy(xpath = "//a[contains(text(),'Autocomplete')]")
	WebElement autoCompleteButton;

	@FindBy(xpath = "//input[contains(@class,'ui-autocomplete-input')]")
	WebElement inputAutocomplete;

	@FindBy(xpath = "//li[@class='ui-menu-item']")
	List<WebElement> tagList;

	@FindBy(xpath = "//a[contains(text(),'Button')]")
	WebElement buttonButt;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::button[contains(text(),'A button element')]")
	WebElement widgetbuttele;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::input[contains(@value,'A submit button')]")
	WebElement submitbuttele;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::a[contains(text(),'An anchor')]")
	WebElement anchorbutt;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::a[contains(text(),'An anchor')]")
	WebElement cssanchorbutt;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::input[contains(@value,'A submit button')]")
	WebElement csssubmitbuttele;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::button[contains(text(),'A button element')]")
	WebElement csswidgetbuttele;

	@FindBy(xpath = "//a[contains(text(),'Checkboxradio')]")
	WebElement checkboxRadio;

	@FindBy(xpath = "//legend[contains(text(),'Select a Location: ')]/following-sibling::label[contains(text(),'New York')]")
	WebElement newyorkRadio;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings: ')]/following-sibling::label[contains(text(),'2 Star')]")
	WebElement twostarRadio;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings: ')]/following-sibling::label[contains(text(),'3 Star')]")
	WebElement threestarRadio;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings: ')]/following-sibling::label[contains(text(),'4 Star')]")
	WebElement fourstarRadio;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings: ')]/following-sibling::label[contains(text(),'5 Star')]")
	WebElement fivestarRadio;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type: ')]/following-sibling::label[contains(@for,'checkbox-nested-1')]")
	WebElement nested1;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type: ')]/following-sibling::label[contains(@for,'checkbox-nested-2')]")
	WebElement nested2;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type: ')]/following-sibling::label[contains(@for,'checkbox-nested-3')]")
	WebElement nested3;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type: ')]/following-sibling::label[contains(@for,'checkbox-nested-4')]")
	WebElement nested4;

	@FindBy(xpath = "//a[contains(text(),'Controlgroup')]")
	WebElement controlgroup;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//span[@id='car-type-button']")
	WebElement carTypeButtonHOR;

	@FindBy(xpath = "//ul[@id='car-type-menu']//div[contains(text(),'Compact car')]")
	WebElement cmpctCarHOR;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[contains(text(),'Standard')]")
	WebElement standardHOR;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[contains(text(),'Insurance')]")
	WebElement insurenceHOR;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//input[@id='horizontal-spinner']")
	WebElement noOfCarsHOR;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//button[contains(text(),'Book')]")
	WebElement bookHOR;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//span[@id='car-type-button']//span[@class='ui-selectmenu-text']")
	WebElement cartypTxtHOR;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//span[contains(text(),'Compact car')]")
	WebElement cartypVRT;

	@FindBy(xpath = "//ul[@id='ui-id-8-menu']//div[contains(text(),'Compact car')]")
	WebElement compactVRT;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']/./label[contains(text(),'Standard')]")
	WebElement standardVRT;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']/./label[contains(text(),'Insurance')]")
	WebElement insuranceVRT;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//input[@id='vertical-spinner']")
	WebElement noOfCarsVRT;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//button[contains(text(),'Book Now!')]")
	WebElement bookVRT;

	@FindBy(xpath = "//a[contains(text(),'Datepicker')]")
	WebElement datePicker;

	@FindBy(xpath = "//input[@id='datepicker']")
	WebElement datePickerBox;

	@FindBy(xpath = "//div[@class='ui-datepicker-title']//span[contains(@class,'month')]")
	WebElement monthele;

	@FindBy(xpath = "//a[@data-handler='next']")
	WebElement nxtArrow;

	@FindBy(xpath = "//a[contains(@class,'ui-state-default')]")
	List<WebElement> dayList;

	@FindBy(xpath = "//div[contains(@class,'ui-dialog ui')]")
	WebElement dialogBox;

	@FindBy(xpath = "//a[contains(text(),'Dialog')]")
	WebElement dialogButton;

	@FindBy(xpath = "//button[@title='Close']")
	WebElement dialogClose;

	@FindBy(xpath = "//a[contains(text(),'Menu')]")
	WebElement menuButton;

	@FindBy(xpath = "//div[contains(text(),'Music')]")
	WebElement musicOPT;

	@FindBy(xpath = "//div[contains(text(),'Jazz')]")
	WebElement jazzOPT;

	@FindBy(xpath = "//div[contains(text(),'Modern')]")
	WebElement modernOPT;

	@FindBy(xpath = "//a[contains(text(),'Progressbar')]")
	WebElement progressbarButton;

	@FindBy(xpath = "//button[contains(text(),'Start Download')]")
	WebElement startDownloadButt;

	@FindBy(xpath = "//div[@class='progress-label']")
	WebElement progressStatus;

	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Close')]")
	WebElement closeButton;

	@FindBy(xpath = "//a[contains(text(),'Download Dialog')]")
	WebElement downloadDialogButt;

	@FindBy(xpath = "//a[contains(text(),'Selectmenu')]")
	WebElement selectmenuButton;

	@FindBy(xpath = "//span[@id='speed-button']")
	WebElement speedButton;

	@FindBy(xpath = "//ul[@id='speed-menu']//div[contains(text(),'Faster')]")
	WebElement fasterOPT;

	@FindBy(xpath = "//span[@id='files-button']")
	WebElement fileButton;

	@FindBy(xpath = "//div[contains(text(),'Some other file with a very long option text')]")
	WebElement file;

	@FindBy(xpath = "//span[@id='number-button']")
	WebElement numberButton;

	@FindBy(xpath = "//ul[@id='number-menu']//div[contains(text(),'3')]")
	WebElement number;

	@FindBy(xpath = "//span[@id='salutation-button']")
	WebElement titleButton;

	@FindBy(xpath = "//div[@id='ui-id-33']")
	WebElement title;

	@FindBy(xpath = "//a[contains(text(),'Slider')]")
	WebElement sliderButton;

	@FindBy(xpath = "//span[contains(@class,'ui-slider-handle')]")
	WebElement slideBar;

	@FindBy(xpath = "//a[contains(text(),'Spinner')]")
	WebElement spinnerButton;

	@FindBy(xpath = "//input[@id='spinner']")
	WebElement spinnerInput;

	@FindBy(xpath = "//a[contains(@class,'ui-spinner-up')]")
	WebElement spinnerUP;

	@FindBy(xpath = "//a[contains(@class,'ui-spinner-down')]")
	WebElement spinnerDOWN;

	@FindBy(xpath = "//label[contains(text(),'Select a value:')]")
	WebElement selectaValue;

	@FindBy(xpath = "//button[contains(text(),'Get value')]")
	WebElement getValueButton;

	@FindBy(xpath = "//a[contains(text(),'Tabs')]")
	WebElement tabsButton;

	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement tab2;

	@FindBy(xpath = "//a[@id='ui-id-3']")
	WebElement tab3;

	@FindBy(xpath = "//a[contains(text(),'Tooltip')]")
	WebElement tooltipButton;

	@FindBy(xpath = "//input[@id='age']")
	WebElement ageEle;

	@FindBy(xpath = "//a[contains(text(),'Add Class')]")
	WebElement addClassButton;

	@FindBy(xpath = "//button[contains(text(),'Run Effect')]")
	WebElement runButton;

	@FindBy(xpath = "//a[contains(text(),'Color Animation')]")
	WebElement colorAnimButton;

	@FindBy(xpath = "//button[contains(text(),'Toggle Effect')]")
	WebElement toggleEffectButton;

	@FindBy(xpath = "//a[contains(text(),'Easing')]")
	WebElement eastingButton;

	@FindBy(xpath = "//div[contains(text(),'1. linear')]/following::canvas")
	List<WebElement> eastAnim;

	@FindBy(xpath = "//a[contains(text(),'Effect')]")
	WebElement effectButton;

	@FindBy(xpath = "//select[@id='effectTypes']")
	WebElement effectDrop;

	@FindBy(xpath = "//a[contains(text(),'Hide')]")
	WebElement hideButton;

	@FindBy(xpath = "//a[contains(text(),'Remove Class')]")
	WebElement removeClassButton;

	@FindBy(xpath = "//a[contains(text(),'Show')]")
	WebElement showButton;

	@FindBy(xpath = "//a[contains(text(),'Switch Class')]")
	WebElement switchClassButton;

	@FindBy(xpath = "//a[contains(text(),'Toggle')]")
	WebElement toggleButton;

	@FindBy(xpath = "//a[contains(text(),'Toggle Class')]")
	WebElement toggleClassButton;

	@FindBy(xpath = "//a[contains(text(),'Position')]")
	WebElement positionButton;

	@FindBy(xpath = "//select[@id='my_horizontal']")
	WebElement myHor;

	@FindBy(xpath = "//select[@id='my_vertical']")
	WebElement myVer;

	@FindBy(xpath = "//select[@id='at_horizontal']")
	WebElement atHor;

	@FindBy(xpath = "//select[@id='at_vertical']")
	WebElement atVer;

	@FindBy(xpath = "//select[@id='collision_horizontal']")
	WebElement collisionHor;

	@FindBy(xpath = "//select[@id='collision_vertical']")
	WebElement collisionVer;

	@FindBy(xpath = "//a[contains(text(),'Widget Factory')]")
	WebElement widgetFac;

	@FindBy(xpath = "//button[contains(text(),'Go green')]")
	WebElement goGreen;

	@FindBy(xpath = "//button[contains(text(),'change')]")
	List<WebElement> changeList;

	public Interactions() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}

	/**
	 * @method validates the page
	 */
	public void validatePage() {
		getTitle();
		getURL();
	}

	/**
	 * @method drags the element and drops it in the given axis.
	 * @throws Exception
	 */
	public void dragAxis() throws Exception {
		clickMethod(draggableButton, "Draggeble button");
		scrollToElement(frameHeading);
		frameByIndex(0);
		Actions act = new Actions(DriverFactory.getDriver());
		int x = dragbox.getLocation().getX();
		int y = dragbox.getLocation().getY();
		act.dragAndDropBy(dragbox, x + 65, y + 75).perform();
		defaultwindow();
	}

	/**
	 * @method to drag and drop at the target element.
	 * @throws Exception
	 */
	public void dragAndDrop() throws Exception {
		clickMethod(droppableButton, "Draggeble button");
		scrollToElement(frameHeading);
		frameByIndex(0);
		act.dragAndDrop(dragbox, dropBox).perform();
		defaultwindow();
	}

	/**
	 * @method to resize the element.
	 * @throws Exception
	 */
	public void resize() throws Exception {
		clickMethod(resizeButton, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		Dimension initsize = resizeBox.getSize();
		act.clickAndHold(resizeSlider).moveByOffset(100, 50).release(resizeSlider).perform();
		Dimension finalSize = resizeBox.getSize();
		if (initsize != finalSize) {
			logMessage(" Resize sucessufull ");
		} else {
			logErrorMessage(" Resize failed ");
		}
		defaultwindow();
	}

	/**
	 * @methods
	 * @throws Exception
	 */
	public void selectable() throws Exception {
		clickMethod(selectableButton, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		for (WebElement element : itemList) {
			webWait(element);
			String name = element.getText();
			if (name.contains("Item 3")) {
				clickMethod(element, "item 3");
				logMessage("item 3" + "  is clicked");
				if (element.getAttribute("class").contains("ui-selected")) {
					logMessage("Item 3 is selected ");
				} else {
					logErrorMessage("Item 3 is not selected ");
				}
				break;
			}
		}
		defaultwindow();
	}

	/**
	 * @method sorts the element.
	 * @throws Exception
	 */
	public void sort() throws Exception {
		clickMethod(sortableButton, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		act.clickAndHold(sortableEle.get(6)).moveToElement(sortableEle.get(0)).release().perform();
		defaultwindow();
	}

	/**
	 * @method expands section 2 and validate.
	 * @throws Exception
	 */
	public void accord() throws Exception {
		clickMethod(accordButton, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(section2, " Section 2 button ");
		if (section2.getAttribute("class").contains("ui-state-active")) {
			logMessage(" section2 is expanded ");
		} else {
			logMessage(" Section2 not expanded ");
		}
		defaultwindow();
	}

	/**
	 * @method or autocomplete.
	 * @throws Exception
	 */
	public void autoComplete() throws Exception {
		clickMethod(autoCompleteButton, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		sendKeysMethod(inputAutocomplete, "java");
		listDrop(tagList, "JavaScript");
		if (inputAutocomplete.getAttribute("value").equalsIgnoreCase("JavaScript")) {
			logMessage(" Autocomplete selected successully ");
		} else {
			logErrorMessage(" Autocomplete not selected ");
		}
		defaultwindow();
	}

	/**
	 * @method clicks widget and css buttons
	 * @throws Exception
	 */
	public void button() throws Exception {
		clickMethod(buttonButt, " Resizable button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(widgetbuttele, " button element under widget ");
		clickMethod(submitbuttele, " A submit button under widget");
		clickMethod(anchorbutt, " Anchor button under widget");
		clickMethod(csswidgetbuttele, " css button element under widget ");
		clickMethod(csssubmitbuttele, " css A submit button under widget");
		clickMethod(cssanchorbutt, " css Anchor button under widget");
		defaultwindow();
	}

	/**
	 * @method to click and validate checkbox.
	 * @throws Exception
	 */
	public void checkBox() throws Exception {
		clickMethod(checkboxRadio, " check box radio button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(newyorkRadio, " newyork radio button ");
		if (newyorkRadio.getAttribute("class").contains("ui-state-active")) {
			logMessage(" newyork radio button clicked sucessfully ");
		} else {
			logErrorMessage(" newyork radio button not clicked ");
		}
		clickMethod(twostarRadio, " Two star radio button ");
		clickMethod(threestarRadio, " Three star radio button ");
		clickMethod(fourstarRadio, " four star radio button ");
		clickMethod(fivestarRadio, " five star radio button ");
		if (twostarRadio.getAttribute("class").contains("ui-state-active")
				&& threestarRadio.getAttribute("class").contains("ui-state-active")
				&& fourstarRadio.getAttribute("class").contains("ui-state-active")
				&& fivestarRadio.getAttribute("class").contains("ui-state-active")) {
			logMessage(" All star check boxes are clicked ");
		} else {
			logErrorMessage(" some of the check box is not clicked");
		}
		clickMethod(nested1, " double 2 ");
		clickMethod(nested2, " Queen 2 ");
		clickMethod(nested3, " Queen 1 ");
		clickMethod(nested4, " king 1 ");
		if (nested1.getAttribute("class").contains("ui-state-active")
				&& nested2.getAttribute("class").contains("ui-state-active")
				&& nested3.getAttribute("class").contains("ui-state-active")
				&& nested4.getAttribute("class").contains("ui-state-active")) {
			logMessage(" All nested check boxes are clicked ");
		} else {
			logErrorMessage(" some of the nested check box is not clicked");
		}
		defaultwindow();
	}

	/**
	 * @method book car in both vertical and horizontal.
	 * @throws Exception
	 */
	public void controlGRP() throws Exception {
		clickMethod(controlgroup, " Control group button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(carTypeButtonHOR, " Car Type horizontal ");
		clickMethod(cmpctCarHOR, " Compact car option in Horizontal ");
		clickMethod(standardHOR, " Standard button in horizontal ");
		clickMethod(insurenceHOR, " insurance button in horizontal ");
		sendKeysMethod(noOfCarsHOR, "5");
		clickMethod(bookHOR, " Book button in horizontal ");
		if (cartypTxtHOR.getText().equalsIgnoreCase("Compact car")
				&& (standardHOR.getAttribute("class").contains("ui-state-active"))
				&& (insurenceHOR.getAttribute("class").contains("ui-state-active"))
				&& (noOfCarsHOR.getAttribute("aria-valuenow").equals("5"))) {
			logMessage("Horizontal Booked successfully ");
		} else {
			logErrorMessage("Horizontal Booking unsuccesful ");
		}
		clickMethod(cartypVRT, " Car type in vertical ");
		clickMethod(compactVRT, " Compact car option in vertical ");
		clickMethod(standardVRT, " Standard option in vertical ");
		clickMethod(insuranceVRT, " Insurance in vertical ");
		sendKeysMethod(noOfCarsVRT, "5");
		clickMethod(bookVRT, " Book button ");
		if (cartypVRT.getText().equalsIgnoreCase("Compact car")
				&& (standardVRT.getAttribute("class").contains("ui-state-active"))
				&& (insuranceVRT.getAttribute("class").contains("ui-state-active"))
				&& (noOfCarsVRT.getAttribute("aria-valuenow").equals("5"))) {
			logMessage("Horizontal Booked successfully ");
		} else {
			logErrorMessage("Horizontal Booking unsuccesful ");
		}
		defaultwindow();
	}

	/**
	 * @method pick the requested date from the date-picker
	 * @throws Exception
	 */
	public void datePicker() throws Exception {
		clickMethod(datePicker, " Date-picker button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(datePickerBox, " datepicker box ");
		String[] crntDate = splitString(currentDate(10, "MMMMMMMMMM/d/YYYY"), "/");
		while (true) {
			if (monthele.getText().equalsIgnoreCase(crntDate[0])) {
				listDrop(dayList, crntDate[1]);
				break;
			} else {
				clickMethod(nxtArrow, " next arrow button ");
			}
		}
		defaultwindow();
	}

	/**
	 * @method closes the dialog box and validates it.
	 * @throws Exception
	 */
	public void dialog() throws Exception {
		clickMethod(dialogButton, " dialog button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(dialogClose, " dialog box close ");
		if (!dialogBox.isDisplayed()) {
			logMessage(" dialog box closed ");
		} else {
			logErrorMessage(" dialog box not closed ");
		}
		defaultwindow();
	}

	/**
	 * @method choose a option from the menu.
	 * @throws Exception
	 */
	public void menu() throws Exception {
		clickMethod(menuButton, " Menu button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		act.moveToElement(musicOPT).perform();
		webWait(jazzOPT);
		act.moveToElement(jazzOPT).perform();
		webWait(modernOPT);
		act.click(modernOPT).perform();
		defaultwindow();
	}

	/**
	 * @method to print the status of download.
	 * @throws Exception
	 */
	public void progressBar() throws Exception {
		clickMethod(progressbarButton, " Menu button ");
		scrollToElement(frameHeading);
		clickMethod(downloadDialogButt, " download dialog ");
		frameByElement(demoFrame);
		Thread.sleep(3000);
		clickMethod(startDownloadButt, " Start download button ");
		while (true) {
			if (progressStatus.getText().equals("Complete!")) {
				logMessage(" Downloaded sucessfully ");
				break;
			} else {
				Thread.sleep(50);
				logMessage(progressStatus.getText());
			}
		}
		act.click(closeButton).perform();
		defaultwindow();
	}

	/**
	 * @method Seleccts options from the drop-down.
	 * @throws Exception
	 */
	public void selectMenu() throws Exception {
		clickMethod(selectmenuButton, " selectMenu button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(speedButton, " SpeedButton ");
		clickMethod(fasterOPT, " Faster option ");
		clickMethod(fileButton, " File button ");
		clickMethod(file, " File ");
		clickMethod(numberButton, " Number button ");
		clickMethod(number, " Number 3 ");
		scrollToElement(titleButton);
		clickMethod(titleButton, " title button ");
		clickMethod(title, " Title Prof. ");
		defaultwindow();
	}

	/**
	 * @method to slide the bar right.
	 * @throws Exception
	 */
	public void slide() throws Exception {
		clickMethod(sliderButton, " Slider button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		act.clickAndHold(slideBar).moveByOffset(60, 0).perform();
		if (Integer.valueOf((slideBar.getAttribute("style").replace("left: ", "")).replace("%;", "")) > 0) {
			logMessage(" Slided bar to right sucessfully ");
		}
		defaultwindow();
	}
	/**
	 * @method to spin and handle.
	 * @throws Exception
	 */
	public void spinner() throws Exception {
		clickMethod(spinnerButton, " spinner button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		int spin = 10;
		while (true) {
			clickMethod(selectaValue, " select a value label ");
			if (spin > 0) {
				if ((spinnerInput.getAttribute("aria-valuenow") == null)
						|| (Integer.valueOf(spinnerInput.getAttribute("aria-valuenow")) < spin)) {
					clickMethod(spinnerUP, " Spinner up button ");
					if (Integer.valueOf(spinnerInput.getAttribute("aria-valuenow")) == spin) {
						break;
					}
				}
			} else {
				clickMethod(spinnerDOWN, " Spinner down ");
				if (Integer.valueOf(spinnerInput.getAttribute("aria-valuenow")) == spin) {
					break;
				}
			}
		}
		clickMethod(getValueButton, " get value button ");
		DriverFactory.getDriver().switchTo().alert().accept();
		defaultwindow();
	}
	/**
	 * @method switch tab inside frame.
	 * @throws Exception
	 */
	public void tabs() throws Exception {
		clickMethod(tabsButton, " tabs button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(tab2, " Tab 2");
		clickMethod(tab3," Tab 3 ");
		defaultwindow();
	}
	/**
	 * @method to view toolTip.
	 * @throws Exception
	 */
	public void toolTip() throws Exception {
		clickMethod(tooltipButton, " tabs button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		act.moveToElement(ageEle).perform();
		Thread.sleep(2000);
		defaultwindow();
	}
	/**
	 * @method runs the animation.
	 * @throws Exception
	 */
	public void addClass() throws Exception {
		clickMethod(addClassButton, " Addclass button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runButton, " Run button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method Toggle color animation.
	 * @throws Exception
	 */
	public void colorAnim() throws Exception {
		clickMethod(colorAnimButton, " Color animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(toggleEffectButton, " Toggle effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method clicks easting anim elements.
	 * @throws Exception
	 */
	public void easting() throws Exception {
		clickMethod(eastingButton, " Easting animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		for(WebElement ele : eastAnim) {
			act.click(ele).perform();
		}
		Thread.sleep(2000);
		defaultwindow();
	}
	/**
	 * @method To run effect.
	 * @throws Exception
	 */
	public void effect() throws Exception {
		clickMethod(effectButton, " effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		selectByVisibleText(effectDrop, "Explode");
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method to run hide effect.
	 * @throws Exception
	 */
	public void hide() throws Exception {
		clickMethod(hideButton, " hide effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		selectByVisibleText(effectDrop, "Explode");
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method runs remove class effect.
	 * @throws Exception
	 */
	public void removeClass() throws Exception {
		clickMethod(removeClassButton, " removeclass effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method runs show effect.
	 * @throws Exception
	 */
	public void show() throws Exception {
		clickMethod(showButton, " show effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		selectByVisibleText(effectDrop, "Explode");
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method runs switchclass effect.
	 */
	public void switchClass() throws Exception {
		clickMethod(switchClassButton, " switch class effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method runs toggle effect.
	 * @throws Exception
	 */
	public void toggle() throws Exception {
		clickMethod(toggleButton, " toggle effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		selectByVisibleText(effectDrop, "Explode");
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method runs Toggle class effect.
	 * @throws Exception
	 */
	public void toggleClass() throws Exception {
		clickMethod(toggleClassButton, " toggle class effect animation button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runButton, " Run Effect button ");
		Thread.sleep(3000);
		defaultwindow();
	}
	/**
	 * @method to position the labels.
	 * @throws Exception
	 */
	public void position() throws Exception {
		clickMethod(positionButton, " Position button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		selectByVisibleText(myHor, "left");
		selectByVisibleText(myVer, "center");
		selectByVisibleText(atHor, "right");
		selectByVisibleText(atVer, "center");
		selectByVisibleText(collisionHor, "flipfit");
		selectByVisibleText(collisionVer, "flipfit");
		defaultwindow();
	}
	/**
	 * @method to change color of the widgets.
	 * @throws Exception
	 */
	public void widgetFactory() throws Exception {
		clickMethod(widgetFac, " widget factory button ");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(goGreen, " Go green button ");
		clickMethod(changeList.get(0), " change button ");
		clickMethod(changeList.get(1), " change button ");
		clickMethod(changeList.get(2), " change button ");
		defaultwindow();
	}
}
