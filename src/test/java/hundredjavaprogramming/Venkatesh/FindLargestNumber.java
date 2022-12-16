package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

//Find Largest no in java Program

public class FindLargestNumber {
	public static void main(String[] args)   
	{  
	int a, b, c;  
	Scanner sc = new Scanner(System.in);   
	System.out.println("Enter the first number:");  
	a = sc.nextInt();  
	System.out.println("Enter the second number:");  
	b = sc.nextInt();  
	System.out.println("Enter the third number:");  
	c = sc.nextInt();    
	if ( a > b && a > c )
		 System.out.println("First number is largest");
		 else if ( b > a && b > c )
		 System.out.println("Second number is largest");
		 else if ( c > a && c > b )
		 System.out.println("Third number is largest");
		 else
		 System.out.println("Entered numbers are not distinct");
	}  

}
