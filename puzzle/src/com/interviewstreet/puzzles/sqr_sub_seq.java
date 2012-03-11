/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewstreet.puzzles;

import java.util.Scanner;

/**
 *
 * @author cypronmaya
 */
public class sqr_sub_seq {
    public static void main(String[] args) {
		Scanner scanner;
		sqr_sub_seq sr = new sqr_sub_seq();
		scanner = new Scanner(System.in);
		int no_cases = scanner.nextInt();
		for (int i = 0; i < no_cases; i++) {
			String to_proc = scanner.next();
			sr.solve(to_proc);
		}
	}

    private void solve(final String input) {
        int total = 0;
        int len = input.length();
        int count=0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                String sub=input.substring(i, j);
                if(sub.length()%2==0)
                {
                    if(evaluate(sub))
                    {
                        System.out.println("success "+sub);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        }
    
    private boolean evaluate(String sub)
    {
        int len=sub.length()/2;
        char[] arr=sub.toCharArray();
        int count=0;
        for(int i=0;i<len;i++)
        {
            if(arr[i]==arr[len+i])
            {
                count++;
            }
        }
         if(count==len)
         {
             return true;
         }
        return false;
    }
    }

    
