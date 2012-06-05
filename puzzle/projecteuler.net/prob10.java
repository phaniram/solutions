package com.cyp.projeuler;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

	Find the sum of all the primes below two million.
 */

public class prob10 {

	public static void main(String args[])
	{
		 int N = 2000000;

	        // initially assume all integers are prime
	        boolean[] isPrime = new boolean[N + 1];
	        for (int i = 2; i <= N; i++) {
	            isPrime[i] = true;
	        }

	        // mark non-primes <= N using Sieve of Eratosthenes
	        for (int i = 2; i*i <= N; i++) {

	            // if i is prime, then mark multiples of i as nonprime
	            // suffices to consider mutiples i, i+1, ..., N/i
	            if (isPrime[i]) {
	                for (int j = i; i*j <= N; j++) {
	                    isPrime[i*j] = false;
	                }
	            }
	        }

	        // count primes
	        long sum = 0;
	        for (int i = 2; i <= N; i++) {
	            if (isPrime[i]) sum+=i;
	        }
	        
	        System.out.println(sum);
	}
}
