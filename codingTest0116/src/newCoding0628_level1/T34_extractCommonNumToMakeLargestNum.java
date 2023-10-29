package newCoding0628_level1;

import java.util.Arrays;

public class T34_extractCommonNumToMakeLargestNum {
	public static void main(String[] args) {
		int n = 5;
		int[] nl = {2,4};
		int[] ml = {1,3,5};


		String s = "12321";
		String ss = "42531";
		String res = solution(s,ss);
		System.out.println(res);
	}

	public static String solution(String s, String ss) {
		String answer="";
		char[] sl = s.toCharArray();
		char[] ssl = ss.toCharArray();

		Arrays.sort(sl);
		Arrays.sort(ssl);

		s = new StringBuilder(new String(sl)).reverse().toString();
		ss = new StringBuilder(new String(ssl)).reverse().toString();

		sl = s.toCharArray();
		ssl = ss.toCharArray();

		int idx = 0;

		for (char element : sl) {
			for(int j=idx;j<ssl.length;j++) {
				if(element == ssl[j]) {
					idx = j+1;
					answer += ssl[j];
					break;
				}

			}
		}

		if(answer.length() ==0)return "-1";
		if(answer.startsWith("0")) return "0";

		return answer;

	}


}
