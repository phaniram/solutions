/*
 * Factorial
 * Status  : ACCEPTED
 * Problem : http://www.codechef.com/problems/FCTRL
 */

package codechef.problems;

import java.util.Scanner;

class FCTRL {
	private void Z(long num)
	{
		long count=0;
		double term=0;
		int i=0;
		while((term=num/Math.pow(5, ++i))>=1)
		{
			count+=term;
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		FCTRL fc=new FCTRL();
		Scanner sc=new Scanner(System.in);
		long test_cases=sc.nextInt();
		while(test_cases-->0)
		{
			long input=sc.nextLong();
				fc.Z(input);

		}
	}

}