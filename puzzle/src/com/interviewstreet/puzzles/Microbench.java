/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interviewstreet.puzzles;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;


public class Microbench
{
    public static void main(String[] argv)
    throws Exception
    {        
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        long start = threadBean.getCurrentThreadCpuTime();
        executeTest();
        long finish = threadBean.getCurrentThreadCpuTime();
        double elapsed = (finish - start) / 1000000.0;
        System.out.println(String.format("elapsed time = %7.3f ms", elapsed));
    }


    private static List<String> executeTest()
    {
        String[] data = generateRandomStrings(100000);

        TreeSet<String> set = new TreeSet<String>();
        for (String s : data)
            set.add(s);

        return new ArrayList<String>(set);
    }


    private static String[] generateRandomStrings(int size)
    {
        Random rnd = new Random();
        String[] result = new String[size];
        for (int ii = 0 ; ii < size ; ii++)
            result[ii] = String.valueOf(rnd.nextLong());
        return result;
    }
}
