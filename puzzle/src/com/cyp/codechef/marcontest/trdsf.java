/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cyp.codechef.marcontest;

/**
 *
 * @author cypronmaya
 */
public class trdsf {
    
    public static void main(String args[])
    {
        String pattern = "[^47]";
        System.out.println("5735366444546455".replaceAll(pattern,""));
        System.out.println("5735366444546455".replaceAll(pattern,"").matches("[47]*"));
    }
}
