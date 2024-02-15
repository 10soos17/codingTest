package newCoding1010;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* 
https://school.programmers.co.kr/learn/courses/30/lessons/250136
land	result
[[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]	9
[[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]	16

0이면 빈 땅을, 1이면 석유
*/
public class Programmers_석유시추_bfs {
	static int[][] land;
	static int[][] dist = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<int[]> list = new ArrayList<>(); // 열s, 열e, 면적
	static boolean[][] visited;
	static int s;
	static int e;
	static int cnt = 0;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {

		//land = new int[][] { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
		//		{ 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } };
		land = new int[][] {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, 
			{1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, 
			{1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
		int answer = solution(land);
		System.out.println(answer);
	}
	public static int solution(int[][] land) {
		int answer = 0;
		N = land.length;
		M = land[0].length;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					list.add(new int[] { s, e, cnt });
				}
			}
		}
		for (int i = 0; i < M; i++) {
			int sum = 0;
			for (int[] n : list) {
				int s = n[0];
				int e = n[1];
				int nSum = n[2];
				if (s <= i && e >= i)sum += nSum;
			}
			answer = Math.max(answer, sum);
		}
		return answer;
	}
	static void bfs(int y, int x) {
		visited[y][x] = true;
		s = 987654321;
		e = -1;
		s = Math.min(s, x);
		e = Math.max(e, x);
		cnt = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			for (int d = 0; d < 4; d++) {
				int dy = dist[d][0] + ny;
				int dx = dist[d][1] + nx;
				if (dy > N - 1 || dx > M - 1 || dy < 0 || dx < 0) continue;
				if (land[dy][dx] == 1 && !visited[dy][dx]) {
					s = Math.min(s, dx);
					e = Math.max(e, dx);
					cnt++;
					visited[dy][dx] = true;
					q.offer(new int[] { dy, dx });
				}
			}
		}
	}
}
