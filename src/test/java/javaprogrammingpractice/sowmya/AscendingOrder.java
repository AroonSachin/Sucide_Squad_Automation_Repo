package javaprogrammingpractice.sowmya;

public class AscendingOrder {

	public static void main(String[] args) {
		int a[]=new int[] {6,9,10,7,8};
		int temp=0;
		System.out.println("Enter the array of elements to be sorted");
		for (int element : a) {
			System.out.println(element + " ");

}
		for(int i=0; i<a.length; i++)
		{
			for(int j=i+1; j<a.length; j++)
			{
				if(a[i]<a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("The array of elements in ascending order");
		for (int element : a) {
			System.out.println(element + " ");
		}

	}

}
