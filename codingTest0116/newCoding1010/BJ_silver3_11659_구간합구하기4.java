package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11659
5 3
5 4 3 2 1
1 3
2 4
5 5

출
12
9
1
*/
public class BJ_silver3_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] list = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<N+1;i++) {
			list[i] = list[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			
			
			int e = Integer.parseInt(st.nextToken());
			sb.append(list[e] - list[s-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
