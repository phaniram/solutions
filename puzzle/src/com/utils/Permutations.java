package com.utils;

import java.util.Arrays;

public class Permutations {

	public static boolean permute(int[] data) {
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
	private static void swap(int[] data, int k, int l) {
		data[k]=data[k]+data[l];
		data[l]=data[k]-data[l];
		data[k]=data[k]-data[l];
	}
	public static void main(String[] args) {
    int[] data = { 1,2,3 };
    do {
        System.err.println(Arrays.toString(data));
    } while(permute(data));
}

}
