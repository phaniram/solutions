/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewstreet.puzzles.quora;

import java.util.*;

/**
 *
 * @author cypronmaya
 */
public class ScrabbleStepladder {
    
    public static void main(String args[])
    {
        HashMap<String,Integer> hs=new HashMap<String,Integer>();
        ArrayList<String> al=new ArrayList<String>();
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int num_words=sc.nextInt();
        String[] words=new String[num_words];
        int tot=0;
        for(int i=0;i<num_words;i++)
        {
            String word=sc.next();
            if(word.length()==len)
            {
                hs.put(word, score(word));
                al.add(word);
                words[tot++]=word;
            }
        }
        Graph G = new Graph();
        for (int i = 0; i < tot; i++)
            for (int j = i + 1; j < tot; j++)
                if (isNeighbor(words[i], words[j]))
                    G.addEdge(words[i], words[j]);
        
        
     //   PathFinder finder = new PathFinder(G, from);
        
        System.out.println(G.toString());
        
    }

    public static boolean isNeighbor(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) differ++;
        }
        return (differ == 1);
    }
    
    private static Integer score(String word) {
        int score=0;
        for(char c : word.toCharArray())
        {
            score+=value(c);
        }
        return score;
    }
    private static Integer value(char c)
    {
        int val=0;
     switch(c)
             {
         case 'Q': case 'Z': val=10; break;
             case 'J': case 'X': val=8; break;
                 case 'K': val=5; break;
                     case 'B': case 'C': case 'M': case 'P': val=3; break;
                         case 'F': case 'H': case 'V': case 'W': case 'Y': val=4; break;
                            case 'D': case 'G': val=2; break;
                            default : val=1; break;
             }
    
        return val;
    }
    
}
