/*
 * ATM
 * Status  : ACCEPTED
 * Problem : http://www.codechef.com/problems/HS08TEST
 */

package codechef.problems;

import java.util.Scanner;

public class HS08TEST {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		double y=sc.nextDouble();
		if(x%5!=0)
		{
			System.out.format("%.2f",y);
		}else if(y-(0.50+x)<0)
		{
			System.out.format("%.2f",y);
		}
		else
		{
			System.out.format("%.2f",(double)(y-(0.50+x)));
		}
		sc.close();
	}
} 