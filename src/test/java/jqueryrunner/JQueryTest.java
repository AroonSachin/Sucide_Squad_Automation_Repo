package jqueryrunner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.JQuerySowmya;

public class JQueryTest extends CommonActionMethods {
	@BeforeMethod
	public void startBrowser() throws Exception {
		invokeBrowser("chrome", "Windows", "https://jqueryui.com/");
	}

	@Test(priority = 1)
	public void interaction() throws Exception {

		new JQuerySowmya().draggable();
		new JQuerySowmya().dragAndDrop();
		new JQuerySowmya().droppable();
		new JQuerySowmya().resizable();
		new JQuerySowmya().selectable();
		new JQuerySowmya().clickSortableButton();
	}

	@Test(priority = 2)
	public void widget() throws Exception {
		new JQuerySowmya().clickAccordianButton();
		new JQuerySowmya().clickAutocompleteButton();
		new JQuerySowmya().clickButtonElement();
		new JQuerySowmya().clickCheckboxRadioButton();
		new JQuerySowmya().clickControlgroupButton();
		new JQuerySowmya().clickDatepickerButton();
		new JQuerySowmya().clickDialogueButton();
		new JQuerySowmya().clickMenuButton();
		new JQuerySowmya().clickProgressbarButton();
		new JQuerySowmya().clickSelectmenuButton();
		new JQuerySowmya().clickSliderButton();
		new JQuerySowmya().clickSpinnerButton();
		new JQuerySowmya().clickTabsButton();
		new JQuerySowmya().clickToolTip();
	}

	@Test(priority = 3)

	public void effects() throws Exception {
		new JQuerySowmya().clickAddclassButton();
		new JQuerySowmya().clickColorAnimation();
		new JQuerySowmya().clickEasingButton();
		new JQuerySowmya().clickEffectButton();
		new JQuerySowmya().clickHideButton();
		new JQuerySowmya().clickRemoveClass();
		new JQuerySowmya().clickShowButton();
		new JQuerySowmya().clickSwitchClassButton();
		new JQuerySowmya().clickToggleButton();
		new JQuerySowmya().clickToggleTypeButton();

	}

	@Test (priority = 4)
	public void utilities() throws Exception {
		new JQuerySowmya().clickPositionButton();
		new JQuerySowmya().clickWidgetFactoryButton();
	}

}
