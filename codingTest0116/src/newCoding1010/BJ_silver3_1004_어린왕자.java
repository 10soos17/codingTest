package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 https://www.acmicpc.net/problem/1004
 위와 같은 은하수 지도, 출발점, 도착점이 주어졌을 때 
 어린 왕자에게 필요한 최소의 행성계 진입/이탈 횟수를 구하는 프로그램을 작성해 보자. 
 행성계의 경계가 맞닿거나 서로 교차하는 경우는 없다. 
 또한, 출발점이나 도착점이 행성계 경계에 걸쳐진 경우 역시 입력으로 주어지지 않는다.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트케이스에 대해 
첫째 줄에 출발점 (x1, y1)과 도착점 (x2, y2)이 주어진다. 
두 번째 줄에는 행성계의 개수 n이 주어지며, 
세 번째 줄부터 n줄에 걸쳐 행성계의 중점과 반지름 (cx, cy, r)이 주어진다.

출력
각 테스트 케이스에 대해 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수를 출력한다.
ex.
2
-5 1 12 1
7
1 1 8
-3 -1 1
2 2 2
5 5 1
-4 5 1
12 1 1
12 1 2
-5 1 5 1
1
0 0 2
 */
public class BJ_silver3_1004_어린왕자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int planets = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int j = 0; j < planets; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				double distanceS = Math.sqrt(Math.pow(x - sx, 2) + Math.pow(y - sy, 2));
				double distanceE = Math.sqrt(Math.pow(x - ex, 2) + Math.pow(y - ey, 2));
				if(distanceS < r && distanceE >= r) answer++;
				if(distanceS >= r && distanceE < r) answer++;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
