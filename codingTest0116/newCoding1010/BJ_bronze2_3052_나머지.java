package newCoding1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* https://www.acmicpc.net/problem/3052
*/
public class BJ_bronze2_3052_나머지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[42];
		int cnt = 0;
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			check[n % 42] = true;
		}
		for(boolean ch : check) if(ch) cnt++;
		System.out.println(cnt);
	}
}
/* 2th 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
List<Integer> list = new ArrayList<>();
for(int i = 0; i < 10; i++) {
	int n = Integer.parseInt(br.readLine());
	int rem = n % 42;
	if(!list.contains(rem))list.add(rem);
}
System.out.println(list.size());	
}
*/