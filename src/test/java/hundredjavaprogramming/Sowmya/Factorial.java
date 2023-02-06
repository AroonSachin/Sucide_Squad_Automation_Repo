package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int i, fact=1;
		for(i=1;i<=number;i++)
		{
			fact = fact*i;
		}
		System.out.println("The factorial of the given number " + number + " is " + fact);

	}

}
