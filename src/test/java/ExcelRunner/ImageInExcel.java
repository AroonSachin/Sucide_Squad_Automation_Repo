package ExcelRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImageInExcel {
	

	public static void excelReader() throws IOException {
		System.out.println(System.getProperty("user.dir") );
		XSSFWorkbook wb = new XSSFWorkbook(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\excelsheet\\InsertImage.xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");
		System.out.println("Located sheet");
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") +"\\Snaps\\1664778082100.png");
		System.out.println(" set inputstream successfull");
		byte[] bytes = IOUtils.toByteArray(inputStream);
		System.out.println(" Converted input stream to bytes");
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		System.out.println(" Added image to workbook");
		XSSFDrawing drawing = sheet.createDrawingPatriarch();
		System.out.println(" Created drawing Patrich");
		XSSFClientAnchor imageAnchor = new XSSFClientAnchor();
		
		imageAnchor.setCol1(2);
		imageAnchor.setCol2(3);
		imageAnchor.setRow1(1);
		imageAnchor.setRow2(2);
		System.out.println(" anchor setup finished ");
		drawing.createPicture(imageAnchor, pictureIdx);
		System.out.println(" Created picture");
		for (int i = 0; i < 3; i++) {
			sheet.autoSizeColumn(i);
		}
		System.out.println("resized");
		try {
			File file = new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/InsertExcel.xlsx");
			GZIPOutputStream gz = new GZIPOutputStream(new FileOutputStream(file));
			wb.write(gz);
			gz.flush();
			gz.close();
			wb.close();
			System.out.println("Saved");
		} catch (Exception e) {
			System.err.println(" Error in saving excel "+e);
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		excelReader();
	}
	
}
