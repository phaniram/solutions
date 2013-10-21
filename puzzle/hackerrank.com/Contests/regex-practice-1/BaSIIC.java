import java.util.Scanner;
/*
 * Building a Smart IDE: Identifying comments
 * https://www.hackerrank.com/contests/regex-practice-1/challenges/ide-identifying-comments
 */
public class BaSIIC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			String curLine = sc.nextLine();
			if(curLine.contains("//"))
			{
				System.out.println(curLine.substring(curLine.indexOf("//")));
			}
			else if(curLine.contains("/*"))
			{
				int idxStart = curLine.indexOf("/*");
				if(curLine.contains("*/"))
				{
					int idxEnd = curLine.indexOf("*/")+2;
					System.out.println(curLine.substring(idxStart,idxEnd));
				}
				else
				{
					while(sc.hasNextLine())
					{
						while(!curLine.contains("*/"))
						{
							System.out.println(curLine);
							curLine = sc.nextLine();
						}
						System.out.println(curLine.substring(0,curLine.indexOf("*/")+2));
						break;
					}
				}
			}
		}
	}
}