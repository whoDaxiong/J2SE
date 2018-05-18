package com.algorithm;

import java.util.Arrays;

public class redix {
	public static void main(String[] args) {
		int[] arrays = { 34, 6, 3, 43, 27, 86, 234, 23, 5687, 5, 34 };
		redix(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	private static void redix(int[] arrays) {
		int max = findMax(arrays);
		for (int i = 1; max / i > 0; i *= 10) {
			int[][] buckets = new int[arrays.length][10];

			// 获取每一位数字然后放入桶中
			for (int j = 0; j < arrays.length; j++) {
				//取出个位十位百位...
				int num = (arrays[j]/i)%10;
				//放入桶中
				buckets[j][num] = arrays[j];
			}
			
			//回收桶中元素
			int k=0;
			//有十个桶
			for(int j=0;j<10;j++){
				//对每个桶中元素进行回收
				for(int l=0;l<arrays.length;l++){
					//如果桶中有元素就回收
					if(buckets[l][j]!=0){
						arrays[k++] = buckets[l][j];
					}
				}
			}
		}
	}

	private static int findMax(int[] arrays) {
		int max = arrays[0];
		for (int i : arrays) {
			if (i > max)
				max = i;
		}
		return max;
	}
}
