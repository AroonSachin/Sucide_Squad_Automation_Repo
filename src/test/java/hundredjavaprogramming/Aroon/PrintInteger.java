package hundredjavaprogramming.Aroon;
/**
 * @Question Print integer in java.
 * @author aroon
 *
 */
public class PrintInteger {
	
	public static void printInt(int upto) {
		
		for(int i=0;i<=upto;i++) {
			System.out.println("-"+i);
		}
		System.out.println("Printed integers from 0 To "+upto);
	}
	public static void main(String[] args) {
		printInt(100);
	}

}
