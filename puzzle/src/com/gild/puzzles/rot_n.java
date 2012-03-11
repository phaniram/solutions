/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gild.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class rot_n {

public void process(String input, int n) {
    int abcd = n;
    if (abcd < 0) {
        abcd = (26 - ((0 - abcd) % 26));
    }
//   int rot = 26 - abcd % 26;  //for decrypting
    int rot=       abcd % 26;  //for encrypting
    char out = 0;
    for (char ch : input.toCharArray()) {
        if (ch >= 65 && ch <= 90) {
            if (ch + rot <= 90) {
                out = (char) (ch + rot);
                System.out.print(out);
            } else {
                out = (char) (ch + rot - 26);
                System.out.print(out);
            }

        } else if (ch >= 97 && ch <= 122) {
            if (ch + rot <= 122) {
                out = (char) (ch + rot);
                System.out.print(out);
            } else {
                out = (char) (ch + rot - 26);
                System.out.print(out);
            }
        } else {
            System.out.print(ch);
        }
    }
}

public void handler(File fFile) throws FileNotFoundException {
    Scanner scanner = new Scanner(new FileReader(fFile));
    int rot = 0;
    int count = 0;
    while (scanner.hasNextLine()) {
        if (count == 0) {
            rot = scanner.nextInt();
            scanner.nextLine();
        } else {
            String wordp = scanner.nextLine();
            process(wordp, rot);
            System.out.println();
        }
        count++;
    }
    scanner.close();

}

public static void main(String args[]) throws FileNotFoundException {
    if (args.length == 0) {
        File fFile = new File("D:\\a.in"); //Input file having the first line as the  key 
        rot_n fsopa = new rot_n();
        fsopa.handler(fFile);
    }
}
}
