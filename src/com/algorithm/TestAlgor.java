package com.algorithm;

import java.util.Arrays;

public class TestAlgor {
	public static void main(String[] args) {
		int[] arrays = { 3, 4, 7, 46, 7, 4, 567, 898, 6, 65, 5, 5, 454, 78, 7 };
		// bubble(sz);
		// choose(sz);
		// insert(sz);
		// quick(sz,0,sz.length-1);
		// mergeSort(sz, 0, sz.length - 1);
		redix(arrays);

		System.out.println(Arrays.toString(arrays));
	}

	private static void redix(int[] arrays) {
		int max = findMax(arrays);
		for (int i = 1; max / i > 0; i *= 10) {
			int[][] bockets = new int[arrays.length][10];
			for (int j = 0; j < arrays.length; j++) {
				int num = (arrays[j] / i) % 10;
				bockets[j][num] = arrays[j];
			}
			int k = 0;
			for (int j = 0; j < 10; j++) {
				for (int l = 0; l < arrays.length; l++) {
					if(bockets[l][j]!=0){
						arrays[k++]=bockets[l][j];
					}
				}
			}
		}
	}

	private static int findMax(int[] sz) {
		int max = sz[0];
		for (int i : sz) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
