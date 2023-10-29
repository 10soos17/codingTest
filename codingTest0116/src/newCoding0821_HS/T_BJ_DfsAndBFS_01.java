package newCoding0821_HS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class T_BJ_DfsAndBFS_01 {

	static int[][] board;
	static int len;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static List<Integer> answer;
	static int cnt;

	public static void dfs(int i, int j) {

		cnt++;

		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni < 0 || nj < 0 || ni > len - 1 || nj > len - 1)
				continue;

			if (!visited[ni][nj] && board[ni][nj] != 0) {
				dfs(ni, nj);
			}
		}

	}

	public static void bfs(int y, int x) {

		visited[y][x] =true;
		cnt++;

		Queue<int[]> queue = new ArrayDeque<>();
		//Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {y,x});

		while(!queue.isEmpty()) {

			int[] c = queue.poll();
			int i = c[0];
			int j = c[1];

			for(int d=0; d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];

				if (ni < 0 || nj < 0 || ni > len - 1 || nj > len - 1) continue;
				if (!visited[ni][nj] && board[ni][nj] != 0) {
					visited[ni][nj] = true;
					cnt++;
					queue.offer(new int[] {ni,nj});
				}
			}


		}


	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		board = new int[len][len];
		answer = new ArrayList<>();
		visited = new boolean[len][len];

		for (int i = 0; i < len; i++) {
			String str = sc.next();
			for (int j = 0; j < len; j++) {
				board[i][j] = str.charAt(j) - '0';
			}

		}

		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(board[i][j]==1&&!visited[i][j]) {
					cnt = 0;
					//dfs(i,j);
					bfs(i,j);
					answer.add(cnt);
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for (Integer element : answer)
			System.out.println(element);

	}

}