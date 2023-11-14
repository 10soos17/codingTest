package newCoding1010;
import java.util.*;
import java.io.*;
/* 
https://www.acmicpc.net/problem/2644
문제
우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화
이러한 촌수는 다음과 같은 방식으로 계산
기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산
예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌

여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성

입력
사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시
입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 
둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호 
셋째 줄에는 부모 자식들 간의 관계의 개수 m
넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호

출력
입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력
어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때에는 -1을 출력

ex.
입력 
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6

출력
3
*/
public class BJ_silver2__2644_촌수계산_graph {

	static int N;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N+1; i++) list.add(new ArrayList<>());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		int ans = bfs(s, e);
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
			for(int next : list.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, cnt+1});
				}
			}
		}
		return -1;
	}

}
