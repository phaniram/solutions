package gild.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cypronmaya
 */
public class Robotwars {

    int fields;
    List<Integer> robots_A = new ArrayList<Integer>();
    List<Integer> robots_B = new ArrayList<Integer>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileReader(new File("D://a.in")));
        int num_of_tournaments = sc.nextInt();
        while (--num_of_tournaments >= 0) {

            int num_of_fields = sc.nextInt();
            int num_of_robots_A = sc.nextInt();
            int num_of_robots_B = sc.nextInt();
            List<Integer> robo_A = new ArrayList<Integer>();;
            List<Integer> robo_B = new ArrayList<Integer>();
            for (int i = 0; i < num_of_robots_A; i++) {
                robo_A.add(sc.nextInt());
            }
            for (int i = 0; i < num_of_robots_B; i++) {
                robo_B.add(sc.nextInt());
            }
            Robotwars rw = new Robotwars(num_of_fields, robo_A, robo_B);
        }

    }

    private Robotwars(int num_of_fields, List<Integer> robo_A, List<Integer> robo_B) {
        this.fields = num_of_fields;
        this.robots_A = robo_A;
        this.robots_B = robo_B;
    }

    private void logic() {
        
    }
}
