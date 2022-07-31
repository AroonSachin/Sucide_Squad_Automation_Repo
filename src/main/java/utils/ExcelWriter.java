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

import commonuseractions.CommonActionMethods;

public class ExcelWriter {
	
	public static void xlWriteStatus(String excelname, String sheetName, String value) throws Exception
	{
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname)));
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		Map<String,Integer> header = new HashMap<String,Integer>();
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



