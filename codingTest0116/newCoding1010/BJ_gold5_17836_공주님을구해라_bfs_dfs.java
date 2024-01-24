package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/17836

ex.
6 6 16
0 0 0 0 1 1
0 0 0 0 0 2
1 1 1 0 1 0
0 0 0 0 0 0
0 1 1 1 1 1
0 0 0 0 0 0

10
*/
public class BJ_gold5_17836_공주님을구해라_bfs_dfs {
	
	static int[][] dist = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int M;
	static int T;
	static boolean[][] visited;
	static int[][] map;
	static boolean find = false;
	static int[] sword = new int[2];
	static int step = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}

		bfs(0, 0, 0);
		if(step == -1 || step > T) System.out.println("Fail");
		else System.out.println(step);
	}
	static void bfs(int y, int x, int dep) {
		visited = new boolean[N][M];		
		visited[y][x] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x, dep});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ty = tmp[0];
			int tx = tmp[1];
			int tDep = tmp[2];
			if(map[ty][tx] == 2) {
				find = true;
				visited = new boolean[N][M];
			}
			if(ty == N -1 && tx == M -1) {
				step = tDep;
				return;
			}
			for(int d = 0; d < 4; d++) {
				int dy = dist[d][0] + ty;
				int dx = dist[d][1] + tx;
				if(dy > N - 1 || dx > M - 1|| dy < 0 || dx < 0) continue;
				if(!visited[dy][dx]){
					if(!find) {
						if(map[dy][dx] != 1) {
							visited[dy][dx] = true;
							q.offer(new int[] {dy, dx, tDep+1});
						}
					}
					else if(find) {
						visited[dy][dx] = true;
						q.offer(new int[] {dy, dx, tDep+1});
					}
				}
			}
		}
		step = -1;
	}
}