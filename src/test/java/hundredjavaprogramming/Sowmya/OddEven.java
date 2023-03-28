package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		System.out.println("Enter the number");
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		if(n%2==0)
		{
			System.out.println("This is an even number");
		}
		else
		{
			System.out.println("This is odd number");
		}
		

	}

}
