package com.algorithm;

import java.util.Arrays;

public class Insert {
	public static void main(String[] args) {
		int[] sz = { 45, 5, 7, 5, 4, 6, 7, 65, 4, 3, 89, 7 };

		// 外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
		for (int i = 1; i < sz.length; i++) {
			int temp = sz[i];
			while (i > 0 && sz[i - 1] > temp) {
				//插入到当前
				sz[i] = sz[i-1];
				i--;
			}
			sz[i]=temp;
			System.out.println(Arrays.toString(sz));
		}
	}
}
