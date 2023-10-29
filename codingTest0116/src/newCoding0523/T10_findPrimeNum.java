package newCoding0523;

//1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환
//n	result
//10	4
//5	3
public class T10_findPrimeNum {
	public static void main(String[] args) {
		int n = 5;
		int answer = solution(n);

		System.out.println(answer);

	}

	public static int solution(int n) {
		int answer = 0;

		while (n > 1) {
			if (check(n))
				answer++;

			n--;
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