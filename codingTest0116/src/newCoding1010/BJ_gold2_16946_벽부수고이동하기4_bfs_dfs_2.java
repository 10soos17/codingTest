package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

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
public class BJ_gold2_16946_벽부수고이동하기4_bfs_dfs_2 {

	static int[][] dist = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int M;
	static int[][] map;
	static int[][] count;
	static boolean[][] visited;
	static Map<Integer, Integer> sumMap = new HashMap<>();
	static int CNT;
	static int IDX;
	static StringBuilder sb = new StringBuilder();
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
				map[i][j] = count[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		sumMap.put(1, 0);
		IDX = 2;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					CNT = 1;
					count[i][j] = IDX;
					bfs(i, j);
					sumMap.put(IDX, CNT);
					IDX++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) sb.append(0);
				else if(map[i][j] == 1) sb.append(getSum(i, j));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	static int getSum(int y, int x) {
		int sum = 1;
		Set<Integer> set = new HashSet<>();
		for(int d=0; d<4;d++) {
			int dy = y + dist[d][0];
			int dx = x + dist[d][1];
			if(dy > N-1 || dx > M-1 || dy < 0 || dx < 0) continue;
			if(count[dy][dx] > 1) {
				set.add(count[dy][dx]);
			}
		}
		for(int num : set) sum+=sumMap.get(num);
		sum = sum%10;
		return sum;
	}
	static void bfs(int y, int x) {
	    visited[y][x] = true;
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
				if(!visited[dy][dx] && count[dy][dx] == 0) {
					visited[dy][dx] = true;
					count[dy][dx] = IDX;
					q.offer(new int[] {dy, dx});
					CNT++;
				}
			}
		}
	}
}