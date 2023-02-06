package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @question How to compare 2 string.
 * @author aroon
 *
 */
public class Compare2String {
	
	public static void compare2String() {
		Scanner scn = new Scanner(System.in);
		System.out.println(" Enter first String ");
		String str1 = scn.next();
		System.out.println(" Enter second String");
		String str2 = scn.next();
		if(str1.compareToIgnoreCase(str2)>0) {
			System.out.println(" First string is greater than second string ");
		}else if(str1.compareToIgnoreCase(str2)<0){
			System.out.println("First string is lesser than the second string");
		}
	}
	
	public static void main(String[] args) {
		compare2String();
	}
}
