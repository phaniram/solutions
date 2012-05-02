package codechef.androidhack;

import java.util.Scanner;

 class A112 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int i=0;i<cases;i++)
		{
			int fst=Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());
			int snd=Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());	
			
			System.out.println(new StringBuffer(new Long((long)fst+snd).toString()).reverse().toString());
		}
	}
}
