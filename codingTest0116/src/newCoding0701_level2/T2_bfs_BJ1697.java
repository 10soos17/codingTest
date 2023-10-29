package newCoding0701_level2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//문제
//수빈이는 동생과 숨바꼭질을 하고 있다.
//수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
//동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
//수빈이는 걷거나 순간이동을 할 수 있다.
//만약, 수빈이의 위치가 X일 때 걷는다면
//1초 후에 X-1 또는 X+1로 이동하게 된다.
//순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때,
//수빈이가 동생을 찾을 수 있는 가장 빠른 시간이
//몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.
//N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//예제
//입력
//5 17
//출력
//4
public class T2_bfs_BJ1697 {

	static int N;
	static int M;
	static int cnt;

	static int[] visited;

	public static void main(String[] args) throws Exception {
		// byte로 들어온 데이터를 -> char 형태로 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new int[100001];

		if(N == M) {
			System.out.println(0);
		} else {
			bfs();
		}

	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;

		while (!q.isEmpty()) {

			int ni = q.poll();

			for(int i=0;i<3;i++) {
				int next = 0;
				if(i==0) next = ni + 1;
				else if(i == 1) next = ni - 1;
				else next = ni * 2;

				if(next == M) {
					System.out.println(visited[ni]);
					return;
				}
				if(next >=0 && next < visited.length && visited[next] == 0) {
					q.add(next);

					visited[next] =Math.min(visited[next], visited[ni] + 1);
				}
			}

		}
	}

}
