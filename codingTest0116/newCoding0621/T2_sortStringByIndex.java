package newCoding0621;

import java.util.Arrays;
import java.util.Comparator;

//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
//각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
//각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//strings	n	return
//["sun", "bed", "car"]	1	["car", "bed", "sun"]
//["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
public class T2_sortStringByIndex {
	public static void main(String[] args) {
		String[] n = { "abce", "abcd", "cdx" };
		int num = 2;
		String[] answer = solution(n, num);
		for (String i : answer) {

			System.out.println(i);
		}
	}

	public static String[] solution(String[] n, int num) {
		String[] answer = n;

		Arrays.sort(answer, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 단어가 같을경우
				String one = s1.charAt(num) + "";
				String two = s2.charAt(num) + "";
				if (one.equals(two)) {
					return s1.compareTo(s2); // 사전 순 정렬
				}
				// 그 외의 경우
				else {
					return one.compareTo(two);
				}
			}
		});

		return answer;
	}
}
