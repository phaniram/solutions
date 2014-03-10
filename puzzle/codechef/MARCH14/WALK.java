/*
 * Walk
 * Status  : Solved
 * Problem : http://www.codechef.com/MARCH14/problems/WALK/
 */

package codechef.MARCH14;

import java.util.Scanner;

class WALK {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int W[] = new int[N];
			for (int j = 0; j < N; j++) {
				W[j] = sc.nextInt();
			}
			int max_V = 0;
			for (int k = N - 1; k >= 0; k--) {
				int current_W = W[k];
				if (current_W <= max_V) {
					max_V++;
				} else if (current_W > max_V) {
					max_V = current_W;
				}
			}
			System.out.println(max_V);
		}
	}
}
