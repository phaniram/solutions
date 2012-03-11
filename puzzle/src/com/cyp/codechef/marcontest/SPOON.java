package com.cyp.codechef.marcontest;

import java.io.IOException;
import java.util.Scanner;
/*
 * Cypronmaya - Codechef March 2012 Contest - Problem Code : SPOON
 */

class SPOON {

    char[][] data;
    int rows;
    int columns;

    public SPOON(char[][] data, int rows, int columns) {
        this.data = data;
        this.rows = rows;
        this.columns = columns;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num_cases = sc.nextInt();

        for (int i = 0; i < num_cases; i++) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();
            char data[][] = new char[rows + 1][columns + 1];
            for (int r = 1; r <= rows; r++) {
                String row = sc.next().toLowerCase();
                for (int c = 1; c <= columns; c++) {
                    data[r][c] = row.charAt(c - 1);
                }
            }
            SPOON spoon = new SPOON(data, rows, columns);
            spoon.solve();
        }
    }

    private void solve() {
        
        boolean found = false;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns - 4; j++) {
                if (check_right(i, j)) {
                    found = true;
                    break;
                }
            }
        }
        once:
        if (!found) {
            for (int i = 1; i <= rows - 4; i++) {
                for (int j = 1; j <= columns; j++) {
                    if (check_down(i, j)) {
                        found = true;
                        break once;
                    }
                }
            }
        }
        
        if (!found) {
            System.out.println("There is indeed no spoon!");
        }
    }

    private boolean check_down(int i, int j) {
        boolean ret = false;
        if (data[i][j] == 's' && data[i + 1][j] == 'p' && data[i + 2][j] == 'o' && data[i + 3][j] == 'o' && data[i + 4][j] == 'n') {
            System.out.println("There is a spoon!");
            ret = true;
        }
        return ret;

    }

    private boolean check_right(int i, int j) {
        boolean ret = false;
        if (data[i][j] == 's' && data[i][j + 1] == 'p' && data[i][j + 2] == 'o' && data[i][j + 3] == 'o' && data[i][j + 4] == 'n') {
            System.out.println("There is a spoon!");
            ret = true;
        }
        return ret;
    }
}
