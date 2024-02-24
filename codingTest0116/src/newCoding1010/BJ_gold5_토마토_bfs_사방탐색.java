package newCoding1010;

import java.io.*;
import java.util.*;
/* 
https://www.acmicpc.net/problem/7576
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 
토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

8
*/
public class BJ_gold5_토마토_bfs_사방탐색 {

	static int[][] dir = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};
	static int N;
	static int M;
	static int[][] map;
	static Queue<int[]> tomato = new ArrayDeque<>();
	static boolean[][] visited;
	static int cnt;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = M * N;
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) cnt--;
				if(map[i][j] == 1) tomato.offer(new int[]{i, j});
			}
		}
		if(cnt  == 0) System.out.println(0); //모두익음
		else {
			answer = bfs();
			System.out.println(answer);
		}
	}
	
	static int bfs() {
		while(!tomato.isEmpty()) {
			int len = tomato.size();
			if(cnt != 0) answer++;
			for(int i = 0; i < len; i++) {
				int[] now = tomato.poll();
				int y = now[0];
				int x = now[1];
				if(!visited[y][x]) visited[y][x] = true;
				if(cnt == 0) return answer;
				
				for(int d = 0; d < 4; d++) {
					int dy = y + dir[d][0];
					int dx = x + dir[d][1];
					if(dy > N - 1 || dx > M - 1 || dy < 0 || dx < 0) continue;
					if(!visited[dy][dx] && map[dy][dx] == 0) {
						cnt--;
						map[dy][dx] = 1;
						tomato.offer(new int[] {dy, dx});
					}
				}
			}
		}
		return -1;
	}
}
