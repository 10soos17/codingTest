package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
 https://www.acmicpc.net/problem/5972
농부 현서는 농부 찬홍이에게 택배를 배달
가는 길에 만나는 모든 소들에게 맛있는 여물을 줘야 합니다.
최소한의 소들을 만나면서 지나가고 싶습니다.
N (1 <= N <= 50,000) 개의 헛간과, 
소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길이 그려져 있고, 
각각의 길은 C_i (0 <= C_i <= 1,000) 마리의 소가 있습니다. 
소들의 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N; A_i != B_i)를 잇습니다. 
두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있습니다. 
농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N에 있습니다.
 
입력
첫째 줄에 N과 M이 공백을 사이에 두고 주어집니다.
둘째 줄부터 M+1번째 줄까지 세 개의 정수 A_i, B_i, C_i가 주어집니다.
출력
첫째 줄에 농부 현서가 가져가야 될 최소 여물을 출력합니다.

ex.
6 8
4 5 3
2 4 0
4 1 4
2 1 1
5 6 1
3 6 2
3 2 6
3 4 4
*/
public class BJ_gold5_5972_택배배송_다익스트라 {
	static int N;
	static int M;
	static List<List<Node>> list = new ArrayList<>();

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
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
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N + 1; i++)
			list.add(new ArrayList<>());
		for (int i = 1; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, w));
			list.get(b).add(new Node(a, w));
		}
		int[] dist = new int[N + 1];
		int INF = 987654321;
		Arrays.fill(dist, INF);

		dist[1] = 0;
		boolean[] visited = new boolean[N + 1];
		for(int i = 1; i < N + 1; i++) {
			int nodeIndex = i;
			int nodeValue = INF;
			for(int j = 1; j < N + 1; j++) {
				if(!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIndex = j;
				}
			}
			visited[nodeIndex] = true;
			for(Node next : list.get(nodeIndex)) {
				if(dist[next.to] > dist[nodeIndex] + next.weight) {
					dist[next.to] = dist[nodeIndex] + next.weight;
				}
			}
			
		}
		System.out.println(dist[N]);

	}

}
