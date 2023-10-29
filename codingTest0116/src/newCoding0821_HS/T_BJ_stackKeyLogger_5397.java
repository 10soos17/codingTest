package newCoding0821_HS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5397

public class T_BJ_stackKeyLogger_5397 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char [][] map = new char[N][M];

		for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();


		System.out.println();

	}
}
