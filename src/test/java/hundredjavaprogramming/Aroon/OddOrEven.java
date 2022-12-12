package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class OddOrEven {
	
	
	public static void oddOrEven() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a number.");
		int num = scn.nextInt();
		
		if(num%2==0) {
			System.out.println("The entered number is a Even number.");
		}else {
			System.out.println("The entered number is a Odd number.");
		}
	}
	
	public static void main(String[] args) {
		oddOrEven();
	}

}
