package jqueryrunner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;
import jqueryautomation.venkatesh.JQueryTest;
import utils.DriverFactory;

public class Venkatesh extends CommonActionMethods {

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
		new JQueryTest().droppable();
	}

	@Test
	private void resize() throws Exception {
		new JQueryTest().resize();
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
		new JQueryTest().autocomplete();
	}

	@Test
	private void button() throws Exception {
		new JQueryTest().button();
	}

	@Test
	private void Checkboxradio() throws Exception {
		new JQueryTest().checkBoxRadio();

	}

	@Test
	private void controlGroup() throws Exception {
		new JQueryTest().controlgroup();
	}

	@Test
	private void diaLog() throws Exception {
		new JQueryTest().dialog();
	}

	@Test
	private void menu() throws Exception {
		new JQueryTest().menu();

	}

	@Test
	private void progressBar() throws Exception {
		new JQueryTest().progressbar();
	}

	@Test
	private void datePicker() throws Exception {
		new JQueryTest().datepicker();

	}

	@Test
	private void selectMenu() throws Exception {
		new JQueryTest().selectMenu();
	}

	@Test
	private void slider() throws Exception {
		new JQueryTest().slider();

	}

	@Test
	private void spinner() throws Exception {
		new JQueryTest().spinner();
	}

	@Test
	private void tabs() throws Exception {
		new JQueryTest().tabs();

	}

	@Test
	private void toolTip() throws Exception {
		new JQueryTest().toolTip();
	}

	@Test
	private void effects() throws Exception {
		new JQueryTest().effects();

	}

	@Test
	private void position() throws Exception {
		new JQueryTest().position();

	}

	@Test
	public void widgetFactory() throws Exception {
		new JQueryTest().widgetFactory();

	}

	@AfterMethod
	private void quit() {
		DriverFactory.getDriver().quit();
	}

}
