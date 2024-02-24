package newCoding1010;

import java.util.*;
import java.io.*;

/*

*/

public class 연습11111 {
	static int N;
	static int[] list;
	static int[] preList;
	static int[] tmp;
	static boolean[] visited;
	static int flag = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		visited = new boolean[N];
		list = new int[N];
		tmp = new int[N];
		preList = new int[N];
		for(int i = 0; i < N; i++) {
			preList[i] = Integer.parseInt(st.nextToken());
		}
		list = preList.clone();
		Arrays.sort(list);
		
		for(int i = 0; i < N; i++) {
			if(list[N - i - 1] != preList[i]) {
				break;
			}
			if(i == N - 1) {
				System.out.println(-1); 
				return;
			}
			
		}
		
		perm(0);
		if(flag == -1) {
			System.out.println(sb.toString());
		}
		
	}
	static void perm(int dep) {
		if(dep == N) {
			for(int i = 0; i < N; i++) {
				if(tmp[i] != preList[i]) {
					break;
				}
				if(i == N - 1) {
					flag = 1;
					return;
				}
			}
				
			if(flag == 1) {
				for(int i = 0; i < N; i++) {
					sb.append(tmp[i]).append(" ");
				}
				flag = -1;
				return;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				tmp[dep] = list[i];
				visited[i] = true;
				perm(dep + 1);
				visited[i] = false;
			}
		}
		
		
	}

}








