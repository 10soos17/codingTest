package newCoding0628_level1;

import java.util.Arrays;

public class T33_borrowGymClothes {
	public static void main(String[] args) {
		int n = 5;
		int[] nl = {2,4};
		int[] ml = {1,3,5};


		String s = "1D2S#10S";
		int res = solution(n, nl, ml);
		System.out.println(res);
	}

	public static int solution(int n, int[] nl, int[] ml) {
		int answer=n - nl.length;
		Arrays.sort(nl);
		Arrays.sort(ml);
		int idx=0;

		for (int element : ml) {
			for(int j=idx;j<nl.length;j++) {
				if(element==nl[j]) {
					idx++;
					answer+=1;
					break;
				}
				if(element==nl[j]-1 ||element==nl[j]+1) {
					idx++;
					answer++;
					break;
				}
			}
		}

		return answer;

	}

}
