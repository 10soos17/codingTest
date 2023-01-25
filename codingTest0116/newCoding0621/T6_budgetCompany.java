package newCoding0621;

//sizes	result
//[[60, 50], [30, 70], [60, 30], [80, 40]]	4000
//[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
//[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
//입출력 예 설명
//입출력 예 #1
//문제 예시와 같습니다.
//
//입출력 예 #2
//명함들을 적절히 회전시켜 겹쳤을 때,
//3번째 명함(가로: 8, 세로: 15)이 다른 모든 명함보다 크기가 큽니다.
//따라서 지갑의 크기는 3번째 명함의 크기와 같으며,
//120(=8 x 15)을 return 합니다.
public class T6_budgetCompany {
	public static void main(String[] args) {

		int[][] a = { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } };
		int answer = solution(a);

		System.out.println(answer);

	}

	public static int solution(int[][] a) {
		int answer = 0;
		int minIdx = 0;
		int maxIdx = 0;

		for (int i = 0; i < a.length; i++) {
			int min = Math.min(a[i][0], a[i][1]);
			int max = Math.max(a[i][0], a[i][1]);
			a[i][0] = min;
			a[i][1] = max;

			if (a[maxIdx][1] < a[i][1]) {
				maxIdx = i;
			}
			if (a[minIdx][0] < a[i][0]) {
				minIdx = i;
			}

		}

		for (int[] element : a) {
			System.out.println(element[0] + ":" + element[1]);
		}
		answer = a[minIdx][0] * a[maxIdx][1];

		return answer;
	}
}
