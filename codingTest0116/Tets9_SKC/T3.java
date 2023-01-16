package Tets9_SKC;

import java.util.ArrayList;
import java.util.List;

class T3 {

//	테스트 1
//	입력값 〉
//	"centerminus", ["cent", "center", "term", "terminus", "rm", "min", "minus", "us"]
//	기댓값 〉
//	3
//	실행 결과 〉
//	실행한 결괏값 0이 기댓값 3과 다릅니다.
//	테스트 2
//	입력값 〉
//	"aaaababab", ["aaa", "aaaa", "ab", "bab", "aababa"]
//	기댓값 〉
//	4
	public static void main(String[] args) {

		String s = "centerminus";

		int n = 7;
		int m = 24;
		int p = 4;

		int[] l = { 2, 4 };
		int[] ll = { 1, 3, 5 };

		String[] sl = {"cent", "center", 
				"term", "terminus", 
				"rm", 
				"min", "minus", 
				"us"};
		String[] sll = {};

		int[][] k = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[][] kk = { { 3, 4 }, { 5, 6 } };

		boolean[] b = { true, false, true };

		int res = solution(s, sl);
		System.out.println(res);

	}

	public static int solution(String s, String[] sl) {
		int answer = 0;
		
		List<String> list = new ArrayList<>();
		for(String word: sl) {
			list.add(word);
		}
		
		for(int i=0;i<list.size();i++) {
			if(s.contains(sl[i])){
			
				System.out.println("test");
			}
		}
		
		return answer;
	}

}