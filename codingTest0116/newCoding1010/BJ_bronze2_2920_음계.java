package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/1389
// c d e f g a b C 
 * ascending descending mixed
*/
public class BJ_bronze2_2920_음계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int before = 0;
		int s = 0;
		int e = 0;
		for(int i = 0; i < 8; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(i == 0) s = n;
			if(i == 7) e = n;
			if(i > 1 && Math.abs(before - n) > 1) {
				System.out.print("mixed");
				return;
			}
			before = n;
		}
		if(s == 1 && e == 8) System.out.print("ascending");
		else if(s == 8 && e == 1) System.out.print("descending");
	}
}
