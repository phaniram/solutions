package codechef.may12;

/**
 * @author Cypronmaya -Codechef- Accepted
 */
import java.util.HashSet;
import java.util.Scanner;

class STONES {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		for (int i = 0; i < test_cases; i++) {
			String j = sc.next();
			String s = sc.next();
			HashSet<Character> hs = new HashSet<Character>();
			for (char c : j.toCharArray()) {
				hs.add(c);
			}
			int count = 0;
			for (char c : s.toCharArray()) {
				if (hs.contains(c)) {
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
