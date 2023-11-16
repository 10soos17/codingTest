package newCoding1010;
import java.util.*;
import java.io.*;
/* https://www.acmicpc.net/problem/1389
 입력
첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다.
둘째 줄부터 M개의 줄에는 친구 관계가 주어진다. 
친구 관계는 A와 B로 이루어져 있으며, A와 B가 친구라는 뜻이다.
A와 B가 친구이면, B와 A도 친구이며, A와 B가 같은 경우는 없다. 
친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다. 
또, 모든 사람은 친구 관계로 연결되어져 있다. 
사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.

출력
첫째 줄에 BOJ의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다. 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.

ex.
5 5
1 3
1 4
4 5
4 3
3 2

3
*/
public class BJ_silver1_1389_케빈베이컨의6단계법칙_graph2 {
	static int N;
	static int M;
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	static int min = Integer.MAX_VALUE;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ni = Integer.parseInt(st.nextToken());
			int mi = Integer.parseInt(st.nextToken());
			list.get(ni).add(mi);
			list.get(mi).add(ni);
		}
		for(int i = 1; i < N + 1; i++) {
			int sum = 0;
			for(int j = 1; j < N + 1; j++) {
				if(i == j) continue;
				sum += bfs(i,j);
			}
			if(sum < min) { 
				min = sum;
				ans = i;
			}else if(sum == min) {
				ans = Math.min(i, ans);
			}
		}
		System.out.println(ans);
	}
	static int bfs(int s, int e) {
		boolean[] visited = new boolean[N+1];
		Queue<int[]> q = new ArrayDeque<>(); 
		q.offer(new int[] {s, 0});
		visited[s] = true;
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int now = c[0];
			int cnt = c[1];
			if(now == e) return cnt;
			for(int next :list.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, cnt+1});
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
		

}
