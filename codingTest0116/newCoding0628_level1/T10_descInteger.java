package newCoding0628_level1;

import java.util.Arrays;

class T10_descInteger {
//	정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴
//	n	return
//	118372	873211
	public static void main(String[] args) {
		long n = 118372;
		//int m = 5;
		long res = solution(n);

		System.out.println(res);
		//System.out.println(res[0]+":"+res[n.length-2]);

	}

    public static long solution(long n) {
    	long answer = 0;

    	String s = String.valueOf(n);

    	char[] arr = s.toCharArray();
    	Arrays.sort(arr);
//      String[] arr = String.valueOf(n).split("");
//		Arrays.sort(arr);

    	s  = new StringBuilder(new String(arr)).reverse().toString();
    	answer = Long.parseLong(s);

    	return answer;
	}
}