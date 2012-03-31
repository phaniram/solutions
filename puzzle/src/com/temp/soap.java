package com.temp;

import java.util.Scanner;

public class soap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int L_perm=26;  // L is a letter of the alphabet A-Z
		final int D_perm=10;  // D is a digit 0-9
		final int B_perm=34;  // B can be either a letter or a digit but cannot be the letter O or the digit 0 34->36-2(O && 0)
		
		System.out.print("Pattern: ");
		Scanner sc=new Scanner(System.in); //Take input
		String pattern=sc.next();
		int pattern_length=pattern.length(); //Given Pattern length
		if(pattern_length>6)
		{
			System.out.println("Invalid pattern");
			System.exit(1);
		}
		int no_L=pattern.replaceAll("[^L]", "").length(); //Number of L's in pattern
		int no_D=pattern.replaceAll("[^D]", "").length(); //Number of D's in pattern
		int no_B=pattern.replaceAll("[^B]", "").length(); //Number of B's in pattern
		
		System.out.println("Standard = "+(int)(Math.pow(L_perm, no_L)*Math.pow(D_perm, no_D)*Math.pow(B_perm, no_B)));
		//For standard license plates 
		//num_of_selections ^ num_of_occurences
		// ex: LDLB -> 26*10*26*34 -> 26^2*10*34
		
		
		// Personalized license plates can contain anywhere from one character up to the number of characters required in non-personalized plates.  
		// No valid regular state license plate number can be used for a personalized plate.  
		// For personalized plates that have the same number of characters as regular plates, the letter O cannot be used in any location 
		// specified as D or B in the required state pattern.
		
		// So finding number of possibilities up to length of pattern_length-1 (as there won't be any limitations)
		//example : LLLL -> Number of possibilities for up to length 3 -> 26*26*26 + 26*26 + 26
		
		int tot=0;
		int x=pattern_length;
		while(--x>=1)
		{
			tot+=Math.pow(26, x);
		}
		
		//Now calculating number of possibilities of plates with length_of_plate
		// Here condition is to eliminate calculating possibilities  if pattern contains all L's or all B's as there won't be any possibilities for them
		if(no_L!=pattern_length && no_B!=pattern_length && no_D!=0)
		{
			//L_perm-1 is used because possibilities won't be containing "O"
			tot+=Math.pow(L_perm, no_L)*Math.pow(L_perm-1, no_D+no_B);
		}
		System.out.println("Personalized = "+tot);
	}

}
