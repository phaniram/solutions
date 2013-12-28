package hackerrank.Challenges;

import java.util.*;

public class Vertical_sticks {

    private ArrayList<int[]> permutations = new ArrayList<int[]>();

    public boolean permute(int[] data) {
        int k = data.length - 2;
        while (data[k] >= data[k + 1]) {
            k--;
            if (k < 0) {
                return false;
            }
        }
        int l = data.length - 1;
        while (data[k] >= data[l]) {
            l--;
        }
        swap(data, k, l);
        int length = data.length - (k + 1);
        for (int i = 0; i < length / 2; i++) {
            swap(data, k + 1 + i, data.length - i - 1);
        }
        return true;
    }

    private void swap(int[] data, int k, int l) {
        data[k] = data[k] + data[l];
        data[l] = data[k] - data[l];
        data[k] = data[k] - data[l];
    }

    public double process(int[] set) {
        Arrays.sort(set);
        int len=set.length;
        permutations.clear();
        do {
            int[] buf = new int[len];
            for (int i = 0; i < len; i++)
                {
                    buf[i] = set[i];
                }
            permutations.add(buf);
            //   System.out.println("-"+Arrays.toString(set));
            System.gc();
        } while (permute(set));

        int v = 0;
        for (int[] single : permutations) {
            v += perform(single);
        }
        //  System.out.println("v="+v+" and num.of permutations"+permutations.size());
        double ret = (double) v / permutations.size();
        return ret;
    }

    public int perform(int[] intArray) {
        int len = intArray.length;
        int total_len = 0;
        for (int i = len - 1; i > 0; i--) {
            int ray_len = 1;
            //  System.out.println("Comparing with "+intArray[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (intArray[j] >= intArray[i]) {
                    //      System.out.println(intArray[j]+">="+intArray[i]);
                    break;
                }
                ray_len++;
            }
            //  System.out.println("Ray length is "+ray_len);
            total_len += ray_len;
        }
        return total_len + 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num_of_testcases = sc.nextInt();
        Vertical_sticks v_sticks = new Vertical_sticks();
        for (int i = 0; i < num_of_testcases; i++) {
            int num_of_points = sc.nextInt();
            int sticks[] = new int[num_of_points];
            for (int j = 0; j < num_of_points; j++) {
                sticks[j] = sc.nextInt();
            }
            double out = v_sticks.process(sticks);
            System.out.printf("%8.2f\n", out);
        }
    }
}
