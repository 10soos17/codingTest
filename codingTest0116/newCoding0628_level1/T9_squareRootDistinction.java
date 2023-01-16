package newCoding0628_level1;

import java.util.Arrays;

class T9_squareRootDistinction {
//	양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//	n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1
//	n	return
//	121	144
//	3	-1
	public static void main(String[] args) {
		long n = 3;
		//int m = 5;
		long res = solution(n);

		System.out.println(res);
		//System.out.println(res[0]+":"+res[n.length-2]);

	}

    public static long solution(long n) {
        long answer = -1;
		if (n % Math.sqrt(n) == 0) {
			return (long)Math.pow((long) Math.sqrt(n) + 1,2);
		}
		return answer;
	}
}