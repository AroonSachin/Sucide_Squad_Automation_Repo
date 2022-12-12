package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

public class LargestNumber {
	public static void main(String[] args) 
	{
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.print(" Please Enter the First Number : ");
		a = sc.nextInt();	
		System.out.print(" Please Enter the Second Number : ");
		b = sc.nextInt();	
		if(a > b) 
	    {
			System.out.println("\n The Largest Number = " + a);          
	    } 
	    else if (b > a)
	    { 
	    	System.out.println("\n The Largest Number = " + b);        
	    } 
	    else 
	    {
	    	System.out.println("\n Both are Equal");
	    }		
	}	

}
