package jqueryrunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.venkatesh.JQueryTest;
import utils.DriverFactory;

public class Runner extends CommonActionMethods {

	@BeforeMethod
	public void browser() throws Exception {
		invokeBrowser("chrome", "normal", "https://jqueryui.com/draggable/");
	}

	@Test
	private void drag() throws Exception {
		new JQueryTest().dragDropBy();

	}

	@Test
	private void drop() throws Exception {
		new JQueryTest().droppables();
	}

	@Test
	private void resize() throws Exception {
		new JQueryTest().resizes();
	}

	@Test
	private void select() throws Exception {
		new JQueryTest().selectable();

	}

	@Test
	private void sortable() throws Exception {
		new JQueryTest().sortable();
	}

	@Test
	private void accordion() throws Exception {
		new JQueryTest().accordion();
	}

	@Test
	private void autoComplete() throws Exception {
		new JQueryTest().autocompletes();
	}

	@Test
	private void button() throws Exception {
		new JQueryTest().buttons();
	}

	@Test
	private void Checkboxradio() throws Exception {
		new JQueryTest().checkBoxRadios();

	}

	@Test
	private void controlGroup() throws Exception {
		new JQueryTest().controlgroups();
	}

	@Test
	private void diaLog() throws Exception {
		new JQueryTest().dialogs();
	}

	@Test
	private void menu() throws Exception {
		new JQueryTest().menus();

	}

	@Test
	private void progressBar() throws Exception {
		new JQueryTest().progressbars();
	}

	@Test
	private void datePicker() throws Exception {
		new JQueryTest().datepickeres();

	}

	@Test
	private void selectMenu() throws Exception {
		new JQueryTest().selectMenus();
	}

	@Test
	private void slider() throws Exception {
		new JQueryTest().sliders();

	}

	@Test
	private void spinner() throws Exception {
		new JQueryTest().spinneres();
	}

	@Test
	private void tabs() throws Exception {
		new JQueryTest().tabed();

	}

	@Test
	private void toolTip() throws Exception {
		new JQueryTest().toolTips();
	}

	@Test
	private void effects() throws Exception {
		new JQueryTest().effects();

	}

	@Test
	private void position() throws Exception {
		new JQueryTest().positions();

	}

	@Test
	public void widgetFactory() throws Exception {
		new JQueryTest().widgetFactories();

	}

	@AfterMethod
	private void quit() {
		DriverFactory.getDriver().quit();
	}

}
