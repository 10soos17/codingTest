package coding07_algo41_50;

//깊이 우선 탐색 - DFS(Depth First Search)
//그래프 순회 방법 중 하나
// 시작 노드에서 깊이가 커지는 방향으로 탐색 진행
//-> 더 이상 방문할 인접 노드가 없는 경우 이전 노드로 돌아가서,
//-> 다시 깊이 우선 탐색을 반복




public class DFS66 {
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

		Visited[node] = true;
		System.out.println(node + " ");

		for(int next=0;next<N;++next) {
			if(!Visited[next] && Graph[node][next]!=0)
				solve(next);
		}
	}
}
