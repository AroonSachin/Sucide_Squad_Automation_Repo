package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 *
 * @author svenkateshwaran This class is used to read the excel data
 *
 */
public class ExcelReader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	public ExcelReader(String excelname, String sheetName) throws Exception {
		workbook = new XSSFWorkbook(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname)));
		sheet = workbook.getSheet(sheetName);
	}

	public Map<String, String> xlReader(int rowNum) throws IOException {
		Map<String, String> dataMap = new HashMap<String, String>();
		try {
			String title = "";
			String value = "";
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				title = sheet.getRow(0).getCell(j).getStringCellValue();
				value = sheet.getRow(rowNum).getCell(j).getStringCellValue();
				dataMap.put(title, value);
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new Error(e.getStackTrace().toString());
		}
		
		return dataMap;
	}

	public int getRowCount() {
		int rows = sheet.getLastRowNum() + 1;
		return rows;
	}

}
