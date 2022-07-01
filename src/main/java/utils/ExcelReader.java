package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader
{
private static Map<String, String> dataMap = new HashMap<String, String>();

public ExcelReader(String Excelpath, String sheetname, int rowNum) throws IOException {

	dataMap.clear();
	try {
		FileInputStream fs = new FileInputStream(new File(Excelpath));
		XSSFWorkbook workbook = new XSSFWorkbook(fs);                  //Read the excel work book
		XSSFSheet sheet = workbook.getSheet(sheetname);                //read the excel sheet based on sheet name
		String title = "";
		String value = "";
		

		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			title = sheet.getRow(0).getCell(j).getStringCellValue();    //fetches the header name from the sheet
			value = sheet.getRow(rowNum).getCell(j).getStringCellValue(); //fetches the value of the header from the sheet
			dataMap.put(title, value);                                    //Stores the header name and the value in the map
		    
		}
		System.out.println(dataMap);
	} catch (Exception e) {
		System.err.println("Error during reading input file");
		throw new Error(e.getStackTrace().toString());
	}
}

public static int getRowCount(String Excelpath, String sheetname) throws IOException
{
	FileInputStream fs = new FileInputStream(new File(Excelpath));
	XSSFWorkbook workbook = new XSSFWorkbook(fs);                  //Read the excel work book
	XSSFSheet sheet = workbook.getSheet(sheetname);
	return sheet.getLastRowNum()+1;
}

public static Map<String, String> hashmap() {
	return dataMap;
}
}
	

