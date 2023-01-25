package newCoding0821_HS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T_HS_smartClub1 {

	public static void main(String[] args) throws Exception {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int nums = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());

		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<nums;i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());

			if(one < min || two < min || three < min || (one + two + three < sum)) continue;

			cnt++;
			sb.append(" ").append(one).append(" ").append(two).append(" ").append(three);

		}
		System.out.println(cnt);
		System.out.println(sb.toString().substring(1));


	}


}
