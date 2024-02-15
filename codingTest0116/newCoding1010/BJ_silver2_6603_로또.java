package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//{1, 2, ..., 49}에서 수 6개
//집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램

//입력은 여러 개의 테스트 케이스
//각 테스트 케이스는 한 줄
//첫 번째 수는 k (6 < k < 13)
//다음 k개 수는 집합 S에 포함되는 수 
//S의 원소는 오름차순
//입력의 마지막 줄에는 0이 하나

//각 테스트 케이스마다 수를 고르는 모든 방법을 사전 순으로 출력
//각 테스트 케이스 사이에는 빈 줄을 하나 출력
/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
*/
public class BJ_silver2_6603_로또 {

	static int[] arr;
	static int[] answer = new int[6];
	static int cnt = 6;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				System.out.println(sb.toString());
				break;
			}
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			sb.append("\n");
		}
	}

	public static void comb(int dep, int start) {
		if (dep == cnt) {
			// System.out.println(Arrays.toString(answer));
			for (int i = 0; i < 6; i++) {
				// System.out.print(answer[i]+" ");
				sb.append(answer[i]).append(" ");
			}
			// System.out.print("\n");
			sb.append("\n");
			return;
		}
		for (int i = start; i < arr.length; i++) {
			answer[dep] = arr[i];
			comb(dep + 1, i + 1);
		}
	}
}
