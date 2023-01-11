package hundredjavaprogramming.Venkatesh;

//Find factorial for given no Program in Java

import java.util.Scanner;

public class Factorial {
	public static void main(String []args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the number: ");
       int num=sc.nextInt();
       int fact=1;
       for(int i=1;i<=num;i++)
       {
           fact=fact*i;
       }
       System.out.println("Factorial of the number: "+fact); 
    }  

}
