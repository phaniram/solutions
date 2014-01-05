/*
 * Valid PAN format
 * Status  : Accepted
 * Problem : https://www.hackerrank.com/challenges/valid-pan-format
 */

package hackerrank.Challenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Valid_PAN_Format {

    public static final String PAN_REGEX = "[A-Z]{5}\\d{4}[A-Z]";

    public static String check(String pan) {
        if (Pattern.compile(PAN_REGEX, Pattern.DOTALL).matcher(pan).matches())
            return "YES";
        else
            return "NO";
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while (N-- > 0) {
            String str = sc.nextLine();
            System.out.println(Valid_PAN_Format.check(str));
        }
    }
}