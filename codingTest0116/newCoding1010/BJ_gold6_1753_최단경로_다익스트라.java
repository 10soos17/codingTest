package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 
 https://www.acmicpc.net/problem/1753
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로.
단, 모든 간선의 가중치는 10 이하의 자연수.
첫째 줄에 정점의 개수 V와 간선의 개수 E(1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 
모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정.
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w).
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻.
u와 v는 서로 다르며 w는 10 이하의 자연수.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음.
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력. 
시작점 자신은 0으로 출력, 경로가 존재하지 않는 경우 INF를 출력.

ex.
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
public class BJ_gold6_1753_최단경로_다익스트라 {

	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			// TODO Auto-generated constructor stub
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Node>> list = new ArrayList<>();
		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		int start = Integer.parseInt(br.readLine());
		int INF = 987654321;
		for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b,w));
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			for(Node next : list.get(now.to)) {
				if(dist[next.to] > dist[now.to] + next.weight) {
					dist[next.to] = dist[now.to] + next.weight;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N + 1; i++) sb.append(dist[i] == INF ? "INF\n" : dist[i] + "\n");
		System.out.println(sb.toString());
		

	}

}
