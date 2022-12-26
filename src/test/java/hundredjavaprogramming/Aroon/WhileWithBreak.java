package hundredjavaprogramming.Aroon;


/**
 * @Question While loop using break.
 * @author amaduraiveeran
 *
 */
public class WhileWithBreak {
	
	public static void main(String[] args) {
		
		int a = 0;
		while(true) {
			System.out.println(a);
			if(a>50) {
				System.out.println("Restricted to print above 50!");
				break;
			}
			a++;
		}
		
		
		
	}

}
