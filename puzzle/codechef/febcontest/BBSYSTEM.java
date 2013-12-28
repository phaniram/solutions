/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.febcontest;

import java.math.BigInteger;
import java.util.*;

class BBSYSTEM {

    boolean[] check;
    static HashMap<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();
    int num_primes;
    BigInteger primes_fact;

    private BBSYSTEM(int upto) {
        sieve(upto);
        this.primes_fact = factorial(num_primes);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();
        while (--num_cases >= 0) {
            int upto = sc.nextInt();
            BBSYSTEM mx = new BBSYSTEM(upto);
            mx.disp();
        }
        sc.close();
    }

    private void disp() {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 2; i < check.length; i++) {
            if (!check[i]) {
                int fact = factors(i);
                if (hm.containsKey(fact)) {
                    hm.put(fact, hm.get(fact) + 1);
                } else {
                    hm.put(fact, 1);
                }
            }
        }
        BigInteger big = new BigInteger("1");
        for (int k : hm.keySet()) {
            big = big.multiply(factorial(hm.get(k)));
        }
        System.out.println(big.multiply(primes_fact).subtract(BigInteger.ONE).mod(new BigInteger("500009")));
    }

    public BigInteger factorial(int n) {
        BigInteger ret;
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (null != (ret = cache.get(n))) {
            return ret;
        }
        ret = BigInteger.valueOf(n).multiply(factorial(n - 1));
        cache.put(n, ret);
        return ret;
    }

    public BigInteger facto(int n) {
        if (n <= 1) {
            return (new BigInteger("1"));
        } else {
            BigInteger bigN = new BigInteger(new Integer(n).toString());
            return (bigN.multiply(facto(n - 1)));
        }
    }

    public int factors(int numbers) {
        int n = numbers;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int factors = 1;
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                if (hm.containsKey(i)) {
                    hm.put(i, hm.get(i) + 1);
                } else {
                    hm.put(i, 1);
                }
                n /= i;
            }
        }
        if (n > 1) {
            if (hm.containsKey(n)) {
                hm.put(n, hm.get(n) + 1);
            } else {
                hm.put(n, 1);
            }
        }
        for (int value : hm.values()) {
            factors *= value + 1;
        }
        return factors;
    }

    private void sieve(int upto) {
        int N = upto;
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i * i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
        this.num_primes = primes;
        this.check = isPrime;
    }
}
