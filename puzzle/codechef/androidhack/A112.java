package codechef.androidhack;

import java.util.Scanner;

 class A112 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int i=0;i<cases;i++)
		{
			int fst=Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());
			int snd=Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());	
			
			System.out.println(new StringBuffer(new Long((long)fst+snd).toString()).reverse().toString());
		}
		sc.close();
	}
}
