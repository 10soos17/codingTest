package newCoding0821_HS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsAndBfs {

	static int N;
	static int[][]map;
	static int cnt;
	static List<Integer> answerList = new ArrayList<>();
	static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		visited = new boolean[N][N];

		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}

		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt = 0;
					//dfs(i,j);
					bfs(i,j);
					answerList.add(cnt);
				}

			}
		}

		Collections.sort(answerList);
		System.out.println(answerList.size());
		System.out.println(answerList);

	}
	static void bfs(int y,int x) {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {y,x});

		while(!q.isEmpty()) {

			int[]c = q.poll();
			int i = c[0];
			int j = c[1];


			for(int d=0;d<4;d++) {

				int ni = i + move[d][0];
				int nj = j + move[d][1];

				if(ni<0 || nj<0 || N-1 <ni || N-1 <nj ) continue;

				if(!visited[ni][nj] && map[ni][nj]==1) {
					visited[ni][nj] = true;
					cnt++;
					q.offer(new int[] {ni,nj});

				}

			}


		}


	}

	static void dfs(int i, int j){



		for(int d=0;d<4;d++) {

			int ni = i + move[d][0];
			int nj = j + move[d][1];

			if(ni<0 || nj<0 || N-1 <ni || N-1 <nj ) continue;

			if(!visited[ni][nj] && map[ni][nj]==1) {
				visited[ni][nj] = true;
				cnt++;
				dfs(ni,nj);

			}

		}


	}

}
