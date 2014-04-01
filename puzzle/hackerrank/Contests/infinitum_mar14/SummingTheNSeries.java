/*
 * Summing the N series
 * Status  : Solved
 * Problem : https://www.hackerrank.com/contests/infinitum-mar14/challenges/summing-the-n-series
 */

package hackerrank.Contests.infinitum_mar14;

import java.math.BigInteger;
import java.util.Scanner;

public class SummingTheNSeries {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
			long n = sc.nextLong();
			if(n<=1000000007) System.out.println((n*n)%1000000007);
			else System.out.println(BigInteger.valueOf(n%1000000007).multiply(BigInteger.valueOf(n)).mod(BigInteger.valueOf(1000000007)));
		}
		sc.close();
	}
}
