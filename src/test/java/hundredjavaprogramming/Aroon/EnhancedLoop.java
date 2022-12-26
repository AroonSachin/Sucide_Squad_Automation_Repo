package hundredjavaprogramming.Aroon;

/**
 * @Question Enhanced loop in java.
 * @author amaduraiveeran
 *
 */
public class EnhancedLoop {
	public static void main(String[] args) {
		int numArr[] = { 1, 2, 3, 4, 5 };
		int c = 0;
		for (int i : numArr) {
			System.out.print(i);
			c++;
			if (c < numArr.length) {
				System.out.print("-");
			}
		}
	}
}
