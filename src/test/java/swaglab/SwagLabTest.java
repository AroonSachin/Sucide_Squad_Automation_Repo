package swaglab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonActions;
import utils.ExcelReader;

/**
 * 
 * @author svenkateshwaran This is the test class
 *
 */

public class SwagLabTest extends CommonActions {
	private ExcelReader xlRead = null;
	private int xlRowCount = 0;

	@DataProvider(name = "automation")
	public Iterator<Object[]> getTestData() throws Exception {
		xlRead = new ExcelReader("bio.xlsx", "Test");
		xlRowCount = xlRead.getRowCount();
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		for (int i = 1; i < xlRowCount; i++) {
			data.add(new Object[] { xlRead.xlReader(i) });
		}
         System.out.println(data.toString());
		return data.iterator();
	}

	@Test(dataProvider = "automation")
	public void test1(Map<String, String> mapData) throws Exception

	{
		inputdata.set(mapData);
		if (CommonActions.getdata("S.no.").equals("1")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/");
			System.out.println(CommonActions.getdata("S.no."));
			System.out.println(CommonActions.getdata("FirstName"));
			System.out.println(CommonActions.getdata("LastName"));
			System.out.println(CommonActions.getdata("DateOfBirth"));
			System.out.println(CommonActions.getdata("Nationality"));
		} else {
			throw new SkipException("Skip test");
		}
	}

	@Test(dataProvider = "automation")
	public void test2(Map<String, String> mapData) throws Exception {

		inputdata.set(mapData);
		if (CommonActions.getdata("S.no.").equals("2")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.geeksforgeeks.org/html5-introduction/");
			System.out.println(CommonActions.getdata("S.no."));
			System.out.println(CommonActions.getdata("FirstName"));
			System.out.println(CommonActions.getdata("LastName"));
			System.out.println(CommonActions.getdata("DateOfBirth"));
			System.out.println(CommonActions.getdata("Nationality"));
		} else {
			throw new SkipException("Skip test");
		}

	}
}
