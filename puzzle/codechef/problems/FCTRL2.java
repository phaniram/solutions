/*
 * Small factorials
 * Status  : ACCEPTED
 * Problem : http://www.codechef.com/problems/FCTRL2
 */

package codechef.problems;

import java.math.BigInteger;
import java.util.Scanner;

class FCTRL2 {
	private static BigInteger factorial(int num)
	{
		if(num==1)
		{
			return BigInteger.ONE;
		}		
		return BigInteger.valueOf(num).multiply(factorial(num-1));
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			System.out.println(factorial(sc.nextInt()));
		}
		sc.close();
	}
}