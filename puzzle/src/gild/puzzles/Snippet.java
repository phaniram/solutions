package gild.puzzles;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Snippet {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Text file: ");
		File input=new File(new File (".").getCanonicalPath(),sc.next());
		
		StringBuilder sb=new StringBuilder();
		sc=new Scanner(new FileReader(input));
		while(sc.hasNextLine())
		{
			sb.append(sc.nextLine()).append(" ");
		}
		System.out.println(sb.toString());
		// System.out.println("Given file is "+input.toString());
	}
}

