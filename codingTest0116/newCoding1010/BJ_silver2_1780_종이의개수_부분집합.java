package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
*/
public class BJ_silver2_1780_종이의개수_부분집합 {
	
	static int N;
	static int[][] map;
	static int[] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[3];
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, map[0][0], N);	
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
	}
	static void dfs(int y, int x, int v, int size) {
		boolean flag = true;
		
		OUTLOOP:
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(map[i][j] != v) {
					flag = false;
					break OUTLOOP;
				}
			}
		}
		if(flag) {
			answer[v+1]++;
			return;
		}
		
		dfs(y, x, map[y][x], size/3);
		dfs(y, x + size/3, map[y][x + size/3], size/3);
		dfs(y, x + (size * 2)/3, map[y][x  + (size * 2)/3], size/3);
		
		dfs(y + size/3, x, map[y + size/3][x], size/3);
		dfs(y + size/3, x + size/3, map[y + size/3][x + size/3], size/3);
		dfs(y + size/3, x + (size * 2)/3, map[y + size/3][x + (size * 2)/3], size/3);
		
		dfs(y  + (size * 2)/3, x, map[y + (size * 2)/3][x], size/3);
		dfs(y  + (size * 2)/3, x + size/3, map[y + (size * 2)/3][x + size/3], size/3);
		dfs(y  + (size * 2)/3, x + (size * 2)/3, map[y + (size * 2)/3][x + (size * 2)/3], size/3);
	}
}



