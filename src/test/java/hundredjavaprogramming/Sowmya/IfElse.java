package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values");
		a = sc.nextInt();
		b = sc.nextInt();
		if(a>b)
		{
			System.out.println("a is greater");
		}
		else
		{
			System.out.println("b is greater");
		}

	}

}
