package coding07_algo41_50;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//너비 우선 탐색 - BFS(Breadth First Search)
//그래프 순회 방법 중 하나 
// 시작 노드에서 인접 노드를 모두 방문 
//-> 방문한 노드에서 인접 노드를 모두 방문  
//-> 다시 반복




public class BFS77 {
	static final int MAX_N = 10;
	static int N, E;
	static int [][] Graph = new int[MAX_N][MAX_N];
	static boolean[] Visited = new boolean[MAX_N];

	public static void main(String[] args) {
		//5(노드),6(간선) 
		//01 02 13 14 24 34
		N=5;
		E=6;
		
		Graph [0][1] = Graph[1][0]=1;
		Graph [0][2] = Graph[2][0]=1;
		Graph [1][3] = Graph[3][1]=1;
		Graph [1][4] = Graph[4][1]=1;
		Graph [2][4] = Graph[4][2]=1;
		Graph [3][4] = Graph[4][3]=1;
		
		solve(0);

	}

	public static void solve(int node) {

		Queue <Integer> myqueue = new LinkedList<>();
		Visited[node] = true;
		myqueue.add(node);
		
		
		while(!myqueue.isEmpty()) {
			int curr = myqueue.remove();
			
			System.out.println(curr + " ");
			
			for(int next=0;next<N;++next) {
				if(!Visited[next] && Graph[curr][next]!=0) {
					Visited[next] = true;
					myqueue.add(next);
					
				}
			}
		}
		
	}
}
