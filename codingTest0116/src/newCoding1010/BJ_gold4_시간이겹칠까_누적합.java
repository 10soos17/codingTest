package newCoding1010;

import java.io.*;
import java.util.*;
/* 
https://www.acmicpc.net/problem/28018
각 좌석은 사용이 종료되는 시각에 곧바로 선택될 수 없다.
편의상 시각은 
0부터 1,000,000까지 주어지며 정수 단위로 구분된다. 
특정한 시각에 선택할 수 없는 좌석이 몇 개였는지 알아보자.

입력
댓글을 달아준 학생 수 N이 주어진다. 
다음 N개 줄에는 각 학생의 좌석 배정 시각 S와 종료 시각 E가 주어진다. 

다음 줄에는 특정한 시각의 개수 Q가 주어진다.
다음 줄에는 알고자 하는 특정 시각 Q개가 주어진다.

출력
특정 시각에 선택할 수 없는 좌석 수를 주어진 순서에 따라 줄마다 출력하라.
1
1 3
2
2 4

1
0
=======
2
1 5 
3 6
3
2 3 7

1
2
0
*/
public class BJ_gold5_시간이겹칠까_누적합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] seat = new int[1000002]; //누적합으로 만들려고 +1
		int sIdx = 987654321;
		int eIdx = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			seat[s]++;
			seat[e+1]--;
			sIdx = Math.min(s, sIdx);
			eIdx = Math.max(e, eIdx);
		}
		for(int i=sIdx;i<eIdx+1;i++)seat[i] = seat[i-1] + seat[i];
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t <sIdx || t > eIdx) sb.append(0);
			else sb.append(seat[t]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
