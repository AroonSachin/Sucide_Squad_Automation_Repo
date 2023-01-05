package hundredjavaprogramming.Aroon;

/**
 * @question print star in console using loop.
 * @author aroon
 *
 */
public class printStar {
	static int starMidUPSpace = 21;
	public static void printStar() {
		int n = 10;
		for (int i = 0; i < n; i++) {
			for(int k=0;k<=20;k++) {
				System.out.print(" ");
			}
			for (int j = n-i ; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
		for(int a = 10;a<=n+10;a++) {
			
			for (int j = starMidUPSpace ; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= a; j++) {
                System.out.print("* ");
                
            }
            System.out.println();
            starMidUPSpace--;
		}
	}
	
	public static void main(String[] args) {
		printStar();
	}

}
