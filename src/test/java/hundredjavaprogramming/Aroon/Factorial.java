package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class Factorial {
	
	public static void factorial(){
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the number for factorial.");
		int num = scn.nextInt();
		int fac = 1;
		for(int i=1;i<=num;i++) {
			fac *=i;
		}
		System.out.println("The factorial of "+num+" is "+fac);
	}

	public static void main(String[] args) {

		factorial();
		
	}

}
