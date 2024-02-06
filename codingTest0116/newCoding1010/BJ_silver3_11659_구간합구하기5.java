package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/11660
4 3
1 2 3 4
2 3 4 5
3 4 5 6 
4 5 6 7
          
2 2 3 4
3 4 3 4
1 1 4 4

출
27
6
64
*/
public class BJ_silver3_11659_구간합구하기5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] list = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<N+1;j++) {
				int n = Integer.parseInt(st.nextToken());
				list[i][j] = list[i-1][j] + list[i][j-1] - list[i-1][j-1] + n;

			}
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int n = list[ex][ey] + list[sx-1][sy-1] - list[sx-1][ey] - list[ex][sy-1];
			sb.append(n).append("\n");
		}
		System.out.println(sb.toString());
	}
}
