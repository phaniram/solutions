/*
 * Please like me
 * Status  : Accepted
 * Problem : http://www.codechef.com/JAN14/problems/PLZLYKME
 */

package codechef.JAN14;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class PLZLYKME {

	public static void main(String[] args) {
		InputReader cin = new InputReader(System.in);
		try 
		{
			int T = cin.nextInt();
			StringBuilder sb = new StringBuilder();
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
			while(T-->0)
			{
		        int L = cin.nextInt();
				int D = cin.nextInt();
				int S = cin.nextInt();
				int C = cin.nextInt();
				
				S = (int) (S * Math.pow((C+1),D-1));
				if(S>=L)	sb.append("ALIVE AND KICKING\n");
				  else sb.append("DEAD AND ROTTING\n");			
			}
		    pw.print(sb);
		    pw.close();
		} catch (Exception ex) {
        }
	}
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;
 
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
 
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt() {
        return Integer.parseInt(next());
    }
 
    public long nextLong() {
        return Long.parseLong(next());
    }
}