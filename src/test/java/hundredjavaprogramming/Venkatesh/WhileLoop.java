package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

//While loop Program in java

public class WhileLoop {
	public static void main(String args[]){
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the value ");
		int number = sc.nextInt(); 
        while(number>1){
             System.out.println(number);
             number--;
        }
   }

}
