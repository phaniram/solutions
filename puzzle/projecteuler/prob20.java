package projecteuler;

import java.math.BigInteger;

class prob20 {

	/**
	* 	n! means n  (n  1)  ...  3  2  1
		
		For example, 10! = 10  9  ...  3  2  1 = 3628800,
		and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
		
		Find the sum of the digits in the number 100!
	 */
	public static void main(String[] args) {
		
		char[]  ch= new prob20().fact(100).toString().toCharArray();
		int sum=0;
		for(char i:ch)
		{
			sum+=Integer.parseInt(Character.toString(i));
		}
		System.out.println(sum);
	}
	
	public BigInteger fact(int num)
	{
		if(num==1)
		{
			return BigInteger.ONE;
		}
		return BigInteger.valueOf(num).multiply(fact(num-1));
	}

}
