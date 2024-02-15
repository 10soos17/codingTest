package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 
https://school.programmers.co.kr/learn/courses/30/lessons/72413
n	s	a	b	fares	result
6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]	82
7	3	4	1	[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]	14
6	4	5	6	[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]	18

 public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        return answer;
    }
*/
public class Programmers_합승택시요금_다익스트라 {

	static class Node implements Comparable<Node> {
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

	static int N;
	static int S;
	static int A;
	static int B;
	static int[][] fares;
	static List<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	static boolean[] visited;
	static int[] dist;
	static int INF = 987654321;
	public static void main(String[] args) throws Exception {

		N = 6;
		S = 4;
		A = 6;
		B = 2;
		fares = new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, 
							{ 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
								{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		int answer = solution(N, S, A, B, fares);
		System.out.println(answer);
		
	}

	static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 987654321;

		for (int i = 0; i < N + 1; i++)
			list.add(new ArrayList<>());
		// visited = new boolean[n + 1];
		for (int i = 0; i < fares.length; i++) {
			int[] data = fares[i];
			list.get(data[0]).add(new Node(data[1], data[2]));
			list.get(data[1]).add(new Node(data[0], data[2]));
		}

		int[] oDist = bfs(S);
		int[] aDist = bfs(A);
		int[] bDist = bfs(B);
		
		for(int i = 0; i < N + 1; i++) {
			int oo = oDist[i];
			int aa = aDist[i];
			int bb = bDist[i];
			if(oo != INF || aa != INF || bb != INF) {
				answer = Math.min(answer, oo + aa + bb);
			}
		}

		return answer;
	}

	static int[] bfs(int s) {
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			//if(now.to == e) return dist[now.to];
			if (visited[now.to]) continue;
			visited[now.to] = true;

			for (Node next : list.get(now.to)) {
				if (dist[next.to] > dist[now.to] + next.weight) {
					dist[next.to] = dist[now.to] + next.weight;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;

	}

}

//프로그래머스 제출  
/*
import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
    
    int INF = 987654321;
    List<List<Node>> list = new ArrayList<>(); 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        for(int i = 0; i < n+1; i++) list.add(new ArrayList<>());
        for(int i = 0; i < fares.length; i++){
            int[] data = fares[i];
            list.get(data[0]).add(new Node(data[1], data[2]));
            list.get(data[1]).add(new Node(data[0], data[2]));
        }
        int[] sDist = dijkst(s, n);
        int[] aDist = dijkst(a, n);
        int[] bDist = dijkst(b, n);
        for(int i = 0; i < n + 1; i++){
            if(sDist[i] != INF && aDist[i] !=INF && bDist[i] != INF){
                int distance = sDist[i] + aDist[i] + bDist[i];
                answer = Math.min(answer, distance);
            }
        }
        
        return answer;
    }
    
    int[] dijkst(int s, int n){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;
            for(Node next : list.get(now.to)){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to]  = dist[now.to] + next.weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
*/
