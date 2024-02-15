package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 
https://www.acmicpc.net/problem/1504
방향성이 없는 그래프.
세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동
임의로 주어진 두 정점은 반드시 통과
한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동 가능. 
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의

입력
첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 
둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, 
a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 
다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1) 
임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.

출력
첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력

ex.
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

7
*/
public class BJ_gold4_1504_특정한최단경로_다익스트라 {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	// 1 - v1
	// 1 - v2
	// v1 - v2
	// v1 - N
	// v2 - N
	static int N;
	static int M;
	static List<ArrayList<Node>> list;
	static boolean[] visited;
	static int[] dist;
	static int INF = 987654321;
	static int flag = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, w));
			list.get(e).add(new Node(s, w));
		}
		st = new StringTokenizer(br.readLine()," ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int a = bfs(1, v1);
		int b = bfs(1, v2);
		
		int c = bfs(v1, v2);
	
		int d = bfs(v1, N);
		int e = bfs(v2, N);
		
		int f = a + c + e;
		int l = b + c + d;
		if(a == INF || c == INF || e == INF) {
			if(b == INF || c == INF || d == INF) System.out.println(-1);
			else System.out.println(l);
		}else if(b == INF || c == INF || d == INF) {
			if(a == INF || c == INF || e == INF) System.out.println(-1);
			else System.out.println(f);
		}else System.out.println(Math.min(f, l));
		
		
		}
		static int bfs(int s, int e) {
			visited = new boolean[N + 1];
			dist = new int[N + 1];
			Arrays.fill(dist, INF);
			dist[s] = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(s, 0));
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				//if(now.to == e) return dist[now.to];
				if(visited[now.to]) continue;
				visited[now.to] = true;
				
				for(Node next : list.get(now.to)) {
					if(dist[next.to] > dist[now.to] + next.weight) {
						dist[next.to] = dist[now.to] + next.weight;
						pq.offer(new Node(next.to, dist[next.to]));
					}
				}
			}
			return dist[e];
			
		}
		

}
