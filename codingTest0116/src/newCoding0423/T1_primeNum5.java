package newCoding0423;

//프로그래머스 정답
public class T1_primeNum5 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		solution(n,k);
	}

	public static int solution(int n, int k) {
		int answer = 0;
		String num = Integer.toString(n, k); // 10진수를 n진수로 변환
		System.out.println(num);
		String[] arr = num.split("0"); // 조건에 맞는 소수를 구하기 위해 0을 기준으로 자르기

		for (String s : arr) {
			if (!s.equals("") && !s.equals("1")) {
				Long prime = Long.parseLong(s); // n진수가 엄청 클 수 있기 때문에 자료형을 Long으로

				if (prime == 2) {
					answer++;
					continue;
				}

				boolean flag = true;
				for (int i = 2; i <= Math.sqrt(prime); i++) {
					// 매우 큰 수는 소수 판별 시 시간이 많이 걸리기 때문에 제곱근까지만 비교해줌
					if (prime % i == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer++;
				}
			}
		}
		return answer;
	}
}
