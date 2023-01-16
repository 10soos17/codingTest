package coding07_algo41_50;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//너비 우선 탐색 - BFS(Breadth First Search)
//그래프 순회 방법 중 하나 
// 시작 노드에서 인접 노드를 모두 방문 
//-> 방문한 노드에서 인접 노드를 모두 방문  
//-> 다시 반복

public class BFS_shortestPath88 {
	static final int MAX_N = 5;
	static int [][] D = {{-1,0},{1,0}, {0,-1},{0,1}};
	static int N;
	static int [][] Board;
	
	static boolean[] Visited = new boolean[MAX_N];

	static class Point{
		Point(int r, int c, int d) {
			row =r;
			col=c;
			dist=d;
		}
		int row, col, dist;
	}
	
	public static void main(String[] args) {

		int sr,sc,dr,dc;
		sr=0;
		sc=1;
		dr=4;
		dc=2;
		
		int [][] Board = {
			{0,0,0,0,0},
			{0,1,1,1,1},
			{0,0,0,0,0},
			{1,1,1,1,0},
			{0,0,0,0,0}
	};
		solve(sr,sc,dr,dc);

	}

	public static int solve(int sr,int sc,int dr,int dc) {

		boolean[][] visited = new boolean[MAX_N][MAX_N];
		Queue<Point> myqueue = new LinkedList<>();
		visited[sr][sc] = true;
		myqueue.add(new Point(sr,sc,0));
		
		while(!myqueue.isEmpty()) {
			Point curr = myqueue.remove();
			if(curr.row == dr && curr.col == dc) {
				return curr.dist;
			}
			for(int i=0;i<4;++i) {
				int nr = curr.row + D[i][0];
				int nc = curr.col + D[i][1];
				
				if(nr<0 || nr > N-1 || nc < 0|| nc > N-1)continue;
				if(visited[nr][nc]) continue;
				if(Board[nr][nc] == 1)continue;
				visited[nr][nc] = true;
				myqueue.add(new Point(nr, nc, curr.dist+1));
						
			}
		}
		return 1;
		 
	}
}
