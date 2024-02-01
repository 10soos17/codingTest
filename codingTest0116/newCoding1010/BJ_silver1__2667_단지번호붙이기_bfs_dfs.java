package newCoding1010;
import java.util.*;
import java.io.*;
/* 
https://www.acmicpc.net/problem/2667
<그림 1>과 같이 정사각형 모양의 지도가 있다. 
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고,단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
대각선상에 집이 있는 경우는 연결된 것이 아니다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

ex.
입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
출력
3
7
8
9
*/
public class BJ_silver1__2667_단지번호붙이기_bfs_dfs {

	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N;
	static int map[][];
	static boolean visited[][];
	static List<Integer> answer = new ArrayList<>();
	static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					sum = 1;
					bfs(i, j);
					//sum = bfs2(i, j);
					//sum = bfs3(i, j);
					answer.add(sum);
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int i : answer) System.out.println(i);
	}
	// o - 개수 밖에서 세기(gloabal변수)
	static void bfs(int y, int x) {
		visited[y][x] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{y, x});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];

			for(int d = 0; d < 4; d++) {
				int dy = dir[d][0] + ny;
				int dx = dir[d][1] + nx;
				if(dy > N -1 || dx > N-1||dy<0||dx<0)continue;
				if(!visited[dy][dx] && map[dy][dx] == 1) {
					visited[dy][dx] = true;
					sum++;
					q.offer(new int[] {dy, dx});
				}
			}
		}
	}	
	// o - 개수 밖에서 세기(지역변수)
	static int bfs2(int y, int x) {
		visited[y][x] = true;
		int cnt=1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{y, x});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];

			for(int d = 0; d < 4; d++) {
				int dy = dir[d][0] + ny;
				int dx = dir[d][1] + nx;
				if(dy > N -1 || dx > N-1||dy<0||dx<0)continue;
				if(!visited[dy][dx] && map[dy][dx] == 1) {
					visited[dy][dx] = true;
					cnt++;
					q.offer(new int[] {dy, dx});
				}
			}
		}
		return cnt;
	}
	// x - q에 개수 넘겨서 세면 안됨 
	static int bfs3(int y, int x) {
		visited[y][x] = true;
		int cnt=1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{y, x, cnt});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int ny = now[0];
			int nx = now[1];
			int dCnt = now[2];
			//System.out.println("");
			for(int d = 0; d < 4; d++) {
				int dy = dir[d][0] + ny;
				int dx = dir[d][1] + nx;
				if(dy > N -1 || dx > N-1||dy<0||dx<0)continue;
				if(!visited[dy][dx] && map[dy][dx] == 1) {
					visited[dy][dx] = true;
					cnt= dCnt+1;
					q.offer(new int[] {dy, dx, dCnt+1});
				}
			}
		}
		return cnt;
	}	
}