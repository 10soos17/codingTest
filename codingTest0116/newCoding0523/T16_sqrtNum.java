package newCoding0523;

import java.util.Arrays;

//양의 정수 n에 대해,n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//n이 양의 정수 x의 제곱이라면 x+1 의 제곱을 리턴하고,
//n이 양의 정수 x의 제곱이 아니라면-1 을 리턴하는 함수 
//n return 
//121 144 
//3 -1

public class T16_sqrtNum {
	public static void main(String[] args) {

		int n = 121;

		long answer = solution(n);
		System.out.println(answer);

	}

	public static long solution(long n) {
		long answer = 0;

		if (n % Math.sqrt(n) != 0) {
			return -1;
		}
		return (long)Math.pow((long) Math.sqrt(n) + 1,2);
	}
}
