package com.interviewstreet.puzzles;

import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.TreeSet;
    
    public class find_str {
    
        private static final String INVALID = "INVALID";
        private TreeSet<String> mainset = new TreeSet<String>();
        private ArrayList<String> array = new ArrayList<String>();
        private String[] main_ary;
        private int length;
        
        public static void main(String args[]) {
            long start=System.currentTimeMillis();
            find_str fin = new find_str();
            System.out.println(System.currentTimeMillis()-start);
            Scanner scanner = new Scanner(System.in);
            int num_of_strings = scanner.nextInt();
            long pr=System.currentTimeMillis();
            
            for (int i = num_of_strings; --i >=0;) {
                fin.process(scanner.next());
            }
            System.out.println("pr took "+(System.currentTimeMillis()-pr));
            long in=System.currentTimeMillis();
            
            fin.initialize();
            System.out.println("in took "+(System.currentTimeMillis()-in));
            
            
            int num_of_queries = scanner.nextInt();
            int length=fin.length;
            long qu=System.currentTimeMillis();
            for (int i = num_of_queries; --i >=0;) {
                int index=scanner.nextInt()-1;
                if(index<length)
                {
                    System.out.println(fin.query(index));
                }
                else
                {
                    System.out.println(INVALID);
                }
            }
            System.out.println("qu took "+(System.currentTimeMillis()-qu));
        }
    
        private String query(int index) {
                return main_ary[index];
               // return array.get(index);
        }
    
        private void process(String input) {
            int len = input.length();
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    mainset.add(input.substring(i, j + 1));
                }
            }
        }
    
        private void initialize() {
          length=mainset.size();
            main_ary=(String[]) mainset.toArray(new String[length]);
        //    array.addAll(mainset);
            
        }
    }