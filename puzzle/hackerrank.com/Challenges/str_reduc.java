package interviewstreet.puzzles;

import java.util.Arrays;
import java.util.Scanner;

public class str_reduc {

	int min=1;
	int val=1;
	public static void main(String[] args) {
		Scanner scanner;
		str_reduc sr = new str_reduc();
		scanner = new Scanner(System.in);
		int no_cases = scanner.nextInt();
		for (int i = 0; i < no_cases; i++) {
			String to_proc = scanner.next();
					sr.solve(to_proc);
					System.out.println(sr.min);
		}
	}

	private boolean solve(String to_proc) {
		char[] ary=to_proc.toCharArray();
		int len=ary.length;
		min =ary.length;
		if(ary.length==1)
		{
			val=1;
			return true;
		}
		if(ary.length==2 && ary[0]==ary[1])
		{
			val=2;
			return true;
		}
		
		for(int i=0;i<ary.length-1;i++)
		{
			if(ary[i]!=ary[i+1])
			{
				
				String build=Character.toString(ary[i]).concat(Character.toString(ary[i+1]));
				char other_char =other(build);
				String one="";
				String two=Character.toString(other_char);
				String three="";
				if(i==1)
				{
					one=Character.toString(ary[0]);
				}else if(i>1)
				{
					one=new String(Arrays.copyOfRange(ary,0,i));
				}
				if(i+2<len-1)
				{
					three=new String(Arrays.copyOfRange(ary,i+2,len));
				}else if(i+2==len-1)
				{
					three=Character.toString(ary[i+2]);
				}
				String fin=one+two+three;
		//		System.out.println(to_proc+" - "+fin);
				boolean stop=solve(fin);
				if(stop)
				{
					min=Math.min(min, val);
					return stop;
				}
			}
		}
		return false;
	}

	private char other(String group_string) {
		char ret='b';
		if (group_string.equalsIgnoreCase("ab")|| group_string.equalsIgnoreCase("ba")) {
			ret='c';
		} else if (group_string.equalsIgnoreCase("bc")|| group_string.equalsIgnoreCase("cb")) {
			ret='a';
		} 
		return ret;
	}
}