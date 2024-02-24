package newCoding1010;
//11600
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
https://www.acmicpc.net/problem/14499
참조: https://blog.naver.com/kelly9509/223034690784
주사위를 굴렸을 때, 
이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.

동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
ex.
3 3 1 1 9
1 2 3
4 0 5
6 7 8
1 3 2 2 4 4 1 1 3

0
0
0
3
0
1
0
6
0
*/
public class BJ_gold4_14499_주사위굴리기_구현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로
		int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//주사위
		// dice[0]: 윗면
		// dice[1]: 뒷면
		// dice[2]: 오른쪽 면
		// dice[3]: 왼쪽 면
		// dice[4]: 앞면
		// dice[5]: 바닥면
		int[] dice = {0,0,0,0,0,0};
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<K;i++) {
			int move = Integer.parseInt(st.nextToken());
			int dy = y+dir[move-1][0];
			int dx = x+dir[move-1][1];
			if(dy > N-1 || dx > M-1 || dy < 0 || dx < 0 )continue;
			// 주사위 굴리기
			// 남북쪽으로 움직이면 동서쪽에 있는 숫자는 바뀌지 않고,
			// 동서쪽으로 움직이면 남북쪽에 있는 숫자는 바뀌지 않는다.
			int tmp = dice[0]; // 현재 내 맨 위 값 저장
			switch (move) { // 방향이
			case 1: // 동쪽으로 움직인다면? 1, 4는 그대로
				//윗면이 왼쪽에있던것, 
				//왼쪽은 아래쪽(바닥)에있던것,
				//바닥은 오른쪽에 있던것
				//오른쪽은 위에있던것
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = tmp;
				break;
			case 2: // 서쪽으로 움직인다면? 1, 4는 그대로
				//윗면이 오른쪽에있던것
				//오른쪽은 아래에있던것
				//바닥은 왼쪽에있던것
				//왼쪽은 위에있던것
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
				break;
			case 3: // 북쪽으로 움직인다면? 2, 3은 그대로
				//윗면이 앞에있던것
				//앞면이 아래(바닥)에있던것
				//아래(바닥)이 뒤에있던것
				//뒷면이 위에있던것
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = tmp;
				break;
			default: // 남쪽으로 움직인다면? 2, 3은 그대로
				//윗면이 뒤에있던것
				//뒷면이 아래(바닥)에있던것
				//아래(바닥)이 앞에있던것
				//앞면이 위에있던것
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = tmp;
				break;
			}
			if(map[dy][dx] == 0) { //칸이 0이면?
				map[dy][dx] = dice[5];//칸에 주사위 바닥면 숫자를 복사
			}else {// 그 외 
				dice[5] = map[dy][dx]; //주사위 바닥에 칸 숫자를 복사
				map[dy][dx] = 0; //칸 숫자는 0
			}
			//주사위좌표
			y = dy;
			x = dx;
			System.out.println(dice[0]);//윗면출력
		}
	}
}
