package coding_BaekJoon;

import java.util.Arrays;

//https://www.youtube.com/watch?v=D1ad7UCbWHY&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=9
//https://www.acmicpc.net/problem/11047

//아이디어
/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */

public class Greedy {

	public static void main(String[] args) {

		int n = 10;
		int m = 4200;
		int[] arr = { 1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000 };

		solution(n, m, arr);
	}

	public static void solution(int n, int m, int[] arr) {
		int cnt = 0;

		Arrays.sort(arr);


		for (int i = arr.length-1; i >= 0; i--) {
			cnt += m / arr[i];
			m %= arr[i];

		}

		System.out.println(cnt);

	}
}
