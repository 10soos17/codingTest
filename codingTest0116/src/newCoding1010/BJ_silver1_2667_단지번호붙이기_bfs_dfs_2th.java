package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/2667

ex.
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
*/
public class BJ_silver1_2667_단지번호붙이기_bfs_dfs_2th {
	
	static int[][] dist = new int[][] {{-1, 0},{0, 1}, {1, 0}, {0, -1}};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> answer = new ArrayList<>();
	static int cnt = 1;
	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt("" + s.charAt(j));
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					//dfs(i, j, map[i][j]);
					bfs(i, j);
					answer.add(cnt);
					cnt = 1;
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	static void dfs(int y, int x, int s) {
		visited[y][x] = true;
		for(int d = 0; d < 4; d++) {
			int dy = dist[d][0] + y;
			int dx = dist[d][1] + x;
			if(dy > N - 1 || dx > N - 1 || dy < 0 || dx < 0) continue;
			if(map[dy][dx] == 0 || map[dy][dx] != s ) continue;
			if(map[dy][dx] == s && !visited[dy][dx]) {
				visited[dy][dx] = true;
				cnt++;
				dfs(dy, dx, map[dy][dx]);
			}
		}
	}
	
	static void bfs(int y, int x) {
		visited[y][x] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x, map[y][x]});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			int t = tmp[2];
			for(int d = 0; d < 4; d++) {
				int dy = dist[d][0] + ty;
				int dx = dist[d][1] + tx;
				if(dy > N -1 || dx > N - 1 || dy < 0 || dx < 0) continue;
				if(map[dy][dx] == 0 || map[dy][dx] != t) continue;
				if(map[dy][dx] == t && !visited[dy][dx]) {
					visited[dy][dx] = true;
					cnt++;
					q.offer(new int[] {dy, dx, map[dy][dx]});
				}	
			}	
		}
	}
}