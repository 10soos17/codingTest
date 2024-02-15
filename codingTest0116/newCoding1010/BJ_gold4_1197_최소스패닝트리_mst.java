package newCoding1010;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1197

/* 
최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 
다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 
이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. 
C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 
최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

출력
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.

ex.
입력
3 3
1 2 1
2 3 2
1 3 3

출력
3
*/
public class BJ_gold4_1197_최소스패닝트리_mst {

	
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
			
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	static int N;
	static int M;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			parents[i] = i; 
		}
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Node(a, b, weight));

		}
		int cnt = 0;
		int answer = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(find(n.from) != find(n.to)) {
				union(n.from, n.to);
				cnt++;
				answer += n.weight;
				if(cnt == N - 1) break;
			}
		}
		System.out.println(cnt != N - 1 ? -1 : answer);
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA > rootB) parents[rootA] = rootB;
		else parents[rootB] = rootA;
		
	}
	
}











