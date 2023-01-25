package newCoding0628_level1;

import java.util.Arrays;
import java.util.Comparator;

class T23_sortListByDictionary {
//	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
//	각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬
//
//	strings가 ["sun", "bed", "car"]이고 n이 1이면
//	각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬
//
//	strings는 길이 1 이상, 50이하인 배열입니다.
//	strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//	strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//	모든 strings의 원소의 길이는 n보다 큽니다.
//	인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치
//
//	strings	n	return
//	["sun", "bed", "car"]	1	["car", "bed", "sun"]
//	["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
	public static void main(String[] args) {

		String[] n = { "abce", "abcd", "cdx" };
		int m = 2;

		String[] res = solution(n, m);

		for (String s : res) {
			System.out.println(s);
		}

	}

	public static String[] solution(String[] n, int m) {
		String[] answer = n;

		Arrays.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String one = s1.charAt(m) + "";
				String two = s2.charAt(m) + "";

				if (one.equals(two)) { // 같을 경우, 사전순 정렬
					return s1.compareTo(s2);
				} else {
					return one.compareTo(two); // 아닐경우, 인덱스 번호 알파벳순으로 정렬
				}
			}

		});

		return answer;
	}

}