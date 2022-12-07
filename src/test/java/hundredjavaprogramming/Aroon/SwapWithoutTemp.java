package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class SwapWithoutTemp {
	
	public static void NoTempSwap() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the First number:");
		int num1 = scn.nextInt();
		System.out.println("Please enter the second number:");
		int num2 = scn.nextInt();
		System.out.println("The first number is: "+num1+", The second number is: "+num2);
		num1 = num2 + num1;
		num2 = num1-num2;
		num1= num1 - num2;
		System.out.println("The first number is: "+num1+", The second number is: "+num2);
	}
	
	public static void main(String[] args) {
		NoTempSwap();
	}

}
