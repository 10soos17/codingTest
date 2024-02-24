package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/2252
3 2
1 3
2 3

출
1 2 3
*/
public class BJ_gold3_2252_줄세우기_위상정렬기본 {

	static int[] dist;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 0; i < N+1;i++) list.add(new ArrayList<>());
		for(int i = 0; i < M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int f = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(f).add(b);
			dist[b]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		int cnt=0;
        for(int i=1;i<N+1;i++) 
			if(dist[i]==0) q.offer(i);
			while(!q.isEmpty()) {
				int now = q.poll();
				sb.append(now);
				cnt++;
                if(cnt < N)sb.append(" ");
				for(int next: list.get(now)) {
					dist[next]--;
	                if(dist[next]== 0){
	                    q.offer(next);
	                }
				}
		}
		System.out.println(sb.toString());
	}
}
