package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import commonuseractions.CommonActionMethods;

/**
 *
 *
 * @author svenkateshwaran
 * @this class is used to read the excel data
 *
 */
public class ExcelReader {
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;

	public ExcelReader(String excelname, String sheetName) throws Exception {
		workbook = new XSSFWorkbook(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname)));
		sheet = workbook.getSheet(sheetName);
	}

	public Map<String, String> xlReader(int rowNum) throws IOException {
		Map<String, String> dataMap = new HashMap<>();
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

	/**
	 * @this method is used to write the data in excel
	 * @param excelname
	 * @param sheetName
	 * @param value
	 * @throws Exception
	 */

	public static synchronized void xlWriteStatus(String excelname, String sheetName, String value) throws Exception
	{


		Map<String,Integer> header = new HashMap<>();
		for(int h = 0; h < sheet.getRow(0).getLastCellNum(); h++) {
			header.put(sheet.getRow(0).getCell(h).getStringCellValue(), h);
		}
		System.out.println(header);

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
				 if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(CommonActionMethods.getdata("Number"))) {
					 Row row = sheet.getRow(i);
					 Cell cell = row.createCell(header.get("Status"));
					 cell.setCellValue(value);
					 break;
				 }
		}

		 FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname);
		 try {
			workbook.write(fos);
		} catch (Exception e) {

			e.printStackTrace();
		}
		 fos.close();
	}

}
