package javaprogrammingpractice;

import java.util.Scanner;

public class Decimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the value");
		double s = sc.nextDouble();
		System.out.println("The number of decimal in the given number is: ");
        System.out.println(countDecimalPlaces(s));
	}
    

    public static int countDecimalPlaces(double s) {
        
        final String st = Double.toString(s);
        System.out.println(st);
        final int index = st.indexOf('.');
        return st.length()-1 -index;
    }
				
		

	}


