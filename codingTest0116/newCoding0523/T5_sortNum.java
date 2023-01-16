package newCoding0523;

import java.util.Arrays;

//n의 각 자릿수를 큰것부터 작은 순으로 정렬
//n	return
//118372	873211

public class T5_sortNum {
	public static void main(String[] args) {

		int n = 118372;
		long answer = solution(n);

		System.out.println(answer);
	}

	public static long solution(long n) {
		long answer = 0;

		String[] arr = String.valueOf(n).split("");
		Arrays.sort(arr);

		String s = "";
		for (String i : arr) {
			s += i;
		}

		s = new StringBuilder(s).reverse().toString();
		answer = Long.parseLong(s);

		return answer;

	}

}
