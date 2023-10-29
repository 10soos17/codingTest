package newCoding0701_level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4307
/*
2
10 3
2
6
7
214 7
11
12
7
13
176
23
191
 */
public class T5_greedy_BJ4307 {
    static int N;
    static int dis;
    static int ants;
    static int[] pos;
    static int[] answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 StringBuilder sb = new StringBuilder();
		 
		 for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			dis = Integer.parseInt(st.nextToken());
			ants = Integer.parseInt(st.nextToken());
			int min = 0;
			int max = 0;
			for(int j = 0; j < ants; j++) {
				int pos = Integer.parseInt(br.readLine());
				min = Math.max(min, Math.min(pos, Math.abs(pos - dis)));
				max = Math.max(max, Math.max(pos, Math.abs(pos - dis)));
 			}
			sb.append(min+" "+max+"\n");
			//System.out.println(min+" "+max); 
		 }
		 System.out.println(sb.toString()); 
	}
}
