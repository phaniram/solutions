package com.temp;


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class test implements Runnable{

        private int[] in;
        public test(int[] input) {
                this.in=input;
        }

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
		long v = 0, count = 0;
		do {
			v += perform(set);
			count++;
		} while (permute(set));
		// System.out.println("v="+v+" and num.of permutations"+count);
		double ret = (double) v / count;
		return ret;
	}

	public int perform(int[] intArray) {
		int len = intArray.length;
		int total_len = 0;
		for (int i = len - 1; i > 0; i--) {
			int ray_len = 1;
			// System.out.println("Comparing with "+intArray[i]);
			for (int j = i - 1; j >= 0; j--) {
				if (intArray[j] >= intArray[i]) {
					// System.out.println(intArray[j]+">="+intArray[i]);
					break;
				}
				ray_len++;
			}
			// System.out.println("Ray length is "+ray_len);
			total_len += ray_len;
		}
		return total_len + 1;
	}

    @Override
    public void run() {
       System.out.printf("%8.2f\n",process(in));
    }
}
public class sampa{
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num_of_testcases = sc.nextInt();
		ExecutorService executor = Executors.newFixedThreadPool(num_of_testcases);
		for (int i = 0; i < num_of_testcases; i++) {
			int num_of_points = sc.nextInt();
			int sticks[] = new int[num_of_points];
			for (int j = 0; j < num_of_points; j++) {
				sticks[j] = sc.nextInt();
			}
                        Runnable worker = new test(sticks);
			executor.execute(worker);
                      
		}
               executor.shutdown();
	}
}