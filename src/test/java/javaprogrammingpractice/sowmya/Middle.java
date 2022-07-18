package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class Middle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String S = sc.nextLine();
		String S1 = MiddleValue.getMiddleChars(S);
		System.out.println(S1);
	}

}

class MiddleValue {
	public static String getMiddleChars(String str) {
		int index, length;
		int l = str.length();
		if (l % 2 == 0) {
			index = l / 2 - 1;
			length = 2;
		} else {
			index = l / 2;
			length = 1;
		}
		return str.substring(index, index + length);
	}
}
