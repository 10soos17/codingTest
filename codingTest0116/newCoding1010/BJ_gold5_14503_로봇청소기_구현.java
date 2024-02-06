package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/14503
0123 북동남서 상우하좌 -> 받을때 -
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
public class BJ_gold5_14503_로봇청소기_구현 {
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };// 상좌하우 +1일때 반시계
	static int[][] map;
	static int cnt = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = (4 - Integer.parseInt(st.nextToken())) % 4;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] next = solution(y, x, d);
		while(true){
			if(next.length == 0)break;
			next = solution(next[0],next[1],next[2]);
		}
		System.out.println(cnt);
	}

	static int[] solution(int y, int x, int d) {
		// 1번
		if (map[y][x] == 0) {
			map[y][x] = -1;
			cnt++;
		}
		int nextD = (d + 1) % 4;
		// 2번
		for (int newD = nextD; newD < 4 + nextD; newD++) {
			int dy = dir[newD % 4][0] + y;
			int dx = dir[newD % 4][1] + x;
			if (dy > N - 1 || dx > M - 1 || dy < 0 || dx < 0) continue; //*******
			if (map[dy][dx] == 0) {
				map[dy][dx] = -1;
				cnt++;
				return new int[] { dy, dx, newD%4};
			}
		}
		// 3번
		if (d == 0) y += 1;
		if (d == 2) y -= 1;
		if (d == 1) x += 1;
		if (d == 3) x -= 1;
		if (y > N - 1 || x > M - 1 || y < 0 || x < 0) return new int[] {}; //*******
		if (map[y][x] == 1) return new int[] {};
		else return new int[] { y, x, d};
	}
}