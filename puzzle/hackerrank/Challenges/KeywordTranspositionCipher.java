/*
 * Keyword Transposition Cipher
 * Status  : Solved
 * Problem : https://www.hackerrank.com/challenges/keyword-transposition-cipher
*/

package hackerrank.Challenges;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KeywordTranspositionCipher {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0)
		{
			String keyword = sc.next();
			sc.nextLine();
			String subStituteStr = generateSubstitutionMap(keyword);
			String cipherText = sc.nextLine();
			//Display Original text based on the position of cipher text character in the subStitutionString 
			for(char ci:cipherText.toCharArray())
			{
				if(ci>=65 && ci<=90) System.out.print((char)(subStituteStr.indexOf(ci)+65));
				else System.out.print(ci);
			}
			System.out.println();
		}
		sc.close();
	}
	public static String generateSubstitutionMap(String keyword)
	{
		//Removing duplicate characters in the given keyword
		StringBuilder noDupes = new StringBuilder();
		for (int i = 0; i < keyword.length(); i++) {
			String si = keyword.substring(i, i + 1);
			if (noDupes.indexOf(si) == -1) {
				noDupes.append(si);
			}
		}
		String noDupesKeyword = noDupes.toString();
		StringBuilder SubstitutionSB = new StringBuilder();	    
		//Building String with all remaining characters (apart from those in keyword)
		SubstitutionSB.append(noDupesKeyword);
		for(int j=65;j<=90;j++)
		{
			char asciiChar = (char)j;
			if(SubstitutionSB.indexOf(new Character(asciiChar).toString()) == -1)
			{
				SubstitutionSB.append(asciiChar);
			}
		}
		String SubstitutionSBStr = SubstitutionSB.toString();
		//Creating Columns based on the Keyword + Remaining Characters String		
		int keyWordLength = noDupesKeyword.length();
		int charColumnsLength = (int) Math.ceil(26.00/keyWordLength);
		String[] strColumns = new String[charColumnsLength];
		strColumns[0] = noDupesKeyword;
		for(int k=1;k<charColumnsLength;k++)
		{
			int fromPos = k*keyWordLength;
			int toPos = (k+1)*keyWordLength;
			if(toPos<SubstitutionSBStr.length()) {
				strColumns[k] = SubstitutionSBStr.substring(fromPos,toPos);
			}
			else {
				strColumns[k] = SubstitutionSBStr.substring(fromPos);
			}
		}
		char[] noDupesKeywordArr = noDupesKeyword.toCharArray();
		Arrays.sort(noDupesKeywordArr);
		//Forming Substitution String based on the alphabetical order of the characters in the keyword 		
		StringBuffer substituteStrBuffer = new StringBuffer();
		for(char ch:noDupesKeywordArr)
		{
			int idx = strColumns[0].indexOf(ch);
			for(int l=0;l<charColumnsLength;l++)
			{
				String colStr =  strColumns[l];
				if(idx<colStr.length()) {
					substituteStrBuffer.append(colStr.charAt(idx));
				}
			}
		}
		return substituteStrBuffer.toString();
	}
}
