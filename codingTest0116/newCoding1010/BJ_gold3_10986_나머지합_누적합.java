package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/10986
5 3
1 2 3 1 2   
출
7

3 5
4 0 5
0 4 4 9
  4 4 4

1 S(누적합)
2 M(누적합나머지배열) -> 나누어떨어지면 ans++ && C(나머지카운트배열)
3 for C 2개이상일 경우만 조합 계산 -> ans++

*/
public class BJ_gold3_10986_나머지합_누적합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long sum = 0;
		long[] ML = new long[N + 1];
		long[] cnt = new long[M];
		long ans = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N+1; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum = sum + n;
			ML[i] = sum % M;
			if (ML[i] == 0)
				ans++;
			cnt[(int)ML[i]] += 1;
		}
		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1) {
				ans += ((cnt[i] * (cnt[i] - 1)) / 2);
			}
		}
		System.out.println(ans);
	}
}
