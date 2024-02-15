package newCoding1010;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1717

/* 
문제
초기에 n+1개의 집합 
$\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
집합을 표현하는 프로그램을 작성하시오.

입력
첫째 줄에 n, m이 주어진다. $m$은 입력으로 주어지는 연산의 개수이다. 
다음 $m$개의 줄에는 각각의 연산이 주어진다. 
합집합은 $0$ $a$ $b$의 형태로 입력이 주어진다. 이는 $a$가 포함되어 있는 집합과, $b$가 포함되어 있는 집합을 합친다는 의미이다. 
두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 $1$ $a$ $b$의 형태로 입력이 주어진다. 이는 $a$와 $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.

출력
1로 시작하는 입력에 대해서 $a$와 $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.

입력
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

출력
NO
NO
YES
*/
public class BJ_gold5_1717_집합의표현_unionFind {

	static int[] parents;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		make();
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dest =Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(dest == 0) {
				union(a, b);
			}else {
				if(find(a) == find(b)) sb.append("YES\n");
				else sb.append("NO\n");
			} 
		}
		System.out.println(sb.toString());
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA < rootB) parents[rootB] = rootA; //작은 게 부모로  
		else parents[rootA] = rootB;
	}
	
	
	static void make() {
		parents = new int[N + 1];
		for(int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}
	
}






