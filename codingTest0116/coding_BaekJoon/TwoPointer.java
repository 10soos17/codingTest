package coding_BaekJoon;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=U0TXIFiCIu0&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=7
//https://www.acmicpc.net/problem/2559

//아이디어
/*
10 2
3 -2 -4 -9 0 3 7 13 8 -3
 */

public class TwoPointer {

	public static void main(String[] args) {

		int m = 10;
		int n = 5;
		int arr[] = { 3, -2, -4, -9, 0, 3, 7, 13, 8, -3 };
		solution(n, arr);
		solution2(n, arr);
	}

	// 1
	public static void solution(int n, int[] arr) {
		int p1 = 0;
		// int p2=0;
		int sum = 0;
		int max = 0;
		int cnt = 0;
		for (int i = p1; i < arr.length - n; i++)
			for (int j = p1; j < arr.length - n; j++) {
				while (cnt < n) {
					sum += arr[j + cnt];
					cnt += 1;
					// System.out.println("3;"+max);
				}
				max = Math.max(max, sum);
				cnt = 0;
				sum = 0;
			}
		p1 += 1;
		System.out.println(max);
	}

	// 2
	public static void solution2(int n, int[] arr) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		max = sum;

		for (int i = n; i < arr.length; i++) {
			sum += arr[i];
			sum -= arr[i - n];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
