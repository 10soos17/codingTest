package newCoding1010;

import java.io.*;
import java.util.*;

/* 
https://www.acmicpc.net/problem/15686
크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 
도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 
도시의 칸은 (r, c)와 같은 형태로 나타내고, 
r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. 
r과 c는 1부터 시작한다.

치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 
즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 
도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.

임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다
0은 빈 칸, 1은 집, 2는 치킨집이다.
(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다. 따라서, (2, 1)에 있는 집의 치킨 거리는 2
프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 
오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는  치킨집의 개수는 
최대 M개라는 사실을 알아내었다.

도시에 있는 치킨집 중에서 최대 M개를 고르고,
나머지 치킨집은 모두 폐업시켜야 한다. 
어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
도시의 정보는 0, 1, 2로 이루어져 있고,
0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 
집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 
치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.

출력
첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.

ex.
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

5
*/
public class BJ_gold5_15686_치킨배달 {
	
	static int N;
	static int M;
	static List<int[]> stores = new ArrayList<>(); 
	static List<int[]> customers =  new ArrayList<>();  
	static int[][] temp;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = new int[M][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int pos = Integer.parseInt(st.nextToken());
				if(pos == 0) continue;
				if(pos == 1) customers.add(new int[] {i+1, j+1});
				if(pos == 2) stores.add(new int[] {i+1, j+1});
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}
	static void calc() {
		int sum = 0;
		for(int i = 0; i < customers.size(); i++) {
			int dis = 987654321;
			for(int j = 0; j < M; j++) {
				int[] cPos = customers.get(i);
				int[] sPos = temp[j];
				int x = Math.abs(cPos[0] - sPos[0]);
				int y = Math.abs(cPos[1] - sPos[1]);
				dis = Math.min(dis, x+y);
			}
			sum += dis;
			if(sum > answer) return;
		}
		answer = Math.min(answer,sum);
	}
	static void comb(int dep, int start) {
		if(dep == M) {
			calc();
			return;
		}
		for(int i = start; i < stores.size(); i++) {
			temp[dep] = stores.get(i);
			comb(dep + 1, i + 1);
		}
	}
}
