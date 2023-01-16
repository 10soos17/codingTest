package coding_BaekJoon;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=ql82YcFisUI&list=PLi-xJrVzQaxUVf9DWyUdEzhJB0dGvvgrk&index=6
//https://www.acmicpc.net/problem/14503å

//아이디어
/*
 * while문으로 특정조건 종료될 때까지 반복
 * 4방향을 for문으로 탐색
 * 더이상 탐색 불가능할 경우, 뒤로 한칸 후진
 * 후진이 불가능하면 종료 
 * 3 3
 * 
1 1 0

1 1 1
1 0 1
1 1 1

 */

public class Simulation {

	static int n;
	static int m;
	static int each;
	static ArrayList<Integer> list;
	static boolean[] check;

	public static void main(String[] args) {

		n = 3;
		m = 3;
		int[][] arr = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		int x = 1;
		int y = 1;
		int d = 0;// 방향은 위,오,아,왼->0,1,2,3을 의미함

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		int ny = 0;
		int nx = 0;
		int cnt = 0;
		boolean sw = false;

		while (true) {
			if(arr[y][x] == 0) {
				arr[y][x] = 2;
				cnt += 1;
			}
			sw = false;
			for (int i = 1; i < 5; i++) {
				ny = y + dy[d - i];
				nx = x + dx[d - i];
				if (0 <= ny && ny < n && 0 <= nx && nx < m) {
					if (arr[ny][nx] == 0) {
						// 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
						d = (d - i+4)%4;
						y = ny;
						x = nx;
						sw = true;
						break;

					}
					// 4방향 모두 있지 않은 경우
					if (sw == false) {
						// 뒤쪽 방향이 막혀있는 지 확인
						ny = y - dy[d];
						nx = x - dx[d];
						if (0 <= ny && ny < n && 0 <= nx && nx < m) {
							if (arr[ny][nx] == 1) {
								break;
							} else {
								y = ny;
								x = nx;
							}
						}else {
							break;
						}
					}
				}
			}
			System.out.println(cnt);
		}

	}

	
}
