package javaprogrammingpractice.venkat;

public class SumValuesArray {

	public static void main(String[] args) {

		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		int sum=0;
		int length=arr.length;
		for (int i = 0; i < length; i++) {
			sum = sum + arr[i];
		}

		System.out.println("sum values of a array" + sum);

	}
}
