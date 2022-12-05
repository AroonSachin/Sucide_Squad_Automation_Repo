package hundredjavaprogramming.Aroon;

import java.util.Scanner;

public class FahrenheitToCelsiusConvertor {

	public static void main(String[] args) {
		System.out.println("Please enter the temprature in Fahrenhiet to convert it to Celsius");
		Scanner scn = new Scanner(System.in);
		float fahren = scn.nextFloat();
		float celsi = (((fahren-32)*5)/9);
		
		System.out.println("The temprature converted fromm Celsius to Fharenhiet is: "+celsi);
		
	}

}
