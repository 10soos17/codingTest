package newCoding0701_level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9663
public class T5_bruteForce_BJ9663_NQUEEN {
    static int N;
    static int[] cols;
    static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		 cols = new int[N];
		 answer = 0;
		 queen(0);
		 System.out.println(answer);

	}
	static boolean check(int row) {
		for(int i = 0; i < row; i++) {
			if(cols[i] == cols[row] || Math.abs(row - i) == Math.abs(cols[row] - cols[i])) {
				return false;
			}
		}
		return true;
	}
	
	static void queen(int row) {
		
		if(!check(row - 1)) {
			return;
		}
		if(row > N-1) {
			answer++;
			return;
		}
		for(int i = 0; i < N; i++) {
			cols[row] = i;
			queen(row+1);
		}
	}
}
