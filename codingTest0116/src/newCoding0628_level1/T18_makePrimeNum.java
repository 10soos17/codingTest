package newCoding0628_level1;

class T18_makePrimeNum {
//	1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수
//	n	result
//	10	4
//	5	3

	public static void main(String[] args) {
		int n = 10;

		// 방법 1
		int res = solution(n);
		System.out.println(res);

		// 방법 2
		int res2 = 0;

		while (n > 1) {
			if (check(n)) {
				res2++;
			}
			n--;
		}
		System.out.println(res2);

	}

	// 1
	public static int solution(int n) {
		int answer = 1;
		int cnt = 0;

		if (n == 2)
			return answer;

		else {
			while (n > 2) {

				cnt = 0;
				for (int i = 2; i < Math.sqrt(n) + 1; i++) {
					if (n % i == 0)
						break;
					cnt++;
				}
				if (cnt == (int) Math.sqrt(n))
					answer++;

				n--;
			}

		}

		return answer;
	}

	public static boolean check(int n) {
		if (n == 2)
			return true;

		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0)
				return false;
		}

		return true;

	}

}