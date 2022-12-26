package hundredjavaprogramming.Aroon;

/**
 * @Question Print Prime number program in java.
 * @author amaduraiveeran
 *
 */
public class PrimeNumber {
	public static void main(String[] args) {
		int a = 100;
		for(int e = 1; e<=a;e++) {
			for (int i = 2; i < Math.sqrt(e); i++) {  
		           if (e % i == 0) {
		        	   System.out.println(e);
		           }  
		       }  
		}
	}
}
