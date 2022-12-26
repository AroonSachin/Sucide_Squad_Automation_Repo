package hundredjavaprogramming.Aroon;

/**
 * @Question While loop using break and continue program in java.
 * @author amaduraiveeran
 *
 */
public class WhileWithBreakAndContinueProgram {
	
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
		
		System.out.println(" The final value is :"+(a));
	}

}
