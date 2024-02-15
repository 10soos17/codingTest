package newCoding1010;
import java.util.*;
import java.io.*;
/* 
https://www.acmicpc.net/problem/1012
차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 
한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 
이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 
그 배추들 역시 해충으로부터 보호받을 수 있다. 
한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.

한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다. 
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 
서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. 
예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다. 

0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.

입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 
배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그
 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 
 두 배추의 위치가 같은 경우는 없다.

각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.
ex.
입
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
출력
5
1
*/
public class BJ_silver2__1012_유기농배추_bfs_dfs2 {
		static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
		static int[][] arr;
		static int N;
		static int M;
		static int T;
		static boolean[][] visited;
		static int sum;
		static StringBuilder sb = new StringBuilder();
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int CNT = Integer.parseInt(br.readLine());
			for(int i = 0; i < CNT; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());		
				arr = new int[N][M];
				visited = new boolean[N][M];
				sum = 0;
				for(int j = 0; j < T; j++) {
					st = new StringTokenizer(br.readLine(), " ");
					arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				}
				for(int k = 0; k < N; k++){
					for(int l = 0; l < M; l++) {
						if(arr[k][l] == 1 && !visited[k][l]) {
							sum +=(bfs(k, l));
						}
					}
				}
				sb.append(sum).append('\n');
			}
			System.out.println(sb.toString());
		}
		static int bfs(int y, int x) {
			visited[y][x] = true;
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {y, x});
			
			while(!q.isEmpty()) {
				int[] c = q.poll();
				int ci = c[0];
				int cj = c[1];
				for(int i = 0; i < 4; i++) {
					int di = ci + dir[i][0];
					int dj = cj + dir[i][1];
					
					if(di < 0 || dj < 0 || di > N-1 || dj > M-1) continue; 
					if(!visited[di][dj] && arr[di][dj] == 1) {
						visited[di][dj] = true;
						bfs(di, dj);
					}
				}
			}
			return 1;
			
		}
}

























