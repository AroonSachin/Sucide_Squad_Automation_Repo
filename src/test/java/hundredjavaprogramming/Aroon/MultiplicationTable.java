package hundredjavaprogramming.Aroon;

import java.util.Scanner;

/**
 * @Question Print Multiplication Table.
 * @author amaduraiveeran
 *
 */
public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number to print its multiplication table");
		int val = scn.nextInt();
		for(int e =1;e<=10;e++) {
			System.out.println(e+" * "+val+" = "+ (e*val));
		}
	}
}
