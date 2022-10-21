package javaprogrammingpractice.venkat;

public class cyclicallyrotatearray {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		int length = arr.length;
		int nooftimes = 1;
		for (int j = 0; j < nooftimes; j++) {
			int temp = arr[arr.length-1];
			for (int i=arr. length -1;i >0 ; i--) {
			arr[i]=arr[i - 1];
			}
			arr[0] = temp;
		}
		for (int element : arr) {
			System.out.println(element + "");
		}
	}

}
