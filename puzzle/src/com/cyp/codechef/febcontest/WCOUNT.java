package com.cyp.codechef.febcontest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

class WCOUNT {
	int len;
	BigInteger mod; 
	HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
	public WCOUNT(String word) {
		len=word.length();
		char[] arr=word.toCharArray();
		for(char ch:arr)
		{
			if(hm.containsKey(ch))
			{
				hm.put(ch,hm.get(ch)+1);
			}
			else
			{
				hm.put(ch, 1);
			}
		}
		mod=new BigInteger("1000000007");
	}

	private void logic() {
		BigInteger fact=factorial(len);
		BigInteger denom=new BigInteger("1");
		for(int val:hm.values())
		{
			denom=denom.multiply(factorial(val));
		}
		BigInteger fin=fact.divide(denom);
		fin=fin.mod(mod);
		System.out.println(fin);
	}
	
	public static BigInteger factorial(int i) {
	    BigInteger n = BigInteger.valueOf(i);
	    while (--i > 0)
	        n = n.multiply(BigInteger.valueOf(i));
	    return n;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num_cases=sc.nextInt();
		while(--num_cases>=0)
		{
			String word=sc.next();
			WCOUNT wc=new WCOUNT(word);
			wc.logic();
		}
	}

	

}
