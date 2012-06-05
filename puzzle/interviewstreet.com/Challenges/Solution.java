package interviewstreet.puzzles;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author cypronmaya
 *  FIND STRINGS - Interviewstreet Challenges (Non-Optimal Solution)
 */
class Solution {

    private static final String INVALID = "INVALID";
    private TreeSet<String> mainset = new TreeSet<String>();
    private ArrayList<String> array = new ArrayList<String>();
    private String[] main_ary;
    private int length;

    public static void main(String args[]) {
        Solution fin = new Solution();
        Scanner scanner = new Scanner(System.in);
        int num_of_strings = scanner.nextInt();

        while (--num_of_strings >= 0) {
            fin.process(scanner.next());
        }

        fin.initialize();

        int num_of_queries = scanner.nextInt();
        int length = fin.length;
        while (--num_of_queries >= 0) {
            int index = scanner.nextInt() - 1;
            if (index < length) {
                System.out.println(fin.query(index));
            } else {
                System.out.println(INVALID);
            }
        }
    }

    private String query(int index) {
        return main_ary[index];
        // return array.get(index);
    }

    private void process(String input) {
        int len = input.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                mainset.add(input.substring(i, j + 1));
            }
        }
    }

    private void initialize() {
        length = mainset.size();
        main_ary = mainset.toArray(new String[length]);
        //    array.addAll(mainset);
    }
}