package jqueryautomation.venkatesh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonuseractions.CommonActionMethods;
import utils.DriverFactory;

public class JQueryTest extends CommonActionMethods {

	@FindBy(id="draggable") 
	public  WebElement draggable;
	@FindBy(id="draggable")
	public  WebElement drag;
	@FindBy(id="droppable")
	public  WebElement droppable;
	@FindBy(xpath="//a[text()='Droppable']")
	public  WebElement drop;
	@FindBy(xpath="//a[text()='Resizable']")
	public  WebElement resize;
	@FindBy(xpath="//div[@id='resizable']//div[3]")
	public  WebElement resizable;
	@FindBy(xpath="//a[text()='Selectable']")
	public  WebElement select;
	@FindBy(xpath="//ol[@id='selectable']//li")
	List<WebElement> selectable;
	@FindBy(xpath="//a[text()='Sortable']")
	public  WebElement sort;
	@FindBy(xpath="//ul[@id='sortable']//li")
	List<WebElement> sortable;
	@FindBy(xpath="//a[text()='Accordion']")
	public  WebElement accord;
	@FindBy(id="ui-id-1")
	public  WebElement sec1;
	@FindBy(id="ui-id-3")
	public  WebElement sec2;
	@FindBy(id="ui-id-5")
	public  WebElement sec3;
	@FindBy(xpath="//a[text()='Autocomplete']")
	public  WebElement autocomplete;
	@FindBy(id="tags")
	public  WebElement tag;
	@FindBy(xpath="//ul[@id='ui-id-1']//li")
	List<WebElement> tagname;
	@FindBy(xpath="//a[text()='Button']")
	public  WebElement button;
	@FindBy(xpath="//button[@class='ui-button ui-corner-all ui-widget']")
	public  WebElement buttonelement;
	@FindBy(xpath="//input[@class='ui-button ui-widget ui-corner-all']")
	public  WebElement submitbutton;
	@FindBy(xpath="//a[text()='Checkboxradio']")
	public  WebElement checkboxradio;
	@FindBy(xpath="//label[@for='radio-1']")
	public  WebElement newyork;
	@FindBy(xpath="//label[@for='checkbox-1']")
	public  WebElement rating;
	@FindBy(xpath="//label[@for='checkbox-nested-1']")
	public  WebElement bedsize;
	@FindBy(xpath="//a[text()='Controlgroup']")
	public  WebElement controlgroup;
	@FindBy(xpath="//span[@id='car-type-button']//span[@class='ui-selectmenu-text']")
	public WebElement cartype;
	@FindBy(xpath="//ul[@id='car-type-menu']//li")
	List<WebElement> carlist;
	@FindBy(xpath="//label[@for='transmission-standard']")
	public  WebElement standard;
	@FindBy(xpath="//label[@for='insurance']")
	public WebElement insurance;
	@FindBy(id="horizontal-spinner")
	public WebElement noofcars;
	@FindBy(xpath="//button[@class='ui-widget ui-controlgroup-item ui-button ui-corner-right']")
	public WebElement booknow;
	@FindBy(xpath="//a[text()='Dialog']")
	public WebElement dialog;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement defaultfunction;
	@FindBy(xpath="//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	public WebElement closefunction;
	@FindBy(xpath="//a[text()='Animation']")
	public WebElement animation;
	@FindBy(id="opener")
	public WebElement opendialog;
	@FindBy(xpath="//span[@class='ui-button-icon ui-icon ui-icon-closethick']")
	public WebElement closeanimation;
	@FindBy(xpath="//a[text()='Modal confirmation']")
	public WebElement modal;
	@FindBy(xpath="//button[text()='Delete all items']")
	public WebElement delete;
	@FindBy(xpath="//a[text()='Modal form']")
	public WebElement modalform;
	@FindBy(id="create-user")
	public WebElement createuser;
	@FindBy(id="name")
	public WebElement username;
	@FindBy(id="email")
    public WebElement email;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath="//button[text()='Create an account']")
	public WebElement create;
	@FindBy(xpath="//a[text()='Modal message']")
	public WebElement modalmeassage;
	@FindBy(xpath="//button[text()='Ok']")
	public WebElement okmodal;
	@FindBy(xpath="//a[text()='Menu']")
	public WebElement menu;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement menudefault;
	@FindBy(xpath="//div[@id='ui-id-9']")
	public WebElement music;
	@FindBy(xpath="//div[@id='ui-id-10']")
	public WebElement rock;
	@FindBy(xpath="//li[@class='ui-menu-item']//div[@id='ui-id-12']")
	public WebElement classic;
	@FindBy(xpath="//a[text()='Progressbar']")
	public WebElement progressbar;
	@FindBy(xpath="//a[text()='Indeterminate Value']")
	public WebElement indeterminate;
	@FindBy(xpath="//button[@id='numButton']")
	public WebElement randomvalue;
	@FindBy(xpath="//button[text()='Indeterminate']")
	public WebElement indeter;
	@FindBy(xpath="//button[text()='Random Color']")
	public WebElement rondomcolor;
	@FindBy(xpath="//a[text()='Selectmenu']")
	public WebElement selectmenu;
	@FindBy(xpath="//a[text()='Product Selection']")
	public WebElement productselection;
	@FindBy(xpath="//label[text()='Circle radius']/following::span[@id='radius-button']")
	public WebElement size;
	@FindBy(xpath="//ul[@id='radius-menu']//li")
	List<WebElement> radius;
	@FindBy(id="color-button")
	public WebElement color;
	@FindBy(xpath="//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']//li")
	List<WebElement>colortype;
	@FindBy(xpath="//a[text()='Datepicker']")
	public WebElement datepicker;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement defaultfunctionality;
	@FindBy(xpath="//input[@class='hasDatepicker']")
	public WebElement datebox;
	@FindBy(xpath="//span[@class='ui-datepicker-month']")
	public WebElement month;
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextmonth;
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//td")
	List<WebElement> datepick;
	@FindBy(xpath="//a[text()='Slider']")
	public WebElement slider;
	@FindBy(xpath="//a[text()='Colorpicker']")
	public WebElement colorpicker;
	@FindBy(id="green")
	public WebElement green;
	@FindBy(xpath="//a[text()='Spinner']")
	public WebElement spinner;
	@FindBy(xpath="//a[text()='Currency']")
	public WebElement currency;
	@FindBy(id="spinner")
	public WebElement spinnerbox;
	@FindBy(id="currency")
	public WebElement dollar;
	@FindBy(xpath="//select[@id='currency']//option")
	List<WebElement> currencytype;
	@FindBy(xpath="//a[text()='Tabs']")
	public WebElement tabs;
	@FindBy(xpath="//a[text()='Collapse content']")
	public WebElement collapse;
	@FindBy(xpath="//a[text()='Proin dolor']")
	public WebElement dolor;
	@FindBy(xpath="//a[text()='Simple manipulation']")
	public WebElement simple;
	@FindBy(id="add_tab")
	public WebElement addtab;
	@FindBy(id="tab_title")
	public WebElement tabtitle;
	@FindBy(xpath="//button[text()='Add']")
	public WebElement add;
	@FindBy(xpath="//a[text()='Tooltip']")
	public WebElement tooltip;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement defaulttool;
	@FindBy(id="age")
	public WebElement agetool;
	@FindBy(xpath="//a[text()='Add Class']")
	public WebElement addclass;
	@FindBy(xpath="//a[text()='Effect demo']")
	public WebElement effectdemo;
	@FindBy(id="button")
	public WebElement effectbutton;
	@FindBy(xpath="//a[text()='addClass demo']")
	public WebElement addclassdemo;
	@FindBy(id="button")
	public WebElement addbutton;
	@FindBy(xpath="//a[text()='Animate demo']")
	public WebElement animatedemo;
	@FindBy(id="button")
	public WebElement animatebutton;
	@FindBy(xpath="//a[text()='Easing demo']")
	public WebElement easingdemo;
	@FindBy(xpath="//div[@class='graph'][1]")
	public WebElement lineargraph;
	@FindBy(xpath="//div[@class='graph'][2]")
	public WebElement swinggraph;
	@FindBy(xpath="//a[text()='Hide Demo']")
	public WebElement hidedemo;
	@FindBy(xpath="//select[@id='effectTypes']//option")
	List<WebElement> effecttype;
	@FindBy(id="button")
	public WebElement hidebutton;
	@FindBy(xpath="//a[text()='removeClass Demo']")
	public WebElement removeclassdemo;
	@FindBy(id="button")
	public WebElement removebutton;
	@FindBy(xpath="//a[text()='Show Demo']")
	public WebElement showdemo;
	@FindBy(xpath="//select[@id='effectTypes']//option")
	List<WebElement> showdemoeffect;
	@FindBy(id="button")
	public WebElement showbutton;
	@FindBy(xpath="//a[text()='switchClass Demo']")
	public WebElement switchclassdemo;
	@FindBy(id="button")
    public WebElement switchbutton;
	@FindBy(xpath="//a[text()='Toggle Demo']")
	public WebElement toggledemo;
	@FindBy(xpath="//select[@id='effectTypes']//option")
	List<WebElement> toggleeffect;
	@FindBy(id="button")
	public WebElement togglebutton;
	@FindBy(xpath="//a[text()='toggleClass Demo']")
	public WebElement toggleclassdemo;
	@FindBy(id="button")
	public WebElement toggleclassbutton;
	@FindBy(xpath="//a[text()='Position']")
	public WebElement position;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement positiondefault;
	@FindBy(xpath="//select[@id='my_horizontal']//option")
	List<WebElement> my;
	@FindBy(xpath="//select[@id='at_vertical']//option")
	List<WebElement> at;
	@FindBy(xpath="//select[@id='collision_horizontal']//option")
	List<WebElement> collision;
	@FindBy(xpath="//a[text()='Image Cycler']")
	public WebElement imagecycler;
	@FindBy(id="next")
	public WebElement imagenext;
	@FindBy(id="previous")
	public WebElement imageprevious;
	@FindBy(xpath="//a[text()='Widget Factory']")
	public WebElement widgetfactory;
	@FindBy(xpath="//a[text()='Default functionality']")
	public WebElement widgetdefault;
	@FindBy(xpath="//div[@id='my-widget1']//button[text()='change']")
	public WebElement widgetchange1;
	@FindBy(xpath="//div[@id='my-widget2']//button[text()='change']")
	public WebElement widgetchange2;
	@FindBy(id="green")
	public WebElement widgetgreen;
	
	public JQueryTest() {
		PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), 30), this);
	}
	public void dragDropBy() throws Exception {
		frameByIndex(0);
		webWait(draggable);
		Actions drag=new Actions(DriverFactory.getDriver());
		int x= draggable.getLocation().getX();
		int y=draggable.getLocation().getY();
		drag.dragAndDropBy(draggable, x+45,y+65).perform();
		defaultwindow();
	}
	public void droppable() throws Exception {
		clickMethod(drop, "droppable");
		frameByIndex(0);
		webWait(drag);
		Actions drop=new Actions(DriverFactory.getDriver());
		drop.dragAndDrop(drag,droppable ).perform();
		defaultwindow();
	}
	public void resize() throws Exception {
		clickMethod(resize, "resizable");
		frameByIndex(0);	
		Actions size=new Actions(DriverFactory.getDriver());
		webWait(resizable);
		//size.dragAndDropBy(resizable, 100,50).perform();
		size.clickAndHold(resizable).moveByOffset(100,60).release(resizable).perform();
		System.out.println("height&width:"+resizable.getSize());
		defaultwindow();
        
	}
	public void selectable() throws Exception {
		clickMethod(select, "selectable");
		frameByIndex(0);
		Actions select=new Actions(DriverFactory.getDriver());
		select.keyDown(Keys.CONTROL).click(selectable.get(0)).click(selectable.get(1)).perform();
		defaultwindow();
	}
	public void sortable() throws Exception {
		clickMethod(sort, "sortable");
		frameByIndex(0);
		WebElement from=sortable.get(5);
		WebElement to=sortable.get(0);
		Actions sort=new Actions(DriverFactory.getDriver());
		Thread.sleep(5000);
        sort.clickAndHold(from).moveToElement(to).release().perform();
        defaultwindow();
	}
	public void accordion() throws Exception {
		clickMethod(accord, "accordion");
		frameByIndex(0);
		clickMethod(sec1, "section1");
		clickMethod(sec2, "section2");
		clickMethod(sec3, "section3"); 
		defaultwindow();
	}
	public void autocomplete() throws Exception {
		clickMethod(autocomplete, "autocomplete");
		frameByIndex(0);
		sendKeysMethod(tag, "java");
		Actions auto=new Actions(DriverFactory.getDriver());
		auto.keyDown(Keys.CONTROL).click(tagname.get(0)).perform();
		defaultwindow();
	}
	public void button() throws Exception {
		clickMethod(button, "button");
		frameByIndex(0);
		clickMethod(buttonelement, "buttonelement");
		clickMethod(submitbutton, "submitbutton");
		defaultwindow();
	}
	
	public void checkBoxRadio() throws Exception {
       clickMethod(checkboxradio, "Checkboxradio");
       frameByIndex(0);
       clickMethod(newyork, "newyork");
       clickMethod(rating, "Rating");
       clickMethod(bedsize, "size");
       defaultwindow();
	}
	
	public void controlgroup() throws Exception {
		clickMethod(controlgroup, "control");
		frameByIndex(0);
		webWait(cartype);
		clickMethod(cartype, "cartype");
		listDrop(carlist, "SUV");
		clickMethod(standard, "standardtype");
        clickMethod(insurance, "insurance");
        sendKeysMethod(noofcars,"2");
        clickMethod(booknow, "booknow");
        defaultwindow();
	}
	public void dialog() throws Exception {
		clickMethod(dialog, "dialog");		
		clickMethod(defaultfunction, "defaultfunction");
		frameByIndex(0);
		clickMethod(closefunction, "closefunction");
		defaultwindow();
		clickMethod(animation, "animation");
		frameByIndex(0);
		clickMethod(opendialog, "open");
		clickMethod(closeanimation, "closeanimation");
		defaultwindow();
		clickMethod(modal, "modalconformation");
		frameByIndex(0);
		webWait(delete);
		clickMethod(delete, "deleteall");
		defaultwindow();
		clickMethod(modalform,"modalform");
		frameByIndex(0);
		clickMethod(createuser, "createuser");
		sendKeysMethod(username,"venkatesh");
		sendKeysMethod(email, "venkat@baskar.com");
		sendKeysMethod(password, "1234567");
		clickMethod(create, "create account");
		defaultwindow();
		clickMethod(modalmeassage, "modalmessage");
		frameByIndex(0);
		clickMethod(okmodal, "okmodalmessage");
		defaultwindow();    
	}
	public void menu() throws Exception {
		clickMethod(menu, "Menu");
		clickMethod(menudefault, "Default function");
		frameByIndex(0);
		clickMethod(music, "music");
		clickMethod(rock, "Rock");
		defaultwindow();
	}
	public void progressbar() throws Exception {
		clickMethod(progressbar, "progressbar");
		clickMethod(indeterminate, "indeterminate value");
		frameByIndex(0);
		webWait(randomvalue);
		clickMethod(randomvalue, "randomvalue");
		clickMethod(indeter, "indeterminate");
		clickMethod(rondomcolor, "Randomcolor");
		defaultwindow();

	}
	public  void selectMenu() throws Exception {
		clickMethod(selectmenu, "selectmenu");
		clickMethod(productselection, "product selection");
		frameByIndex(0);
		webWait(size);
		size.click();
		listDrop(radius, "200px");
		clickMethod(color, "color");
		listDrop(colortype, "Black");
		defaultwindow();

	}
	public void datepicker() throws Exception {
		clickMethod(datepicker, "datepicker");
		clickMethod(defaultfunctionality, "default");
		frameByIndex(0);
		clickMethod(datebox, "datebox");
		System.out.println(currentdate(5));
		String[]date = splitString(currentdate(5), "/");
		System.out.println(month.getText());
		String text=getTextElement(month, "month");
		while (true) {		
			if(text.equalsIgnoreCase(date[0])) {
			    Thread.sleep(3000);
				listDrop(datepick, date[1]);
				break;
			}else {
				webWait(nextmonth);
				clickMethod(nextmonth, "nextmonth");
			}	
		}
		defaultwindow();

	}
	public String currentdate(int plusdays) {		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,+plusdays);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern("MMMMMMMMMM/d");
		String dat = date.format(cal.getTime());
		return dat;
	}
	public void slider() throws Exception {
		clickMethod(slider, "slider");
		clickMethod(colorpicker, "colorpicker");
		frameByIndex(0);
		Actions greenslider=new Actions(DriverFactory.getDriver());
		Thread.sleep(3000);
		greenslider.dragAndDropBy(green, -100, 0).perform();
		System.out.println("height&width:"+green.getSize());
		defaultwindow();
	}
	public void spinner() throws Exception {
		clickMethod(spinner, "spinner");
		clickMethod(currency, "currency");
		frameByIndex(0);
		sendKeysMethod(spinnerbox, "$58");
		clickMethod(dollar, "dollar");
		Thread.sleep(3000);
		listDrop(currencytype, "EUR €");
		defaultwindow();
	}
	public void tabs() throws Exception {
		clickMethod(tabs, "tabs");
		clickMethod(collapse, "collapse");
		frameByIndex(0);
		clickMethod(dolor, "dolor");
		defaultwindow();
		clickMethod(simple, "simple");
		frameByIndex(0);
		clickMethod(addtab, "addtab");
		sendKeysMethod(tabtitle, "jqueryui");
		clickMethod(add, "tabadded");
		defaultwindow();
	}
	public void toolTip() throws Exception {
		clickMethod(tooltip, "tooltip");
		clickMethod(defaulttool, "defaulttool");
		frameByIndex(0);
		String tooltiptext=agetool.getAttribute("title");
		System.out.println("tooltil text is :"+tooltiptext);	

	}
	public void effects() throws Exception {
		clickMethod(addclass, "addclass");
		clickMethod(effectdemo, "effectdemo");
		frameByIndex(0);
		clickMethod(effectbutton, "effectbutton");
		defaultwindow();
		clickMethod(addclassdemo, "addclassdemo");
		frameByIndex(0);
		clickMethod(addbutton, "addbutton");
		defaultwindow();
		clickMethod(animatedemo, "animatedemo");
		frameByIndex(0);
		clickMethod(animatebutton, "animatebutton");
		defaultwindow();
		clickMethod(easingdemo, "easingdemo");
		frameByIndex(0);
		clickMethod(lineargraph, "lineargraph");
		clickMethod(swinggraph, "swinggraph");
		defaultwindow();
		clickMethod(hidedemo, "hidedemo");
		frameByIndex(0);
		listDrop(effecttype, "Explode");
		clickMethod(hidebutton, "hidebutton");
		defaultwindow();
		clickMethod(removeclassdemo, "removeclassdemo");
		frameByIndex(0);
		clickMethod(removebutton, "removebutton");
		defaultwindow();
		clickMethod(showdemo, "showdemo");
		frameByIndex(0);
		listDrop(showdemoeffect, "Bounce");
		clickMethod(showbutton, "showbutton");
		defaultwindow();
		clickMethod(switchclassdemo, "switchclassdemo");
		frameByIndex(0);
		clickMethod(switchbutton, "switchbutton");
		Thread.sleep(3000);
		clickMethod(switchbutton, "switch");
		defaultwindow();
		clickMethod(toggledemo, "toggledemo");
		frameByIndex(0);
		listDrop(toggleeffect, "Pulsate");
		clickMethod(togglebutton, "togglebutton");
		defaultwindow();
		clickMethod(toggleclassdemo, "toggleclassdemo");
		frameByIndex(0);
		clickMethod(toggleclassbutton, "toggleclassbutton");
		clickMethod(toggleclassbutton, "toggleclass");
		defaultwindow();		
	}
	public void position() throws Exception {
		clickMethod(position, "position");
		clickMethod(positiondefault, "positiondefault");
		frameByIndex(0);
		listDrop(my, "center");
		listDrop(at, "top");
		listDrop(collision, "flipfit");
		defaultwindow();
		clickMethod(imagecycler, "imagecycler");
		frameByIndex(0);
		clickMethod(imagenext, "imagenext");
		webWait(imageprevious);
		clickMethod(imageprevious, "imagepervious");
		defaultwindow();
	}
	public void widgetFactory() throws Exception {
		clickMethod(widgetfactory, "widfactory");
		clickMethod(widgetdefault, "widgetdefault");
		frameByIndex(0);
		clickMethod(widgetchange1, "color1");
		System.out.println("color name:"+widgetchange1.getText());
		clickMethod(widgetchange2, "color2");
		System.out.println("color name:"+widgetchange2.getText());
		clickMethod(widgetgreen, "gogreen");
		defaultwindow();

	}

}
