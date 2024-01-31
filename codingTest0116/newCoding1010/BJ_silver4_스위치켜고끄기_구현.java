package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
입력
첫째 줄에는 스위치 개수가 주어진다. 스위치 개수는 100 이하인 양의 정수이다. 
둘째 줄에는 각 스위치의 상태가 주어진다. 켜져 있으면 1, 꺼져있으면 0이라고 표시하고 사이에 빈칸이 하나씩 있다. 
셋째 줄에는 학생수가 주어진다. 
학생수는 100 이하인 양의 정수이다. 넷째 줄부터 마지막 줄까지 한 줄에 한 학생의 성별, 학생이 받은 수가 주어진다. 
남학생은 1로, 여학생은 2로 표시하고, 학생이 받은 수는 스위치 개수 이하인 양의 정수이다.

남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 
여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.

출력
스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다. 
예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다. 
켜진 스위치는 1, 꺼진 스위치는 0으로 표시하고, 스위치 상태 사이에 빈칸을 하나씩 둔다.

ex.
64
0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
2
1 2
2 1
*/
public class BJ_silver4_스위치켜고끄기_구현 {
	static int N;
	static int[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i < N + 1; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			calc(s, n);
		}
		int cnt = 1;
		for(int i = 1; i < N + 1; i++) {
			if(i%(20*cnt+1) == 0) {
				System.out.println();
				cnt++;
			}
			System.out.print(list[i]);
			if(i%(20*cnt+1) != 20*cnt && i != N)System.out.print(" ");
		}
	}
	static void calc(int s, int n) {
		list[n] = Math.abs(list[n] -1);
		int cnt = 1;
		if(s == 1) {
			while(true) {
				cnt++;
				if(N < cnt * n) break;
				list[n*cnt] = Math.abs(list[n*cnt] - 1);
			}
		}
		if(s == 2) {
			int limit = Math.min(n-1, N-n);
			if(limit == 0) return;
			while(true) {
				if(list[n-cnt] != list[n+cnt]) break;
				if(list[n-cnt] == list[n+cnt]) {
					int status = Math.abs(list[n-cnt] - 1);
					list[n-cnt] = status;
					list[n+cnt] = status;
				}
				if(limit == cnt) break;
				cnt++;
			}
		}
	}
}
