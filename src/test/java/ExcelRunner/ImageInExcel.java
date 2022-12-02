package ExcelRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImageInExcel {
	static XSSFWorkbook wb = null;
	static XSSFSheet sheet = null;

	public static void setExcel(String excelName, String sheetName) throws IOException {
		wb = new XSSFWorkbook(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\excelsheet\\" + excelName + ".xlsx");
		sheet = wb.getSheet(sheetName);
	}

	public static void insertPicture(int columnNum, int rowNum, String imageName) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Located sheet");
		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\Snaps\\" + imageName + ".png");
		System.out.println(" set inputstream successfull");
		byte[] bytes = IOUtils.toByteArray(inputStream);
		System.out.println(" Converted input stream to bytes");
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		System.out.println(" Added image to workbook");
		XSSFDrawing drawing = sheet.createDrawingPatriarch();
		System.out.println(" Created drawing Patrich");
		XSSFClientAnchor imageAnchor = new XSSFClientAnchor();
		imageAnchor.setCol1(columnNum - 1);
		imageAnchor.setCol2(columnNum);
		imageAnchor.setRow1(rowNum - 1);
		imageAnchor.setRow2(rowNum);
		System.out.println(" anchor setup finished ");
		drawing.createPicture(imageAnchor, pictureIdx);
		System.out.println(" Created picture");
		try {
			GZIPOutputStream gz = new GZIPOutputStream(new FileOutputStream(
					new File(System.getProperty("user.dir") + "/src/main/java/resources/excelsheet/InsertExcel.xlsx")));
			wb.write(gz);
			gz.flush();
			gz.close();

			System.out.println("Saved");
		} catch (Exception e) {
			System.err.println(" Error in saving excel " + e);
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		setExcel("InsertImage", "Sheet1");
		File directory = new File(System.getProperty("user.dir") + "\\Snaps");

		String[] cont = directory.list();

		for (int i = 0; i < cont.length; i++) {
			System.out.println(cont[i].replace(".png", ""));
			insertPicture(2, i + 2, cont[i].replace(".png", ""));
		}

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			row.setHeight((short) 1500);

		}
		sheet.setDefaultColumnWidth(100);

		wb.close();
	}

}
