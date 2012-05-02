package codechef.aprcontest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PLAYFIT {

	int matches;
	int[] scores;
	public PLAYFIT(int[] scs, int num) {
		this.scores=scs;
		this.matches=num;
		solve();
	}

	private void solve() {
	
		Arrays.sort(scores);
		Set<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<scores.length;i++)
		{
			hs.add(scores[i+1]);
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int num_of_cases=sc.nextInt();
		for(int i=0;i<num_of_cases;i++)
		{
			int num_of_matches=sc.nextInt();
			int[] scores=new int[num_of_matches+1];
			for(int k=0;k<num_of_matches;k++)
			{
				scores[k+1]=sc.nextInt();
			}
			PLAYFIT pf =new PLAYFIT(scores,num_of_matches);
		}
		
	}

}
