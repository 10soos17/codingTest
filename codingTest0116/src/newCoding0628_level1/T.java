package newCoding0628_level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//[8기 07회차] B반_알고리즘 응용_과목평가
//문제 2-2 예제 입력

//2
//10 5 200
//1 2 3 6 7 9 11 22 44 50
//10 5 51
//1 2 3 6 7 9 11 22 44 50

public class T {

	static StringBuilder sb;

	static int town;
	static int ps;

	static int dia;
	static int distance;

	static int ans;

	static int[] list;
	static int[] tmp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		int TC = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			town = Integer.parseInt(st.nextToken());
			ps = Integer.parseInt(st.nextToken());
			dia = Integer.parseInt(st.nextToken());

			list = new int[town];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < town; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			tmp = new int[ps];

			ans = 987654321;

			comb(0, 0);

			sb.append("#").append(t).append(" ").append(ans).append("\n");

		}
		System.out.println(sb.toString());
	}

	public static void comb(int start, int dep) {

		if (dep == ps) {

			distance = 0;

			for (int i = 0; i < town; i++) {
				int min = 987654321;
				for (int j = 0; j < ps; j++) {
					min = Math.min(Math.abs(list[i] - tmp[j]),
								   Math.min(dia - Math.abs(list[i] - tmp[j]), min)
								  );

				}
				distance += min;
				if (distance >= ans) return;
			}

			ans = Math.min(ans, distance);
			return;
		}

		for (int i = start; i < town; i++) {
			tmp[dep] = list[i];
			comb(i + 1, dep + 1);
		}
	}

}
