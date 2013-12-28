package codechef.marcontest;

import java.math.BigInteger;
import java.util.Scanner;

public class LUCKY2 {

    String from;
    String to;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();
        for (int i = 0; i < num_cases; i++) {
            String L = sc.next();
            String R = sc.next();
            LUCKY2 luc = new LUCKY2(L, R);
            luc.solve();
        }
        sc.close();
    }

    private LUCKY2(String L, String R) {
        this.from = L;
        this.to = R;
    }

    private void solve() {
        BigInteger num = new BigInteger(to).min(new BigInteger(from));
        BigInteger i = new BigInteger(from);
        BigInteger k = new BigInteger(to);
        BigInteger count = BigInteger.ZERO;
        
        for (; i.compareTo(k) >= 0; i.add(BigInteger.ONE)) {
            if (F(i)) {
                count.add(BigInteger.ONE);
            }
        }
        System.out.println(count.mod(BigInteger.valueOf(1000000007)));
    }

    private boolean F(BigInteger i) {
       String num=i.toString();
       String pattern = "[^4]";
       BigInteger bg=BigInteger.ZERO;
       for(char c:num.toCharArray())
       {
           if(c=='4'|| c=='7')
           {
               bg.add(BigInteger.ONE);
           }
       }
       String ag=bg.toString();
       
       if(ag.matches(ag));
       return false;
    }
}
