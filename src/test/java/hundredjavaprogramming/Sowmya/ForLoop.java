package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		System.out.println("Enter the value of n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1; i<=n; i++)
		{
			System.out.println(i);
		}

	}

}
