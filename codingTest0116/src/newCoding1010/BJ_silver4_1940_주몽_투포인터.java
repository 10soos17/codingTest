package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*https://www.acmicpc.net/problem/1940
갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다. 

첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다. 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다. 
그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.

첫째 줄에 갑옷을 만들 수 있는 개수를 출력한다.
6
9
2 7 4 1 5 3

2
*/
public class BJ_silver4_1940_주몽_투포인터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0;i < N;i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int s = 0;
		int e = N-1;
		int cnt = 0;
		while(s < e) {
			int sum = list[s] + list[e];
			if(sum == M) {
				s++; e--; cnt++;
			}
			else if(sum > M) e--;
			else if(sum < M) s++;
		}
		System.out.println(cnt);
	}
}
