package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/2056
7
5 0
1 1 1
3 1 2
6 1 1
1 2 2 4
8 2 2 4
4 3 3 5 6 

출
23
*/
public class BJ_gold4_2056_작업_위상정렬 {

	public static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	static int N;
	static int[] dist;
	static int[] distW;
	static List<List<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		distW = new int[N + 1];
		int num = 0;
		for (int i = 0; i < N + 1; i++)
			list.add(new ArrayList<>());
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			distW[i] = w;
			for (int j = 0; j < m; j++) {
				int connect = Integer.parseInt(st.nextToken());
				list.get(connect).add(new Node(i, w));
				dist[i]++;
			}
		}
		Queue<Node> q = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (dist[i] == 0)
				q.offer(new Node(i, dist[i]));
		}
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (Node next : list.get(now.to)) {
				if (distW[next.to] < distW[now.to] + next.weight) {
					distW[next.to] = distW[now.to] + next.weight;
				}
				dist[next.to]--;
				if (dist[next.to] == 0) {
					q.offer(new Node(next.to, distW[next.to]));
				}
			}
		}
		int ans = Arrays.stream(distW).max().orElse(-1);
		System.out.println(ans);
	}
}
