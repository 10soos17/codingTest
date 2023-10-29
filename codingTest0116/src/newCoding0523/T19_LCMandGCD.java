package newCoding0523;

//수의 최대공약수와 최소공배수를 반환하는 함수
//n	m	return
//3	12	[3, 12]
//2	5	[1, 10]
public class T19_LCMandGCD {
	public static void main(String[] args) {

		int n = 3;
		int m = 12;

		int[] answer = solution(n, m);
		for (int i : answer) {
			System.out.println(i);
		}

	}

	public static int[] solution(int n, int m) {
		int min = Math.min(n, m);
		int[] answer = { min, n * m };

		while (min > 0) {
			if (n % min == 0 && m % min == 0) {
				answer[0] = min;

				if (min != 1) {
					answer[1] = n * m / min;
					break;
				}
			}
			min--;
		}

		return answer;

	}

}
