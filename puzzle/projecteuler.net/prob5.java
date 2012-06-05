package com.cyp.projeuler;

public class prob5 {

	public static void main(String args[])
	{
		int i=0;
		while(true)
		{
			if(check(++i))
			{
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean check(int num) {
		int count=0;
		for(int i=1;i<=20;i++)
		{
			if(num%i==0)
			{
				count++;
			}
		}
		if(count==20)
		{
			return true;
		}
		return false;
	}
}
