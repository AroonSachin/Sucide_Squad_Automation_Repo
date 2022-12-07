package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class SwapUsingTemp {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the First number:");
		int num1 = scn.nextInt();
		System.out.println("Please enter the second number:");
		int num2 = scn.nextInt();
		System.out.println("The first number is: "+num1+", The second number is: "+num2);
		int temp = num1;
		System.out.println(" Swaping.....");
		num1 = num2;
		num2 = temp;
		System.out.println("The first number is: "+num1+", The second number is: "+num2);
		
	}

}
