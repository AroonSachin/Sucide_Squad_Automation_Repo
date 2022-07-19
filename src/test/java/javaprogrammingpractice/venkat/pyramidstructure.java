package javaprogrammingpractice.venkat;

public class pyramidstructure {

	public static void main(String[] args) {

		int n = 5;
		for (int i = n; i <= 10; i++) {
			for (int j = 10; j >= i; j--)
				System.out.print(" ");
			for (int k = 1; k <= i; k++)
				System.out.print(i + " ");
			System.out.println();
		}

	}

}
