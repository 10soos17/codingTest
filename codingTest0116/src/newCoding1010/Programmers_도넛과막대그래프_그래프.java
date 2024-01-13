package newCoding1010;

import java.util.*;

/* 
https://school.programmers.co.kr/learn/courses/30/lessons/258711

ex.
edges	result
1 [[2, 3], [4, 3], [1, 1], [2, 1]]	[2, 1, 1, 0]

2 [[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], 
[7, 11], [4, 8], [9, 6], [10, 11], [6, 10], 
[3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]	[4, 0, 1, 2]
*/
public class Programmers_도넛과막대그래프_그래프 {
	
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static int[] answer = new int[4];
	static int len;
	static int node;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		//int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
		int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},{7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, 
			{3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
		int max = 0;
		node = 0;
		len = 0;
		for(int i = 0; i < edges.length; i++) {
			len = Math.max(len,edges[i][0]);
			len = Math.max(len,edges[i][1]);
		}
		for(int i = 0; i < len + 1; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			if(max < list.get(edges[i][0]).size()) {
				max = list.get(edges[i][0]).size();
				node = edges[i][0];
			}
		}
		answer[0] = node;
		for(int start : list.get(node)) {
			solution(start);
		}
		System.out.println(Arrays.toString(answer));
	}
	static void solution(int s) {
		visited = new boolean[len + 1];
		
		Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        
        while(!q.isEmpty()){
            int now = q.poll();
            List<Integer> nowList = list.get(now);
			//donut 
            if (visited[now]) {
				answer[1]++;
				return;
			}
            visited[now] = true;
			//eight
			if(nowList.size() == 2) {
				answer[3]++;
				return;
            }
			for (int next : nowList) q.offer(next);
        }
        answer[2]++;
	}
	/*
	void bfs(int s) {
		visited = new boolean[len + 1];
		
		Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        
        while(!q.isEmpty()){
            int now = q.poll();
			//donut 
            if (visited[now]) {
				answer[1]++;
				return;
			}
            visited[now] = true;
			//eight
			if(list.get(now).size() == 2) {
				answer[3]++;
				return;
            }
			//stick 
			if(list.get(now).size() == 0) {
				answer[2]++;
				return;
            }
			q.offer(list.get(now).get(0));
        }
       // answer[2]++;
	}
	*/
}
