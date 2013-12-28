package projecteuler;
/*
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

	What is the sum of the digits of the number 21000?
 */
import java.math.BigInteger;

public class prob16 {

	public static void main(String args[])
	{
		BigInteger bi=new BigInteger("1");
		int count=0;
		while(count<1000)
		{
			bi=bi.add(bi);
			count++;
		}
		String num=bi.toString();
		char[] ch=num.toCharArray();
		int sum=0;
		for(char i :ch )
		{
			sum+=Integer.parseInt(Character.toString(i));
		}
		System.out.println(sum);
	}
}
