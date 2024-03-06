package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/16946
문제
맵에서 0은 이동, 1은 벽이 있는 곳을 나타낸다.두 칸이 변을 공유할 때, 인접하다고 한다.

해당 칸이,
벽이면, 벽을 부수고 이동할 수 있는 곳으로 변경한다.
그 위치에서 이동할 수 있는 칸의 개수를 세어본다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.

출력
맵의 형태로 정답을 출력한다. 
원래 빈 칸인 곳은 0을 출력하고, 
벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.
ex.
3 3
101
010
101

303
050
303
=========
4 5
11001
00111
01010
10101

46003
00732
06040
50403
*/
public class BJ_gold2_16946_벽부수고이동하기4_bfs_dfs {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] count;
	static int[][] dist = {{-1,0},{0,1},{1,0},{0,-1}};
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		/*
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int now = map[i][j]; 
				if(now == 0) {
					System.out.print(0);
					continue;
				}
				int cnt = bfs2(i, j);
				cnt = cnt % 10;
				System.out.print(cnt);
			}
			System.out.println();
		}*/
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(1, 0);
		int idx = 2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int now = map[i][j];
				if(now == 0) {
					//System.out.print(0);
					count[i][j] = 1;
					continue;
				}
				if(now == 1) {
					count[i][j] = idx;
				}
				if(!visited[i][j]&& map[i][j] == 1) {
					cnt  += bfs(i, j, idx);
					count[i][j] = idx;
					sumMap.put(idx, cnt);
					idx++;
					//System.out.print(cnt%10);
				};
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(sumMap.get(count[i][j]));
			}
			System.out.println();
		}
	}
	static int bfs(int y, int x, int idx) {
		visited[y][x] = true;
		map[y][x] = idx;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			for(int d=0; d<4;d++) {
				int dy = ny + dist[d][0];
				int dx = nx + dist[d][1];
				if(dy > N-1 || dx > M-1 || dy < 0 || dx < 0) continue;
				if(!visited[dy][dx] && map[dy][dx] == 0) {
					cnt++;
					visited[dy][dx] = true;
					q.offer(new int[] {dy, dx});
				}
			}
		}
		return cnt;
	}
	
	
	static int bfs2(int y, int x) {
		int cnt = 0;
		visited = new boolean[N][M];
	    visited[y][x] = true;
	    if(map[y][x] == 1)cnt++;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			for(int d=0; d<4;d++) {
				int dy = ny + dist[d][0];
				int dx = nx + dist[d][1];
				if(dy > N-1 || dx > M-1 || dy < 0 || dx < 0) continue;
				if(!visited[dy][dx] && map[dy][dx] == 0) {
					visited[dy][dx] = true;
					cnt++;
					q.offer(new int[] {dy, dx});
				}
			}
		}
		return cnt;
	}
	
}