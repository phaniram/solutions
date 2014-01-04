/*
 * Status  : ACCEPTED
 * Problem : http://www.codechef.com/problems/INTEST
 */

package codechef.problems;

import java.util.Scanner;

class INTEST {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		while(n-->0)
		{
			int t = sc.nextInt();
			if(t>=k)
			{
				if(t%k == 0)
				{
					count++;
				}				
			}
		}
		System.out.print(count);
		sc.close();
	}
}
