package newCoding0821_HS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1085

public class T_BJ_B3_1085_exodusFromRectangle {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int ans = Math.min(Math.min(X, W-X), Math.min(Y,H-Y));
		System.out.println(ans);

	}
}
