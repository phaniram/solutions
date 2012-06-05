package interviewstreet.puzzles;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cypronmaya
 */
class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Quad_query {

    private ArrayList<Point> arrayList;

    public Quad_query(int capacity) {
        this.arrayList = new ArrayList<Point>(capacity);
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int num_of_points = scanner.nextInt();
        Quad_query quad_query = new Quad_query(num_of_points);
        for (int i = num_of_points; --i >= 0;) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            quad_query.add(x, y);
        }
        int num_of_queries = scanner.nextInt();
        for (int i = num_of_queries; --i >= 0;) {
            char c = scanner.next().charAt(0);
            quad_query.query(c, scanner.nextInt() - 1, scanner.nextInt() - 1);
        }
    }

    public void add(int x, int y) {
        Point point = new Point(x, y);
        arrayList.add(point);
    }

    public void query(char c, int i, int j) {

        switch (c) {
            case 'C':
                queryC(i, j);
                break;
            default:
                queryXY(c, i, j);
                break;
        }
    }

    public void queryC(int i, int j) {

        int quad_1 = 0, quad_2 = 0, quad_3 = 0, quad_4 = 0;
        for (int k = i; k <= j; k++) {
            Point pnt = arrayList.get(k);
            int pnt_x = pnt.x;
            int pnt_y = pnt.y;
            if (pnt_x > 0 && pnt_y > 0) {
                quad_1++;
            } else if (pnt_x < 0 && pnt_y > 0) {
                quad_2++;
            } else if (pnt_x < 0 && pnt_y < 0) {
                quad_3++;
            } else if (pnt_x > 0 && pnt_y < 0) {
                quad_4++;
            }
        }
        System.out.println(quad_1 + " " + quad_2 + " " + quad_3 + " " + quad_4);
    }

    private void queryXY(char c, int i, int j) {

        for (int k = i; k <= j; k++) {
            Point pnt = arrayList.get(k);
            int pnt_x = pnt.x;
            int pnt_y = pnt.y;
            if (c == 'X') {
                pnt = new Point(pnt_x, -pnt_y);
            } else if (c == 'Y') {
                pnt = new Point(-pnt_x, pnt_y);
            }
            arrayList.set(k, pnt);
        }
    }
}