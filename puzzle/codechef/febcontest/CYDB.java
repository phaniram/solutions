package codechef.febcontest;

import java.util.Scanner;

class CYDB {

    int A_rep = 26;
    String a, b, c;
    int na, nb, r;

    public static void main(String args[]) {
        CYDB cydb = new CYDB();
        Scanner sc = new Scanner(System.in);
        String arr[] = new String[3];
        for (int i = 0; i < 3; i++) {
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                sb.append(cydb.conv(ch));
            }
            arr[i] = sb.toString();
        }
        sc.close();
        cydb.logic(arr);
    }

    public String conv(char ch) {
        if (Character.isUpperCase(ch)) {
            return Integer.toBinaryString(ch - 'A' + 26);
        } else {
            return String.format("%5s", Integer.toBinaryString(ch - 'a')).replace(' ', '0');
        }
    }

    public void logic(String[] arr) {
        a = arr[0];
        na = a.length();
        b = arr[1];
        nb = b.length();
        c = arr[2];
        r = 0;
        for (int i = 0; i < nb; i++) {
            for (int j = 1; j < Math.min(na + 1, nb - i + 1); j++) {
                boolean f = true;
                int d = 0;
                for (int k = 0; k < j; k++) {
                    if (a.charAt(k) != b.charAt(i + k)) {
                        if (c.charAt(k) == '1') {
                            d += 1;
                        } else {
                            f = false;
                        }
                    }
                }
                if (f && d <= 2) {
                    r = (r + j * j) % 1000000007;
                }
            }
        }
        System.out.println(r);
    }
}
