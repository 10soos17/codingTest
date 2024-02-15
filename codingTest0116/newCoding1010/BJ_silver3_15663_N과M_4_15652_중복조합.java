package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도
//고른 수열은 비내림차순
//첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력
//중복되는 수열을 여러 번 출력하면 안됨
//각 수열은 공백으로 구분해서 출력
//수열은 사전 순으로 증가하는 순서로 출력
/* 
3 3

1 1 1
1 1 2
1 1 3
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
*/
public class BJ_silver3_15663_N과M_4_15652_중복조합 {

	static int N;
	static int M;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		System.out.println(N);
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		comb(0, 1);
		System.out.println(sb.toString());
	}
	static void comb(int dep, int start) {
		if(dep == M) {
			for(int i = 1; i < M + 1; i++) {
				sb.append(arr[i-1]);
				if(i != M + 1) sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < M + 1; i++) {
			arr[dep] = i;
			comb(dep + 1, i);
		}
	}

}
