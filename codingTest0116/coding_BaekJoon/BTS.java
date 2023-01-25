package coding_BaekJoon;

import java.util.Arrays;

//https://www.youtube.com/watch?v=D1ad7UCbWHY&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=8
//https://www.acmicpc.net/problem/1920

//아이디어
/*
5
4 1 5 2 3
5
1 3 7 9 5
 */

public class BTS {
	static int m;
	static int n;
	static int[] arr = new int[] {};
	static int[] arr2 = new int[] {};
	public static void main(String[] args) {

		m =5;
		arr = new int[]{ 4, 1, 5, 2, 3};
		n =5;
		arr2 = new int[]{ 1, 3, 7, 9, 5};
		solution();
	}

	public static void bts(int start, int end, int target) {

		if(start==end) {
			if(arr[start] == target) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			return;
		}

		int mid=(start+end)/2;

		if(arr[mid] < target) {
			bts(mid+1,end,target);
		}else {
			bts(start,mid,target);
		}

	}

	public static void solution() {
		Arrays.sort(arr);
		for(int i:arr2) {
			bts(0,n-1,i);
		}

	}
}
