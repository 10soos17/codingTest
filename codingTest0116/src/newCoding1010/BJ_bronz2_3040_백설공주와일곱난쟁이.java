package newCoding1010;


import java.io.BufferedReader;
import java.io.InputStreamReader;

// 100이 되는 일곱 개의 수 
//총 아홉개 줄에 1보다 크거나 같고 99보다 작거나 같은 자연수가 주어진다.
//모든 숫자는 서로 다르다. 또, 항상 답이 유일한 경우만 입력으로 주어진다.
//일곱 난쟁이가 쓴 모자에 쓰여 있는 수를 한 줄에 하나씩 출력한다.
/*
7
8
10
13
15
19
20
23
25
 */
public class BJ_bronz2_3040_백설공주와일곱난쟁이 {

	static int[] arr = new int[9];
	static int N = 9;
	static int[] answer = new int[7];
	static int sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			// sum += arr[i];
		}
		// sum -= 100;
		comb(0, 0, 0);
		System.out.println(sb.toString());
	}

	static void comb(int dep, int start, int sum) {
		if (dep == 7) {
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(answer[i]);
					if (i != 7)
						sb.append("\n");
				}
				sum = 100;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			int newSum = sum + arr[i];
			answer[dep] = arr[i];
			comb(dep + 1, i + 1, newSum);
		}

	}
}

/*
 import java.io.*;
import java.util.*;

public class Main {

	static int[] arr = new int[9];
	static int[] answer = new int[2];
	static boolean[] visited = new boolean[9];
	static int sum;
	static boolean res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sum -= 100;
		comb(0, 0);

	}

	public static void comb(int dep, int start) {
		
		if(res) return;;
		
		if (dep == 2) {
			if (sum == answer[0] + answer[1]) {
				
				for (int i = 0; i < 9; i++) {
					if(arr[i] == answer[0] || arr[i] == answer[1]) continue;
					System.out.println(arr[i]);
				}
				res = true;
				return;
			} 
			return;
		}
		for (int i = start; i < 9; i++) {
			answer[dep] = arr[i];
			comb(dep + 1, i + 1);
		}
	}
}

 */
