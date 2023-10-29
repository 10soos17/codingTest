package newCoding0821_HS;

public class DFS {

	static int[][]board =  {{0,0,0},
							{0,1,0},
							{0,1,0},
							{0,0,0}};
	static int[] di = {-1,0,1,0};//상 우 하 좌
	static int[] dj = {0,1,0,-1};
	static boolean[][]visited;
	static int answer = Integer.MAX_VALUE/2;

	static void dfs(int i, int j,int cnt) {

		//visited[i][j] = true;

		if(i == board.length-1 && j == board[0].length-1) {
			answer = Math.min(answer, cnt);
			return;
		}

		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];

			if(ni <0 || nj<0 || ni > board.length-1 || nj > board[0].length-1) continue;

			if(!visited[ni][nj] && board[ni][nj] == 0) {
				visited[ni][nj] = true;
				dfs(ni,nj,cnt+1);
			}

		}

	}

	public static void main(String[] args) {

		visited = new boolean[board.length][board[0].length];

		dfs(0,0,0);

		System.out.print(answer);

	}


}