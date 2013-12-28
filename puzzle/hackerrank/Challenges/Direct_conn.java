package hackerrank.Challenges;

import java.util.Scanner;

public class Direct_conn {

    int num;
    int[] dist;
    int[] pop;

    public Direct_conn(int num, int[] dist, int[] pop) {
        this.num = num;
        this.dist = dist;
        this.pop = pop;
    }

    public long solve() {
        long ret = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i; j < num; j++) {
                ret += perform(i, (j + 1));
            }
        }
        return ret;
    }

    public long perform(int i, int j) {
        int conn = Math.max(pop[i], pop[j]);
        int distance = dist[j] - dist[i];
        long ret = conn * distance;
        return ret;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int test_cases = scanner.nextInt();
        for (int i = 0; i < test_cases; i++) {
            int num_of_cities = scanner.nextInt();
            int[] cities_dist = new int[num_of_cities];
            int[] cities_pop = new int[num_of_cities];
            for (int j = 0; j < num_of_cities; j++) {
                cities_dist[j] = scanner.nextInt();
            }
            for (int k = 0; k < num_of_cities; k++) {
                cities_pop[k] = scanner.nextInt();
            }
            Direct_conn dc = new Direct_conn(num_of_cities - 1, cities_dist, cities_pop);
            System.out.println(dc.solve());
        }
    }
}
