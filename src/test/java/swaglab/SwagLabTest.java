package swaglab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelReader;

public class SwagLabTest {
	
    @DataProvider(name="automation")
	public static Iterator<Object[]> dataFetcher() throws IOException
	{
	ArrayList<Object[]> data = new ArrayList<Object[]>();
    int count = ExcelReader.getRowCount(System.getProperty("user.dir")+"/src/main/java/resources/excelsheet/bio.xlsx", "Test");
    for (int i = 1; i <count ; i++) {
		data.add(new Object[] { new ExcelReader(System.getProperty("user.dir")+"/src/main/java/resources/excelsheet/bio.xlsx", "Test", i) });
	    
	}

	return data.iterator();
	}
	
	@Test(dataProvider="automation")
	public void test1(ExcelReader data1) throws IOException
	{
		System.out.println(data1.hashmap().get("S.no."));
		System.out.println(data1.hashmap().get("FirstName"));
		System.out.println(data1.hashmap().get("LastName"));
		System.out.println(data1.hashmap().get("DateOfBirth"));
		System.out.println(data1.hashmap().get("Nationality"));
	}

}
