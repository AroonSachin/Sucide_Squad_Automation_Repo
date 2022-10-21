package javaprogrammingpractice.arunsachin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.thoughtworks.qdox.parser.ParseException;

public class Checkdate {
	public static void validateJavaDate(String strDate) throws java.text.ParseException {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yy");
		sdfrmt.setLenient(false);
		try {
			Date javaDate = sdfrmt.parse(strDate);
			System.out.println(strDate + " is valid date format");
		}
		catch (ParseException e) {
			System.out.println(strDate + " is Invalid Date format");
		}
	}
	public static void main(String[] args) throws java.text.ParseException {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the date : ");
		String date = scn.next();
		validateJavaDate(date);
	}
}
