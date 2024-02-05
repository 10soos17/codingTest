package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/14503
0123 북동남서 상우하좌
1.빈칸이면 청소
2.4방향 중 빈칸 o, -> 반시계 90 회전 -> 빈칸 o -> 전진
                            -> 빈칸 x -> 반시계 90회전 반복
  4방향 중 빈칸 x, -> 후진 가능 -> 한칸 후진
               -> 후진 불가능 -> stop
ex.
3 3
1 1 0
1 1 1
1 0 1
1 1 1

1
*/
public class BJ_gold5_14503_로봇청소기_bfs {
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};//상좌하우
	static int D;
	static int cnt = 0;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
	
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(Y,X);
		System.out.println(cnt);
	}
	static void bfs(int y, int x) {
		visited[y][x] = true;
		cnt++;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x, D});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			int nd = now[2];
			boolean flag = false;
			for(int d = nd; d < 4+nd; d++) {
				int dy = dir[d%4][0] + ny;
				int dx = dir[d%4][1] + nx;
				//D = d%4;
				if(dy > N-1 || dx > M-1 || dy < 0 || dx <0) continue;
				if(!visited[dy][dx]) {
					System.out.println("o:"+ d);
					//D +=1;
					//D %=4;
					visited[dy][dx] = true;
					if(map[dy][dx] == 0) {
						map[dy][dx] = -1;
						cnt++;
						flag = true;
						q.offer(new int[] {dy, dx, d} );
						break;
					}
				}
			}
			if(!flag) {
				System.out.println("x:"+ nd);
				if(nd == 0) ny += 1;
				if(nd == 2) ny -= 1;
				if(nd == 1) nx += 1;
				if(nd == 3) nx -= 1;
				if(ny > N-1 || nx > M-1||ny<0||nx < 0) return;
				if(map[ny][nx] == 1) return;
				else if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new int[] {ny, nx, nd});
				}
 			}
			
		}
	}
}