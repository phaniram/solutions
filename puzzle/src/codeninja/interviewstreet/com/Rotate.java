package codeninja.interviewstreet.com;

import java.util.Scanner;

public class Rotate {

	int size;
	int[][] arr;
	int[][] rot_arr;
	public Rotate(int[][] array, int s) {
		this.arr=array;
		this.size=s;
		this.rot_arr=new int[s+1][s+1];
		System.out.println("Given array is");
		for(int p=1;p<=size;p++)
		{
			for(int k=1;k<=size;k++)
			{
				System.out.print(arr[p][k]+" ");
			}
			System.out.println();
		}
		solve();
		
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[][] arr=new int[size+1][size+1];
		for(int i=1;i<=size;i++)
		{
			for(int j=1;j<=size;j++)
			{
				arr[i][j]=sc.nextInt();
			}
		}
		Rotate rot=new Rotate(arr,size);
	}

	private void solve() {
		int num_of_rotations=size/2;
		int N=size;
		for(int r=1;r<=num_of_rotations;r++)
		{
			int b=N-(r-1);
			if(r%2==1)
			{
				for(int t=r;t<b;t++)
				{
					rot_arr[r][t+1]=arr[r][t];
					rot_arr[t+1][b]=arr[t][b];
				}
				for(int t=b;t>r;t--)
				{
					rot_arr[b][t-1]=arr[b][t];
					rot_arr[t-1][r]=arr[t][r];
				}
			}
			
			
		}
		
		for(int s=1;s<=size;s++)
		{
			for(int k=1;k<=size;k++)
			{
				System.out.print(rot_arr[s][k]+" ");
			}
			System.out.println();
		}
	}
}
