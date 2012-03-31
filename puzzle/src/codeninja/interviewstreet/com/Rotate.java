package codeninja.interviewstreet.com;

import java.util.Scanner;

public class Rotate {

	int size;
	int[][] arr;
	int[][] rot_arr;
	public Rotate(int[][] array, int s) {
		this.arr=array;
		this.size=s;
		this.rot_arr=new int[s][s];
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
		
		for(int k=1;k<=num_of_rotations;k++)
		{
			
		}
		
	}
}
