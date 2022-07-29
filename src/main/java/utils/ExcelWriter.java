package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	
	
	public static void xlWriter(int rowNum, int cellNum, String excelname, String header, String sheetName, String value) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname)));
		XSSFSheet sheet = workbook.getSheet(sheetName);
		 
		 for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				String title = sheet.getRow(0).getCell(j).getStringCellValue();

			 if(title.equalsIgnoreCase(header)) //to find the index value of the header to match the header
			 {
				Row row = sheet.getRow(j);
				Cell cell = row.createCell(cellNum);
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



