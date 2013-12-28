package projecteuler;

/*
 * The sum of the squares of the first ten natural numbers is,
	
	12 + 22 + ... + 102 = 385
	The square of the sum of the first ten natural numbers is,
	
	(1 + 2 + ... + 10)2 = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
	
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class prob6 {


	public static void main(String args[])
	{
		int sum_sq=0;
		int sq_sum=0;
		for(int i=1;i<=100;i++)
		{
			sum_sq+=i;
			sq_sum+=i*i;
		}
		System.out.println((sum_sq*sum_sq-sq_sum));
	}

}
