package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/14891
 * 
첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 
상태는 8개의 정수로 이루어져 있고, 
12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.

다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 
다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 
각 방법은 두 개의 정수로 이루어져 있고, 
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 
방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.

총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.
1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
10101111
01111101
11001110
00000010
2
3 -1
1 1

출
7
회전전, 인덱스비교해서 같은극이면 회전x, 반대극이면 반대방향회전

회전후, 인덱스변경
반시계면, (idx+1 시계면 idx+7)%8
1번은 idx
4번은 idx+4
2,3번 둘다


1: 2
*/
public class BJ_gold5_14891_톱니바퀴_구현 {

	static int N;
	static int[][] list = new int[4][8];
	static int[] idx = {2,2,2,2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) list[i][j] = Integer.parseInt(s.charAt(j)+"");
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int number = Integer.parseInt(st.nextToken())-1;
			int action = Integer.parseInt(st.nextToken());
			String chk = "both";
			if(number==0)chk = "right";
			if(number == 3) chk = "left";
			solution(number, action, chk);
		}
		int answer=0;
		for(int i=0;i<4;i++) {
			int n = list[i][(idx[i]+6)%8];
			if(n==1) answer += Math.pow(2, i);
		}
		System.out.println(answer);
	}
	static void solution(int number, int action, String chk) {
		int now = idx[number];
		if(action == -1) idx[number] = (now+1)%8;
		else idx[number] = (now+7)%8;
		
		if(chk == "right" && number > 2 ||chk == "left" && number < 1) return;
		
		if(chk == "right") {
			int next= idx[number+1];
			if(list[number][now] != list[number+1][(next+4)%8]) solution(number+1, action*-1, "right");
		}
		if(chk == "left") {
			int next= idx[number-1];
			if(list[number][(now+4)%8] != list[number-1][next])solution(number-1, action*-1,"left");
		}
		if(chk == "both") {
			int next= idx[number+1];
			if(list[number][now] != list[number+1][(next+4)%8]) solution(number+1, action*-1, "right");
			next= idx[number-1];
			if(list[number][(now+4)%8] != list[number-1][next])solution(number-1, action*-1,"left");
		}
	}
}
