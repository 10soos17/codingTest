package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
((110(0101))(0010)1(0001))
*/
public class BJ_silver1_1992_쿼드트리_부분집합 {

	static int N;
	static int map[][];
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line.charAt(j) + "");
			}
		}
		dfs(0, 0, map[0][0], N);
		System.out.println(answer.toString());
	}
	static void dfs(int y, int x, int v, int size) {
		boolean flag = true;
		OUTLOOP:
		for(int i = y; i < y + size; i++ ) {
			for(int j = x; j < x + size; j++) {
				if(map[i][j] != v) {
					flag = false;
					break OUTLOOP;
				}
			}
		}
		if(flag) {
			answer.append(v);
			return;
		}
		answer.append("(");
		dfs(y, x, map[y][x], size/2);
		dfs(y, x + size/2, map[y][x + size/2], size/2);
		dfs(y + size/2, x, map[y + size/2][x], size/2);
		dfs(y + size/2, x + size/2, map[y + size/2][x + size/2], size/2);
		answer.append(")");
	}
	
}
/*
 2. char 로 받은 경우
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char map[][];
	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, map[0][0], map.length);
		System.out.println(answer.toString());
	}

	static void dfs(int y, int x, char v, int size) {
		boolean flag = true;

		OUTLOOP: for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != v) {
					flag = false;
					break OUTLOOP;
				}
			}
		}
		if (flag) {
			answer.append(v);
			return;
		}
		answer.append('(');

		dfs(y, x, map[y][x], size / 2);
		dfs(y, x + size / 2, map[y][x + size / 2], size / 2);
		dfs(y + size / 2, x, map[y + size / 2][x], size / 2);
		dfs(y + size / 2, x + size / 2, map[y + size / 2][x + size / 2], size / 2);

		answer.append(')');
	}

 */



