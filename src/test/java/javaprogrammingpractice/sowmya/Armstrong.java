package javaprogrammingpractice.sowmya;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		int n, a, sum = 0;
        System.out.print("Armstrong numbers from 1 to 600:");
        for(int i = 1; i <= 600; i++)
        {
            n = i;
            while(n > 0)
            {
                a = n%10;
                sum = sum + (a * a * a);
                n = n/10;
            }
            if(sum == i)
            {
                System.out.print(i+" ");
            }
            sum = 0;
        }
    }
}

	
		
		






//int i=1,a,arm,n,temp;
//System.out.println("Armstrong numbers between 1 to 500 are");
//while(i<500)
//{
//n=i;
//arm=0;
//while(n>0)
//{
//	a=n%10;
//	arm=arm+(a*a*a);
//	n=n/10;
//}
//if(arm==i)
//	System.out.println(i);
//i++;
//}
//}
//}

