package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/2018
15

출
4
*/
public class BJ_silver5_2018_수들의합_투포인터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int S=0;
		int E=1;
		int cnt=0;
		int sum=E;
		
		while(E<=N) {
			if(sum==N) {
				cnt++;
				S+=1;
				sum-=S;
				continue;
			}
			else if(sum <N) {
				E+=1;
				sum+=E;
				continue;
			}
			else if(sum >N) {
				S+=1;
				sum-=S;
				continue;
			}
		}
		System.out.println(cnt);
	}
}
