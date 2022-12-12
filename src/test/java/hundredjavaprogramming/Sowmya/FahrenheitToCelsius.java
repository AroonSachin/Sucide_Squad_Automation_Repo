package hundredjavaprogramming.Sowmya;
import java.util.Scanner;

public class FahrenheitToCelsius {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value in Fahrenheit");
		float f = sc.nextFloat();
		float c = (((f-32)*5)/9);
		System.out.println("The value in celsius is: " + c);

	}

}
