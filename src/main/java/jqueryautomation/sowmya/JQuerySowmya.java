package jqueryautomation.sowmya;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

/**
 * @this class contains action methods
 * @author svenkateshwaran
 *
 */

public class JQuerySowmya extends CommonActionMethods {

	Actions drag = new Actions(DriverFactory.getDriver());

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement frameHeading;

	@FindBy(xpath = "//iframe[@class='demo-frame']")
	WebElement demoFrame;

	@FindBy(xpath = "//a[text()='Draggable']")
	public WebElement dragButton;

	@FindBy(id = "draggable")
	public WebElement draggable;

	@FindBy(xpath = "//a[text()='Droppable']")
	public WebElement dropButton;

	@FindBy(xpath = "//a[text()='Resizable']")
	public WebElement resizeButton;

	@FindBy(xpath = "//div[@id='resizable']//div[3]")
	public WebElement resizable;

	@FindBy(xpath = "//a[text() = 'Selectable']")
	public WebElement selectableButton;

	@FindBy(xpath = "//ol[@id='selectable']//li[text()='Item 3']")
	public WebElement selectItem;

	@FindBy(xpath = "//a[text()='Sortable']")
	public WebElement sortableButton;

	@FindBy(xpath = "//li[contains(@class,'ui-sortable-handle')]")
	List<WebElement> sortItems;

	@FindBy(xpath = "//a[text()='Accordion']")
	public WebElement accordianButton;

	@FindBy(id = "ui-id-3")
	public WebElement clickAccordian;

	@FindBy(xpath = "//a[text()='Autocomplete']")
	public WebElement autocompleteButton;

	@FindBy(id = "tags")
	public WebElement fillAutocompleteData;

	@FindBy(xpath = "//div[contains(text(),'JavaScript')]")
	public WebElement jsOpt;

	@FindBy(xpath = "//a[text()='Button']")
	public WebElement buttonElement;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::button[contains(text(),'A button element')]")
	public WebElement widgetButton1;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::input[contains(@value,'A submit button')]")
	public WebElement widgetButton2;

	@FindBy(xpath = "//h1[contains(text(),'Widget Buttons')]/following-sibling::a[contains(text(),'An anchor')]")
	public WebElement widgetButton3;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::button[contains(text(),'A button element')]")
	public WebElement cssButton1;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::input[contains(@value,'A submit button')]")
	public WebElement cssButton2;

	@FindBy(xpath = "//h1[contains(text(),'CSS Buttons')]/following-sibling::a[contains(text(),'An anchor')]")
	public WebElement cssButton3;

	@FindBy(xpath = "//a[contains(text(),'Checkboxradio')]")
	public WebElement checkboxRadioButton;

	@FindBy(xpath = "//legend[contains(text(),'Select a Location:')]/following-sibling::label[contains(text(),'New York')]")
	public WebElement newyorkRadioButton;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings: ')]/following-sibling::label[contains(text(),'2 Star')]")
	public WebElement checkboxOne;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings:')]/following-sibling::label[contains(text(),'3 Star')]")
	public WebElement checkboxTwo;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings:')]/following-sibling::label[contains(text(),'3 Star')]")
	public WebElement checkboxThree;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings:')]/following-sibling::label[contains(text(),'4 Star')]")
	public WebElement checkboxFour;

	@FindBy(xpath = "//legend[contains(text(),'Hotel Ratings:')]/following-sibling::label[contains(text(),'5 Star')]")
	public WebElement checkboxFive;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type:')]/following-sibling::label[contains(text(),'2 Double')]")
	public WebElement nestedCheckbox1;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type:')]/following-sibling::label[contains(text(),'2 Queen')]")
	public WebElement nestedCheckbox2;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type:')]/following-sibling::label[contains(text(),'1 Queen')]")
	public WebElement nestedCheckbox3;

	@FindBy(xpath = "//legend[contains(text(),'Bed Type:')]/following-sibling::label[contains(text(),'1 King')]")
	public WebElement nestedCheckbox4;

	@FindBy(xpath = "//a[contains(text(),'Controlgroup')]")
	public WebElement controlgroupButton;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//span[@id='car-type-button']")
	public WebElement selectCarTypeHorizontal;

	@FindBy(xpath = "//ul[@id='car-type-menu']//div[contains(text(),'Compact car')]")
	public WebElement compactButtonHorizontal;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[contains(text(),'Standard')]")
	public WebElement standardButtonHorizontal;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//label[contains(text(),'Insurance')]")
	public WebElement insuranceRadioButtonHorizontal;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//input[contains(@class,'ui-spinner-input')]")
	public WebElement carCountHorizontal;

	@FindBy(xpath = "//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//button[text()='Book Now!']")
	public WebElement bookButtonHorizontal;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//span[@class='ui-selectmenu-text']")
	public WebElement selectCarTypeVertical;

	@FindBy(xpath = "//ul[@id='ui-id-8-menu']//div[contains(text(),'Compact car')]")
	public WebElement compactButtonVertical;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//label[contains(text(),'Standard')]")
	public WebElement standardButtonVertical;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//label[text()='Insurance']")
	public WebElement insuranceRadioButtonVertical;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//input[contains(@class,'ui-spinner-input')]")
	public WebElement carCountVertical;

	@FindBy(xpath = "//div[@class='controlgroup-vertical ui-controlgroup ui-controlgroup-vertical']//button[text()='Book Now!']")
	public WebElement bookButtonVertical;

	@FindBy(xpath = "//a[text()='Datepicker']")
	public WebElement datePickerButton;

	@FindBy(id = "datepicker")
	public WebElement fillDatePicker;

	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	public WebElement dpMonth;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	public WebElement dpNext;

	@FindBy(xpath = "//a[contains(@class, 'ui-state-default')]")
	public List<WebElement> dpDays;

	@FindBy(xpath = "//a[text()='Dialog']")
	public WebElement dialogueButton;

	@FindBy(xpath = "//div[contains(@class,'ui-dialog ui-corner-all')]")
	public WebElement dialogueBox;

	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeDialogue;

	@FindBy(xpath = "//a[text()='Menu']")
	public WebElement menuButton;

	@FindBy(xpath = "//div[contains(text(),'Electronics')]")
	public WebElement electronicsButton;

	@FindBy(xpath = "//li[@class='ui-menu-item']//div[text()='Car Hifi']")
	public WebElement carHifiButton;

	@FindBy(xpath = "//a[text()='Progressbar']")
	public WebElement progressbarButton;

	@FindBy(xpath = "//a[text()='Download Dialog']")
	public WebElement downloadDialogButton;

	@FindBy(xpath = "//button[text()='Start Download']")
	public WebElement startDownload;

	@FindBy(xpath = "//div[text()='Complete!']")
	public WebElement downloadComplete;

	@FindBy(xpath = "//div[@class='ui-dialog-buttonset']//button[contains(text(),'Close')]")
	public WebElement closeButton;

	@FindBy(xpath = "//a[text()='Selectmenu']")
	public WebElement selectMenuButton;

	@FindBy(xpath = "//span[@class='ui-selectmenu-button ui-selectmenu-button-closed ui-corner-all ui-button ui-widget']//span[contains(text(),'Medium')]")
	public WebElement selectSpeed;

	@FindBy(xpath = "//ul[@class='ui-menu ui-corner-bottom ui-widget ui-widget-content']//div[contains(text(),'Faster')]")
	public WebElement selectFaster;

	@FindBy(xpath = "//span[@class='ui-selectmenu-button ui-selectmenu-button-closed ui-corner-all ui-button ui-widget']//span[contains(text(),'jQuery.js')]")
	public WebElement selectFile;

	@FindBy(xpath = "//ul[@class='ui-menu ui-corner-bottom ui-widget ui-widget-content']//div[text()='ui.jQuery.js']")
	public WebElement selectUiJQueryOption;

	@FindBy(xpath = "//span[@class='ui-selectmenu-button ui-selectmenu-button-closed ui-corner-all ui-button ui-widget']//span[text()='2']")
	public WebElement selectNumber;

	@FindBy(xpath = "//ul[@class='ui-menu ui-corner-bottom ui-widget ui-widget-content overflow']//div[text()='3']")
	public WebElement threeCount;

	@FindBy(xpath = "//span[@class='ui-selectmenu-button ui-selectmenu-button-closed ui-corner-all ui-button ui-widget']//span[contains(text(),'Please pick one')]")
	public WebElement selectTitle;

	@FindBy(xpath = "//div[text()='Mrs.']")
	public WebElement TitleMrs;

	@FindBy(xpath = "//a[text()='Slider']")
	public WebElement clickSlider;

	@FindBy(xpath = "//span[contains(@class,'ui-slider-handle')]")
	public WebElement DragSlideBar;

	@FindBy(xpath = "//a[text()='Spinner']")
	public WebElement clickSpinner;

	@FindBy(id = "spinner")
	public WebElement spinnerValue;

	@FindBy(xpath = "//button[text()='Toggle disable/enable']")
	public WebElement disableAbleToggle;

	@FindBy(xpath = "//button[text()='Toggle widget']")
	public WebElement toggleWidget;

	@FindBy(xpath = "//button[text()='Get value']")
	public WebElement getValue;

	@FindBy(xpath = "//button[text()='Set value to 5']")
	public WebElement setValue;

	@FindBy(xpath = "//a[text()='Tabs']")
	public WebElement tabsButton;

	@FindBy(xpath = "//li[@aria-controls='tabs-1']")
	public WebElement tabsOption1;

	@FindBy(xpath = "//li[@aria-controls='tabs-2']")
	public WebElement tabsOption2;

	@FindBy(xpath = "//li[@aria-controls='tabs-3']")
	public WebElement tabsOption3;

	@FindBy(xpath = "//a[text()='Tooltip']")
	public WebElement toolTip;

	@FindBy(id = "age")
	public WebElement fillAge;

	@FindBy(xpath = "//a[text()='Add Class']")
	public WebElement addClassButton;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectButton;

	@FindBy(xpath = "//a[text()='Color Animation']")
	public WebElement colorAnimationButton;

	@FindBy(xpath = "//button[text()='Toggle Effect']")
	public WebElement toggleButton;

	@FindBy(xpath = "//a[text()='Easing']")
	public WebElement easingButton;

	@FindBy(xpath = "//div[@class='graph']//div[text()='1. linear']")
	public WebElement linearGraph;

	@FindBy(xpath = "//a[text()='Effect']")
	public WebElement effectButton;

	@FindBy(xpath = "//select[@id='effectTypes']")
	public WebElement effectTypes;

	@FindBy(xpath = "//select[@id='effectTypes']//option[text()='Explode']")
	public WebElement selectEffectType;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectExplode;

	@FindBy(xpath = "//a[text()='Hide']")
	public WebElement hideButton;

	@FindBy(xpath = "//select[@id='effectTypes']")
	public WebElement hideEffectType;

	@FindBy(xpath = "//select[@id='effectTypes']//option[text()='Bounce']")
	public WebElement selectHideType;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectBounce;

	@FindBy(xpath = "//a[text()='Remove Class']")
	public WebElement removeClassButton;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectRemove;

	@FindBy(xpath = "//a[text()='Show']")
	public WebElement showButton;

	@FindBy(xpath = "//select[@id='effectTypes']//option[text()='Highlight']")
	public WebElement selectShowType;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectShow;

	@FindBy(xpath = "//a[text()='Switch Class']")
	public WebElement switchClassButton;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectSwitch;

	@FindBy(xpath = "//a[text()='Toggle']")
	public WebElement toggleButtonOption;

	@FindBy(xpath = "//select[@id='effectTypes']//option[text()='Shake']")
	public WebElement selectToggleType;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectToggle;

	@FindBy(xpath = "//a[text()='Toggle Class']")
	public WebElement toggleClassButton;

	@FindBy(xpath = "//button[text()='Run Effect']")
	public WebElement runEffectToggleClassButton;

	@FindBy(xpath = "//a[text()='Position']")
	public WebElement positionButton;

	@FindBy(xpath = "//select[@id='my_horizontal']")
	public WebElement myPositionHorizontal;

	@FindBy(xpath = "//select[@id='my_horizontal']//option[text()='center']")
	public WebElement myPositionCenter;

	@FindBy(xpath = "//select[@id='my_vertical']")
	public WebElement myPositionVertical;

	@FindBy(xpath = "//select[@id='my_vertical']//option[text()='bottom']")
	public WebElement myPositionBottom;

	@FindBy(xpath = "//select[@id='at_horizontal']")
	public WebElement atPositionHorizontal;

	@FindBy(xpath = "//select[@id='at_horizontal']//option[text()='center']")
	public WebElement atPositionCenter;

	@FindBy(xpath = "//select[@id='at_vertical']")
	public WebElement atPositionVertical;

	@FindBy(xpath = "//select[@id='at_vertical']//option[text()='bottom']")
	public WebElement atPositionBottom;

	@FindBy(xpath = "//select[@id='collision_horizontal']")
	public WebElement collisionPositonHorizontal;

	@FindBy(xpath = "//select[@id='collision_horizontal']//option[text()='flipfit']")
	public WebElement collisionFlipfit;

	@FindBy(xpath = "//select[@id='collision_vertical']")
	public WebElement collisionPositionVertical;

	@FindBy(xpath = "//select[@id='collision_vertical']//option[text()='fit']")
	public WebElement collisionFit;

	@FindBy(xpath = "//a[text()='Widget Factory']")
	public WebElement widgetFactoryButton;

	@FindBy(xpath = "//div[@id='my-widget1']//button[text()='change']")
	public WebElement colormeOne;

	@FindBy(xpath = "//div[@id='my-widget2']//button[text()='change']")
	public WebElement colormeTwo;

	@FindBy(xpath = "//div[@id='my-widget3']//button[text()='change']")
	public WebElement colormeThree;

	@FindBy(xpath = "//button[text()='Go green']")
	public WebElement goGreenButton;

	public JQuerySowmya() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	/**
	 * @this method is used to drag the element
	 * @throws Exception
	 */
	public void draggable() throws Exception {
		clickMethod(dragButton, "drag");
	}

	/**
	 * @this method is to drag and drop an element inside an element
	 * @throws Exception
	 */
	public void dragAndDrop() throws Exception {
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		webWait(draggable);
		int x = draggable.getLocation().getX();
		int y = draggable.getLocation().getY();
		drag.dragAndDropBy(draggable, x + 45, y + 65).perform();
		defaultwindow();
	}

	/**
	 * @this method is to drop the element from one place to another
	 * @throws Exception
	 */
	public void droppable() throws Exception {
		clickMethod(dragButton, "droppable");

	}

	/**
	 * @this method is to resize the element
	 * @throws Exception
	 */
	public void resizable() throws Exception {
		clickMethod(resizeButton, "resizable");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		webWait(resizable);
		drag.clickAndHold(resizable).moveByOffset(100, 60).release(resizable).perform();
		logMessage("height&width:" + resizable.getSize());
		defaultwindow();
	}

	/**
	 * @this method is to select one of the elements
	 * @throws Exception
	 */
	public void selectable() throws Exception {
		clickMethod(selectableButton, "select");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(selectItem, "Item 3");
		defaultwindow();
	}

	/**
	 * @this method is to sort the list of elements
	 * @throws Exception
	 */
	public void clickSortableButton() throws Exception {
		clickMethod(sortableButton, "sortable");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		drag.clickAndHold(sortItems.get(3)).moveToElement(sortItems.get(2)).release().perform();
		defaultwindow();
	}

	/**
	 * @this method is used to select the sections
	 * @throws Exception
	 */
	public void clickAccordianButton() throws Exception {
		clickMethod(accordianButton, "accordian");
		logMessage("Accordian button is clicked");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(clickAccordian, "click accordian");
		if (clickAccordian.getAttribute("class").contains("ui-state-active")) {
			logMessage("Accordian section is selected");
		} else {
			logErrorMessage("Accordian section is not selected");
		}
		defaultwindow();

	}

	/**
	 * @this method is to pass the data and autocomplete the data
	 * @throws Exception
	 */
	public void clickAutocompleteButton() throws Exception {
		clickMethod(autocompleteButton, "autocomplete");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		sendKeysMethod(fillAutocompleteData, "java");
		clickMethod(jsOpt, "Javascript");
		defaultwindow();
	}

	/**
	 * @this method is to click on elements using button, anchors, etc.
	 * @throws Exception
	 */
	public void clickButtonElement() throws Exception {
		clickMethod(buttonElement, "button element");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(widgetButton1, "A widget button element is clicked");
		clickMethod(widgetButton2, "A widget submit element is clicked");
		clickMethod(widgetButton3, "A widget anchor is clicked");
		clickMethod(cssButton1, "A CSS button element is clicked");
		clickMethod(cssButton2, "A CSS submit element is clicked");
		clickMethod(cssButton3, "A CSS anchor element is clicked");
		defaultwindow();
	}

	/**
	 * @this method is to choose the options by clicking on the checkboxes
	 * @throws Exception
	 */
	public void clickCheckboxRadioButton() throws Exception {
		clickMethod(checkboxRadioButton, "Checkbox");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(newyorkRadioButton, "Newyork");
		clickMethod(checkboxOne, "Checkbox 1");
		clickMethod(checkboxFive, "Checkbox 5");
		clickMethod(nestedCheckbox4, "King size");
		defaultwindow();
	}

	/**
	 * @this method is to select the items from the group of multiple buttons and
	 *       widgets
	 * @throws Exception
	 */
	public void clickControlgroupButton() throws Exception {
		clickMethod(controlgroupButton, "control group");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(selectCarTypeHorizontal, "Select car option in horizontal");
		clickMethod(compactButtonHorizontal, "Horizontal compact car");
		clickMethod(standardButtonHorizontal, "Standard");
		clickMethod(insuranceRadioButtonHorizontal, "Insurance");
		sendKeysMethod(carCountHorizontal, "3");
		clickMethod(bookButtonHorizontal, "Booking");
		clickMethod(selectCarTypeVertical, "Select car option in vertical");
		clickMethod(compactButtonVertical, "Vertical compact car");
		clickMethod(standardButtonVertical, "Vertical standard car");
		clickMethod(insuranceRadioButtonVertical, "Vertical insurance");
		sendKeysMethod(carCountVertical, "4");
		clickMethod(bookButtonVertical, "Vertical booking");
		defaultwindow();
	}

	/**
	 * @this method is to select a particular date from the calendar
	 * @throws Exception
	 */
	public void clickDatepickerButton() throws Exception {
		clickMethod(datePickerButton, "Date picker");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(fillDatePicker, "Select date");
		String[] date = splitString(currentDate(7, "MMMMMMMMMM/d"), "/");
		while (true) {
			if (dpMonth.getText().equalsIgnoreCase(date[0])) {
				listDrop(dpDays, date[1]);
				break;
			} else {
				clickMethod(dpNext, "Next month");
			}
		}

		defaultwindow();

	}

	/**
	 * @this method is to close the dialogue box
	 * @throws Exception
	 */
	public void clickDialogueButton() throws Exception {
		clickMethod(dialogueButton, "Dialogue");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(closeDialogue, "Close dialogue");
		if (!dialogueBox.isDisplayed()) {
			logMessage("Dialogue box is closed");
		} else {
			logErrorMessage("Dialogue box is not closed");
		}
		defaultwindow();
	}

	/**
	 * @this method is to select the menu
	 * @throws Exception
	 */
	public void clickMenuButton() throws Exception {
		clickMethod(menuButton, "Menu");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(electronicsButton, "Electronics");
		clickMethod(carHifiButton, "Car Hifi");
		defaultwindow();
	}

	/**
	 * @this method is to display the status of the process
	 * @throws Exception
	 */
	public void clickProgressbarButton() throws Exception {
		clickMethod(progressbarButton, "Progress bar");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		defaultwindow();
		clickMethod(downloadDialogButton, "Download dialog");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		Thread.sleep(3000);
		clickMethod(startDownload, "Start download");
		webwaitVisibility(downloadComplete);
		if (downloadComplete.isDisplayed()) {
			logMessage("Download is completed");
		} else {
			logErrorMessage("Download is not successful");
		}
		clickMethod(closeButton, "Close");
		defaultwindow();

	}

	/**
	 * @this method is to select the menus from the dropdown values
	 * @throws Exception
	 */
	public void clickSelectmenuButton() throws Exception {
		clickMethod(selectMenuButton, "Select menu");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(selectSpeed, "Select speed");
		clickMethod(selectFaster, "Faster");
		clickMethod(selectFile, "Select file");
		clickMethod(selectUiJQueryOption, "Ui JQuery Option");
		clickMethod(selectNumber, "Number");
		clickMethod(threeCount, "Number 3");
		clickMethod(selectTitle, "Title");
		clickMethod(TitleMrs, "Title");
		defaultwindow();
	}

	/**
	 * @this method is to drag the slider from one location to another
	 * @throws Exception
	 */
	public void clickSliderButton() throws Exception {
		clickMethod(clickSlider, "Slider button");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		String initvalue = DragSlideBar.getAttribute("style").replace("left: ", "").replace("%;", "");
		drag.clickAndHold(DragSlideBar).moveByOffset(90, 0).perform();
		if ((Integer.valueOf(DragSlideBar.getAttribute("style").replace("left: ", "").replace("%;", ""))) > Integer
				.valueOf(initvalue)) {
			logMessage("Slider slided successfully");
		} else {
			logErrorMessage("Slider is not slided successfully");
		}

		defaultwindow();
	}

	/**
	 * @this method is to pass the values in the fields and to select the element by
	 *       clicking on it
	 * @throws Exception
	 */
	public void clickSpinnerButton() throws Exception {
		clickMethod(clickSpinner, "Spinner");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		sendKeysMethod(spinnerValue, "2");
		clickMethod(disableAbleToggle, "Diable and enable toggle");
		clickMethod(toggleWidget, "Toggle Widget");
		clickMethod(getValue, "Get Value");
		clickMethod(setValue, "Set Value");
		defaultwindow();
	}

	/**
	 * @this method is to click various tabs
	 * @throws Exception
	 */
	public void clickTabsButton() throws Exception {
		clickMethod(tabsButton, "Click button");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(tabsOption1, "Nunc tincidunt");
		if (tabsOption1.getAttribute("class").contains("ui-state-active")) {
			logMessage("Nunc tincidunt is selected");
		} else {
			logErrorMessage("Nunc tincidunt is not selected");
		}
		clickMethod(tabsOption2, "Proin dolor");
		if (tabsOption2.getAttribute("class").contains("ui-state-active")) {
			logMessage("Proin dolor is selected");
		} else {
			logErrorMessage("Proin dolor is not selected");
		}
		clickMethod(tabsOption3, "Aenean lacinia");
		if (tabsOption3.getAttribute("class").contains("ui-state-active")) {
			logMessage("Aenean lacinia is selected");
		} else {
			logErrorMessage("Aenean lacinia is not selected");
		}
		defaultwindow();
	}

	/**
	 * @this method is to pass the value to the field
	 * @throws Exception
	 */
	public void clickToolTip() throws Exception {
		clickMethod(toolTip, "Tool tip");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		sendKeysMethod(fillAge, "26");
		defaultwindow();
	}

	/**
	 * @this method is to animate the style of the sentence displayed
	 * @throws Exception
	 */
	public void clickAddclassButton() throws Exception {
		clickMethod(addClassButton, "Add class");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runEffectButton, "Run effect");
		defaultwindow();
	}

	/**
	 * @this method is to animate the properties of the elements
	 * @throws Exception
	 */
	public void clickColorAnimation() throws Exception {
		clickMethod(colorAnimationButton, "Color animation");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(toggleButton, "Toggle effect");
		defaultwindow();
	}

	/**
	 * @this method is to apply animation to the equation
	 * @throws Exception
	 */
	public void clickEasingButton() throws Exception {
		clickMethod(easingButton, "Easing");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(linearGraph, "Linear graph");
		defaultwindow();
	}

	/**
	 * @this method is to select an animation effect and apply it to the elements
	 * @throws Exception
	 */
	public void clickEffectButton() throws Exception {
		clickMethod(effectButton, "Effect");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(effectTypes, "Effect types");
		clickMethod(selectEffectType, "Explode");
		clickMethod(runEffectExplode, "Explode run effect");
		defaultwindow();
	}

	/**
	 * @this method is to hide elements using visual effects
	 * @throws Exception
	 */
	public void clickHideButton() throws Exception {
		clickMethod(hideButton, "Hide button");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(hideEffectType, "Hide effect type");
		clickMethod(selectHideType, "Bounce");
		clickMethod(runEffectBounce, "Bounce run effect");
		defaultwindow();
	}

	/**
	 * @this method is to remove class from elements using style changes
	 * @throws Exception
	 */
	public void clickRemoveClass() throws Exception {
		clickMethod(removeClassButton, "Remove class");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runEffectRemove, "remove run effect");
		defaultwindow();
	}

	/**
	 * @this method is to display elements using custom effects
	 * @throws Exception
	 */
	public void clickShowButton() throws Exception {
		clickMethod(showButton, "Show button");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(selectShowType, "Show type");
		Thread.sleep(2000);
		clickMethod(runEffectShow, "Highlight run effect");
		defaultwindow();
	}

	/*
	 * @this method is to display elements using custom effects
	 */
	public void clickSwitchClassButton() throws Exception {
		clickMethod(switchClassButton, "Switch class");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runEffectSwitch, "Switch run effect");
		defaultwindow();
	}

	/**
	 * @this method is to display elements using custom effects
	 * @throws Exception
	 */
	public void clickToggleButton() throws Exception {
		clickMethod(toggleButtonOption, "Toggle option");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(selectToggleType, "Shake toggle type");
		clickMethod(runEffectToggle, "Toggle run effect");
		defaultwindow();
	}

	/**
	 * @this method is to display elements using custom effects
	 * @throws Exception
	 */
	public void clickToggleTypeButton() throws Exception {
		clickMethod(toggleClassButton, "Toggle class");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(runEffectToggleClassButton, "Run effect toggle class");
		defaultwindow();
	}

	/**
	 * @this method is to position the element
	 * @throws Exception
	 */
	public void clickPositionButton() throws Exception {
		clickMethod(positionButton, "Position");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(myPositionHorizontal, "My position");
		clickMethod(myPositionCenter, "My center position");
		clickMethod(myPositionVertical, "My vertical position");
		clickMethod(myPositionBottom, "My bottom position");
		clickMethod(atPositionHorizontal, "At position");
		clickMethod(atPositionCenter, "At center position");
		clickMethod(atPositionVertical, "At vertical position");
		clickMethod(atPositionBottom, "At bottom position");
		clickMethod(collisionPositonHorizontal, "Collision horizontal");
		clickMethod(collisionFlipfit, "Collision flipfit");
		clickMethod(collisionPositionVertical, "Collision vertical");
		clickMethod(collisionFit, "Collision fit");
		defaultwindow();

	}

	/**
	 * @this method is change the color of the element
	 * @throws Exception
	 */
	public void clickWidgetFactoryButton() throws Exception {
		clickMethod(widgetFactoryButton, "Widget factory");
		scrollToElement(frameHeading);
		frameByElement(demoFrame);
		clickMethod(colormeOne, "Color me 1");
		clickMethod(colormeTwo, "Color me 2");
		clickMethod(colormeThree, "Color me 3");
		clickMethod(goGreenButton, "Go Green");
		defaultwindow();

	}

}
