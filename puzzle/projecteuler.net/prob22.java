package com.cyp.projeuler;
/*
	* Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
	
	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938  53 = 49714.
	
	What is the total of all the name scores in the file?
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class prob22 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File input=new File("D://names.txt");
		SortedSet<String> ts=new TreeSet<String>();;
		Scanner sc=new Scanner(new FileReader(input)).useDelimiter(",");
		while(sc.hasNext())
		{
			ts.add(sc.next().replace('"',' ').trim());
		}
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(ts);
		int total=0;
		for(String str:list)
		{
			int sum=0;
			for(char ch:str.toCharArray())
			{
				sum+=ch-'A'+1;
			}
			sum*=list.indexOf(str)+1;
			total+=sum;
		}
		System.out.println(total);
	}

}
