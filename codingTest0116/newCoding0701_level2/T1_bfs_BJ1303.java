package newCoding0701_level2;

import java.io.*;
import java.util.*;

//문제
//전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다. 
//그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다. 
//문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
//
//N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가? 
//단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
//
//입력
//첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 
//그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다. 
//모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.
//
//출력
//첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
//5 5
//WBWWW
//WWWWW
//BBBBB
//BBBWW
//WWWWW
//
//130 65
public class T1_bfs_BJ1303 {
	static int M;
	static int N;
	static int B;
	static int W;
	static char[][] map;
	
	static boolean[][] visited;
	static int[] di = {-1, 0, 1, 0}; //상 우 하 좌 
	static int[] dj = {0, 1, 0, -1};
	static int cnt=1;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
					if(map[i][j] == 'W') W += (cnt * cnt);
					else B += (cnt * cnt);
					cnt=1;
				}
			}
		}
		System.out.println(W + " "+ B);
	}
	
	static void bfs(int y,int x) {
		
		visited[y][x] = true;
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {y,x});
		
		while(!queue.isEmpty()) {
			int[] c = queue.poll();
			int i = c[0];
			int j = c[1];
			
			for(int d=0;d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(ni < 0 || nj < 0 || ni > N-1 || nj > M-1) continue;
				if(!visited[ni][nj] && map[i][j] == map[ni][nj]) {
					queue.offer(new int[] {ni, nj});
					visited[ni][nj] = true;
					cnt++;
				}
			}
			
		}
		
		
	}
}
