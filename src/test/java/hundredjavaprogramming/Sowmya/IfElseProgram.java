package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class IfElseProgram {

	public static void main(String[] args) {
	System.out.println("Enter the value");
	int a;
	Scanner sc = new Scanner(System.in);
	a = sc.nextInt();
	if(a<0)
	{
		System.out.println("The number is negative");
	}
	else
	{
		System.out.println("The number is positive");
	}
	}

}
