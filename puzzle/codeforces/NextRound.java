package codeforces;

import java.util.Scanner;

public class NextRound {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] arr=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=sc.nextInt();
		}
		sc.close();
	}

}
