package newCoding0821_HS;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

	static int[][]board =  {{0,0,0},
							{0,1,0},
							{0,1,0},
							{0,0,0}};
	static int[] di = {-1,0,1,0};//상 우 하 좌 
	static int[] dj = {0,1,0,-1};
	static boolean[][]visited;
	static int answer = Integer.MAX_VALUE/2;
	
	static void bfs(int y, int x, int cnt) {
		
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {y,x,cnt});
		
		while(!queue.isEmpty()) {
			
			int[]c = queue.poll();
			
			int i = c[0];
			int j = c[1];
			int count = c[2];
			
			if(i==board.length-1 && j==board[0].length-1) {
				answer = Math.min(answer, count);
				return;
			}
			
			
			for(int d=0;d<4;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				
				if(ni < 0 || nj <0 || ni > board.length-1 || nj > board[0].length-1) continue;
				
				if(!visited[ni][nj] && board[ni][nj] == 0) {
					visited[ni][nj] = true;
					queue.offer(new int[] {ni,nj,count+1});
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
	
		bfs(0,0,0);
		
		System.out.print(answer);
	}
	

}