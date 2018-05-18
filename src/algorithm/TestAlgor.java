package algorithm;

import java.util.Arrays;

public class TestAlgor {
	public static void main(String[] args) {
		int[] sz = { 3, 4, 7, 46, 7, 4, 567, 898, 6, 65, 5, 5, 454, 78, 7 };
		//bubble(sz);
		//choose(sz);
		//insert(sz);
		quick(sz,0,sz.length-1);
	}

	private static void quick(int[] sz, int L, int R) {
		int i=L;
		int j=R;
		int t=sz[(L+R)/2];
		while(i<=j){
			while(sz[i]<t){
				i++;
			}
			while(sz[j]>t){
				j--;
			}
			if(i<=j){
				int temp = sz[i];
				sz[i] = sz[j];
				sz[j] = temp;
				i++;///error
				j--;
			}
		}
		if(L<j){
			quick(sz,L,j);
		}
		if(i<R){
			quick(sz,i,R);
		}
		System.out.println(Arrays.toString(sz));
	}

	private static void insert(int[] sz) {
		for(int i=1;i<sz.length;i++){
			int temp = sz[i];
			while(i>0&&sz[i-1]>temp){
				sz[i] = sz[i-1];
				i--;
			}
			sz[i]=temp;
		}
		System.out.println(Arrays.toString(sz));
	}

	private static void choose(int[] sz) {
		int max = 0;
		for(int i = 0;i<sz.length-1;i++){
			max=0;
			for(int j =0;j<sz.length-i;j++ ){//error:sz.length-i-1
				if(sz[j]>sz[max])
					max=j;
			}
			int temp=sz[sz.length-i-1];
			sz[sz.length-i-1]=sz[max];
			sz[max]=temp;
		}
		System.out.println(Arrays.toString(sz));
	}

	public static void Bubble(int[] sz) {
		for (int i = 0; i < sz.length - 1; i++) {
			for (int j = 0; j < sz.length - i-1; j++) {
				if (sz[j] > sz[j + 1]) {
					int temp = sz[j];
					sz[j] = sz[j + 1];
					sz[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(sz));
	}
}
