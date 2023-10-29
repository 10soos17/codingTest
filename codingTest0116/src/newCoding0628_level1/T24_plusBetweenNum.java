package newCoding0628_level1;

class T24_plusBetweenNum {
//	두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수
//	예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴
//		a	b	return
//		3	5	12
//		3	3	3
//		5	3	12
	public static void main(String[] args) {

		int n = 3;
		int m = 5;

		int res = solution(n, m);

		System.out.println(res);

	}

	public static int solution(int n, int m) {

		int min = Math.min(n, m);
		int max = Math.max(n, m);
		int answer = min;
		while (max > min) {
			answer += max;
			max--;
		}

		return answer;
	}

}