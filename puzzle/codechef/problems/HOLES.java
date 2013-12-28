/*
 * Status  : ACCEPTED
 * Problem : http://www.codechef.com/problems/INTEST
 */

package codechef.problems;

import java.util.Scanner;

class HOLES {

	public static int retHoles(int ch)
	{
		if(ch=='B')
			return 2;
		else if(ch=='A' || ch=='D' || ch=='O' || ch=='P' || ch=='Q' || ch=='R')
			return 1;
		else 
			return 0;
	}
	
	public static int calculateHoles(String str)
	{
		int cnt = 0;
		for(char ch: str.toCharArray())
		{
			cnt += retHoles(ch);
		}
		return cnt;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
			System.out.println(calculateHoles(sc.next()));
		}
		sc.close();
	}
}