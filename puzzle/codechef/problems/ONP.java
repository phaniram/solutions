/*
 * Transform the Expression
 * Status  : ONP
 * Problem : http://www.codechef.com/problems/ONP
 */

package codechef.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class ONP {
	
	public static void toRPN(String expr)
	{
		Deque<Character> stack = new ArrayDeque<Character>();
		for(char ch: expr.toCharArray())
		{
			stack.add(ch);
			
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0)
		{
			String expr = sc.next();
			System.out.println(expr);
		}
		sc.close();
	}
}