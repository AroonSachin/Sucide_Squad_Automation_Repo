package hundredjavaprogramming.Venkatesh;

import java.util.Scanner;

public class FahrenheitToCelsius {
	//T=(F -32  ) ×  5)/9
	 public static void main(String[] args) {
	 float temp;
	 Scanner sc = new Scanner(System.in); 
	 System.out.println("Enter the temperature value- ");
	 temp=sc.nextFloat();
	 temp = ((temp - 32)*5)/9;
	 System.out.println("Temperatue in Celsius = " + temp);
}
}
