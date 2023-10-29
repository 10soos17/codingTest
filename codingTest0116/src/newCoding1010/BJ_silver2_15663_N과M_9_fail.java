package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N개의 자연수 중에서 M개를 고른 수열
//고른 수열은 오름차순
//첫째 줄에 N과 M이(1 ≤ M ≤ N ≤ 8)
//둘째 줄에 N개의 수. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력
//각 수열은 공백으로 구분해서 출력
//수열은 사전 순으로 증가하는 순서로 출력
/*
3 1
4 4 2
*/
public class BJ_silver2_15663_N과M_9_fail {

	static int arr[];
	static int answer[];
	static boolean visited[];
	static int cnt[] = new int[10001];
	static int N;
	static int M;
	static int NUM;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[M];
		visited = new boolean[N];
		NUM = N;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(cnt[arr[i]] < M) cnt[arr[i]]++;
			if(i != 0) NUM *= i;
		}
		Arrays.sort(arr);
		permu(0);
		//combi(0,0);
		System.out.println(sb.toString());
	}
	
	public static void permu(int dep) {
		if (dep == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		for (int i = 0; i < N; i++) {
			//if(i != 0) {
			//	if(arr[i] == arr[i-1]) continue;
			//}
			if(!visited[i]) {
				visited[i] = true;
				if(cnt[arr[i]] > N - NUM) {
					answer[dep] = arr[i];
					cnt[arr[i]]--;
				}
				permu(dep + 1);
				visited[i] = false;
			}

		}
	}
	/*
	public static void combi(int dep, int start) {
		if (dep == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			answer[dep] = arr[i];
			combi(dep + 1, i+1);

		}
	}*/
}
