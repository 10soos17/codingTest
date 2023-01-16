package newCoding0523;

import java.util.Arrays;

//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
//예를들어 n이 12345이면 [5,4,3,2,1]을 리턴
//n	return
//12345	[5,4,3,2,1]
public class T18_reverseNumToArray {
	public static void main(String[] args) {

		long num = 12345;

		int[] answer = solution(num);
		for (int i : answer) {
			System.out.println(i);
		}

	}

	public static int[] solution(long n) {
		int len = String.valueOf(n).length();
		String s = String.valueOf(n);
		int[] answer = new int[len];

		for (int i = 0; i < String.valueOf(n).length(); i++) {
			answer[len - i - 1] = Integer.parseInt("" + s.charAt(i));
		}

		return answer;

	}

}
