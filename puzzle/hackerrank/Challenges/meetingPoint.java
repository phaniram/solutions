package hackerrank.Challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cypronmaya
 * Meeting Point - Interviewstreet Challenges (Non-Optimal Solution)
 */
public class meetingPoint {
    
	HashMap<Integer,Integer> hs;
	public meetingPoint(HashMap<Integer, Integer> hashmap) {
		this.hs=hashmap;
		
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int num_of_points=sc.nextInt();
		HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
		while(--num_of_points>=0)
		{
			
			hs.put(sc.nextInt(), sc.nextInt());
		}
		meetingPoint mp=new meetingPoint(hs);
		mp.solve();
	}

	private void solve() {
		
	}
	
}
