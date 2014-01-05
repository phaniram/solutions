/*
 * Saying Hi
 * Status  : Accepted
 * Problem : https://www.hackerrank.com/challenges/saying-hi
 */

package hackerrank.Challenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Saying_Hi {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (N-- > 0) {
            String str = sc.nextLine();
            if (Pattern.compile("^[h|H][i|I] [^dD].*", Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher(str).matches())
                System.out.println(str);
        }
        sc.close();
    }
}