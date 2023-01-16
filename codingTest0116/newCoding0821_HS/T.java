package newCoding0821_HS;

import java.io.*;
import java.util.*;

public class T {
	
	static int target = 0;
	static int[] arr = {1,1,1,1};
	static boolean[] visited;
	static int len = arr.length;
	static int ans = 0;
	
	public static void main(String[] args){

		//subset(0, 0);
		comb(0,0,0,0);
		System.out.println(ans);
	}
	
	public static void subset(int dep, int sum) {
		if(dep == len) {
			if(sum == target) {
				ans++;
			}
			return;
		}
		subset(dep+1, sum+arr[dep]);
		subset(dep+1, sum-arr[dep]);
	}
	
	
	public static void comb(int start,int dep, int sum,int sum2) {
		 Byte a = 5;
		if(dep == len) {
			if(sum == target ) {
				ans++;
			}
			if(sum2 == target) {
				ans++;
			}
		}
		
		for(int i=start;i<arr.length;i++) {
			int summ = sum + arr[i];
			int summ2 = sum2 - arr[i];
			comb(i, dep+1, summ, summ2);
		}
		
	}
}
