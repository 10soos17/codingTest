package coding_AlgoBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.youtube.com/watch?v=5BRmT4VTEpo&list=PLDV-cCQnUlIZOsYWdD5u1Qo3ByXoC6CmZ&index=5
//문자열 내에서 가장 긴 중복없는 문자열 찾기
//시간복잡도:
//공간복잡도:
public class String1_GroupAnagrams {

	public static void main(String[] args) {

		String[] arr1 = { "abc", "cde", "bca", "adc", "dec", "ba" };
		solution(arr1);

	}

	//anagram
	public static void solution(String[] nums) {

		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> anagramList = new ArrayList<>();

		for (String num : nums) {

			// string -> list로 -> sort
			String[] arr = num.split("");
			Arrays.sort(arr);
			// 정렬된 list -> string으로
			String sortedStr = "";
			for (String s : arr) {
				sortedStr += s;
			}

			// map에 key값이 있는 지 체크
			if (checkData(sortedStr, map)) {// 있으면, 기존 value 뽑기
				anagramList = map.get(sortedStr);
			} else {// 없으면, 새로
				anagramList = new ArrayList<>();
			}

			// value 추가, map 저장
			anagramList.add(num);
			map.put(sortedStr, anagramList);
		}

		for(String s : map.keySet()) {
			System.out.println(s+":"+map.get(s));
		}

	}

	//map에 값 있는 지 체크
	public static boolean checkData(String str, HashMap<String, ArrayList<String>> map) {
		if (map.get(str) != null) {
			return true;
		}
		return false;
	}

}

