import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Snippet {

	int simpleSearch(String pattern, String text) {

		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();

		int m = p.length;
		int n = t.length;

		int count = 0;
		long start_time = System.currentTimeMillis();
		int i = 0;
		while (i + m <= n) {
			int j = 0;
			while (t[i + j] == p[j]) {
				j++;
				if (j >= m)
					break;
			}
			if (j == m)
				count++;
			i++;
		}
		long end_time = System.currentTimeMillis();
		System.out.print("Simple Search: Count = " + count + " Time = "
				+ ((long) end_time - start_time));
		return count;
	}

	int boyerMooreHorspoolSearch(String pattern, String text) {
		char p[] = pattern.toCharArray();
		char t[] = text.toCharArray();

		int m = p.length;
		int n = t.length;

		int radix = 256;
		int[] shift = new int[radix];

		for (int c = 0; c < radix; c++)
			shift[c] = m;
		for (int k = 0; k <= m - 2; k++)
			shift[p[k]] = m - 1 - k;

		int count = 0;
		long start_time = System.currentTimeMillis();
		int i = 0;
		while (i + m <= n) {
			int j = m - 1;
			while (t[i + j] == p[j]) {
				j = j - 1;
				if (j < 0)
					break;
			}
			if (j < 0)
				count++;
			i = i + shift[t[i + m - 1]];
		}
		long end_time = System.currentTimeMillis();
		System.out.print("Boyer-Moore-Horspool Search: Count " + count
				+ " Time = " + ((long) end_time - start_time));
		return count;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		System.out.print("Text file: ");
		 File input=new File(new File (".").getCanonicalPath(),sc.next());

		// File input = new File("C:\\Users\\cypronmaya\\git\\solutions_github\\puzzle\\src\\pg98.txt");
		System.out.print("Pattern: ");
		String pattern = sc.next();

		sc = new Scanner(new FileReader(input));
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine()).append(" ");
		}

		Snippet sp = new Snippet();

		sp.simpleSearch(pattern, sb.toString().trim());
		System.out.println();
		sp.boyerMooreHorspoolSearch(pattern, sb.toString().trim());

		// System.out.println("Given file is "+input.toString());
	}

}
