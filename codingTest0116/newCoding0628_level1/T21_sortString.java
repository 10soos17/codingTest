package newCoding0628_level1;

import java.util.Arrays;

class T21_sortString {
//	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴
//	s	return
//	"bZcdefg"	"gfedcbZ"
	public static void main(String[] args) {

		String n = "Zbcdefg";

		String res = solution(n);

		System.out.println(res);

	}

	public static String solution(String n) {
		String answer = "";
		
		char[] list = n.toCharArray();
		Arrays.sort(list);
		
		answer = new StringBuilder(new String(list)).reverse().toString();



		return answer;
	}

}