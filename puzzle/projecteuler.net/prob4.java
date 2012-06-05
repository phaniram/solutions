package com.cyp.projeuler;


class prob4 {

	public static void main(String[] args) {
		int largest=0;
		for(int i=999;i>100;i--)
		{
			for(int j=999;j>100;j--)
			{
				int product=i*j;
				if(isPalindrome(product))
				{
					if(product>largest)
						largest=product;
				}
			}
		}
		System.out.println(largest);
	}

	private static boolean isPalindrome(int prod) {
		Integer p=prod;
		String rep=p.toString();
		int len=rep.length();
		int count=0;
			for(int k=len/2;k>0;k--)
			{
				if(rep.charAt(k-1)==rep.charAt(len-k))
					{
						count++;
					}
			}
			if(count==len/2)
			{
				return true;
			}
		return false;
	}

}
