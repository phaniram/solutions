/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewstreet.puzzles;

import java.util.TreeSet;

/**
 *
 * @author cypronmaya
 */
public class test {
   
    public static void main(String args[])
    {
         TreeSet<String> ts=new TreeSet<String>();
         ts.add("a");
         ts.add("aa");
         ts.add("aab");
         ts.add("ab");
         ts.add("b");
         ts.add("a");
         ts.add("aa");
         ts.add("aac");
         ts.add("ac");
         ts.add("c");
         System.out.println(ts);
    }
}
