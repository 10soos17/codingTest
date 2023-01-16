package newCoding0628_level1;

import java.util.HashMap;
import java.util.Map;

public class T35_checkCharacter {

//성격유형검사 https://school.programmers.co.kr/learn/courses/30/lessons/118666

//지표 번호	성격 유형
//1번 지표	라이언형(R), 튜브형(T)
//2번 지표	콘형(C), 프로도형(F)
//3번 지표	제이지형(J), 무지형(M)
//4번 지표	어피치형(A), 네오형(N)

//survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나

//survey	choices	result
//["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
//["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

//캐릭터 : 첫 - 비동의 , 둘 - 동의 
//123(321)
//4(0)
//567(123) 
//
	public static void main(String[] args) {
		int n = 5;
		int[] nl = { 5, 3, 2, 7, 5 };
		int[] ml = { 1, 3, 5 };

		String[] sl = { "AN", "CF", "MJ", "RT", "NA" };
		String s = "12321";
		String ss = "42531";
		String res = solution(sl, nl);
		System.out.println(res);
	}

	public static String solution(String[] sl, int[] nl) {
		String answer = "";
		int score = 0;
		Map<String, Integer> map = new HashMap<>();
		map.put("RT", 0);
		map.put("CF", 0);
		map.put("JM", 0);
		map.put("AN", 0);

		for (int i = 0; i < sl.length; i++) {

			if (nl[i] > 4) {
				score = -(nl[i] - 4);

			} else {
				score = 4 - nl[i];
			}

			if (map.containsKey(sl[i])) {
				map.put(sl[i], map.get(sl[i]) + score);
			} else {
				String tmp = "" + sl[i].charAt(1) + sl[i].charAt(0);
				map.put(tmp, map.get(tmp) - score);
			}

		}

		for (String s : map.keySet()) {
			if (map.get(s) >= 0) {
				answer += s.charAt(0);
			} else {
				answer += s.charAt(1);
			}

		}
		return answer;

	}

}
