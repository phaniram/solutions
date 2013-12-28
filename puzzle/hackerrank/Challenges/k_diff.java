package hackerrank.Challenges;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author cypronmaya
 * K Difference - Interviewstreet Challenges (Optimal Solution)
 */
public class k_diff {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int total_nums = scanner.nextInt();
        int diff = scanner.nextInt();
        int ary_nums[] = new int[total_nums];
        for (int i = 0; i < total_nums; i++) {
            ary_nums[i] = scanner.nextInt();
        }
        int count = 0;
        Arrays.sort(ary_nums);
        for (int i = total_nums - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (ary_nums[i] - ary_nums[j] == diff) {
                    count++;
                    j = 0;
                }
            }
        }
        System.out.println(count);
    }
}
