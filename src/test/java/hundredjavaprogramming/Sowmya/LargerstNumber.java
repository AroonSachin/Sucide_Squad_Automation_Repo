package hundredjavaprogramming.Sowmya;

import java.util.Scanner;

public class LargerstNumber {

	public static void main(String[] args) {
		System.out.println("Enter the total number of values");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = 0;
		int a[]=new int [n];
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter the number for index " + i);
			a[i] = sc.nextInt();
		}
			for (int i = 0; i < a.length; i++) {     
	            for (int j = i+1; j < a.length; j++) {     
	               if(a[i] > a[j]) {    
	                   temp = a[i];    
	                   a[i] = a[j];    
	                   a[j] = temp;    
	               }     
	            }     
	        }
		
System.out.println("The largest number is: " + a[a.length-1]);
	}

}
