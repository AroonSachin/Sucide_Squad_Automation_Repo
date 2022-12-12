package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

public class OddAndEvenNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your value");
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println("Entered Number is Even");
		}

		else {
			System.out.println("Entered Number is Odd");
		}
	}

}
