/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gild.puzzles;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class sampa {

   private String charset;
   private int len;
    sampa()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 128; i++)
        {
            sb.append((char)i);
        }
        charset=sb.toString();
        len=charset.length();
    }
public String processEncrypt(String input, int n) {
 
    Map<Character, Character> mapEncrypt = new HashMap<Character, Character>();
    
    for (int i = 0; i < len; i++) {
        mapEncrypt.put(charset.charAt(i), charset.charAt((i + n + len) % len));
    }
    
    
    StringBuilder sbe = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
        Character ch = mapEncrypt.get(input.charAt(i));
        sbe.append(ch);
    }
    
    System.out.println(sbe.toString());
    
    return sbe.toString();
}

public String processDecrypt(String input, int n) {

    Map<Character, Character> mapDecrypt = new HashMap<Character, Character>();
    
    for (int i = 0; i < len; i++) {
        mapDecrypt.put(charset.charAt(i), charset.charAt((i - n + len) % len));
    }
    
    StringBuilder sbd = new StringBuilder();
    for(int i = 0; i < input.length(); i++) {
        Character ch = mapDecrypt.get(input.charAt(i));
        sbd.append(ch);
    }
    
   System.out.println(sbd.toString());
    return sbd.toString();
}

public static void main(String args[]) throws FileNotFoundException {

        sampa fsopa = new sampa();
        String orig="Encrypted";
        int rot=-128;
       System.out.println("String being encrypted is - "+orig);
        String enc=fsopa.processEncrypt(orig, rot);
      //  String dec=fsopa.processDecrypt(enc, rot);
        System.out.println(orig+" - "+enc+"  - ");
}
}
