/*
 * Chef and Feedback
 * Status  : Accepted
 * Problem : http://www.codechef.com/JAN14/problems/ERROR
 */

package codechef.JAN14;

import java.util.Scanner;

class ERROR {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		StringBuilder sb;
		while(T-->0)
		{
			sb = new StringBuilder(sc.next());
			if(sb.indexOf("010")!=-1 || sb.indexOf("101")!=-1)
			{
				System.out.println("Good");
			}else
			{
				System.out.println("Bad");				
			}
		}
		sc.close();
	}
}