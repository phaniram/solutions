package interviewstreet.puzzles;

import java.util.Scanner;
public class str_sim {
	public static void main(String[] args) {
		Scanner scanner;
		str_sim sr = new str_sim();
		scanner = new Scanner(System.in);
		int no_cases = scanner.nextInt();
		for (int i = 0; i < no_cases; i++) {
			String to_proc = scanner.next();
			sr.solve(to_proc);
		}
	}
    private void solve(final String input) {
        int total = 0;
        final char[] inputArray = input.toCharArray();
        for (int i = 1; i < inputArray.length; i++) {
            int count = 0;
                for (int j = i; j < inputArray.length; j++) {
                         if (inputArray[j - i] != inputArray[j]) {
                            break;
                             }
                    count++;
            }
            total = total + count;
     }
            System.out.println(total + inputArray.length);
        }
}