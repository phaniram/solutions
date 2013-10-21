
package interviewstreet.puzzles;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Save_humanity {
    
    int bit;
    int[] A;
    int[] B;
    String C_str;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int num_of_bits=sc.nextInt();
        int num_of_queries=sc.nextInt();
        Save_humanity sh=new Save_humanity(num_of_bits,sc.next(),sc.next());
        while(--num_of_queries>=0)
        {
            String str=sc.next();
            if(str.equals("set_a"))
            {
                sh.query_set_a(sc.nextInt(),sc.nextInt());
            }else if(str.equals("set_b"))
            {
                sh.query_set_b(sc.nextInt(),sc.nextInt());
            }else
            {
                sh.query_get_c(sc.nextInt());
            }
                
        }
        
    }

    private Save_humanity(int num_of_bits, String A_str, String B_str) {
       this.bit=num_of_bits;
       A = new int[num_of_bits];
       int i=0;
        for (char c : A_str.toCharArray()) {
              A[i++] = Character.digit(c,10);
            }
       
        B = new int[num_of_bits];
       i=0;
        for (char c : B_str.toCharArray()) {
              B[i++] = Character.digit(c,10);
            }
    
    }

    private void query_set_a(int idx, int x) {
        
        A[bit-1-idx]=x;
    }

    private void query_set_b(int idx, int x) {
        
        B[bit-1-idx]=x;
    }

    private void query_get_c(int idx) {
       String a_bin_string=Arrays.toString(A).replace(" ","").replace(",","").replace("[","").replace("]","");
       String b_bin_string=Arrays.toString(B).replace(" ","").replace(",","").replace("[","").replace("]","");
       BigInteger a_bigInt = new BigInteger(a_bin_string, 2);
       BigInteger b_bigInt = new BigInteger(b_bin_string, 2);
       BigInteger c_bigInt= a_bigInt.add(b_bigInt);
       C_str=c_bigInt.toString(2);
     //  System.out.println(C_str);
       int len=C_str.length();
       if(len==bit)
       {
           C_str="0".concat(C_str);
           len+=1;
       }
    //   System.out.print(C_str.charAt(len-1-idx));
    //   System.out.print(C_str+" - "+" idx- "+idx+" ");
       System.out.print(C_str.charAt(len-1-idx));
    }
}
