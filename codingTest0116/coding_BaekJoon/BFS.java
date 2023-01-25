package coding_BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/1926
public class BFS {
	static int m;
	static int n;

	public static void main(String[] args) {

		n = 6;//세로크기 = row = y
		m = 5;//가로크기 = col = x

		int[][] list = {
				{ 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 1, 1 },
				{ 0, 0, 1, 1, 1 },
				{ 0, 0, 1, 1, 1 }
				};
		solution(n,m, list);

	}

	public static int bfs(int y, int x, int[][] list, boolean[][] check) {
		int rs = 1;
		int ny;
		int nx;
		int[] dy = { 0, 1, 0, -1 }; // 오른쪽,아래쪽,왼쪽, 위쪽
		int[] dx = { 1, 0, -1, 0 };

		Queue<ArrayList<Integer>> q = new LinkedList<>();
		ArrayList<Integer> e = new ArrayList<>();

		e.add(y);
		e.add(x);
		q.add(e);

		while (q.size() > 0) {
			e = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = e.get(0) + dy[i];
				nx = e.get(1) + dx[i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m) {
					if (list[ny][nx] == 1 && !check[ny][nx]) {
						rs += 1;
						check[ny][nx] = true;

						e.add(ny);
						e.add(nx);
						q.add(e);
					}
				}
			}

		}
		return rs;
	}

	public static void solution(int n, int m, int[][] list) {

		boolean[][] check = new boolean[n][m];
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (list[i][j] == 1 && !check[i][j]) {
					check[i][j] = true;
					cnt += 1;
					max = Math.max(max, bfs(j, i, list, check));
					// 전체 그림 갯수를 +1
					// BFS > 그림 크기를 구해주고
					// 최대값 갱신
				}
				System.out.print(check[i][j]);
			}
			System.out.println();
		}

		System.out.println(cnt);
		System.out.println(max);
	}

}
