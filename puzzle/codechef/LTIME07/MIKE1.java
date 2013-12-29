/*
 * Mike and Matrices
 * Status  : MIKE1
 * Problem : http://www.codechef.com/LTIME07/problems/MIKE1
 */

package codechef.LTIME07;

import java.util.Scanner;

class MIKE1 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		for(int p=1;p<=N;p++)
		{
			for(int q=1;q<=M;q++)
			{
				int el = sc.nextInt();
				arr[p][q] = el;
			}
		}
		int L = sc.nextInt();
		int cnt_E1 = 0;
		int cnt_E2 = 0;
		while(L-->0)
		{
			int iK = sc.nextInt();
			int jK = sc.nextInt();
			if(iK<=N && jK<=M && cnt_E1!=-1)
			{
				cnt_E1 += arr[iK][jK];
				
			}else
			{
				cnt_E1 = -1;
			}
			if(jK<=N && iK<=M && cnt_E2!=-1)
			{
				cnt_E2 += arr[jK][iK];
			}else
			{
				cnt_E2 = -1;
			}
		}
		
		System.out.println(Math.max(cnt_E1, cnt_E2));		
		sc.close();
	}
}