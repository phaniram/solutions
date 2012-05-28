/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.febcontest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class MAXCOUNT {

    HashMap<Integer, Integer> hm;

    public MAXCOUNT(int size) {
        hm = new HashMap<Integer, Integer>(size);
    }

    private void put(int next) {
        if (hm.containsKey(next)) {
            hm.put(next, hm.get(next) + 1);
        } else {
            hm.put(next, 1);
        }
    }

    private void disp() {
        int max = Collections.max(hm.values());
        StringBuilder sb=new StringBuilder();
        for (int key : hm.keySet()) {
            if (hm.get(key) == max) {
                sb.append(key).append(" ").append(max).append("\n");
                System.out.print(sb);
                break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();
        while (--num_cases >= 0) {
            int size = sc.nextInt();
            MAXCOUNT mx = new MAXCOUNT(size);
            while (--size >= 0) {
                mx.put(sc.nextInt());
            }
            mx.disp();
        }
    }
}