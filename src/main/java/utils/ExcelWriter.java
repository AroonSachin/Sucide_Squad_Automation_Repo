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
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	public ExcelWriter(String excelname, String sheetName) throws Exception {
		workbook = new XSSFWorkbook(new FileInputStream(
				new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + excelname)));
		sheet = workbook.getSheet(sheetName);
	}
	
	
	public void xlWriter() throws IOException
	{
		 Row row = sheet.createRow(1);
		 Cell cell = row.createCell(1);
		 //Now we need to find out the type of the value we want to enter.
		                 //If it is a string, we need to set the cell type as string
		                 //if it is numeric, we need to set the cell type as number
		
		 cell.setCellValue("SoftwareTestingMaterial.com");
		 FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/" + "writeexcel.xlsx");
		 try {
			workbook.write(fos);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 fos.close();
	}

//	public Map<String, String> xlReader(int rowNum) throws IOException {
//		Map<String, String> dataMap = new HashMap<String, String>();
//		try {
//			String title = "";
//			String value = "";
//			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
//				title = sheet.getRow(0).getCell(j).getStringCellValue();
//				value = sheet.getRow(rowNum).getCell(j).getStringCellValue();
//				dataMap.put(title, value);
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			throw new Error(e.getStackTrace().toString());
//		}
//
//		return dataMap;

	}

