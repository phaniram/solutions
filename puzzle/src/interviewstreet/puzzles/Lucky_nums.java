/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewstreet.puzzles;

/**
 *
 * @author cypronmaya
 */
import java.util.Scanner;

public class Lucky_nums {

    boolean[] check;

    public static void main(String[] args) {

        Lucky_nums sr = new Lucky_nums();
        sr.sieve(1458);
        Scanner scanner = new Scanner(System.in);
        int no_cases = scanner.nextInt();
        for (int i = 0; i < no_cases; i++) {
            System.out.println(sr.solve(scanner.nextLong(), scanner.nextLong()));
        }
    }

    private int solve(long l, long m) {
        int count = 0;
        for (long i = l; i <= m; i++) {
            if (logic(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean logic(long i) {
    //    return (isSUM(i) && isSUMsq(i));
        return (isSUM_SUMsq(i));
    }

    private boolean isSUMsq(long i) {
        int sum = 0;
        while (i > 9) {
            long k = i % 10;
            i = i / 10;
            sum += k * k;
        }
        sum += i * i;
        return (check[sum]);
    }

    private boolean isSUM(long i) {
        int sum = 0;
        while (i > 9) {
            long k = i % 10;
            i = i / 10;
            sum += k;
        }
        sum += i;
        return (check[sum]);
    }

    private boolean isSUM_SUMsq(long i)
    {
         int sum = 0;
         int sumsq=0;
        while (i > 9) {
            long k = i % 10;
            i = i / 10;
            sum += k;
            sumsq += k * k;
        }
        sum += i;
        sumsq +=i*i;
        if(check[sum])
        {
            return check[sumsq];
        }
        return false;
        
    }
    boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    private void sieve(int upto) {
        int N = upto;
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        this.check = isPrime;
    }
}
