package newCoding0523;

import java.util.Arrays;

//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주
//내림차순 정렬
//s	return
//"Zbcdefg"	"gfedcbZ"

public class T7_sortString {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String answer = solution(s);
		System.out.println(answer);
		answer = solution2(s);
		System.out.println(answer);

	}

	public static String solution(String s) {
		String answer = "";

		String[] list = s.split("");
		Arrays.sort(list);

		for (String ss : list) {
			answer += ss;
		}
		answer = new StringBuilder(answer).reverse().toString();

		return answer;
	}

	//programmers
	public static String solution2(String s) {
		String answer = "";

		char[] list = s.toCharArray();
		Arrays.sort(list);

		answer = new StringBuilder(new String(list)).reverse().toString();

		return answer;
	}
}