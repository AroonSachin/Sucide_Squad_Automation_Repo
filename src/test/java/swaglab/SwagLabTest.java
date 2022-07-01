package swaglab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.SkipException;
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
		System.out.println(data1.hashmap());
		System.out.println(data1.hashmap().get("S.no."));
		if(data1.hashmap().get("S.no.").equals("1"))
		{
		System.out.println(data1.hashmap().get("S.no."));
		System.out.println(data1.hashmap().get("FirstName"));
		System.out.println(data1.hashmap().get("LastName"));
		System.out.println(data1.hashmap().get("DateOfBirth"));
		System.out.println(data1.hashmap().get("Nationality"));
		}
		else
		{
			throw new SkipException("Skip test");
		}
	}
	
	@Test(dataProvider="automation")
	public void test2(ExcelReader data2)
	{
		if(data2.hashmap().get("S.no.").equals("2"))
		{
		System.out.println(data2.hashmap().get("S.no."));
		System.out.println(data2.hashmap().get("FirstName"));
		System.out.println(data2.hashmap().get("LastName"));
		System.out.println(data2.hashmap().get("DateOfBirth"));
		System.out.println(data2.hashmap().get("Nationality"));	
	}
		else
		{
			throw new SkipException("Skip test");
		}

}
}
