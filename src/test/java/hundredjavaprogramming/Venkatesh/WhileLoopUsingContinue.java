package hundredjavaprogramming.Venkatesh;

//While loop using break and continue Program in java

public class WhileLoopUsingContinue {

	public static void main(String[] args) {
		first:
			for (int i = 1; i < 5; i++) {
		second: 
			for (int j = 1; j < 3; j++) {
				System.out.println("i = " + i + "; j = " + j);
				if (i == 2) {
					continue;

				} else {
					break first;

				}
			}
		}
	}
}
