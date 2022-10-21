package javaprogrammingpractice.venkat;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//How to validate an email address format?

public class EmailAddressFormat {

	public static void main(String[] args) {

		String regex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Scanner len = new Scanner(System.in);
		System.out.println("enter the mail id ");
		String email = len.next();
		Matcher matcher = pattern.matcher(email);
		System.out.println(email + " : " + matcher.matches() );

	}

}
