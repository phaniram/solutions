package com.codeforces.problems;
/*
		Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters. On the occasion of the city's anniversary, a decision was taken to pave the Square with square granite flagstones. Each flagstone is of the size a × a.
		
		What is the least number of flagstones needed to pave the Square? It's allowed to cover the surface larger than the Theatre Square, but the Square has to be covered. It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.
		
		Input
		The input contains three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 109).
		
		Output
		Write the needed number of flagstones.
		
		Sample test(s)
		Input
		6 6 4
		Output
		4
*/
import java.util.Scanner;

public class TheatreSquare {


	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a=sc.nextInt();
		int tmp = n;
		int cnt1=0;
		while(tmp>0)
		{
			tmp-=a;
			cnt1++;
		}
		tmp=m;
		int cnt2=0;
		while(tmp>0)
		{
			tmp-=a;
			cnt2++;
		}
		System.out.print((long)cnt1*cnt2);
	}

}
